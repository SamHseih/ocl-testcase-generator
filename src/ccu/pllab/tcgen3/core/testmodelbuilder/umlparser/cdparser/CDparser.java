package ccu.pllab.tcgen3.core.testmodelbuilder.umlparser.cdparser;

import java.nio.file.Path;

import ccu.pllab.tcgen3.symboltable.scope.Scope;

public class CDparser {
	private final Path umlPath;
	private Scope symboltable ; 
	
	public CDparser(Path umlPath) {
		if (umlPath == null) {
            throw new IllegalArgumentException("umlPath cannot be null");
        }
		this.umlPath = umlPath;
	}
	
	public Scope parse() {
		XmlParser parser = new XmlParser(umlPath);
		SymbolTableBuilder symbolTableBuilder = new SymbolTableBuilder(parser.getDocument());
		//System.out.println(parser);
		this.symboltable = symbolTableBuilder.build();
		System.out.println("======================================================================");
		System.out.println("================ Symbol table was built successfully. ================");
		System.out.println("======================================================================");
		System.out.println("If you want to see class info, please call XmlParser.toString() method.");
		return this.symboltable;
	}

	public Scope getSymboltable(){
		 if (this.symboltable == null) {
		        throw new IllegalStateException("Symbol table has not been built. Call parse() first.");
		    }
		    return this.symboltable;
	}
	
	@Override
	public String toString() {
		XmlParser parser = new XmlParser(umlPath);
		return parser.toString();
	}
}
