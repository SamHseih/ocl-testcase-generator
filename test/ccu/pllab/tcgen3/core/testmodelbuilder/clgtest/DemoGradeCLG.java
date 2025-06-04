package ccu.pllab.tcgen3.core.testmodelbuilder.clgtest;

import ccu.pllab.tcgen3.core.testmodelbuilder.ASTBuilder;
import ccu.pllab.tcgen3.core.testmodelbuilder.CLGbuilder;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.Criterion;
import ccu.pllab.tcgen3.io.FileLoader;

/** Run Configuration > Arguments<br> 
 * arg1: &lt; Papyrus WorkSpace dir &gt;<br> 
 * arg2: &lt; projectname &gt;<br> 
 * arg3: &lt; "DC"/"DCC"/"MCC" &gt;<br> 
 *  */
public class DemoGradeCLG {
	//test main
	public static void main(String[] args) {
		FileLoader Loader = new FileLoader(args);
		if(args.length>1 && args.length<3) {
			System.out.println("Enter DC/DCC/MCC");
			System.exit(1);
		}
		 ASTBuilder astbuilder = new ASTBuilder(Loader.getOclPath(), Loader.getUmlPath());
		 astbuilder.build();
		 //astbuilder.printAST(dotpath, svgpath, ast);
		 
		 Criterion criterion = switch(args[2]) {
		 case "DC" -> Criterion.DC;
		 case "DCC" -> Criterion.DCC;
		 case "MCC" -> Criterion.MCC;
		 default -> throw new IllegalArgumentException("Unexpected value: " + args[2]);
		 };

		 CLGbuilder clgbuilder = new CLGbuilder(astbuilder.getAST(),astbuilder.getSymboltable(),criterion);
		 clgbuilder.build();
		 
		 clgbuilder.genCLGGraph();
		 /*List<CLGGraph> clgs = clgbuilder.getCLGGrapies();		 
		 PackageDeclAST p = (PackageDeclAST) astbuilder.getAST();
		 for(int i = 0; i< p.numChildren(); i++) {
			 StringBuilder filename = new StringBuilder();
			 filename.append(p.getPackagename()).append("_");
			if(p.child(i) instanceof ContextDeclAST ctx) {
				filename.append(ctx.getFilename());
			}
			 String cube_dotfilename = filename.toString()+".dot";
			 String cube_svgfilename = filename.toString()+".svg";
			 Path cube_dotpath = Paths.get(System.getProperty("user.dir")+"\\output\\CLG\\"+cube_dotfilename);
			 Path cube_svgpath =  Paths.get(System.getProperty("user.dir")+"\\output\\CLG\\"+cube_svgfilename);
			 ClgVisualization.printGraphvizSvg(cube_dotpath, cube_svgpath, clgs.get(i)); 
		 }*/
	 }
	
}
