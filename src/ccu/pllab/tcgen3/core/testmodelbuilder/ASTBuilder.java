package ccu.pllab.tcgen3.core.testmodelbuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import ccu.pllab.tcgen3.core.testmodelbuilder.clgbuilder.CLGbuilder;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.Oclparser;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.PackageDeclAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.umlparser.cdparser.CDparser;
import ccu.pllab.tcgen3.io.FileLoader;
import ccu.pllab.tcgen3.symboltable.scope.Scope;
import ccu.pllab.tcgen3.visualization.AstVisualization;
import ccu.pllab.tcgen3.visualization.DotFileConverter;

public class ASTBuilder {
	private FileLoader fileLoader;
	private CDparser cdparser;
	private Oclparser oclparser;
	private Scope symboltable;
	private ASTree ast;
	private CLGbuilder clgbulder;
	private String criterion;

	//args <papyrus workspace dir> <project Name> <DC/DCC/MCC default DC>
	public ASTBuilder(String[] args) {
		if(args.length<3) {
			System.out.println("Enter DC/DCC/MCC");
			System.exit(1);
		}else {
			this.criterion = args[2];
			fileLoader = new FileLoader(args);
			}
		
    }
	
	public void initializeFromArgs() {
        try {
            parseUML(fileLoader.getUmlPath());
            parseOCL(fileLoader.getOclPath());
        } catch (Exception e) {
            System.err.println("[TestModelBuilder] Error during initialization: " + e.getMessage());
            e.printStackTrace();
        }
        printAST();
 
        clgbulder = new CLGbuilder(ast,symboltable);
    }

	public Scope getSymboltable() {
	        return symboltable;
	    }

	public ASTree getAST() {
	        return ast;
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
	
	private void printAST() {
		 try {
			 String dotfilename = ((PackageDeclAST) ast).getASTfilname()+"1.dot";
			 String svgfilename = ((PackageDeclAST) ast).getASTfilname()+"1.svg";
			 String dotpathstr = System.getProperty("user.dir")+"\\output\\AST\\"+dotfilename;
		     String svgpathstr =  System.getProperty("user.dir")+"\\output\\AST\\"+svgfilename;
			 Path dotpath = Paths.get(dotpathstr);
			 Path svgpath = Paths.get(svgpathstr);
				String astcontent = AstVisualization.toGraphviz(ast);
	            Files.createDirectories(dotpath.getParent());
	            Files.writeString(dotpath, astcontent, StandardCharsets.UTF_8);
	            System.out.println("DOT file output successfully：" + dotpath);
	            
	            DotFileConverter.convertDotToImage(dotpath, svgpath);
	            System.out.println("SVG file output successfully：" + svgpath);
	        } catch (Exception e) {
	            System.err.println("Write file fail：" + e.getMessage());
	            e.printStackTrace();
	        }
        
	}
	
	//test main
	public static void main(String[] args) {
		 ASTBuilder builder = new ASTBuilder(args);
		 builder.initializeFromArgs();
	 }
	
}
