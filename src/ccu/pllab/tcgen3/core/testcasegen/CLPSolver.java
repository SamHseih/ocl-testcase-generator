package ccu.pllab.tcgen3.core.testcasegen;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import com.parctechnologies.eclipse.CompoundTerm;
import com.parctechnologies.eclipse.EclipseEngine;
import com.parctechnologies.eclipse.EclipseEngineOptions;
import com.parctechnologies.eclipse.EclipseException;
import com.parctechnologies.eclipse.EmbeddedEclipse;
import com.parctechnologies.eclipse.OutOfProcessEclipse;

import ccu.pllab.tcgen3.util.FileUtil;

public class CLPSolver implements AutoCloseable {
	private final EclipseEngine engine;
	
	//-Declipse.directory=<eclipse_dir>
	//https://www.eclipseclp.org/doc/embedding/embroot042.html
	private static final File ECLIPSE_HOME = new File("C:\\ECLiPSe"); // ECLiPSe installation path	
	
	public CLPSolver() throws IOException, EclipseException {
		EclipseEngineOptions opt = new EclipseEngineOptions(ECLIPSE_HOME);
		opt.setUseQueues(false);  
       this.engine = new OutOfProcessEclipse(opt); 
		//this.engine = EmbeddedEclipse.getInstance(opt); // 使用嵌入式模式
	}
	public void compile(File eclfile) throws EclipseException, IOException {
		this.engine.compile(eclfile);
	}
	
	public CompoundTerm solve(String goal,Path eclpath)  {
		try {
			CompoundTerm solved = engine.rpc(goal);
			return solved;
		} catch (EclipseException e) {
			//e.printStackTrace();
			try {
				FileUtil.deleteEclFile(eclpath);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//for DemoTesting
	public CompoundTerm solve_fortest(String goal)  {
		try {
			CompoundTerm solved = engine.rpc(goal);
			return solved;
		} catch (EclipseException e) {
			e.printStackTrace();
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
