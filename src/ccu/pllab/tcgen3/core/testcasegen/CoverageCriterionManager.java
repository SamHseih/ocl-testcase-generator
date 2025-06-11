package ccu.pllab.tcgen3.core.testcasegen;

import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGEdge;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph;
import ccu.pllab.tcgen3.symboltable.scope.Scope;

public class CoverageCriterionManager {
	private Scope globalSymbolTable;
	private CLGGraph clg;
	private boolean meetCriterion;
	
	private int maxUnoll;

	//Boundary value for unroll, default is Integer.MAX_VALUE
	public CoverageCriterionManager(Scope globalSymbolTable, CLGGraph clgGraph, int maxUnoll) {
		this.globalSymbolTable = globalSymbolTable;
		this.clg = clgGraph;
		this.meetCriterion = false;
		this.maxUnoll = maxUnoll; 
	}
	public CoverageCriterionManager(Scope globalSymbolTable, CLGGraph clgGraph) {
		this.globalSymbolTable = globalSymbolTable;
		this.clg = clgGraph;
		this.meetCriterion = false;
		this.maxUnoll = Integer.MAX_VALUE; // default maxUnoll
	}

	public void genTestCase() {
		PathEnumerator pathEnumerator = new PathEnumerator(this.clg,maxUnoll);
		for (List<CLGEdge> path : pathEnumerator) {
			 
		 }
		
	}
	
}
