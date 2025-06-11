package ccu.pllab.tcgen3.core.main;

import ccu.pllab.tcgen3.core.testcasegen.TestCaseGenerator;
import ccu.pllab.tcgen3.core.testmodelbuilder.TestmodelBuilder;

public class TCGenBlackBoxLauncher {
	public static void main(String[] args) {
		
		TestmodelBuilder builder = new TestmodelBuilder(args);
		builder.build();
		builder.genGraph();
		System.out.println("Test model generation completed successfully.");
		TestCaseGenerator generator = new TestCaseGenerator(builder.getCLG());
		generator.generateTestCases();
		System.out.println("Test cases generated successfully.");
		TestCaseScriptGenerator scriptGenerator = new TestCaseScriptGenerator(generator.getTestCases());
		scriptGenerator.generateScripts();
		System.out.println("Test case scripts generated successfully.");
		
	}
}
