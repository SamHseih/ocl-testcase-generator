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
  int clgNodeSize; // for performance analysis, not used in current version
  int clgEdgeSize; // for performance analysis, not used in current version
  int timeLimit; // default time limit for CLP solver, can be set by user
  boolean isKeepInfeasiableInfo; // default not keep infeasiable path in ecl file and
                                 // InfeasiablePath

  // <clgfile name, CLGTestDatas>
  Map<String, CLGTestDatas> AlltestCase;

  private String PROHECT_DIR = System.getProperty("user.dir");
  private Map<String, String> tesecasemessage = new LinkedHashMap<>();
  private Map<String, Map<String, String>> fesiablePaths = new LinkedHashMap<>();
  private List<String> specCLGList;

  public TestCaseGenerator(Scope SymbolTable, int maxTestCaseNum, boolean BA) {
    this.globalSymbolTable = SymbolTable;
    AlltestCase = new LinkedHashMap<>();
    this.maxTestCaseNum = maxTestCaseNum;
    isBoundaryAnalysis = BA;
    clgNodeSize = 0;
    clgEdgeSize = 0;
    timeLimit = 10;
    isKeepInfeasiableInfo = false;
    specCLGList = new ArrayList<>();
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

  public void setTimeLimit(int timeLimit) {
    this.timeLimit = timeLimit;
  }

  public List<String> getSpecCLGList() {
    return specCLGList;
  }

  public void setKeepInfeasiableInfo(boolean isKeepInfeasiablePathEcl) {
    this.isKeepInfeasiableInfo = isKeepInfeasiablePathEcl;
  }

  public void generateTestCases(List<CLGGraph> clgGraphs) {
    Path predefinedPath = Path.of(PROHECT_DIR, "output", "CLPPredefined", "staticArrayFunc.ecl");
    List<String> clpSolverErrMessage = new ArrayList<>();// debug
    try (CLPSolver solver = new CLPSolver(clpSolverErrMessage)) {
      solver.setKeepInfeasiablePathInfo(isKeepInfeasiableInfo);
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
        coverageCriterionManager.setTimeLimit(timeLimit);
        coverageCriterionManager.setisKeepInfeasiableInfo(isKeepInfeasiableInfo);

        coverageCriterionManager.genTestCase(solver);

        AlltestCase.put(clg.getFilename(), coverageCriterionManager.getClgTestDatas());
        fesiablePaths.put(clg.getFilename(), coverageCriterionManager.getFeasiablePathMessage());
        specCLGList.add(clg.getFilename());
        clgNodeSize += clg.getNodes().size();
        clgEdgeSize += clg.getEdges().size();

        int PathNum = coverageCriterionManager.getPathNum();
        int TestCaseNum = coverageCriterionManager.getTestCaseNum();
        int BoundaryPathNum = coverageCriterionManager.getBoundaryPathNum();
        String BVAinfo = "";
        if (this.isBoundaryAnalysis) {
          BVAinfo = ", BoundaryPathNum: " + BoundaryPathNum;
        }

        String testCaseInfo = "PathNum: " + PathNum + BVAinfo + ", TestCaseNum: " + TestCaseNum;
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
