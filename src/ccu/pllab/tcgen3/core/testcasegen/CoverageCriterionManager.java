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
	private String PROHECT_DIR = System.getProperty("user.dir");
	
	private List<String> logMessage = new ArrayList<>();
	//<PathNum , TestCaseStr>
	private Map<Integer,String> testCaseStr = new LinkedHashMap<>();

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
	
	//INFINITY Loop
	public CoverageCriterionManager(Scope globalSymbolTable, CLGGraph clgGraph) {
		this.globalSymbolTable = globalSymbolTable;
		this.clg = clgGraph;
		this.meetCriterion = false;
		this.maxUnoll = Integer.MAX_VALUE; // default maxUnoll
	}

	public void genTestCase() {
		PathEnumerator pathEnumerator = new PathEnumerator(this.clg,maxUnoll);

		for (List<CLGEdge> path : pathEnumerator) {
			 CLPSolver solver =null;
			 try {
				solver = new CLPSolver();
			} catch (IOException | EclipseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			 
			 if(solver != null) {
				 Path predefined = Path.of(PROHECT_DIR,"output","CLP","staticArrayFunc");
				 try {
					solver.compile(predefined.toFile());
				} catch (EclipseException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
				 //get clg symboltable
				 Scope currentscope = null;
				 if( globalSymbolTable.resolve(clg.getClassname()) instanceof Scope classsymbol){
					 currentscope = classsymbol; 
					 //operation clg
					 if(!clg.getMethodname().isEmpty()) {
						 currentscope = (Scope) currentscope.resolve(clg.getMethodname());
					 } 
				 }
				 
				 //genCLPcode 
				 CLPTranslator translator = new CLPTranslator(path, currentscope,pathNUm);
				 String CLPCode = translator.translate();
				 String eclfilename = clg.getFilename()+"_Path_"+pathNUm;
				 Path outputpath = Paths.get(System.getProperty("user.dir")+"\\output\\CLP\\"+ eclfilename);
				 try {
						ClpUtil.writeEclFile(outputpath, CLPCode);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 //COMPILE ecl
				 try {
					solver.compile(outputpath.toFile());
				} catch (EclipseException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				 //Solving
				 String SolvingHead = translator.getRequestTerm();
				 String goal = "timeout("+SolvingHead+",0.0001"+",true"+")";
				 //Feasiable
				 try {
						CompoundTerm result = solver.getEngine().rpc(goal);
						//System.out.println(result);
						testCaseStr.put(pathNUm,"There has a feasiable path.");
						testcaseNum++;
						
				//InFeasiable
					} catch (EclipseException e) {
						//e.printStackTrace();
						try {
							FileUtil.deleteEclFile(outputpath);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				 pathNUm++;
			 }
		
		}
		System.out.print("genTestCase End~~~~~~");
	}
	
	
}
