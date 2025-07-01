package ccu.pllab.tcgen3.core.testcasegen.eclipse.test;

import java.io.File;

import com.parctechnologies.eclipse.CompoundTermImpl;
import com.parctechnologies.eclipse.EclipseEngine;
import com.parctechnologies.eclipse.EclipseEngineOptions;
import com.parctechnologies.eclipse.EmbeddedEclipse;

public class DemoQuickTest {
	public static void main(String[] args) throws Exception
	  {
	    // Create some default Eclipse options
	    EclipseEngineOptions eclipseEngineOptions = new EclipseEngineOptions(new File("C:\\ECLiPSe"));
	    // Object representing the Eclipse process
	    EclipseEngine eclipse;

	    // Connect the Eclipse's standard streams to the JVM's
	    eclipseEngineOptions.setUseQueues(false);

	    // Initialise Eclipse
	    eclipse = EmbeddedEclipse.getInstance(eclipseEngineOptions);//呼叫static method?

	 //範例1,以下快速測試 Write a message 8.1
	    //eclipse.rpc("write(output, 'hello world'), flush(output)");
	    //類似直接在 ECLiPSe 下 predicate,只是不需要句號。
	    
	 //範例2,以下為null代表不同變數的 8.4.3  More details about rpc goal execution
	    eclipse.rpc("assert(q(a, b))");
	    eclipse.rpc("assert(q(b, b))");
	    System.out.println(eclipse.rpc("q(X, X)"));
	    /* tkECLiPSe 的操作
	     * ?- q(X, X).
	     * X = b
	     * Yes (0.00s cpu)
	     *. 在Java這邊的操作
	     *.會回傳 q(b,b). 變數相同的關聯
	     * */
	    System.out.println(eclipse.rpc(new CompoundTermImpl("q", null, null)));
	    /* 相當於tkECLiPSe 的操作
	     * ?- q(A, X).
	     * A = a
	     * X = b
	     * Yes (0.00s cpu)
	     *. 在Java這邊的操作
	     *.會回傳 q(a,b). 因為JAva 這邊null 表示不同的變數
	     * */
	    
	    // Destroy the Eclipse process
	    ((EmbeddedEclipse) eclipse).destroy();
	  }
}
