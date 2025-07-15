package ccu.pllab.tcgen3.core.testmodelbuilder.test;

import java.nio.file.Path;

import org.w3c.dom.Document;

import ccu.pllab.tcgen3.core.testmodelbuilder.umlparser.cdparser.XmlParser;

public class DemoXmlParser {
	/**
	 * Main method for testing the XML parser.
	 * 
	 * @param args command line arguments (not used)
	 */
	public static void main(String[] args) {
		 try {
			// ´ú¸Õ¥Î¨Ò
			Path umlPath = Path.of(".\\spec\\Cube.uml");
			XmlParser parser = new XmlParser(umlPath);
			Document doc = parser.getDocument();			
            
         // Invoke each method to retrieve the relevant sections
            System.out.println("=== (1) UML Class Info ===");
            System.out.println(parser.parseClassInfo());

            System.out.println("=== (2) UML Association Info ===");
            System.out.println(parser.parseAssociationInfo());

            System.out.println("=== (3) UML Package (Primitivetype) Info ===");
            System.out.println(parser.parsePrimitivePackageInfo());

            System.out.println("=== (4) UML Package (Referencetype) Info ===");
            System.out.println(parser.parseReferencePackageInfo());
            
        } catch (Exception e) {
        		e.printStackTrace();
        }
	}
}
