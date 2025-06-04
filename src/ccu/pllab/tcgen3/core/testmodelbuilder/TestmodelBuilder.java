package ccu.pllab.tcgen3.core.testmodelbuilder;

import ccu.pllab.tcgen3.io.FileLoader;

public class TestmodelBuilder {
	private FileLoader fileLoader;
	private ASTBuilder astbuilder;
	private CLGbuilder clgbuilder;
	private String criterion;
	
	/** Run Configuration > Arguments<br> 
	 * arg1: &lt; Papyrus WorkSpace dir &gt;<br> 
	 * arg2: &lt; projectname &gt;<br> 
	 * arg3: &lt; "DC"/"DCC"/"MCC" &gt;<br> 
	 *  */
	public TestmodelBuilder(String[] args) {
		if(args.length>1 && args.length<3) {
			System.out.println("Enter DC/DCC/MCC");
			System.exit(1); 
		}else {
			this.criterion = args[2];
			fileLoader = new FileLoader(args);
			}
	}
	
	
	public void main(String[] args) {
		
	}
}
