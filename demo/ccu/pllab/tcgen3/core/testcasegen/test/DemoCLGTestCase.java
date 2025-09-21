package ccu.pllab.tcgen3.core.testcasegen.test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.parctechnologies.eclipse.CompoundTerm;
import ccu.pllab.tcgen3.core.testcasegen.CLPSolver;
import ccu.pllab.tcgen3.core.testcasegen.CLPTranslator;
import ccu.pllab.tcgen3.core.testcasegen.PathEnumerator;
import ccu.pllab.tcgen3.core.testmodelbuilder.ASTBuilder;
import ccu.pllab.tcgen3.core.testmodelbuilder.CLGbuilder;
import ccu.pllab.tcgen3.core.testmodelbuilder.Criterion;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGEdge;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph;
import ccu.pllab.tcgen3.io.FileLoader;
import ccu.pllab.tcgen3.symboltable.scope.Scope;
import ccu.pllab.tcgen3.util.ClpUtil;
import ccu.pllab.tcgen3.util.FileUtil;
import ccu.pllab.tcgen3.util.StringTool;

public class DemoCLGTestCase {
  public static void main(String[] args) {
    List<String> solver_errmessage = new ArrayList<>();
    Map<Integer, String> feasiablePathinfo = new LinkedHashMap<>();

    FileLoader Loader = new FileLoader(args);
    if (args.length > 1 && args.length < 3) {
      System.out.println("Enter DC/DCC/MCC");
      System.exit(1);
    }
    ASTBuilder astbuilder = new ASTBuilder(Loader.getOclPath(), Loader.getUmlPath());
    astbuilder.build();

    Criterion criterion = switch (args[2]) {
      case "DC" -> Criterion.DC;
      case "DCC" -> Criterion.DCC;
      case "MCC" -> Criterion.MCC;
      default -> throw new IllegalArgumentException("Unexpected value: " + args[2]);
    };

    CLGbuilder clgbuilder =
        new CLGbuilder(astbuilder.getAST(), astbuilder.getSymboltable(), criterion);
    clgbuilder.build();

    List<CLGGraph> clg = clgbuilder.getCLGGrapies();
    int nthCLG = 2;
    int cycle = 7;


    PathEnumerator pathEnumerator = new PathEnumerator(clg.get(nthCLG), cycle);
    System.out.println(clg.get(nthCLG).getFilename());
    String classname = clg.get(nthCLG).getClassname();
    String methodname = clg.get(nthCLG).getMethodname();
    Scope currentscope = (Scope) astbuilder.getSymboltable().resolve(classname);

    if (!methodname.isEmpty()) {
      currentscope = (Scope) currentscope.resolve(methodname);
    }
    String ECL = clg.get(nthCLG).getFilename();
    int PATHNUM = 1;
    boolean isConstructor = false;
    if (classname.equals(methodname)) {
      isConstructor = true;
    }
    for (List<CLGEdge> path : pathEnumerator) {
      // System.out.println("Path "+PATHNUM+": "+ path);
      String eclfilename = ECL + "Path_" + PATHNUM;
      CLPTranslator translator = new CLPTranslator(path, currentscope, isConstructor, eclfilename);
      String clpcontent = translator.translate();
      // System.out.println(translator.translate());

      Path outputpath = Paths.get(System.getProperty("user.dir") + "\\output\\CLP\\" + eclfilename);

      // System.out.println(translator.getRequestTerm());
      try {
        ClpUtil.writeEclFile(outputpath, clpcontent);
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      try (CLPSolver solver = new CLPSolver(solver_errmessage)) {
        // Compile Pre-defined Method
        if (solver != null) {
          Path predefined =
              Path.of(System.getProperty("user.dir"), "output", "CLP", "staticArrayFunc");
          solver.compile(predefined.toFile());

          // Compile Path Constraint

          solver.compile(outputpath.toFile());


        }
        // Solving
        String SolvingHead = translator.getRequestTerm();
        String goal = "timeout(" + SolvingHead + "," + "1" + "," + "false" + ")";
        // Feasiable

        CompoundTerm result = solver.solve_fortest(goal);
        feasiablePathinfo.put(PATHNUM, path.toString());
        if (!translator.getisVarArray())
          break;
        // InFeasiable
        if (result == null) {
          try {
            // Path tmp
            FileUtil.deleteEclFile(outputpath);
          } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          }
        }
      }

      PATHNUM++;
    }

    System.out.println(StringTool.mapToString(feasiablePathinfo, 2));
  }
}
