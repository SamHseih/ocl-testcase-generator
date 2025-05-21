package ccu.pllab.tcgen3.core.testmodelbuilder;

import java.io.IOException;
import java.nio.file.Path;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.Oclparser;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.umlparser.cdparser.CDparser;
import ccu.pllab.tcgen3.io.FileLoader;
import ccu.pllab.tcgen3.symboltable.scope.Scope;

public class ASTBuilder {
	private FileLoader fileLoader;
	private CDparser cdparser;
	private Oclparser oclparser;
	private Scope symboltable;
	private ASTree ast;

	public ASTBuilder(String[] args) {
		fileLoader = new FileLoader(args);
    }
	
	public void initializeFromArgs() {
        try {
            parseUML(fileLoader.getUmlPath());
            parseOCL(fileLoader.getOclPath());
        } catch (Exception e) {
            System.err.println("[TestModelBuilder] Error during initialization: " + e.getMessage());
            e.printStackTrace();
        }
    }

	private void parseUML(Path umlPath) {
		cdparser = new CDparser(umlPath);
        Scope cdScope = cdparser.parse();// 暫時不使用 cdScope，但會傳給 OCL parser
        // parse() 本身就會設定 cdparser 屬性 symboltable
	}

	private void parseOCL(Path oclPath) {
		Scope prdiefinedSymboltable = cdparser.getSymboltable();
        oclparser = new Oclparser(oclPath, prdiefinedSymboltable);
        try {
			oclparser.build();
		} catch (IOException e) {
			e.printStackTrace();
		}
        this.symboltable = oclparser.getSymbolTable();
        this.ast = oclparser.getAst(); 
	}
	
	 public Scope getSymboltable() {
	        return symboltable;
	    }

	    public ASTree getAST() {
	        return ast;
	    }
	
	 public static void main(String[] args) {
		 ASTBuilder builder = new ASTBuilder(args);
		 builder.initializeFromArgs();
		 
	 }
	
}
