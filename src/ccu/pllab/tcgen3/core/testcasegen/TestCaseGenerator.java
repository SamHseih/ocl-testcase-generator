package ccu.pllab.tcgen3.core.testcasegen;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph;
import ccu.pllab.tcgen3.symboltable.scope.Scope;

public class TestCaseGenerator {
	Scope globalSymbolTable;
	CoverageCriterionManager coverageCriterionManager;
	Map<String,Map<Integer,String>> AlltestCase ;
	int maxloop;
	
	public TestCaseGenerator(Scope SymbolTable,int loopnum ) {
		this.globalSymbolTable = SymbolTable;
		AlltestCase =  new LinkedHashMap<>();
		maxloop = loopnum;
	}
	
	public Map<String,Map<Integer,String>> generateTestCases(List<CLGGraph> clgGraphs) {
		for(CLGGraph clg : clgGraphs) {
			coverageCriterionManager = new CoverageCriterionManager(globalSymbolTable, clg ,maxloop );
			coverageCriterionManager.genTestCase();
			AlltestCase.put(clg.getFilename(), coverageCriterionManager.getTestCase());
		}
		return AlltestCase;
	}
}
