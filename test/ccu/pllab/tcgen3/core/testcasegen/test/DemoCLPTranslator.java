package ccu.pllab.tcgen3.core.testcasegen.test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import ccu.pllab.tcgen3.core.testcasegen.CLPTranslator;
import ccu.pllab.tcgen3.core.testcasegen.PathEnumerator;
import ccu.pllab.tcgen3.core.testmodelbuilder.ASTBuilder;
import ccu.pllab.tcgen3.core.testmodelbuilder.CLGbuilder;
import ccu.pllab.tcgen3.core.testmodelbuilder.Criterion;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGEdge;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph;
import ccu.pllab.tcgen3.io.FileLoader;
import ccu.pllab.tcgen3.symboltable.scope.Scope;
import ccu.pllab.tcgen3.util.ClpUtil;

public class DemoCLPTranslator {
	public static void main(String[] args) {
		FileLoader Loader = new FileLoader(args);
		if(args.length>1 && args.length<3) {
			System.out.println("Enter DC/DCC/MCC");
			System.exit(1);
		}
		 ASTBuilder astbuilder = new ASTBuilder(Loader.getOclPath(), Loader.getUmlPath());
		 astbuilder.build();
		 
		 Criterion criterion = switch(args[2]) {
		 case "DC" -> Criterion.DC;
		 case "DCC" -> Criterion.DCC;
		 case "MCC" -> Criterion.MCC;
		 default -> throw new IllegalArgumentException("Unexpected value: " + args[2]);
		 };
		 
		 CLGbuilder clgbuilder = new CLGbuilder(astbuilder.getAST(),astbuilder.getSymboltable(),criterion);
		 clgbuilder.build();
		 
		 List<CLGGraph> clg = clgbuilder.getCLGGrapies();
		 int nthCLG = 0; // Change this to select which CLG to translate
		 int cycle = 7;
		 PathEnumerator pathEnumerator = new PathEnumerator(clg.get(nthCLG),cycle);
		 //NestedLoopPathEnumerator  NestedpathEnumerator = new NestedLoopPathEnumerator(clg.get(nthCLG),1000 ,cycle);
		 System.out.println(clg.get(nthCLG).getFilename());
		 String ECL = clg.get(nthCLG).getFilename();
		 String classname = clg.get(nthCLG).getClassname();
		 String methodname = clg.get(nthCLG).getMethodname();
		 Scope currentscope = (Scope) astbuilder.getSymboltable().resolve(classname);
		       
		 if(!methodname.isEmpty()){
			 currentscope = (Scope) currentscope.resolve(methodname);
		 } 
		 int i = 1;
		 for(List<CLGEdge> path : pathEnumerator) {
			 System.out.println("Path "+i+": "+ path);
			 boolean isConstructor = false;
			 if(classname.equals(methodname)) {
				 isConstructor = true;
			 }
			 String filename = ECL+"_Path_"+i;
			 CLPTranslator translator = new CLPTranslator(path, currentscope,isConstructor,filename);
			 String clpcontent = translator.translate();
			 //System.out.println(translator.translate());
			 
			 Path outputpath = Paths.get(System.getProperty("user.dir")+"\\output\\CLP\\"+ filename);
			 
			 //System.out.println(translator.getRequestTerm());
			 try {
				ClpUtil.writeEclFile(outputpath, clpcontent);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 i++;
		 }
	}
}
