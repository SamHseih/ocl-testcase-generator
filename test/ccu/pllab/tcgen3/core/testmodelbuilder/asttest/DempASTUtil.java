package ccu.pllab.tcgen3.core.testmodelbuilder.asttest;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.ASTBuilder;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ContextExpAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.PackageDeclAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IfExp;
import ccu.pllab.tcgen3.io.FileLoader;
import ccu.pllab.tcgen3.util.ASTutil;
import ccu.pllab.tcgen3.visualization.AstVisualization;

public class DempASTUtil {
	public static void main(String[] args) {
		/* ------------------------------------------------------------------
         * 0.  Load UML / OCL model paths
         * ------------------------------------------------------------------ */
		FileLoader Loader = new FileLoader(args);
		if(args.length>1 && args.length<3) {
			System.out.println("Enter DC/DCC/MCC");
			System.exit(1);
		}
		/* ------------------------------------------------------------------
         * 1.  Build the original AST from the model files
         * ------------------------------------------------------------------ */
		 ASTBuilder astbuilder = new ASTBuilder(Loader.getOclPath(), Loader.getUmlPath());
		 astbuilder.build();
		 ASTree ast = astbuilder.getAST();
		 
		 /* ------------------------------------------------------------------
	         * 2.  Clone test
	         *     (a) create a deep copy via clone()
	         *     (b) confirm that the two trees are different objects
	         * ------------------------------------------------------------------ */
		 ASTree astclone = ast.clone();
		 
		 System.out.println("Clone success?  " +
		            (ast != astclone && ast.toString().equals(astclone.toString())));
		 System.out.println("======================= OriginAST =======================");
		 ASTutil.printAST(ast, ASTutil::dfsPost, 10);
		 System.out.println("======================= CloneAST =======================");
		 ASTutil.printAST(astclone, ASTutil::dfsPost, 10);
		 
		 /* ------------------------------------------------------------------
	         * 3.  De Morgan's laws test
	         * ------------------------------------------------------------------ */
		 
		 
		 List<ASTree> ctxs = new ArrayList<>();
		 List<ASTree> ifexps = new ArrayList<>();
		 ASTutil.dfsPre(ast,n-> {
			 if(n instanceof ContextExpAST b){
				 ctxs.add(b);
			 }
			 if(n instanceof IfExp ifexp) {
				 ifexps.add(ifexp);
			 }
			 
		 });
		 String dotfilename0 = ((PackageDeclAST) ast).getPackagename()+"_BinDeMorgan_Before.dot";
		 String svgfilename0 = ((PackageDeclAST) ast).getPackagename()+"_BinDeMorgan_Before.svg";
		 String dotpathstr0 = System.getProperty("user.dir")+"\\output\\AST\\"+dotfilename0;
	     String svgpathstr0 =  System.getProperty("user.dir")+"\\output\\AST\\"+svgfilename0;
		 Path dotpath0 = Paths.get(dotpathstr0);
		 Path svgpath0 = Paths.get(svgpathstr0);
		 ASTree binast = ctxs.get(0);
		 AstVisualization.printGraphvizSvg(dotpath0, svgpath0, binast);
		 
		 String dotfilename1 = ((PackageDeclAST) ast).getPackagename()+"_IfDeMorgan_Before.dot";
		 String svgfilename1 = ((PackageDeclAST) ast).getPackagename()+"_IfDeMorgan_Before.svg";
		 String dotpathstr1 = System.getProperty("user.dir")+"\\output\\AST\\"+dotfilename1;
	     String svgpathstr1 =  System.getProperty("user.dir")+"\\output\\AST\\"+svgfilename1;
		 Path dotpath1 = Paths.get(dotpathstr1);
		 Path svgpath1 = Paths.get(svgpathstr1);
		 ASTree ifast = ifexps.get(0);
		 AstVisualization.printGraphvizSvg(dotpath1, svgpath1, ifast);
		 
		 String dotfilename2 = ((PackageDeclAST) ast).getPackagename()+"_BinDeMorgan_After.dot";
		 String svgfilename2 = ((PackageDeclAST) ast).getPackagename()+"_BinDeMorgan_After.svg";
		 String dotpathstr2 = System.getProperty("user.dir")+"\\output\\AST\\"+dotfilename2;
	     String svgpathstr2 =  System.getProperty("user.dir")+"\\output\\AST\\"+svgfilename2;
		 Path dotpath2 = Paths.get(dotpathstr2);
		 Path svgpath2 = Paths.get(svgpathstr2);
		 ASTree nast = ASTutil.DeMorgan(ctxs.get(0));
		 AstVisualization.printGraphvizSvg(dotpath2, svgpath2, nast);
		 
		 String dotfilename3 = ((PackageDeclAST) ast).getPackagename()+"_IfDeMorgan_After.dot";
		 String svgfilename3 = ((PackageDeclAST) ast).getPackagename()+"_IfDeMorgan_After.svg";
		 String dotpathstr3 = System.getProperty("user.dir")+"\\output\\AST\\"+dotfilename3;
	     String svgpathstr3 =  System.getProperty("user.dir")+"\\output\\AST\\"+svgfilename3;
		 Path dotpath3 = Paths.get(dotpathstr3);
		 Path svgpath3 = Paths.get(svgpathstr3);
		 ASTree nast2 = ASTutil.DeMorgan(ifexps.get(0));
		 AstVisualization.printGraphvizSvg(dotpath3, svgpath3, nast2);
	 }
}
