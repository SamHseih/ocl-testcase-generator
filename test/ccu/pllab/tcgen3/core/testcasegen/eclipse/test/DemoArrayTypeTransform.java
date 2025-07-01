package ccu.pllab.tcgen3.core.testcasegen.eclipse.test;

import java.nio.file.Path;
import java.util.LinkedList;

import com.parctechnologies.eclipse.CompoundTerm;

import ccu.pllab.tcgen3.core.testcasegen.CLPSolver;
import ccu.pllab.tcgen3.util.ClpUtil;

public class DemoArrayTypeTransform {
	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		Path clpdir = Path.of(projectPath,"output","CLP","staticArrayFunc");
		try {
			// Initialize the CLPSolver
			try (CLPSolver solver = new CLPSolver()) {
				// Compile the CLP file
				solver.compile(clpdir.toFile());

				// Solve a goal
				String goal = "initialize_and_label_array(Array,[2,2])";
				CompoundTerm result = solver.solve(goal);

				if(result.arg(1) instanceof CompoundTerm ct) {
					// Convert the result to a Java String
					String array = ClpUtil.compoundArrayToString(ct);
					System.out.println("Result: " + array);
					String List = ClpUtil.compoundArrayToString(ct);

				} else {
					System.out.println("Unexpected result type: " + result.arg(1).getClass());
				}
				
				
				if(result.arg(2) instanceof LinkedList ll) {
					// Convert the result to a Java String
					String List = ClpUtil.listToString(ll);
					System.out.println("Result: " + List);
				} else {
					System.out.println("Unexpected result type: " + result.arg(1).getClass());
				}
				// Print  the result
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
