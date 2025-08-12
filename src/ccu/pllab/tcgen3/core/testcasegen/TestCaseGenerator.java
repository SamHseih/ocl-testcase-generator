package ccu.pllab.tcgen3.core.testcasegen;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph;
import ccu.pllab.tcgen3.symboltable.scope.Scope;

public class TestCaseGenerator {
  Scope globalSymbolTable;
  CoverageCriterionManager coverageCriterionManager;
  boolean isBoundaryAnalysis;// user defined
  int maxTestCaseNum;// user defined
  int clgNodeSize = 0; // for performance analysis, not used in current version
  int clgEdgeSize = 0; // for performance analysis, not used in current version

  // clgfile name -> CLGTestDatas
  Map<String, CLGTestDatas> AlltestCase;

  private String PROHECT_DIR = System.getProperty("user.dir");
  private Map<String, String> tesecasemessage = new LinkedHashMap<>();
  private Map<String, Map<String, String>> fesiablePaths = new LinkedHashMap<>();

  public TestCaseGenerator(Scope SymbolTable, int maxTestCaseNum, boolean BA) {
    this.globalSymbolTable = SymbolTable;
    AlltestCase = new LinkedHashMap<>();
    this.maxTestCaseNum = maxTestCaseNum;
    isBoundaryAnalysis = BA;

  }

  public Map<String, String> getTestCaseMessage() {
    return tesecasemessage;
  }

  public Map<String, Map<String, String>> getFeasiablePath() {
    return fesiablePaths;
  }

  public CLGTestDatas getCLGTestDatas(String clgFileName) {
    return AlltestCase.get(clgFileName);
  }

  public int getSpecClgNodeSize() {
    return clgNodeSize;
  }

  public int getSpecClgEdgeSize() {
    return clgEdgeSize;
  }

  public Map<String, CLGTestDatas> getAllCLGTestDatas() {
    return AlltestCase;
  }

  public void generateTestCases(List<CLGGraph> clgGraphs) {
    Path predefinedPath = Path.of(PROHECT_DIR, "output", "CLPPredefined", "staticArrayFunc.ecl");
    List<String> clpSolverErrMessage = new ArrayList<>();// debug
    try (CLPSolver solver = new CLPSolver(clpSolverErrMessage)) {
      solver.compile(predefinedPath.toFile());// compile predefined CLP file

      if (!clpSolverErrMessage.isEmpty()) {
        System.out
            .println("=========================================================================");
        System.out
            .println("!!!!!!!!!!!!!!!!!!!! CLP PreDefined Errors !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out
            .println("=========================================================================");
        for (String s : clpSolverErrMessage)
          System.out.println(s);
        System.exit(1);
      } else {
        System.out
            .println("======================================================================");
        System.out
            .println("================ CLP PreDefined Compile successfully. ================");
        System.out.println(predefinedPath.toString());
        System.out
            .println("======================================================================");
      }

      for (CLGGraph clg : clgGraphs) {
        long startTime = System.currentTimeMillis();
        coverageCriterionManager = new CoverageCriterionManager(globalSymbolTable, clg,
            maxTestCaseNum, isBoundaryAnalysis);
        coverageCriterionManager.genTestCase(solver);
        AlltestCase.put(clg.getFilename(), coverageCriterionManager.getClgTestDatas());
        fesiablePaths.put(clg.getFilename(), coverageCriterionManager.getFeasiablePathMessage());

        clgNodeSize += clg.getNodes().size();
        clgEdgeSize += clg.getEdges().size();

        int PathNum = coverageCriterionManager.getPathNum();
        int TestCaseNum = coverageCriterionManager.getTestCaseNum();
        int BoundaryPathNum = coverageCriterionManager.getBoundaryPathNum();

        String testCaseInfo = "TestCaseNum: " + TestCaseNum + ", PathNum: " + PathNum
            + ", BoundaryPathNum: " + BoundaryPathNum;
        String testcaseTime = "Generate " + clg.getFilename() + " Using Time:"
            + (System.currentTimeMillis() - startTime) + " ms";
        tesecasemessage.put(clg.getFilename(), testCaseInfo + "  " + testcaseTime);
      }
    }
    if (!coverageCriterionManager.getErrorMesg().isEmpty()) {
      System.out
          .println("=========================================================================");
      System.out
          .println("!!!!!!!!!!!!!!!!!!! Test case Gen. Errors !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      System.out
          .println("=========================================================================");
      for (String s : coverageCriterionManager.getErrorMesg())
        System.out.println(s);
      System.exit(1);
    } else if (!clpSolverErrMessage.isEmpty()) {
      System.out
          .println("=========================================================================");
      System.out
          .println("!!!!!!!!!!!!!!!!!!!!! CLP Solver Errors !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      System.out
          .println("=========================================================================");
      for (String s : clpSolverErrMessage)
        System.out.println(s);
      System.exit(1);
    } else {
      System.out.println("======================================================================");
      System.out.println("================= Test case Generated successfully. ==================");
      System.out.println("======================================================================");
    }

  }
}
