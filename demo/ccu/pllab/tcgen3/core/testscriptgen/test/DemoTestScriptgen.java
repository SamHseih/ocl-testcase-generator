package ccu.pllab.tcgen3.core.testscriptgen.test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import ccu.pllab.tcgen3.core.testcasegen.CLGTestDatas;
import ccu.pllab.tcgen3.core.testcasegen.TestCaseGenerator;
import ccu.pllab.tcgen3.core.testmodelbuilder.TestmodelBuilder;
import ccu.pllab.tcgen3.symboltable.ClassSymbol;
import ccu.pllab.tcgen3.symboltable.MethodSymbol;
import ccu.pllab.tcgen3.symboltable.scope.Scope;
import ccu.pllab.tcgen3.symboltable.type.PrimitiveTypeSymbol;
import ccu.pllab.tcgen3.symboltable.type.Type;
import ccu.pllab.tcgen3.util.StringTool;

record MethodVM(String displayName, // ex: "next - 1_1"
    String methodName, // ex: "next"
    String pathId, // ex: "1_1"
    String selfDecl, // ex: "Date self = new Date(1,12,31);"
    String callStmt, // ex: "var actual = self.next();"
    String expectedDecl, // ex: "int[] expected = new int[]{1,2,3};"
    String assertion, // ex: "assertArrayEquals(expected, actual);"
    boolean isThrows, // �O�_ assertThrows
    String lambdaCall, // �ҥ~ case: "new Date(-1, -1, -1)"
    String exceptionClass // ex: "Date.DateErrorException"
) {
}


public class DemoTestScriptgen {
  public static void main(String[] args) {
    // User Defined
    int testCaseNum = 50; // default maxTestCaseNum for dynamicArray TestCase generate
    boolean isBoundaryAnalysis = false;
    boolean keepInfeasiablePathInfo = false; // default=false, not keep infeasiable path in ecl file
    int solverlimitTime = 10;
    boolean isgenASTandCLG_Graph = false;
    Path projectpath = Path.of(System.getProperty("user.dir"));
    // TestModel
    TestmodelBuilder testmodelbuilder = new TestmodelBuilder(args);
    /* build AST */
    testmodelbuilder.buildAST();
    /* output AST Graph (option) */
    if (isgenASTandCLG_Graph)
      testmodelbuilder.genASTGraph();
    /* build CLG */
    testmodelbuilder.buildCLG();
    /* output CLG Graph (option) */
    if (isgenASTandCLG_Graph)
      testmodelbuilder.genCLGGraph();
    System.out.println("======================================================================");
    System.out.println("====================== TestModel was built Done. =====================");
    System.out.println("======================================================================");
    /* Generate Test Case , need set testNum && isBVA analysis */
    TestCaseGenerator tcgen =
        new TestCaseGenerator(testmodelbuilder.getSymbolTable(), testCaseNum, isBoundaryAnalysis);
    tcgen.setTimeLimit(solverlimitTime);
    tcgen.setKeepInfeasiableInfo(keepInfeasiablePathInfo);
    tcgen.generateTestCases(testmodelbuilder.getCLGs());
    Map<String, CLGTestDatas> allCLGTestDatas = tcgen.getAllCLGTestDatas();
    List<String> specCLGList = tcgen.getSpecCLGList();

    Scope globalsymboltable = testmodelbuilder.getSymbolTable();
    MethodSymbol methodsymbol = null;
    /* JUnit Test Gen */
    String packageNameprefix = "TestScript";// default package name

    // �ҪO�ɮ׸��|
    Path stgpath = projectpath.resolve("src").resolve("ccu").resolve("pllab").resolve("tcgen3")
        .resolve("core").resolve("testscriptgen").resolve("stg").resolve("primitivetype.stg");
    /*
     * 1) �إ߼ҪO�s�� �Y�� STGroupString(...)�A�Ѽƭn��u�ҪO���e�v�����A���O�ɮ׸��|�C �Y�n���ɮ׸��|���J�ҪO�A��� STGroupFile(...)�C
     */
    STGroup group = new STGroupFile(stgpath.toString());

    // 2) �մ������O
    String BVA = "";
    if (isBoundaryAnalysis)
      BVA = "BVA";
    String fileName =
        testmodelbuilder.getProjectName() + BVA + "_" + TestmodelBuilder.criterion.toString(); // �o�ӥܽd�u��
    // DateTest�A�@�뱡�p�A�i���N�h�����O
    ST imports = group.getInstanceOf("imports");
    ST cls = group.getInstanceOf("testClass");
    cls.add("packageInfo", packageNameprefix);
    cls.add("className", fileName + "_");
    cls.add("imports", List.of(imports)); // �� ST �Φr�곣�i

    // 3) �ǳƳo�����O�n���X�����դ�k�]���I�Gmethods �o���ܼƦ��ŧi�]����ȡI�^
    for (String clgfilename : specCLGList) {
      List<MethodVM> methods = new ArrayList<>();
      CLGTestDatas clgtd = allCLGTestDatas.get(clgfilename);
      if (clgtd.getMethodName().isEmpty()) // Invariant Skip
        continue;
      Map<String, Map<String, String>> testDatas = clgtd.getTestDatas();
      List<String> pathIds = new ArrayList<>(testDatas.keySet());
      boolean isConstructor = clgtd.getClassName().equals(clgtd.getMethodName());
      for (String Pathid : pathIds) {
        String upperclassName = StringTool.tocapitalizeFirstLetter(clgtd.getClassName());
        if (globalsymboltable.resolve(clgtd.getClassName()) instanceof ClassSymbol c) {
          if (c != null) {
            methodsymbol = c.resolveMethod(clgtd.getMethodName());
          }
        }

        // Deal with Self�BArg_s�BResult String
        List<String> params = new ArrayList<>();
        String returnStr = "";
        String SelfStr = "";
        Map<String, String> testdatapredicate = testDatas.get(Pathid);
        for (String predicate : testdatapredicate.keySet()) {
          if (predicate.equals("Self")) {
            SelfStr = StringTool.formatListString(testdatapredicate.get(predicate));
          } else if (predicate.startsWith("Arg")) {
            params.add(testdatapredicate.get(predicate));
          } else if (predicate.equals("Result")) {
            returnStr = testdatapredicate.get(predicate);
          }
        }
        String ArgStr = StringTool.formatListString(params.toString());
        returnStr = StringTool.formatListString(returnStr.toString());
        Boolean isException = returnStr.contains("Exception") || returnStr.contains("exception");

        String selfObjDecl = "";
        // constructor selfDecl ex: "Date self = new Date(1,12,31);"
        if (isConstructor) {// constructor
          selfObjDecl = "new " + upperclassName + "(" + ArgStr + ")";
        } else // method need obj constructor
          selfObjDecl = upperclassName + " self = new " + upperclassName + "(" + SelfStr + ");";

        // callStmt "self.next();"
        String callStmt = "";
        String typeName = "";
        boolean isPrimitiveType = false;
        if (!isConstructor) {
          Type rttype = methodsymbol.getType();
          if ((rttype instanceof PrimitiveTypeSymbol)) {
            typeName = rttype.getTypeName();
            isPrimitiveType = true;
          }
          // String rttype =
          callStmt = " self." + clgtd.getMethodName() + "()";
          if (!isPrimitiveType)
            callStmt = callStmt + ".toString()";
        }
        // expectedDecl constructor = Self , method = Result
        // Array Type: "int[] expected = new int[]{1,2,3};"
        String expectedDecl = "";
        StringBuilder assertion = new StringBuilder();// assertEquals(m, actual.getMonth());
        String exceptionClass = "Exception";
        StringBuilder lambdaCall = new StringBuilder();

        if (isConstructor) {// constructor
          SelfStr = "\"" + SelfStr + "\"";
          assertion.append("assertEquals(").append(SelfStr)
              .append("," + selfObjDecl + ".toString() );");
          lambdaCall.append(selfObjDecl);
        } else {// method
          returnStr = "\"" + returnStr + "\"";
          assertion.append("assertEquals(").append(returnStr).append("," + callStmt + " );");
          lambdaCall.append(selfObjDecl);
          lambdaCall.append(callStmt);
        }

        String exc = "";
        if (isException)
          exc = "_Exception";
        methods.add(new MethodVM(clgfilename + "_" + Pathid + exc, // displayName
            clgtd.getMethodName(), // methodName�]�Ω� test ��k�W�A���r�j�g�^
            Pathid, // ex: BVA case is "1_1" , or normal case is "1"
            selfObjDecl, // ex: "new Date(1,12,31);"
            callStmt, // ex: "self.next();"
            expectedDecl, // expectedDecl
            assertion.toString(), // assertion �i�@����h��A�ҪO���|��
            isException, // isThrows
            lambdaCall.toString(), // lambdaCall
            exceptionClass.toString() // exceptionClass
        ));
      } // a testcase of paths loop from a method or constructor

      // 4) ����C�@�Ӥ�k�ι����ҪO��V�� ST ����]�Ϊ����r��]�i�^
      List<ST> methodTemplates = new ArrayList<>();
      for (MethodVM m : methods) {
        if (m.isThrows()) {
          ST t = group.getInstanceOf("methodThrows");
          t.add("displayName", m.displayName());
          t.add("methodName", m.methodName());
          t.add("pathId", safeId(m.pathId()));
          t.add("exceptionClass", m.exceptionClass());
          t.add("lambdaCall", m.lambdaCall());
          methodTemplates.add(t);
        } else if (isConstructor) {
          ST t = group.getInstanceOf("methodConstructor");
          t.add("displayName", m.displayName());
          t.add("methodName", m.methodName());
          t.add("pathId", safeId(m.pathId()));
          t.add("assertion", m.assertion());
          methodTemplates.add(t);
        } else {
          ST t = group.getInstanceOf("methodNormal");
          t.add("displayName", m.displayName());
          t.add("methodName", m.methodName());
          t.add("pathId", safeId(m.pathId()));
          t.add("selfDecl", m.selfDecl());
          t.add("expectedDecl", m.expectedDecl());
          t.add("assertion", m.assertion());
          methodTemplates.add(t);
        }
      }
      cls.add("methods", methodTemplates); // �� �o�̴N�O methods ���ӷ�
    } // clg testcase for loop

    // 2) �մ������O (��)
    String code = cls.render();

    // 5) �g��
    Path outputdir = projectpath.resolve("testCaseOutput").resolve("TestScript");

    try {
      Files.createDirectories(outputdir);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    try {
      Files.write(outputdir.resolve(fileName + "_Test.java"),
          code.getBytes(StandardCharsets.UTF_8));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out
        .println("OutputPath�G\n" + outputdir.resolve(fileName + "Test.java").toAbsolutePath());
  }

  /** �� pathId �M���u�t�r���Ʀr�P���u�A�קK�ͦ�����k�W���X�k */
  private static String safeId(String s) {
    return s.replaceAll("[^0-9A-Za-z_]", "_");
  }
}
