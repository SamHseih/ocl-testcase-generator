package ccu.pllab.tcgen3.core.testcasegen.solver.test;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import com.parctechnologies.eclipse.Atom;
import com.parctechnologies.eclipse.CompoundTerm;
import ccu.pllab.tcgen3.core.testcasegen.CLPSolver;
import ccu.pllab.tcgen3.util.ClpUtil;

public class DemoCLPDataType {
  public static void main(String[] args) {
    String projectPath = System.getProperty("user.dir");
    Path clpdir = Path.of(projectPath, "output", "CLP", "staticArrayFunc");
    List<String> errMessage = new ArrayList<>();
    try (CLPSolver solver = new CLPSolver(errMessage)) {
      solver.compile(clpdir.toFile());
      CompoundTerm ListType = solver.solve_fortest("A=[1,2]");
      System.out.println("Op argNum: " + ListType.arity());
      System.out.println("Op Name: " + ListType.functor());
      for (int i = 1; i <= ListType.arity(); i++) {
        System.out.println("ListType " + i + ": " + ListType.arg(i).getClass());
        System.out.println("ListType " + i + ": " + ListType.arg(i).toString());
      }
      CompoundTerm StringType = solver.solve_fortest("A=\"Str\"");
      System.out.println("Op argNum: " + StringType.arity());
      System.out.println("Op Name: " + StringType.functor());
      for (int i = 1; i <= StringType.arity(); i++) {
        System.out.println("StringType " + i + ": " + StringType.arg(i).getClass());
        System.out.println("StringType " + i + ": " + StringType.arg(i).toString());
      }
      CompoundTerm AtomType = solver.solve_fortest("A='Tom'");
      System.out.println("Op argNum: " + AtomType.arity());
      System.out.println("Op Name: " + AtomType.functor());
      for (int i = 1; i <= AtomType.arity(); i++) {
        System.out.println("AtomType " + i + ": " + AtomType.arg(i).getClass());
        System.out.println("AtomType " + i + ": " + AtomType.arg(i).toString());
        if (AtomType.arg(i) instanceof Atom a) {
          System.out.println("AtomToString " + i + ": " + ClpUtil.AtomToString(a));
        }

      }
      CompoundTerm Variable = solver.solve_fortest("A = B");
      System.out.println("Op argNum: " + Variable.arity());
      System.out.println("Op Name: " + Variable.functor());
      for (int i = 1; i <= Variable.arity(); i++) {
        System.out.println("Variable " + i + ": " + Variable.arg(i));
        System.out.println("Variable " + i + ": " + Variable.arg(i));
      }
      CompoundTerm term = solver.solve_fortest("new_array(A,[2,2])");
      CompoundTerm array = (CompoundTerm) term.arg(1);
      System.out.println("Op argNum: " + array.arity());
      System.out.println("Op Name: " + array.functor());
      for (int i = 1; i <= array.arity(); i++) {
        System.out.println("array " + i + ": " + array.arg(i).getClass());
        System.out.println("array " + i + ": " + array.arg(i).toString());

      }
      CompoundTerm term2 = solver.solve_fortest("[A,B,C]::10..100,labeling([A,B,C])");
      CompoundTerm labeling = (CompoundTerm) term2.arg(1);
      System.out.println("Op argNum: " + labeling.arity());
      System.out.println("Op Name: " + labeling.functor());
      for (int i = 1; i <= labeling.arity(); i++) {
        System.out.println("labeling " + i + ": " + labeling.arg(i).getClass());
        System.out.println("labeling " + i + ": " + labeling.arg(i).toString());
      }
    }
    if (!errMessage.isEmpty()) {
      System.out.println(errMessage);
    }
  }


}
