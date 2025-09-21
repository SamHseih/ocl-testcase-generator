package ccu.pllab.tcgen3.core.testscriptgen;

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
import ccu.pllab.tcgen3.core.testmodelbuilder.TestmodelBuilder;
import ccu.pllab.tcgen3.symboltable.ClassSymbol;
import ccu.pllab.tcgen3.symboltable.FieldSymbol;
import ccu.pllab.tcgen3.symboltable.MethodSymbol;
import ccu.pllab.tcgen3.symboltable.ParameterSymbol;
import ccu.pllab.tcgen3.symboltable.Symbol;
import ccu.pllab.tcgen3.symboltable.type.ArrayTypeClassSymbol;
import ccu.pllab.tcgen3.symboltable.type.MultiplicityListType;
import ccu.pllab.tcgen3.symboltable.type.PrimitiveTypeSymbol;
import ccu.pllab.tcgen3.symboltable.type.Type;
import ccu.pllab.tcgen3.util.StringTool;

public class TestScriptGenerator {

  private Path projectpath = Path.of(System.getProperty("user.dir"));
  private List<String> specCLGList;
  private Map<String, CLGTestDatas> allCLGTestDatas;
  private ClassSymbol classSymbol;
  private STGroup templates;
  private boolean isBoundaryAnalysis;
  private String projectName;
  private String packageName; // 預設 package
  private List<String> errMessage = new ArrayList<>();// debug
  // *.stgfile

  public TestScriptGenerator(List<String> specCLGList, Map<String, CLGTestDatas> allCLGTestDatas,
      ClassSymbol classSymbol, boolean isBoundaryAnalysis, String projname) {
    this.specCLGList = specCLGList;
    this.allCLGTestDatas = allCLGTestDatas;
    this.classSymbol = classSymbol;
    this.isBoundaryAnalysis = isBoundaryAnalysis;
    this.projectName = projname;
    Path primitivetypestgpath =
        projectpath.resolve("src").resolve("ccu").resolve("pllab").resolve("tcgen3").resolve("core")
            .resolve("testscriptgen").resolve("JunitStringtemplate.stg");
    // 建立模板群組 若用 STGroupString(...)，參數要放「模板內容」本身，不是檔案路徑。 若要用檔案路徑載入模板，改用 STGroupFile(...)。
    templates = new STGroupFile(primitivetypestgpath.toString());
  }

  public List<String> geterrMessage() {
    return this.errMessage;
  }

  public void genTestScript(Path outputdir) throws IOException {
    // conbine file name
    String bva = isBoundaryAnalysis ? "BVA" : "";
    String className = projectName + bva + "_" + TestmodelBuilder.criterion + "_Test";
    String fileName = projectName + bva + "_" + TestmodelBuilder.criterion + "_Test.java";
    packageName = "test" + "." + projectName;
    // 1) Class Template
    ST imports = templates.getInstanceOf("imports");
    ST cls = templates.getInstanceOf("testClass");
    cls.add("packageInfo", packageName);
    cls.add("className", className);
    cls.add("imports", List.of(imports));

    // 2) 蒐集所有 method 渲染結果
    List<ST> methodBlocks = new ArrayList<>();
    for (String clgFilename : specCLGList) {// read each of clg name
      CLGTestDatas clgtd = allCLGTestDatas.get(clgFilename);// get clg test data
      if (clgtd == null)
        continue;
      String classNameRaw = clgtd.getClassName();
      String methodNameRaw = clgtd.getMethodName();
      if (methodNameRaw == null || methodNameRaw.isEmpty()) {
        // Invariant → 跳過
        continue;
      }
      boolean isConstructor = classNameRaw.equals(methodNameRaw);
      Map<String, Map<String, String>> testDatas = clgtd.getTestDatas();
      if (testDatas == null || testDatas.isEmpty())
        continue;

      for (String pathId : new ArrayList<>(testDatas.keySet())) {// read predicate of test case
        MethodSymbol methodsymbol = this.classSymbol.resolveMethod(clgtd.getMethodName());
        StringBlockRecord vm = buildRecord(clgFilename, pathId, clgtd, methodsymbol);

        // Choose template depends on test case
        if (vm.isThrows()) {
          ST t = templates.getInstanceOf("methodThrows");
          t.add("displayName", vm.displayName());
          t.add("methodName", vm.methodName());
          t.add("pathId", safeId(vm.pathId()));
          t.add("exceptionClass", vm.exceptionClass());
          t.add("lambdaCall", vm.lambdaCall());
          methodBlocks.add(t);
        } else if (isConstructor) {
          ST t = templates.getInstanceOf("methodConstructor");
          t.add("displayName", vm.displayName());
          t.add("methodName", vm.methodName());
          t.add("pathId", safeId(vm.pathId()));
          t.add("assertion", vm.assertion());
          t.add("arryobjdecl", vm.arryobjdecl());
          t.add("argdecl", vm.argdecl());
          methodBlocks.add(t);
        } else {
          ST t = templates.getInstanceOf("methodNormal");
          t.add("displayName", vm.displayName());
          t.add("methodName", vm.methodName());
          t.add("pathId", safeId(vm.pathId()));
          t.add("selfDecl", vm.selfDecl());
          t.add("expectedDecl", vm.expectedDecl());
          t.add("argdecl", vm.argdecl());
          t.add("assertion", vm.assertion());
          t.add("arryobjdecl", vm.arryobjdecl());
          methodBlocks.add(t);
        }
      }
    }

    cls.add("methods", methodBlocks);

    // 3) Render 並寫檔
    String code = cls.render();
    Files.createDirectories(outputdir);
    Path out = outputdir.resolve(fileName);
    Files.write(out, code.getBytes(StandardCharsets.UTF_8));

    // 4) final check
    if (!this.errMessage.isEmpty()) {
      System.out
          .println("=========================================================================");
      System.out
          .println("!!!!!!!!!!!!!!!!!!! TestScript gen Errors !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      System.out
          .println("=========================================================================");
      for (String s : this.errMessage)
        System.out.println(s);
      System.exit(1);
    } else {
      System.out.println("======================================================================");
      System.out.println("================= Test case Junit successfully. ==================");
      System.out.println(outputdir.resolve(fileName));
      System.out.println("======================================================================");
    }

  }

  public String getfilename() {
    String bva = isBoundaryAnalysis ? "BVA" : "";
    String fileBase = projectName + bva + "_" + TestmodelBuilder.criterion;
    String fileName = fileBase + "_Test.java";
    return fileName;
  }


  // --- helpers ---

  /** 把 pathId 清成只含字母數字與底線，避免生成的方法名不合法 */
  private static String safeId(String s) {
    return s.replaceAll("[^0-9A-Za-z_]", "_");
  }

  private StringBlockRecord buildRecord(String clgFilename, String pathId, CLGTestDatas clgtd,
      MethodSymbol methodSymbol) {
    if (methodSymbol == null)
      this.errMessage.add("Method Symbol can't be null !!!!");
    boolean isConstructor = clgtd.getClassName().equals(clgtd.getMethodName());
    String upperClassName = StringTool.tocapitalizeFirstLetter(clgtd.getClassName());
    Map<String, String> predicateData = clgtd.getTestDatas().get(pathId);

    // collect Arg* dataType
    List<Type> argsType = new ArrayList<>();
    for (Symbol symbol : methodSymbol.getAllSymbols()) {
      if (symbol instanceof ParameterSymbol p) {
        argsType.add(p.getType());
      }
    }

    // Self / Arg* / Result toString
    List<String> argsName = new ArrayList<>();
    String selfValue = "";
    String resultValue = "";
    StringBuilder arrayobjdecl = new StringBuilder();// int[] a = {1,2,3};
    StringBuilder argdecl = new StringBuilder();// obj ArgObj = new obj(a);
    StringBuilder brackets = new StringBuilder();
    int count = 0;
    for (String k : predicateData.keySet()) {
      if ("Self".equals(k)) {
        selfValue = StringTool.extractArrayIfPair(predicateData.get(k));// [1,2,3]
      } else if (k.startsWith("Arg")) {
        // for (Type t : argsType) {
        Type t = argsType.get(count);
        count++;
        if (t instanceof ArrayTypeClassSymbol arrinfo) {// constructor array arg
          String dimensionvalue = "0";
          Symbol s = arrinfo.resolve("dimension");
          if (s instanceof FieldSymbol f)
            dimensionvalue = f.getDefaultValue();
          for (int i = 0; i < Integer.parseInt(dimensionvalue); i++) {
            brackets.append("[]");
          }
          Type eletype = null;
          if (arrinfo.resolve("elements") instanceof FieldSymbol f) {
            if (f.getType() instanceof MultiplicityListType m) {
              eletype = m.getElementType();
            }
          }
          arrayobjdecl.append(declarrStr(eletype.getTypeName(), brackets.toString(), k,
              StringTool.replaceBrackets(predicateData.get(k))) + ";");

        } else if (t instanceof PrimitiveTypeSymbol p) {
          argdecl.append(p.getTypeName() + " " + k + " = "
              + StringTool.formatListString(predicateData.get(k)) + ";\n");

        } else if (t instanceof ClassSymbol c) {
          FieldSymbol s = (FieldSymbol) c.resolve("data");
          if (s.getType() instanceof ArrayTypeClassSymbol arrinfo) {
            String dimensionvalue = "0";
            Symbol sym = arrinfo.resolve("dimension");
            if (sym instanceof FieldSymbol f)
              dimensionvalue = f.getDefaultValue();
            for (int i = 0; i < Integer.parseInt(dimensionvalue); i++) {
              brackets.append("[]");
            }
            Type eletype = null;
            if (arrinfo.resolve("elements") instanceof FieldSymbol f) {
              if (f.getType() instanceof MultiplicityListType m) {
                eletype = m.getElementType();
              }
            }
            arrayobjdecl
                .append(declarrStr(eletype.getTypeName(), brackets.toString(), "inputarray_" + k,
                    StringTool.replaceBrackets(StringTool.extractArrayIfPair(predicateData.get(k))))
                    + ";\n");
          }
          argdecl.append(upperClassName + " ").append(k + " = new " + upperClassName + " ")
              .append("(").append("inputarray_" + k).append(");");
        }
        // }
        argsName.add(k);
      } else if ("Result".equals(k)) {
        resultValue = StringTool.extractArrayIfPair(predicateData.get(k));
      } else {
        errMessage.add("Unknow predicate :  " + k + "\n");
      }
    }

    // combine args
    StringBuilder argStr = new StringBuilder();
    for (String s : argsName) {
      argStr.append(s).append(",");
    }
    if (argStr.length() > 0 && argStr.charAt(argStr.length() - 1) == ',') {
      argStr.deleteCharAt(argStr.length() - 1);// delete "the last one ,"
    }

    // selfdecl
    String selfDecl = "";
    if (!isConstructor) {
      if (StringTool.isArrayPairArrayAndDimension(predicateData.get("Self"))) {
        if (methodSymbol.getType() instanceof ArrayTypeClassSymbol arrinfo) {// iny[2][2]
          String dimensionvalue = "0";
          Symbol sym = arrinfo.resolve("dimension");
          if (sym instanceof FieldSymbol f)
            dimensionvalue = f.getDefaultValue();
          for (int i = 0; i < Integer.parseInt(dimensionvalue); i++) {
            brackets.append("[]");
          }
        }
        arrayobjdecl.append("int").append(brackets.toString()).append(" inputarray_self = ")
            .append(StringTool.replaceBrackets(selfValue)).append(";");
        selfDecl = upperClassName + " self = new " + upperClassName + "( inputarray_self );";
      } else {
        selfDecl = upperClassName + " self = new " + upperClassName + "("
            + StringTool.formatListString(selfValue) + ");";
      }
    } else {
      // 直接 new(...) 當 lambdaCall 用，assertion 用 toString 比對 Self
      selfDecl = "new " + upperClassName + "(" + argStr.toString() + ")";
    }

    // callStmt 與 callStmt.toString()
    String callStmt = "";

    boolean rtIsPrimitive = false;
    if (!isConstructor) {
      Type rt = methodSymbol.getType();
      if (rt instanceof PrimitiveTypeSymbol) {
        rtIsPrimitive = true;
      }
      String callStmtarg = "()";
      if (!methodSymbol.getParameters().isEmpty())
        callStmtarg = "(" + StringTool.formatListString(argsName.toString()).toString() + ")";
      callStmt = " self." + clgtd.getMethodName() + callStmtarg;
      if (!rtIsPrimitive)
        callStmt += ".toString()";
    }

    // assertion / lambdaCall /expectedDecl
    String exceptionClass = "Exception";
    StringBuilder assertion = new StringBuilder();
    StringBuilder lambdaCall = new StringBuilder();

    if (!arrayobjdecl.isEmpty())
      lambdaCall.append(arrayobjdecl).append("\n");
    if (isConstructor) {
      String quotedSelf = quote(selfValue);
      assertion.append("assertEquals(").append(quotedSelf).append(", ").append(selfDecl)
          .append(".toString() );");
      lambdaCall.append(argdecl).append(selfDecl);
    } else {
      if (rtIsPrimitive) {
        resultValue = StringTool.formatListString(resultValue);
        String quotedResult = quote(resultValue);
        assertion.append("assertEquals(").append(quotedResult).append(",").append(callStmt)
            .append(" );");
        lambdaCall.append(selfDecl).append(" ").append(callStmt);
      } else {
        String quotedResult = quote(resultValue);
        assertion.append("assertEquals(").append(quotedResult).append(",").append(callStmt)
            .append(" );");
        lambdaCall.append(selfDecl + "\n").append(argdecl.toString() + "\n").append(callStmt);
      }
    }
    // isException / display
    boolean isException = resultValue.contains("Exception") || resultValue.contains("exception")
        || resultValue.contains("Illegal");
    String excSuffix = isException ? "_Exception" : "";
    String display = clgFilename + "_" + pathId + excSuffix;

    return new StringBlockRecord(display, clgtd.getMethodName(), pathId, selfDecl,
        argdecl.toString(), arrayobjdecl.toString(), callStmt, "", // expectedDecl 目前未使用，保留欄位
        assertion.toString(), isException, lambdaCall.toString(), exceptionClass);
  }

  private String quote(String s) {
    return "\"" + s + "\"";
  }

  // input [ [[4,5,6],[1,2,3]]] , Self/Arg/Result
  private String declarrStr(String type, String brackets, String objname, String value) {
    return type + brackets + " " + objname + " = " + value;
  }

}
