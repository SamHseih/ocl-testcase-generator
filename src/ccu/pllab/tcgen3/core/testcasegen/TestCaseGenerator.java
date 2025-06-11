package ccu.pllab.tcgen3.core.testcasegen;

import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.TestmodelBuilder;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph;
import ccu.pllab.tcgen3.symboltable.scope.Scope;

public class TestCaseGenerator {
	Scope globalSymbolTable;
	CoverageCriterionManager coverageCriterionManager;
	public TestCaseGenerator(Scope SymbolTable) {
		this.globalSymbolTable = SymbolTable;
		
	}
	
	public void generateTestCases(List<CLGGraph> clgGraphs) {
		for(CLGGraph clg : clgGraphs) {
			coverageCriterionManager = new CoverageCriterionManager(globalSymbolTable, clg);
			coverageCriterionManager.genTestCase();
			coverageCriterionManager.getTestCases();
		}
	}
}
