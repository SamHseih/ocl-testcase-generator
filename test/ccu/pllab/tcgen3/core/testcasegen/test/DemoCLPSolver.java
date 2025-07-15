package ccu.pllab.tcgen3.	core.testcasegen.test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.parctechnologies.eclipse.CompoundTerm;
import com.parctechnologies.eclipse.EclipseException;

import ccu.pllab.tcgen3.core.testcasegen.CLPSolver;
import ccu.pllab.tcgen3.util.ClpUtil;
import ccu.pllab.tcgen3.util.FileUtil;

public class DemoCLPSolver {
	public static void main(String[] args) {
		int PathmaxNum=380;
		int i = 1;
		String title = "StaticFixedsizeArrays_ThreeDimVarArray_sub_DC_";
		List<String> feasiablePath = new ArrayList<>();
		Map<Integer,String> info = new LinkedHashMap<>();
		
		// Initialize the CLPSolver
		CLPSolver solver = null;
		try {
			solver = new CLPSolver();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EclipseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		// Compile the Pre-defined CLP file
		String projectPath = System.getProperty("user.dir");
		Path predefined = Path.of(projectPath,"output","CLP","staticArrayFunc");
		try {
			solver.compile(predefined.toFile());
		} catch (EclipseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Solve a goal
		System.out.println("Solving Begin");
		for(;i<PathmaxNum;i++) {
			// Compile the CLP file
			Path clp = Path.of(projectPath,"output","CLP",title+"Path_"+i);
			try {
				solver.compile(clp.toFile());
			} catch (EclipseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Solving
			String headArg = "(Self,Arg,Result)";
			String Solving = "solving_Path_"+i+headArg;
			String goal = "timeout("+Solving+","+"1"+","+"false"+").";
			CompoundTerm result = null;
			
			try {
				result = solver.getEngine().rpc(goal);
				feasiablePath.add("There has a feasiable path_"+i+"\n");

				if(result != null) {
					System.out.println("Result: " + result);
//					if(result.functor().toString().equals("timeout") ) {
//						if(result.arg(1) instanceof CompoundTerm c) {
//							if(c.arg(3) instanceof List dimesnsionSize)
//							info.put(i, ClpUtil.listToString(dimesnsionSize)+"\n");
//						}
//					}
				}
			} catch (EclipseException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				try {
					FileUtil.deleteEclFile(clp);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			//e.printStackTrace();
			//System.out.println("Fail");
					
			/*if(result.arg(1) instanceof CompoundTerm c ) {
			if(c.arg(1) != null)
			System.out.println("There has a feasiable path_"+i);};*/
			//System.out.println("~~~~~~~~~~~Solving Next~~~~~~~~~~~");
			// Print the result
			//System.out.println(ClpUtil.toJavaString(result));
		}
		System.out.println("Solving End~~~~~~");
		System.out.println(feasiablePath.toString());
		System.out.println(info.toString());
	}
}
