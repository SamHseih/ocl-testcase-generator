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
import com.parctechnologies.eclipse.OutOfProcessEclipse;


public class DemononSynchronizeMode {
	private final EclipseEngine engine;
    public DemononSynchronizeMode() throws EclipseException, IOException {
		EclipseEngineOptions opt = new EclipseEngineOptions(new File("C:\\ECLiPSe"));
        opt.setUseQueues(false);                    // 先用 RPC，暫不開啟佇列
        // 若要讓 ECLiPSe 先載入你寫好的 .ecl 檔：
        //this.engine = new OutOfProcessEclipse(opt); 
        this.engine = EmbeddedEclipse.getInstance(opt);        
    }
    public void compile(File eclfile) throws EclipseException, IOException {
		this.engine.compile(eclfile);
	}

    
    public void solve(String goal)  {
    	try {
    		// 2-1. 執行該 goal，回傳會帶出結果變數    		
            engine.rpc(goal);
            
            // 2-2. 執行並取回填好值的 Result
            CompoundTerm solved = engine.rpc(goal);
            
            // 2-3. solved 跟 goal 同形，最外層 ','/2；最後一子 goal 是 Result = [...]
            System.out.println("ObjClass： " + solved.getClass()); //solve_path
            System.out.println("functor： " + solved.functor()); //solve_path
            System.out.println("argNum： " + solved.arity());//6
            for(int i=1 ; i<=solved.arity();i++) {
            	System.out.println("ObjClass： " + solved.arg(i).getClass());
            	System.out.println("toString： " + solved.arg(i).toString());
            	if(solved.arg(i) instanceof CompoundTerm arg) {
            		System.out.println("arg i (" + i + ")");
					System.out.println("arg.functor()： " + arg.functor());
					System.out.println("arg.arity()： " + arg.arity());
					for(int j=1 ; j<=arg.arity();j++) {
						System.out.println("ObjClass： " + arg.arg(j).getClass());
						System.out.println("arg.arg("+j+")： " + arg.arg(j).toString());
						if(arg.arg(j) instanceof CompoundTerm c) {
							System.out.println("Special_j ObjClass： " + c.arg(1).getClass());
							System.out.println("Special_j arg.arg("+j+")： " + c.arg(1).toString());
							if(c.arg(1) instanceof CompoundTerm c2) {
								System.out.println("Special arg.arg("+j+") functor： " + c2.functor());
								System.out.println("Special arg.arg("+j+") arity： " + c2.arity());
								for(int k=1 ; k<=c2.arity();k++) {
									System.out.println("Special ObjClass： " + c2.arg(k).getClass());
									System.out.println("Special arg.arg("+j+").arg("+k+")： " + c2.arg(k).toString());
								}
							}
						}
						
					}
				}
            	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
            //System.out.println("Atom : " + solved.arg(1).toString()); //Obj_pre
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
			((OutOfProcessEclipse) this.engine).destroy();
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
        // 假設你在 .ecl 檔中定義了：
        // solve_path([], [ScorePre], [], [Score], [Number], []) :- ...constraints...
		//array_data ,sum_list
        // 建構你要執行的 goal，這裡是一個 RPC 呼叫
		String goal = "solve_path(Obj_pre,Arg_pre,Obj,Arg,Result,Exception)";
		
		String goal2 = "sum_list([1,2,3,4],Sum)"
				+ ",array_data(Array,[2,2])";
    	try {
    		DemononSynchronizeMode demo = new DemononSynchronizeMode();
    		demo.compile(eclfile);
 			demo.compile(eclfile2);
			demo.solve(goal);
			demo.solve(goal2);
			demo.close();
		} catch (EclipseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    //another demo
    /*
	 public static void main(String[] args) throws Exception {

	        EclipseEngineOptions opt = new EclipseEngineOptions(new File("C:\\ECLiPSe"));
	        EclipseEngine eng = new OutOfProcessEclipse(opt);   // 🔹啟動子行程

	        try {
	            eng.rpc("writeln('before-crash'), flush(output).");
	            eng.rpc("exit(99).");          // 只結束子行程
	        } catch (Throw   e) {                // 連線被關會拋 Throw
	        	e.printStackTrace(); // 這行會被執行
	            System.err.println("子行程已結束，JVM 繼續跑！");
	        }

	        // ➜ JVM 仍活著，可再開一顆新引擎繼續工作
	        EclipseEngine eng2 = new OutOfProcessEclipse(opt);
	        eng2.rpc("lib(ic).");
	        System.out.println(eng2.rpc("writeln('New process OK'), flush(output)."));
	        ((OutOfProcessEclipse) eng2).destroy();
	    }*/
}
