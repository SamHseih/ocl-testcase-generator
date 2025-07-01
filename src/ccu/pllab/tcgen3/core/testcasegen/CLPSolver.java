package ccu.pllab.tcgen3.core.testcasegen;

import java.io.File;
import java.io.IOException;

import com.parctechnologies.eclipse.CompoundTerm;
import com.parctechnologies.eclipse.EclipseEngine;
import com.parctechnologies.eclipse.EclipseEngineOptions;
import com.parctechnologies.eclipse.EclipseException;
import com.parctechnologies.eclipse.OutOfProcessEclipse;

public class CLPSolver implements AutoCloseable {
	private final EclipseEngine engine;
	private static final String ECLIPSE_HOME = "C:\\ECLiPSe"; // ECLiPSe installation path
	
	
	public CLPSolver() throws IOException, EclipseException {
		EclipseEngineOptions opt = new EclipseEngineOptions(new File("C:\\ECLiPSe"));
		opt.setUseQueues(false);  
        this.engine = new OutOfProcessEclipse(opt); 
	}
	public void compile(File eclfile) throws EclipseException, IOException {
		this.engine.compile(eclfile);
	}
	
	public CompoundTerm solve(String goal)  {
		try {
			CompoundTerm solved = engine.rpc(goal);
			return solved;
		} catch (EclipseException e) {
			e.printStackTrace();
			//System.out.println("Fail");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public EclipseEngine getEngine() {
		if(this.engine != null)
		return this.engine;
		return null;
	}
	
	@Override
	public void close() {
		if (engine instanceof OutOfProcessEclipse oop) { 
			try {
			oop.destroy();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} }
	}
}
