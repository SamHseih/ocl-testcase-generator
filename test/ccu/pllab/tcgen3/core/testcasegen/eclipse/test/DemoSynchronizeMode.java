package ccu.pllab.tcgen3.core.testcasegen.eclipse.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.parctechnologies.eclipse.CompoundTerm;
import com.parctechnologies.eclipse.EclipseEngine;
import com.parctechnologies.eclipse.EclipseEngineOptions;
import com.parctechnologies.eclipse.EclipseException;
import com.parctechnologies.eclipse.EmbeddedEclipse;

public class DemoSynchronizeMode {
	 private final EclipseEngine engine;
	    public DemoSynchronizeMode() throws EclipseException, IOException {
			File eclipseHome = new File("C:\\ECLiPSe");
	    	EclipseEngineOptions opt = new EclipseEngineOptions(eclipseHome);
			opt.setUseQueues(false);                  // ���� RPC�A�Ȥ��}�Ҧ�C
	        // �Y�n�� ECLiPSe �����J�A�g�n�� .ecl �ɡG
	        this.engine = EmbeddedEclipse.getInstance(opt);  
	    }
	    
	    public void compile(File eclfile) throws EclipseException, IOException {
	    	this.engine.compile(eclfile);
	    }

	    
	    public void solve(String goal)  {
	    	try {
	            //2-1. ����� goal�A�^�Ƿ|�a�X���G�ܼ�
	            engine.rpc(goal);
	            
	            // 2-2. ����è��^��n�Ȫ� Result
	            CompoundTerm solved = engine.rpc(goal);
	            
	            // 2-3. solved �� goal �P�ΡA�̥~�h ','/2�F�̫�@�l goal �O Result = [...]
	            System.out.println("Class�G " + solved.getClass()); //solve_path
	            System.out.println("functor�G " + solved.functor()); //solve_path
	            System.out.println("argNum�G " + solved.arity());//6
	            for(int i=1 ; i<=solved.arity();i++) {
	            	System.out.println("ObjClass�G " + solved.arg(i).getClass());
	            	System.out.println("toString�G " + solved.arg(i).toString());
	            	if(solved.arg(i) instanceof CompoundTerm arg) {
	            		System.out.println("arg i (" + i + ")");
						System.out.println("arg.functor()�G " + arg.functor());
						System.out.println("arg.arity()�G " + arg.arity());
						for(int j=1 ; j<=arg.arity();j++) {
							System.out.println("ObjClass�G " + arg.arg(j).getClass());
							System.out.println("arg.arg("+j+")�G " + arg.arg(j).toString());
						}
					}
	            	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public void close() {
	        try {
				((EmbeddedEclipse) this.engine).destroy();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    public static void main(String[] args) {
	    	Path eclpath = Paths.get(System.getProperty("user.dir"),"example","example.ecl");
	    	File eclfile = eclpath.toFile();
	    	
	    	Path eclpath2 = Paths.get(System.getProperty("user.dir"),"example","example2.ecl");
	    	File eclfile2 = eclpath2.toFile();
	    	
	    	// ���]�A�b .ecl �ɤ��w�q�F�G
            // solve_path([], [ScorePre], [], [Score], [Number], []) :- ...constraints...
    		
            // �غc�A�n���檺 goal�A�o�̬O�@�� RPC �I�s
    		String goal = "solve_path(Obj_pre,Arg_pre,Obj,Arg,Result,Exception)";
    		String goal2 = "sum_list([1,2,3,4],Sum)"
    				+ ",array_data(Array,[2,2])";
    		try {
				DemoSynchronizeMode demo = new DemoSynchronizeMode();
				demo.compile(eclfile);
				demo.compile(eclfile2);
				demo.solve(goal);
				demo.solve(goal2);
			} catch (EclipseException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	
	    }
	    //another demo
	    /* 
	    public static void main(String[] args) throws Exception {

	        EclipseEngine eng = EmbeddedEclipse.getInstance(
	                new EclipseEngineOptions(new File("C:\\ECLiPSe")));
	        try {
	        eng.rpc("writeln('before-crash'), flush(output).");
	        // �o��|�� *�P�@�� JVM �i�{* �������� exit(99) ��
	        eng.rpc("exit(99).");            // �� 99 �u�O�ܷN
	        } catch (Exception t) {                // �s�u�Q���|�� Throw
	            System.err.println("�l��{�w�����AJVM �~��]�I");
	            t.printStackTrace();
	        }
	        EclipseEngine eng2 = EmbeddedEclipse.getInstance(
	                new EclipseEngineOptions(new File("C:\\ECLiPSe")));
	        eng2.rpc("lib(ic).");
	        System.out.println(eng2.rpc("writeln('New process OK'), flush(output)."));
	      
	        // **�H�U�{���û����|�Q����**
	        System.out.println("�A�ݤ����");
	    }*/
}
