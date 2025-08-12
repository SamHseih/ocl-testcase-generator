package ccu.pllab.tcgen3.core.testcasegen;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import com.parctechnologies.eclipse.CompoundTerm;
import com.parctechnologies.eclipse.EclipseEngine;
import com.parctechnologies.eclipse.EclipseEngineOptions;
import com.parctechnologies.eclipse.EclipseException;
import com.parctechnologies.eclipse.OutOfProcessEclipse;
import ccu.pllab.tcgen3.util.FileUtil;

public class CLPSolver implements AutoCloseable {
  private EclipseEngine engine;
  private List<String> errMessage;
  // -Declipse.directory=<eclipse_dir>
  // https://www.eclipseclp.org/doc/embedding/embroot042.html
  private static final File ECLIPSE_HOME = new File("C:\\ECLiPSe"); // ECLiPSe installation path

  public CLPSolver(List<String> errMessage) {
    EclipseEngineOptions opt = new EclipseEngineOptions(ECLIPSE_HOME);
    opt.setUseQueues(false);
    try {
      this.engine = new OutOfProcessEclipse(opt);
    } catch (IOException e) {
      e.printStackTrace();
      errMessage.add("ECLiPSe new instance IOException Error");
    } catch (EclipseException e) {
      e.printStackTrace();
      errMessage.add("ECLiPSe new instance EclipseException Error");
    }
    // this.engine = EmbeddedEclipse.getInstance(opt); // 使用嵌入式模式
    this.errMessage = errMessage;
  }

  public void compile(File eclfile) {
    if (!eclfile.exists()) {
      errMessage.add("Invalid file path (not found or not a regular file):");
      errMessage.add("\t" + eclfile.getAbsolutePath());
    }
    try {
      this.engine.compile(eclfile);
    } catch (IOException e) {
      e.printStackTrace();
      errMessage.add("ECLiPSe Compile IOException Error.");
    } catch (EclipseException e) {
      e.printStackTrace();
      errMessage.add("ECLiPSe Compile EclipseException.");
      if (e.getMessage() != null)
        errMessage.add(e.getMessage());
    }
  }

  public CompoundTerm solve(String goal, Path eclpath) {
    if (!eclpath.isAbsolute()) {
      errMessage.add("Threre is wrong  file at Path: ");
      errMessage.add(eclpath.toString());
    }
    try {
      CompoundTerm solved = engine.rpc(goal);
      return solved;
    } catch (EclipseException e) {
      // e.printStackTrace();
      try {
        FileUtil.deleteEclFile(eclpath);
      } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
        errMessage.add(e.getMessage());
      }
    } catch (IOException e) {
      e.printStackTrace();
      errMessage.add(e.getMessage());
    }
    return null;
  }

  // for DemoTesting
  public CompoundTerm solve_fortest(String goal) {
    try {
      CompoundTerm solved = engine.rpc(goal);
      return solved;
    } catch (EclipseException e) {
      e.printStackTrace();
      errMessage.add(e.getMessage());
    } catch (IOException e) {
      e.printStackTrace();
      errMessage.add(e.getMessage());
    }
    return null;
  }

  public EclipseEngine getEngine() {
    if (this.engine != null)
      return this.engine;
    else {
      errMessage.add("ECLiPSE is null  Falt! ");
      return null;
    }
  }



  @Override
  public void close() {
    if (engine instanceof OutOfProcessEclipse oop) {
      try {
        oop.destroy();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
