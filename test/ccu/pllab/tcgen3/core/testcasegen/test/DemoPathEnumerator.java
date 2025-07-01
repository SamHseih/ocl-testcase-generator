package ccu.pllab.tcgen3.core.testcasegen.test;

import java.util.List;

import ccu.pllab.tcgen3.core.testcasegen.PathEnumerator;
import ccu.pllab.tcgen3.core.testmodelbuilder.ASTBuilder;
import ccu.pllab.tcgen3.core.testmodelbuilder.CLGbuilder;
import ccu.pllab.tcgen3.core.testmodelbuilder.Criterion;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGEdge;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGNode;
import ccu.pllab.tcgen3.io.FileLoader;
import ccu.pllab.tcgen3.util.ClgUtil;

public class DemoPathEnumerator {
	public static void main(String[] args) {
		FileLoader Loader = new FileLoader(args);
		if(args.length>1 && args.length<3) {
			System.out.println("Enter DC/DCC/MCC");
			System.exit(1);
		}
		 ASTBuilder astbuilder = new ASTBuilder(Loader.getOclPath(), Loader.getUmlPath());
		 astbuilder.build();
		 
		 Criterion criterion = switch(args[2]) {
		 case "DC" -> Criterion.DC;
		 case "DCC" -> Criterion.DCC;
		 case "MCC" -> Criterion.MCC;
		 default -> throw new IllegalArgumentException("Unexpected value: " + args[2]);
		 };
		 	
		 CLGbuilder clgbuilder = new CLGbuilder(astbuilder.getAST(),astbuilder.getSymboltable(),criterion);
		 clgbuilder.build();
		 
		 List<CLGGraph> clg = clgbuilder.getCLGGrapies();
		 
		 /*
		 PathEnumerator pathEnumerator = new PathEnumerator(clg.get(1), 1000, 100);
		 System.out.println(clg.get(1).getFilename());
		 int i = 1;
		 for (List<CLGEdge> path : pathEnumerator) {
			 System.out.println("Path " + i++ + ":");
			 System.out.println(path);
		 }*/
		  
		 PathEnumerator pathEnumerator = new PathEnumerator(clg.get(1), 3);
		 System.out.println(clg.get(1).getFilename());
		 int i = 1;
		 for (List<CLGEdge> path : pathEnumerator) {
			 System.out.println("Path " + i++ + ": "+ path);
			 List<CLGNode> cs =  ClgUtil.collectExprNodes(path);
			 for(CLGNode c : cs) {
				 System.out.println(c.getExpr().toClgString());
			 }
		 }
		 
	}
}
