package ccu.pllab.tcgen3.core.testcasegen.test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.parctechnologies.eclipse.CompoundTerm;
import ccu.pllab.tcgen3.core.testcasegen.CLPSolver;
import ccu.pllab.tcgen3.util.FileUtil;

public class DemoCLPSolver {
  public static void main(String[] args) {
    int PathmaxNum = 380;
    int i = 1;
    String title = "StaticFixedsizeArrays_ThreeDimVarArray_sub_DC_";
    List<String> feasiablePath = new ArrayList<>();
    Map<Integer, String> info = new LinkedHashMap<>();
    List<String> errmessage = new ArrayList<>();

    // Initialize the CLPSolver
    try (CLPSolver solver = new CLPSolver(errmessage)) {
      // Compile the Pre-defined CLP file
      String projectPath = System.getProperty("user.dir");
      Path predefined = Path.of(projectPath, "output", "CLP", "staticArrayFunc");
      solver.compile(predefined.toFile());

      // Solve a goal
      System.out.println("Solving Begin");
      for (; i < PathmaxNum; i++) {
        // Compile the CLP file
        Path clp = Path.of(projectPath, "output", "CLP", title + "Path_" + i);
        solver.compile(clp.toFile());

        // Solving
        String headArg = "(Self,Arg,Result)";
        String Solving = "solving_Path_" + i + headArg;
        String goal = "timeout(" + Solving + "," + "1" + "," + "false" + ").";
        CompoundTerm result = solver.solve_fortest(goal);

        feasiablePath.add("There has a feasiable path_" + i + "\n");

        if (result != null) {
          System.out.println("Result: " + result);
        } else {
          try {
            FileUtil.deleteEclFile(clp);
          } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          }
        }
      }

      System.out.println("Solving End~~~~~~");
      System.out.println(feasiablePath.toString());
      System.out.println(info.toString());
    }
  }
}
