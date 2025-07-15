package ccu.pllab.tcgen3.core.testcasegen;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.parctechnologies.eclipse.CompoundTerm;
import com.parctechnologies.eclipse.EclipseException;

import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGEdge;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph;
import ccu.pllab.tcgen3.symboltable.scope.Scope;
import ccu.pllab.tcgen3.util.ClpUtil;
import ccu.pllab.tcgen3.util.FileUtil;

public class CoverageCriterionManager {
	private Scope globalSymbolTable;
	private CLGGraph clg;
	private boolean meetCriterion;
	private int testcaseNum = 0;
	private int pathNUm;
	private int maxUnoll;
	
	private List<String> logMessage = new ArrayList<>();
	//<PathNum , TestCaseStr>
	private Map<Integer,String> testCaseStr = new LinkedHashMap<>();
	private Map<Integer,String> test = new LinkedHashMap<>();
	
	//Boundary value for unroll, default is Integer.MAX_VALUE
	public CoverageCriterionManager(Scope globalSymbolTable, CLGGraph clgGraph, int maxUnoll) {
		this.globalSymbolTable = globalSymbolTable;
		this.clg = clgGraph;
		this.meetCriterion = false;
		this.maxUnoll = maxUnoll; 
		pathNUm = 1;
	}
	
	public List<String> getlogMessage(){
		return this.logMessage;
	}
	
	public Map<Integer,String> getTestCase(){
		return this.testCaseStr;
	}
	
	public Map<Integer,String> getTest(){
		return this.test;
	}
	
	//INFINITY Loop
	public CoverageCriterionManager(Scope globalSymbolTable, CLGGraph clgGraph) {
		this.globalSymbolTable = globalSymbolTable;
		this.clg = clgGraph;
		this.meetCriterion = false;
		this.maxUnoll = Integer.MAX_VALUE; // default maxUnoll
	}

	public void genTestCase(CLPSolver solver) {
		PathEnumerator pathEnumerator = new PathEnumerator(this.clg,maxUnoll);
		
		for (List<CLGEdge> path : pathEnumerator) {
//get CLG symboltable
				 Scope currentscope = null;
				 if( globalSymbolTable.resolve(clg.getClassname()) instanceof Scope classsymbol){
					 currentscope = classsymbol; 
					 //operation clg
					 if(!clg.getMethodname().isEmpty()) {
						 currentscope = (Scope) currentscope.resolve(clg.getMethodname());
					 }
				 }
				 
//Generate ECLiPSe CLPcode: PathCLP && WrapperCLP
				 boolean isConstructor = false;
				 if(clg.getClassname().equals(clg.getMethodname())) {
					 isConstructor = true;
				 }
				 String eclfilename = clg.getFilename()+"_Path_"+pathNUm;
				 
				 CLPTranslator translator = new CLPTranslator(path, currentscope,isConstructor,eclfilename);
				 String CLPCode = translator.translate();
				
				 Path outputpath = Paths.get(System.getProperty("user.dir")+"\\output\\CLP\\"+ eclfilename);
				 try {
						ClpUtil.writeEclFile(outputpath, CLPCode);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//Compile  ECLiPSe CLPcode <eclfilename>.ecl
				 try {
					solver.compile(outputpath.toFile());
				} catch (EclipseException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
//Solving ECLiPSe CLP Code , Predicte is timeout(eclfilename,0.01,true).
				 String SolvingHead = translator.getRequestTerm();
				 String goal = "timeout("+SolvingHead+",0.01"+",true"+")";
				 
				 CompoundTerm result = solver.solve(goal,outputpath);
//Feasiable
				if(result != null) {
				
				testCaseStr.put(pathNUm,"There has a feasiable path.");
//Boundary Analysis
				
//Test Case OutPut				
				test.put(pathNUm,result.toString());
				testcaseNum++;
				pathNUm++;
				//if(!translator.getisVarArray()) {break;}
				}
//InFeasiable
				else {
					
				pathNUm++;	
				}
			 }
		System.out.println(clg.getFilename()+"genTestCase End~~~~~~");
	}

	private String resultToString(CompoundTerm result) {
		return null;
	}
	
	
}
