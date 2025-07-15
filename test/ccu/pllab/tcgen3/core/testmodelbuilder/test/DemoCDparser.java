package ccu.pllab.tcgen3.core.testmodelbuilder.test;

import java.nio.file.Path;

import ccu.pllab.tcgen3.core.testmodelbuilder.umlparser.cdparser.CDparser;

public class DemoCDparser {
	public static void main(String[] args) {
		//Path umlPath = Path.of("spec", "MultiDimArray.uml");
		Path umlPath = Path.of("F:\\papyrus\\WorkSpace","ThreeDimStaticArray", "ThreeDimStaticArray.uml");
		CDparser parser = new CDparser(umlPath);
		parser.parse();
		System.out.println("Symbol table: " + parser.getSymboltable());
		System.out.println("Parsing completed.\n");
	}
}
