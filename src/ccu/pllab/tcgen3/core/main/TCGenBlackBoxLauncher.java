package ccu.pllab.tcgen3.core.main;

import java.util.Map;

import ccu.pllab.tcgen3.core.testcasegen.TestCaseGenerator;
import ccu.pllab.tcgen3.core.testmodelbuilder.TestmodelBuilder;
import ccu.pllab.tcgen3.core.testscriptgen.TestScriptGenerator;

public class TCGenBlackBoxLauncher {
	public static void main(String[] args) {
		
		TestmodelBuilder modelbuilder = new TestmodelBuilder(args);
/*build AST/CLG*/
		modelbuilder.build();
/*output AST/CLG Graph*/
		modelbuilder.genGraph();
		System.out.println("Test model generation completed successfully.");
/*Generate Test Case , need set loop max*/
		TestCaseGenerator generator = new TestCaseGenerator(modelbuilder.getSymbolTable(),10);
		Map<String,Map<Integer,String>> testcase  = generator.generateTestCases(modelbuilder.getCLGs());
		System.out.println("Test cases generated successfully.");
/*Generate Test Script*/
//		TestScriptGenerator scriptGenerator = new TestScriptGenerator(testcase);
//		scriptGenerator.generateScripts();
		System.out.println("Test case scripts generated successfully.");
		
	}
}
