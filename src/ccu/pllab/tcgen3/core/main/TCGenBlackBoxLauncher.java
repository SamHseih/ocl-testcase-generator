package ccu.pllab.tcgen3.core.main;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;
import ccu.pllab.tcgen3.core.testcasegen.TestCaseGenerator;
import ccu.pllab.tcgen3.core.testmodelbuilder.TestmodelBuilder;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph;
import ccu.pllab.tcgen3.util.StringTool;

public class TCGenBlackBoxLauncher {

  public static void main(String[] args) {
    // User Defined
    int testCaseNum = 50; // default maxTestCaseNum for dynamicArray TestCase generate
    boolean isBoundaryAnalysis = true;

    boolean keepInfeasiablePathInfo = true; // default=false, not keep infeasiable path in ecl file
    int solverlimitTime = 10;
    boolean isgenASTandCLG_Graph = false;

    String seprater =
        "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";

    LocalDateTime now = LocalDateTime.now();// get current time
    StringBuilder performancesb = new StringBuilder();
    Path projectpath = Path.of(System.getProperty("user.dir"));

    // TestModel
    TestmodelBuilder testmodelbuilder = new TestmodelBuilder(args);
    long aststartTime = System.currentTimeMillis();
    /* build AST */
    testmodelbuilder.buildAST();
    performancesb.append("AST Build Using Time:").append(System.currentTimeMillis() - aststartTime)
        .append(" ms\n");
    /* output AST Graph (option) */
    if (isgenASTandCLG_Graph)
      testmodelbuilder.genASTGraph();


    /* build CLG */
    long clgstartTime = System.currentTimeMillis();
    testmodelbuilder.buildCLG();
    performancesb.append("Total CLGBuild Using Time:")
        .append(System.currentTimeMillis() - clgstartTime).append(" ms\n");
    /* output CLG Graph (option) */
    if (isgenASTandCLG_Graph)
      testmodelbuilder.genCLGGraph();

    System.out.println("======================================================================");
    System.out.println("====================== TestModel was built Done. =====================");
    System.out.println("======================================================================");

    long testcasestartTime = System.currentTimeMillis();
    /* Generate Test Case , need set testNum && isBVA analysis */
    TestCaseGenerator tcgen =
        new TestCaseGenerator(testmodelbuilder.getSymbolTable(), testCaseNum, isBoundaryAnalysis);
    tcgen.setTimeLimit(solverlimitTime);
    tcgen.setKeepInfeasiableInfo(keepInfeasiablePathInfo);

    tcgen.generateTestCases(testmodelbuilder.getCLGs());

    Map<String, String> tcgenm = tcgen.getTestCaseMessage();

    performancesb.append("Total TestCase Generation Using Time:")
        .append(System.currentTimeMillis() - testcasestartTime).append(" ms\n");
    performancesb.append(seprater);
    performancesb.append("TestCase Information:");
    performancesb.append(StringTool.mapToString(tcgenm, 0)).append("\n");
    performancesb.append("Total System Generation Using Time:")
        .append(System.currentTimeMillis() - aststartTime).append(" ms\n");

    performancesb.append(seprater);

    /* Generate Test Script Not Yet */
    // TestScriptGenerator scriptGenerator = new
    // TestScriptGenerator(generator.getAllCLGTestDatas());
    // scriptGenerator.generateScripts();
    // System.out.println("Test case scripts generated successfully.");

    /* Output CLG Edges & nodes */
    StringBuilder testsb = new StringBuilder();
    for (CLGGraph clg : testmodelbuilder.getCLGs()) {
      // packagename + classname + <mewthodname?> + criterion
      performancesb.append(clg.getFilename()).append(" CLG Info :").append("");
      performancesb.append("  CLGNodes Size: ").append(clg.getNodes().size()).append("  ");
      performancesb.append("CLGEdges Size: ").append(clg.getEdges().size()).append("\n");
      // get test data by clg file name
      testsb.append(tcgen.getCLGTestDatas(clg.getFilename())).append(seprater);
    }

    /* write to file && Date format¡Gyyyy/mm/dd xx:xx */
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd H:mm", Locale.getDefault());
    performancesb.append("======================================================================\n")
        .append("============== ").append(now.format(fmt)).append(" TestCase output Finish.")
        .append(" ==============\n")
        .append("=====================================================================\n");

    /* set output path & filename */
    String BVAhead = "";
    if (isBoundaryAnalysis)
      BVAhead = "BVA_";
    String performancefilename = BVAhead + "Performance_" + args[1] + "_" + args[2] + ".txt";
    String pathInfofilename = BVAhead + "Path_" + args[1] + "_" + args[2] + ".txt";
    String testdatafilename = BVAhead + "TestData_" + args[1] + "_" + args[2] + ".txt";
    String projectname = testmodelbuilder.getProjectName();

    Path PerformanceOutputPath = projectpath.resolve("output").resolve("Performance")
        .resolve(projectname).resolve(Paths.get(performancefilename));
    Path PathInfoOutputPath = projectpath.resolve("output").resolve("Path").resolve(projectname)
        .resolve(Paths.get(pathInfofilename));
    Path TestdataOutputPath = projectpath.resolve("output").resolve("TestDatas")
        .resolve(projectname).resolve(Paths.get(testdatafilename));
    try {
      /* Output path Info */
      Files.createDirectories(PathInfoOutputPath.getParent());
      Files.writeString(PathInfoOutputPath, StringTool.mapToString(tcgen.getFeasiablePath(), 0),
          StandardCharsets.UTF_8);
      /* Output test data */
      Files.createDirectories(TestdataOutputPath.getParent());
      Files.writeString(TestdataOutputPath, testsb.toString(), StandardCharsets.UTF_8);

      /* Output Performance */
      Files.createDirectories(PerformanceOutputPath.getParent());
      Files.writeString(PerformanceOutputPath, seprater + performancesb.toString(),
          StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
      System.out.print(performancesb.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
