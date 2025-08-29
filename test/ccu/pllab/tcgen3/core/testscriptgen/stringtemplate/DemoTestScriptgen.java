package ccu.pllab.tcgen3.core.testscriptgen.stringtemplate;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import ccu.pllab.tcgen3.core.testcasegen.CLGTestDatas;
import ccu.pllab.tcgen3.core.testcasegen.TestCaseGenerator;
import ccu.pllab.tcgen3.core.testmodelbuilder.TestmodelBuilder;
import ccu.pllab.tcgen3.core.testscriptgen.TestScriptGenerator;

public class DemoTestScriptgen {
  public static void main(String[] args) {
    int testCaseNum = 10; // default maxTestCaseNum for dynamicArray TestCase generate
    boolean isBoundaryAnalysis = true;
    Path projectpath = Path.of(System.getProperty("user.dir"));

    // TestModel
    TestmodelBuilder testmodelbuilder = new TestmodelBuilder(args);
    testmodelbuilder.buildAST();
    testmodelbuilder.buildCLG();

    /* Generate Test Case , need set testNum && isBVA analysis */
    TestCaseGenerator tcgen =
        new TestCaseGenerator(testmodelbuilder.getSymbolTable(), testCaseNum, isBoundaryAnalysis);
    tcgen.generateTestCases(testmodelbuilder.getCLGs());

    // Assume testDataMap is populated elsewhere with all test data.
    // <clgfile name, CLGTestDatas>
    Map<String, CLGTestDatas> testDataMap = tcgen.getAllCLGTestDatas(); // pseudo-method for


    String BVAhead = "";
    if (isBoundaryAnalysis)
      BVAhead = "BVA_";// obtaining input
    String filename = BVAhead + "TestScript_" + args[1] + "_" + args[2] + "Test.java";

    Path OutputPath = projectpath.resolve("output").resolve("TestScript").resolve(projectpath)
        .resolve(Paths.get(filename));


    String outputDirectory = "generated-tests"; // ensure this directory exists
    try {
      TestScriptGenerator.generateAllTests(testDataMap, OutputPath);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("Test classes generated in directory: " + outputDirectory);
  }
}
