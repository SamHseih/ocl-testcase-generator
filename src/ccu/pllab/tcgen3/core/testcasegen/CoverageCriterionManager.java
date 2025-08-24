package ccu.pllab.tcgen3.core.testcasegen;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.parctechnologies.eclipse.CompoundTerm;
import ccu.pllab.tcgen3.core.testmodelbuilder.TestmodelBuilder;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGEdge;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph;
import ccu.pllab.tcgen3.symboltable.MethodSymbol;
import ccu.pllab.tcgen3.symboltable.scope.Scope;
import ccu.pllab.tcgen3.util.ClgUtil;
import ccu.pllab.tcgen3.util.ClpUtil;

public class CoverageCriterionManager {
  private Scope globalSymbolTable;
  private Scope currentscope;
  private CLGGraph clg;
  private boolean isBoundaryAnalysis;
  private boolean isKeepInfeasiableInfo; // default not keep infeasiable path in ecl file
                                         // and InfeasiablePath

  private int testcaseNum;// record the number of test cases generated
  private int pathNUm;// record the number of paths generated
  private int ithboundarypath;// fot a compelete path -> ith BVA Path
  private int bdpathNum;// record the number of BVA paths generated
  private int maxUnoll;// record the max unroll number, default is Integer.MAX_VALUE
  int maxDynamicArrayTestCaseNum;// record the max dynamic array test case number, default is
                                 // <user-define>, (meaning can be set by user)
  boolean isConstructor;// for result analysis, if the method is a constructor
  boolean isException; // for result analysis, if the method is exception handling, default is
                       // false,for future use
  int timeLimit = 10; // default time limit for CLP solver, can be set by user

  private List<String> errMessage = new ArrayList<>();// debug
  // <PathNum , TestCaseStr>
  private CLGTestDatas testdatas;
  private Map<String, String> feasiablePathMessage = new LinkedHashMap<>();

  // Boundary value for unroll, default is Integer.MAX_VALUE
  public CoverageCriterionManager(Scope globalSymbolTable, CLGGraph clgGraph, int maxTestCaseNum,
      boolean isBoundaryAnalysis) {
    this.globalSymbolTable = globalSymbolTable;
    this.clg = clgGraph;
    this.isBoundaryAnalysis = isBoundaryAnalysis;
    this.maxUnoll = Integer.MAX_VALUE; // default maxUnoll
    pathNUm = 0;
    testcaseNum = 0;
    ithboundarypath = 0;
    bdpathNum = 0;
    this.maxDynamicArrayTestCaseNum = maxTestCaseNum; // set maxTestCaseNum
    this.isConstructor = false;
    this.isException = false; // default is false, for future use
    currentscope = null;
    this.testdatas = new CLGTestDatas(clg.getClassname(), clg.getMethodname(), isBoundaryAnalysis);
    isKeepInfeasiableInfo = false;// default not keep infeasiable path in ecl file and
                                  // InfeasiablePath
  }

  public List<String> getErrorMesg() {
    return this.errMessage;
  }

  public int getTestCaseNum() {
    return this.testcaseNum;
  }

  public int getPathNum() {
    return this.pathNUm;
  }

  public int getBoundaryPathNum() {
    return bdpathNum;
  }

  // A CLG <fesiable path , testdata>
  public CLGTestDatas getClgTestDatas() {
    return this.testdatas;
  }

  public Map<String, String> getFeasiablePathMessage() {
    return this.feasiablePathMessage;
  }

  public void setTimeLimit(int timeLimit) {
    this.timeLimit = timeLimit;
  }

  public void setisKeepInfeasiableInfo(boolean isKeepInfeasiableInfo) {
    this.isKeepInfeasiableInfo = isKeepInfeasiableInfo;
  }

  public void genTestCase(CLPSolver solver) {
    Path projectpath = Path.of(System.getProperty("user.dir"));

    PathEnumerator pathEnumerator = new PathEnumerator(this.clg, maxUnoll);
    int dynamicArrayNum = 0;

    outer: for (List<CLGEdge> completepath : pathEnumerator) {
      pathNUm++;
      ithboundarypath = 0;
      // get CLG symboltable
      if (globalSymbolTable.resolve(clg.getClassname()) instanceof Scope classsymbol) {
        currentscope = classsymbol;
        // operation clg
        if (!clg.getMethodname().isEmpty()) {
          currentscope = (Scope) currentscope.resolve(clg.getMethodname());
        }
      }

      // Generate ECLiPSe CLPcode: PathCLP && WrapperCLP
      if (clg.getClassname().equals(clg.getMethodname())) {
        isConstructor = true;
      }
      String eclfilename = clg.getFilename() + "_Path_" + pathNUm;

      CLPTranslator translator =
          new CLPTranslator(completepath, currentscope, isConstructor, eclfilename);
      String CLPCode = translator.translate();
      if (!translator.getErrorMesg().isEmpty()) {
        errMessage.add("=========================================================================");
        errMessage.add("!!!!!!!!!!!!!!!!!!!! CLP Translate Errors !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        errMessage.add("=========================================================================");
        for (String s : translator.getErrorMesg())
          this.errMessage.add(s);
      }

      isException = translator.getisException();

      Path clpoutputpath = projectpath.resolve("output").resolve("CLP").resolve(clg.getClassname())
          .resolve(TestmodelBuilder.criterion.name()).resolve(eclfilename + ".ecl");
      try {
        ClpUtil.writeEclFile(clpoutputpath, CLPCode);
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        errMessage.add(e.getMessage());
      }
      // Compile ECLiPSe CLPcode <eclfilename>.ecl
      solver.compile(clpoutputpath.toFile());


      // Solving ECLiPSe CLP Code , Predicte is timeout(eclfilename,0.01,true).
      String SolvingHead = translator.getRequestTerm();
      String goal = "timeout(" + SolvingHead + "," + timeLimit + ",false" + ")";// timeout 10
                                                                                // seconds
      CompoundTerm result = solver.solve(goal, clpoutputpath);// if false delete eclfile

      // Feasiable
      if (result != null) {
        feasiablePathMessage.put("Feasiable Path " + pathNUm,
            ClgUtil.collectAllNodes(completepath).toString() + "\n");
        // debug use
        // testCaseStr.put(pathNUm,"There has a feasiable path. ");
        // testdatas.setTestDatas(pathNUm, resultToString(result));
        // Boundary Analysis
        BoundaryEnumerator bd = new BoundaryEnumerator(completepath);
        if (isBoundaryAnalysis) {
          for (List<CLGEdge> bdPath : bd.getBoundaryPath()) {
            bdpathNum++;
            ithboundarypath++;
            String BDeclfilename =
                clg.getFilename() + "_Path_" + pathNUm + "_BDPath_" + ithboundarypath;
            CLPTranslator BDtranslator =
                new CLPTranslator(bdPath, currentscope, isConstructor, BDeclfilename);
            String BDCLPCode = BDtranslator.translate();

            if (!BDtranslator.getErrorMesg().isEmpty()) {
              for (String s : BDtranslator.getErrorMesg())
                this.errMessage.add(s);
            }

            isException = BDtranslator.getisException();
            Path BVAclpoutputpath = projectpath.resolve("output").resolve("CLP")
                .resolve(clg.getClassname()).resolve(TestmodelBuilder.criterion.name())
                .resolve("BVA").resolve(BDeclfilename + ".ecl");
            try {
              ClpUtil.writeEclFile(BVAclpoutputpath, BDCLPCode);
            } catch (IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
              errMessage.add(e.getMessage());
            }
            // BVA Compile ECLiPSe CLPcode <eclfilename>.ecl

            solver.compile(BVAclpoutputpath.toFile());


            // BVA Solving ECLiPSe CLP Code , Predicte is timeout(eclfilename,0.01,true).
            String BDSolvingHead = BDtranslator.getRequestTerm();

            String BDgoal = "timeout(" + BDSolvingHead + "," + timeLimit + ",false" + ")";
            // timeout 10seconds

            CompoundTerm BDresult = solver.solve(BDgoal, BVAclpoutputpath);

            // BVA Feasiable
            if (BDresult != null) {
              feasiablePathMessage.put("Feasiable BVA Path " + pathNUm + "_" + ithboundarypath,
                  " Same as in the Feasible Path : " + pathNUm + "\n");
              // Test Case OutPut
              testcaseNum++;
              testdatas.setTestDatas(
                  Integer.toString(pathNUm) + "_" + Integer.toString(ithboundarypath),
                  resultToString(BDresult));
              // Array Test Case Use
              if (ClgUtil.isIterateNode(clg)) {
                // static array
                if (!translator.getisVarArray()) {
                  break outer; // continue to next complete path
                }
                // dynamic array
                else {
                  if (!this.isException) {
                    dynamicArrayNum++;
                  }
                  if (dynamicArrayNum == maxDynamicArrayTestCaseNum) {
                    break outer; // continue to next complete path
                  }
                }
              }
              // BVA InFeasiable Path .
            } else {
              if (isKeepInfeasiableInfo)
                feasiablePathMessage.put("InFeasiable BVA Path " + pathNUm + "_" + ithboundarypath,
                    ClgUtil.collectAllNodes(bdPath).toString() + "\n");
            }
          } // BVA Path for loop End
        }
        if (!isBoundaryAnalysis) {
          // Test Case OutPut
          testdatas.setTestDatas(Integer.toString(pathNUm), resultToString(result));
          testcaseNum++;
          // Array Test Case Use
          if (ClgUtil.isIterateNode(clg)) {
            // static array
            if (!translator.getisVarArray()) {
              break;
            }
            // dynamic array
            else {
              if (!this.isException) {
                dynamicArrayNum++;
              }
              if (dynamicArrayNum == maxDynamicArrayTestCaseNum) {
                break;
              }
            }
          }
        }
      } // if (result != null).. Analysis Fesiable Complete Path END.
      else {// Analysis InFeasiable Complete Path END.
        // debug use
        if (isKeepInfeasiableInfo)
          feasiablePathMessage.put("InFeasiablePath" + pathNUm,
              ClgUtil.collectAllNodes(completepath).toString() + "\n");
      }
    } // path for loop end
  }

  private Map<String, String> resultToString(CompoundTerm result) {
    boolean hasResult = false;
    int ArgNum = 0;
    Map<String, String> resultMap = new LinkedHashMap<>();

    if (this.currentscope instanceof MethodSymbol m) {
      if (!(m.getType() == null)) {
        hasResult = true;
      }
      ArgNum = m.getNumberOfParameters();
    }

    if (result == null) {
      // return "In FeasiablePath but No result Some Error Occured";
      resultMap.put("Error", "In FeasiablePath but No result Some Error Occured");
      return resultMap;

    } else if (clg.getMethodname().isEmpty()) {
      // return "Invariant condition not used";
      if (result.arg(1) instanceof CompoundTerm predicate)
        resultMap.put("Invariant Self", ClpUtil.toJavaString(predicate.arg(1)));
      return resultMap;

      // Args,Result='Exception'
    } else if (isConstructor && isException) {
      if (result.arg(1) instanceof CompoundTerm predicate) {
        int index = 1;
        for (int i = 1; i <= predicate.arity(); i++) {
          if (i == predicate.arity()) {
            resultMap.put("Result", ClpUtil.toJavaString(predicate.arg(i)));
          } else {
            resultMap.put("Arg_" + index, ClpUtil.toJavaString(predicate.arg(i)));
          }
          index++;
        }
      }
      // return "Self,Result='Exception'";
      return resultMap;

      // Self,Args
    } else if (isConstructor) {
      if (result.arg(1) instanceof CompoundTerm predicate) {
        int index = 1;
        for (int i = 1; i <= predicate.arity(); i++) {
          if (i == 1) {
            resultMap.put("Self", ClpUtil.toJavaString(predicate.arg(i)));
          } else {
            resultMap.put("Arg_" + index, ClpUtil.toJavaString(predicate.arg(i)));
          }
          if (i != 1)
            index++;
        }
      }
      // return "Self,Arg";
      return resultMap;

      // Self,Arg,Result
    } else if (!(clg.getMethodname().isEmpty()) && hasResult && ArgNum > 0) {
      if (result.arg(1) instanceof CompoundTerm predicate) {
        int index = 1;
        for (int i = 1; i <= predicate.arity(); i++) {
          if (i == 1) {
            resultMap.put("Self", ClpUtil.toJavaString(predicate.arg(i)));
          } else if (i != predicate.arity()) {
            resultMap.put("Arg_" + index, ClpUtil.toJavaString(predicate.arg(i)));
          } else {
            resultMap.put("Result", ClpUtil.toJavaString(predicate.arg(i)));
          }
          if (i != 1)
            index++;
        }
      }
      // return "Self,Arg,Result";
      return resultMap;

      // Self,Result
    } else if (!(clg.getMethodname().isEmpty()) && ArgNum == 0) {
      if (result.arg(1) instanceof CompoundTerm predicate) {

        for (int i = 1; i <= predicate.arity(); i++) {
          if (i == 1) {
            resultMap.put("Self", ClpUtil.toJavaString(predicate.arg(i)));
          } else {
            resultMap.put("Result", ClpUtil.toJavaString(predicate.arg(i)));
          }
        }
      }
      // return sb.toString();
      return resultMap;
    }

    return null;
  }

}
