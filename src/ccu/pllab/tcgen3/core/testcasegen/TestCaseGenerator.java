package ccu.pllab.tcgen3.core.testcasegen;

import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.parctechnologies.eclipse.EclipseException;

import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph;
import ccu.pllab.tcgen3.symboltable.scope.Scope;
import ccu.pllab.tcgen3.util.StringTool;

public class TestCaseGenerator {
	Scope globalSymbolTable;
	CoverageCriterionManager coverageCriterionManager;
	Map<String,Map<Integer,String>> AlltestCase ;
	int maxloop;
	private String PROHECT_DIR = System.getProperty("user.dir");
	public TestCaseGenerator(Scope SymbolTable,int loopnum ) {
		this.globalSymbolTable = SymbolTable;
		AlltestCase =  new LinkedHashMap<>();
		maxloop = loopnum;
	}
	
	public Map<String,Map<Integer,String>> generateTestCases(List<CLGGraph> clgGraphs) {
		CLPSolver solver =null;
		 try {
			solver = new CLPSolver();
		} catch (IOException | EclipseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	//compile predefined CLP file		 
		 if(solver != null) {
			 Path predefined = Path.of(PROHECT_DIR,"output","CLP","staticArrayFunc");
			 try {
				solver.compile(predefined.toFile());
			} catch (EclipseException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		for(CLGGraph clg : clgGraphs) {
			coverageCriterionManager = new CoverageCriterionManager(globalSymbolTable, clg ,maxloop );
			coverageCriterionManager.genTestCase(solver);
			AlltestCase.put(clg.getFilename(), coverageCriterionManager.getTestCase());
			 System.out.println(StringTool.mapToString(coverageCriterionManager.getTest(),2));
		}
		
		return AlltestCase;
	}
}
