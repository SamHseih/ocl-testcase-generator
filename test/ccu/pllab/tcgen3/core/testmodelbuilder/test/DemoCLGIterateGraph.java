package ccu.pllab.tcgen3.core.testmodelbuilder.test;

import java.util.ArrayList;
import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.ASTBuilder;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.builder.DcCLGBuilder;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.AstVisitor;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IterateExp;
import ccu.pllab.tcgen3.io.FileLoader;
import ccu.pllab.tcgen3.symboltable.scope.Scope;
import ccu.pllab.tcgen3.util.AstUtil;
import ccu.pllab.tcgen3.visualization.ClgVisualization;

public class DemoCLGIterateGraph {
	public static void main(String[] args) {
		FileLoader Loader = new FileLoader(args);
		if(args.length>1 && args.length<3) {
			System.out.println("Enter DC/DCC/MCC");
			System.exit(1);
		}
		 ASTBuilder astbuilder = new ASTBuilder(Loader.getOclPath(), Loader.getUmlPath());
		 astbuilder.build();
		 ASTree ast = astbuilder.getAST();
		 
		 List<ASTree> iterates = new ArrayList<>();
		 AstUtil.dfsPre(ast,n-> {
			 if(n instanceof IterateExp)
				 iterates.add(n);
		 });
		 
		 ASTree i = iterates.get(0);
	        //System.out.println("--- Iteration AST result ---");
	        //System.out.println(AstVisualization.toGraphvizDot(i));
	        Scope globolsymboltable = astbuilder.getSymboltable();
	        AstVisitor<CLGGraph> visitor = new  DcCLGBuilder<CLGGraph>(globolsymboltable);
	        CLGGraph gI = i.accept(visitor);
	        //gI.graphClosure();                    // (E)+
	        System.out.println("--- Iterate result ---");
	        System.out.println(ClgVisualization.toGraphvizDot(gI));
	}
}
