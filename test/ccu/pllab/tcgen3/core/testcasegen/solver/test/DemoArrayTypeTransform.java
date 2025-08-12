package ccu.pllab.tcgen3.core.testcasegen.solver.test;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import com.parctechnologies.eclipse.CompoundTerm;
import ccu.pllab.tcgen3.core.testcasegen.CLPSolver;
import ccu.pllab.tcgen3.util.ClpUtil;

public class DemoArrayTypeTransform {
  public static void main(String[] args) {
    String projectPath = System.getProperty("user.dir");
    Path clpdir = Path.of(projectPath, "output", "CLP", "staticArrayFunc");
    List<String> errMessage = new ArrayList<>();

    try {
      // Initialize the CLPSolver
      try (CLPSolver solver = new CLPSolver(errMessage)) {
        // Compile the CLP file
        solver.compile(clpdir.toFile());

        // Solve a goal
        String goal =
            "D = [   []([]([](2887, -28852, 22525, 7192, 25878), [](21010, 5289, 10854, -19901, -13804)), []([](-9316, -19770, 29420, 9212, 24095), [](-27016, 22695, -16030, 5369, -11589)), []([](3889, 6255, -8279, 9694, 31429), [](-2146, -30465, 17287, 29021, 8046))),"
                + "[3,2,5] ]";
        CompoundTerm result = solver.solve_fortest(goal);
        if (result.arg(1) instanceof LinkedList ll) {
          System.out.println(ll + "\nSize: " + ll.size());
          // ll.get(0) should be a compound term = ECLiPSe Array []([](-16790, -21863), [](20057,
          // 9308))
          // ll.get(1) should be a linked list = ECLiPSe List [2,2]
          for (int i = 0; i < ll.size(); i++) {
            if (ll.get(i) instanceof CompoundTerm ct) {
              String dimStr = "[2,2,5]";

              // 去掉方括號 → "2,2,5"，再用逗號分割
              List<Integer> dims =
                  Arrays.stream(dimStr.replaceAll("[\\[\\]]", "").split("\\s*,\\s*"))
                      .map(Integer::parseInt).collect(Collectors.toList());

              System.out.println(dims); // 輸出: [2, 2, 5]
              System.out
                  .println("CompoundTerm " + i + ": " + ClpUtil.compoundArrayToString_braces(ct));
              System.out
                  .println("CompoundTerm " + i + ": " + ClpUtil.compoundArrayToString_brackets(ct));
              // Object arr = ClpUtil.toNestedList(ct);
              // System.out.println(Arrays.deepToString((Object[]) arr));
            } else if (ll.get(i) instanceof LinkedList lll) {
              System.out.println("LinkedList " + i + ": " + ClpUtil.listToString(lll));
            } else {
              System.out.println("Unexpected type at index " + i + ": " + ll.get(i).getClass());
            }
          }
        }
        if (result.arg(2) instanceof LinkedList ll) {
          System.out.println(ll + "\nSize: " + ll.size());
          // ll.get(0) should be a compound term = ECLiPSe Array []([](-16790, -21863), [](20057,
          // 9308))
          // ll.get(1) should be a linked list = ECLiPSe List [2,2]
          for (int i = 0; i < ll.size(); i++) {
            if (ll.get(i) instanceof CompoundTerm ct) {
              System.out
                  .println("CompoundTerm " + i + ": " + ClpUtil.compoundArrayToString_braces(ct));
              System.out
                  .println("CompoundTerm " + i + ": " + ClpUtil.compoundArrayToString_brackets(ct));
            } else if (ll.get(i) instanceof LinkedList lll) {
              System.out.println("LinkedList " + i + ": " + lll);
            } else {
              System.out.println("Unexpected type at index " + i + ": " + ll.get(i).getClass());
            }
          }
        }
        System.out.println("End");
      }

      if (!errMessage.isEmpty()) {
        System.out.println(errMessage);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
