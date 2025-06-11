package ccu.pllab.tcgen3.core.testmodelbuilder.test;

import java.nio.file.Path;

import org.w3c.dom.Document;

import ccu.pllab.tcgen3.core.testmodelbuilder.umlparser.cdparser.SymbolTableBuilder;
import ccu.pllab.tcgen3.core.testmodelbuilder.umlparser.cdparser.XmlParser;
import ccu.pllab.tcgen3.symboltable.scope.Scope;

public class DemoSymbolTableBuilder {
	// Test the SymbolTableBuilder
	public static void main(String[] args) {
		try {
			//Path umlPath = Path.of("F:\\papyrus\\WorkSpace\\Cube\\Cube.uml");
			//Path umlPath = Path.of("F:\\papyrus\\WorkSpace\\MultiDimArray\\MultiDimArray.uml");
			Path umlPath = Path.of("F:\\papyrus\\WorkSpace\\ThreeDimStaticArray\\ThreeDimStaticArray.uml");

			XmlParser parser = new XmlParser(umlPath);
			Document document = parser.getDocument();
			SymbolTableBuilder symbolTableBuilder = new SymbolTableBuilder(document);
			Scope symbolTable = symbolTableBuilder.build();
			System.out.println("Symbol Table: \n" + symbolTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
