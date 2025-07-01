package ccu.pllab.tcgen3.core.testcasegen.test;

import java.util.List;
import java.util.Map;

import ccu.pllab.tcgen3.core.testcasegen.TestCaseGenerator;
import ccu.pllab.tcgen3.core.testmodelbuilder.ASTBuilder;
import ccu.pllab.tcgen3.core.testmodelbuilder.CLGbuilder;
import ccu.pllab.tcgen3.core.testmodelbuilder.Criterion;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph;
import ccu.pllab.tcgen3.io.FileLoader;

public class DemoTestCaseGenerator {
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
		 
		 List<CLGGraph> clgs = clgbuilder.getCLGGrapies();
		 int maxloop = 8;
		 
		 TestCaseGenerator tcgen = new TestCaseGenerator(astbuilder.getSymboltable(),maxloop);
		 Map<String,Map<Integer,String>> testcases = tcgen.generateTestCases(clgs);
		 System.out.println(testcases);
	}
}
