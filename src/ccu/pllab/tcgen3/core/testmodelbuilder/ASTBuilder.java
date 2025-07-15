package ccu.pllab.tcgen3.core.testmodelbuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.Oclparser;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ContextDeclAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.PackageDeclAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.umlparser.cdparser.CDparser;
import ccu.pllab.tcgen3.symboltable.scope.Scope;
import ccu.pllab.tcgen3.visualization.AstVisualization;
import ccu.pllab.tcgen3.visualization.ClgVisualization;
import ccu.pllab.tcgen3.visualization.DotFileConverter;

public class ASTBuilder {
	private Path oclpath;
	private Path umlpath;
	private CDparser cdparser;
	private Oclparser oclparser;
	private Scope symboltable;
	private ASTree ast;

	public ASTBuilder(Path oclpath, Path umlpath) {
		this.oclpath = oclpath;
		this.umlpath = umlpath;
	}
	
	public void build() {
        try {
            parseUML(umlpath);
            parseOCL(oclpath);
        } catch (Exception e) {
            System.err.println("[ASTBuilder] Error during initialization: " + e.getMessage());
            e.printStackTrace();
        }
    }

	/* Public Helper*/
	public Scope getSymboltable() {
	        return symboltable;
	    }

	public ASTree getAST() {
	        return ast;
	    }
	
	public void genASTGraph() {
		//Print Separate AST for each ContextDeclAST
		PackageDeclAST p = (PackageDeclAST) ast;
		 for(int i = 0; i< p.numChildren(); i++) {
			 StringBuilder filename = new StringBuilder();
			 filename.append(p.getPackagename()).append("_");
			if(p.child(i) instanceof ContextDeclAST ctx) {
				filename.append(ctx.getFilename());
			}
			 String dotfilename = filename.toString()+"_AST.dot";
			 String svgfilename = filename.toString()+"_AST.svg";
			 Path dotpath = Paths.get(System.getProperty("user.dir")+"\\output\\AST\\"+dotfilename);
			 Path svgpath =  Paths.get(System.getProperty("user.dir")+"\\output\\AST\\"+svgfilename);
			 AstVisualization.printGraphvizSvg(dotpath, svgpath, ast.child(i)); 
		 }
		 //print Total AST
		 String dotfilename = p.getPackagename()+"_AST.dot";
		 String svgfilename = p.getPackagename()+"_AST.svg";
		 Path dotpath = Paths.get(System.getProperty("user.dir")+"\\output\\AST\\"+dotfilename);
		 Path svgpath =  Paths.get(System.getProperty("user.dir")+"\\output\\AST\\"+svgfilename);
		 AstVisualization.printGraphvizSvg(dotpath, svgpath, ast); 
	}
		
	/* Inner Helper*/
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
	
}
