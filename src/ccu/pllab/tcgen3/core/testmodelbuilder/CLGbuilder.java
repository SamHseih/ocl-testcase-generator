package ccu.pllab.tcgen3.core.testmodelbuilder;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.Criterion;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.visitor.DcCLGBuilderVisitor;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.visitor.DccCLGBuilderVisitor;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.visitor.MccCLGBuilderVisitor;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.CLGAstVisitor;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ContextDeclAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.PackageDeclAST;
import ccu.pllab.tcgen3.symboltable.scope.Scope;
import ccu.pllab.tcgen3.visualization.ClgVisualization;

public class CLGbuilder {
	private	final ASTree root;
	private	final Scope globolsymboltable;
	private	final Criterion criterion;
	private List<CLGGraph> clgs;

	
	public CLGbuilder(ASTree ast, Scope symboltable, Criterion criterion) {
		this.root = ast;
		this.globolsymboltable = symboltable;
		this.criterion = criterion;
		this.clgs = new ArrayList<>();
	}
	
	public void build() {
		CLGAstVisitor<CLGGraph> visitor = switch(criterion) {
			case DC -> new  DcCLGBuilderVisitor<CLGGraph>(globolsymboltable);
			case DCC -> new  DccCLGBuilderVisitor<CLGGraph>(globolsymboltable);
			case MCC -> new  MccCLGBuilderVisitor<CLGGraph>(globolsymboltable);
		  /*case DCDUP -> new DcdupCLGBuilderVisitor<CLGGraph>(globolsymboltable);
			case DCCDUP -> new DccddupCLGBuilderVisitor<CLGGraph>(globolsymboltable);
			case MCCDUP -> new MccddupCLGBuilderVisitor<CLGGraph>(globolsymboltable);*/
		};
	
		//parser each ContextDeclAST and build CLGS
		for(ASTree ctxDecl: root) {
			CLGGraph ctx = ctxDecl.accept(visitor);
			if(ctx != null )clgs.add(ctx);
			else System.err.println(visitor.getErrorMesg());
		}
	}
	
	public List<CLGGraph> getCLGGrapies(){
		return this.clgs;
	}
	
	public void genCLGGraph() {
		PackageDeclAST p = (PackageDeclAST) root;
		 for(int i = 0; i< p.numChildren(); i++) {
			 StringBuilder filename = new StringBuilder();
			 filename.append(p.getPackagename()).append("_");
			if(p.child(i) instanceof ContextDeclAST ctx) {
				filename.append(ctx.getFilename());
			}
			 String dotfilename = filename.toString()+".dot";
			 String svgfilename = filename.toString()+".svg";
			 Path dotpath = Paths.get(System.getProperty("user.dir")+"\\output\\CLG\\"+dotfilename);
			 Path svgpath =  Paths.get(System.getProperty("user.dir")+"\\output\\CLG\\"+svgfilename);
			 ClgVisualization.printGraphvizSvg(dotpath, svgpath, clgs.get(i)); 
		 }
	}
	
} 
