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
import ccu.pllab.tcgen3.util.StringTool;

record MethodVM(String displayName, // ex: "next - 1_1"
    String methodName, // ex: "next"
    String pathId, // ex: "1_1"
    String selfDecl, // ex: "Date self = new Date(1,12,31);"
    String callStmt, // ex: "var actual = self.next();"
    String expectedDecl, // ex: "int[] expected = new int[]{1,2,3};"
    String assertion, // ex: "assertArrayEquals(expected, actual);"
    boolean isThrows, // 是否 assertThrows
    String lambdaCall, // 例外 case: "new Date(-1, -1, -1)"
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

    /* JUnit Test Gen */
    String packageNameprefix = "TestScript";// default package name

    // 模板檔案路徑
    Path stgpath = projectpath.resolve("src").resolve("ccu").resolve("pllab").resolve("tcgen3")
        .resolve("core").resolve("testscriptgen").resolve("stg").resolve("primitivetype.stg");
    /*
     * 1) 建立模板群組 若用 STGroupString(...)，參數要放「模板內容」本身，不是檔案路徑。 若要用檔案路徑載入模板，改用 STGroupFile(...)。
     */
    STGroup group = new STGroupFile(stgpath.toString());

    // 2) 組測試類別
    String fileName =
        testmodelbuilder.getProjectName() + "_" + TestmodelBuilder.criterion.toString(); // 這個示範只產
                                                                                         // DateTest，一般情況你可迭代多個類別
    ST imports = group.getInstanceOf("imports");
    ST cls = group.getInstanceOf("testClass");
    cls.add("packageInfo", packageNameprefix);
    cls.add("className", fileName);
    cls.add("imports", List.of(imports)); // 傳 ST 或字串都可

    // 3) 準備這個類別要產出的測試方法（重點：methods 這個變數有宣告也有賦值！）
    List<MethodVM> methods = new ArrayList<>();

    for (String clgfilename : specCLGList) {
      CLGTestDatas clgtd = allCLGTestDatas.get(clgfilename);
      if (clgtd.getMethodName().isEmpty()) // Invariant Skip
        continue;
      Map<String, Map<String, String>> testDatas = clgtd.getTestDatas();
      List<String> pathIds = new ArrayList<>(testDatas.keySet());

      for (String Pathid : pathIds) {
        String className = StringTool.tocapitalizeFirstLetter(clgtd.getClassName());
        String methodName = StringTool.tocapitalizeFirstLetter(clgtd.getMethodName());

        // Deal with Self、Arg_s、Result String
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
        Boolean isException = returnStr.contains("Exception");

        String selfDecl = "";
        // constructor selfDecl ex: "Date self = new Date(1,12,31);"
        if (className.equals(methodName)) {// constructor
          selfDecl = className + " self = new " + className + "(" + ArgStr + ");";
        } else // method
          selfDecl = className + " self = new " + className + "(" + SelfStr + ");";

        // callStmt "var actual = self.next();"
        String callStmt = "";
        if (className.equals(methodName)) {// constructor
          callStmt = "";
        } else // method
          callStmt = className + " actual = self." + methodName + "();";

        // expectedDecl constructor = Self , method = Result
        // Array Type ex1: "int[] expected = new int[]{1,2,3};"
        // Primitive Type ex2: "int y=2, m=1, d=1;"
        String expectedDecl = "";
        if (className.equals(methodName)) {// constructor
          expectedDecl = "";
        } else // method
          expectedDecl = "";

        // assertEquals(m, actual.getMonth());
        StringBuilder assertion = new StringBuilder();
        if (className.equals(methodName)) {// constructor
          expectedDecl = "";
        } else // method
          expectedDecl = "";
        assertion.append("assertEquals(").append(returnStr).append("," + callStmt + " );");


        // 正常案例：Date.next()，Self = (1,12,31) → 結果 (2,1,1)
        methods.add(new MethodVM(clgfilename + "_" + Pathid, // displayName
            clgtd.getMethodName(), // methodName（用於 test 方法名，首字大寫）
            Pathid, // ex: "1_1"
            selfDecl, // ex: "Date self = new Date(1,12,31);"
            callStmt, // ex: "var actual = self.next();"
            expectedDecl, // expectedDecl
            assertion.toString(), // assertion 可一次放多行，模板不會擋
            isException, // isThrows
            null, // exceptionClass
            null // lambdaCall
        ));
      }

      // 4) 先把每一個方法用對應模板渲染成 ST 物件（或直接字串也可）
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
        } else {
          ST t = group.getInstanceOf("methodNormal");
          t.add("displayName", m.displayName());
          t.add("methodName", m.methodName());
          t.add("pathId", safeId(m.pathId()));
          t.add("selfDecl", m.selfDecl());
          t.add("callStmt", m.callStmt());
          t.add("expectedDecl", m.expectedDecl());
          t.add("assertion", m.assertion());
          methodTemplates.add(t);
        }
      }
      cls.add("methods", methodTemplates); // ★ 這裡就是 methods 的來源
    }

    // 2) 組測試類別 (續)
    String code = cls.render();

    // 5) 寫檔
    Path outputdir = projectpath.resolve("testCaseOutput").resolve("TestScript");

    try {
      Files.createDirectories(outputdir);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    try {
      Files.write(outputdir.resolve(fileName + "Test.java"), code.getBytes(StandardCharsets.UTF_8));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println("已輸出：" + outputdir.resolve(fileName + "Test.java").toAbsolutePath());
  }

  /** 把 pathId 清成只含字母數字與底線，避免生成的方法名不合法 */
  private static String safeId(String s) {
    return s.replaceAll("[^0-9A-Za-z_]", "_");
  }
}
