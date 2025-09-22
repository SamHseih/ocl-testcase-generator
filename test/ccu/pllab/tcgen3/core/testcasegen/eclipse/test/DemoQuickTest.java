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
	    eclipse = EmbeddedEclipse.getInstance(eclipseEngineOptions);//�I�sstatic method?

	 //�d��1,�H�U�ֳt���� Write a message 8.1
	    //eclipse.rpc("write(output, 'hello world'), flush(output)");
	    //���������b ECLiPSe �U predicate,�u�O���ݭn�y���C
	    
	 //�d��2,�H�U��null�N���P�ܼƪ� 8.4.3  More details about rpc goal execution
	    eclipse.rpc("assert(q(a, b))");
	    eclipse.rpc("assert(q(b, b))");
	    System.out.println(eclipse.rpc("q(X, X)"));
	    /* tkECLiPSe ���ާ@
	     * ?- q(X, X).
	     * X = b
	     * Yes (0.00s cpu)
	     *. �bJava�o�䪺�ާ@
	     *.�|�^�� q(b,b). �ܼƬۦP�����p
	     * */
	    System.out.println(eclipse.rpc(new CompoundTermImpl("q", null, null)));
	    /* �۷��tkECLiPSe ���ާ@
	     * ?- q(A, X).
	     * A = a
	     * X = b
	     * Yes (0.00s cpu)
	     *. �bJava�o�䪺�ާ@
	     *.�|�^�� q(a,b). �]��JAva �o��null ��ܤ��P���ܼ�
	     * */
	    
	    // Destroy the Eclipse process
	    ((EmbeddedEclipse) eclipse).destroy();
	  }
}
