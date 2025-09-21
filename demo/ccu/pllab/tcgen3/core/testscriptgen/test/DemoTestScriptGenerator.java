package ccu.pllab.tcgen3.core.testscriptgen.test;

import java.io.IOException;
import java.nio.file.Path;
import ccu.pllab.tcgen3.core.testcasegen.TestCaseGenerator;
import ccu.pllab.tcgen3.core.testmodelbuilder.TestmodelBuilder;
import ccu.pllab.tcgen3.core.testscriptgen.TestScriptGenerator;
import ccu.pllab.tcgen3.symboltable.ClassSymbol;

public class DemoTestScriptGenerator {
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

    /* JUnit Test Gen */
    ClassSymbol classsymbol =
        (ClassSymbol) testmodelbuilder.getSymbolTable().resolve(testmodelbuilder.getProjectName());

    TestScriptGenerator genScript =
        new TestScriptGenerator(tcgen.getSpecCLGList(), tcgen.getAllCLGTestDatas(), classsymbol,
            isBoundaryAnalysis, testmodelbuilder.getProjectName());
    Path outputdir = projectpath.resolve("testCaseOutput").resolve("TestScript");
    try {
      genScript.genTestScript(outputdir);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out
        .println("OutputPath¡G\n" + outputdir.resolve(genScript.getfilename()).toAbsolutePath());



  }
}
