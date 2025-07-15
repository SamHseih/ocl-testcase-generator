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
				String goal = "D = [[]([](-16790, -21863), [](20057, 9308)),[2,2]]";
				CompoundTerm result = solver.solve_fortest(goal);
				if(result.arg(1) instanceof LinkedList ll) {
					System.out.println(ll + "\nSize: " + ll.size());
					//ll.get(0) should be a compound term  = ECLiPSe Array []([](-16790, -21863), [](20057, 9308))
					//ll.get(1) should be a linked list  = ECLiPSe List  [2,2]
					for(int i=0;i<ll.size();i++) {
						if(ll.get(i) instanceof CompoundTerm ct) {
							System.out.println("CompoundTerm " + i + ": " + ClpUtil.compoundArrayToString(ct));
						} else if(ll.get(i) instanceof LinkedList lll) {
							System.out.println("LinkedList " + i + ": " +ClpUtil.listToString(lll) );
						} else {
							System.out.println("Unexpected type at index " + i + ": " + ll.get(i).getClass());
						}
					}
				}
				if(result.arg(2) instanceof LinkedList ll) {
					System.out.println(ll + "\nSize: " + ll.size());
					//ll.get(0) should be a compound term  = ECLiPSe Array []([](-16790, -21863), [](20057, 9308))
					//ll.get(1) should be a linked list  = ECLiPSe List  [2,2]
					for(int i=0;i<ll.size();i++) {
						if(ll.get(i) instanceof CompoundTerm ct) {
							System.out.println("CompoundTerm " + i + ": " + ClpUtil.compoundArrayToString(ct));
						} else if(ll.get(i) instanceof LinkedList lll) {
							System.out.println("LinkedList " + i + ": " + lll);
						} else {
							System.out.println("Unexpected type at index " + i + ": " + ll.get(i).getClass());
						}
					}
				}
				System.out.println("End");
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
