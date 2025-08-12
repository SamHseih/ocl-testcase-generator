package ccu.pllab.tcgen3.io;

import java.net.URI;
import java.nio.file.Path;

/**
 * Get File Path <br>
 * input: 1. Papyrus WorkSpace Directory 2. XX (cause XX.uml XX.ocl) Ex arg[0]= F:\papyrus\WorkSpace
 * , arg[1]= Cube
 */
public class FileLoader {
  Path projectPath;
  Path umlfilePath;
  Path oclfilePath;

  public FileLoader(String[] args) {
    if (args.length < 2) {
      System.out.println("Run Configuration -> Argument Block -> Programing arguments..");
      System.out.println("Assume that the .ocl and .uml files are in the same location.");
      System.out.println("Enter arg1: <Papyrus WorkSpace Directory> to find Spec Project.");
      System.out.println("Enter arg2: <ProjectName> to find ProjectName");
      System.exit(1);
    }

    projectPath = Path.of(args[0], args[1]);
    umlfilePath = Path.of(args[0], args[1], args[1] + ".uml");
    oclfilePath = Path.of(args[0], args[1], args[1] + ".ocl");
  }

  public Path getProjectPath() {
    return this.projectPath;
  }

  public Path getUmlPath() {
    return this.umlfilePath;
  }

  public Path getOclPath() {
    return this.oclfilePath;
  }

  // 新增方法，返回 URI
  public URI getProjectUri() {
    return this.projectPath.toUri();
  }

  public URI getUmlUri() {
    return this.umlfilePath.toUri();
  }

  public URI getOclUri() {
    return this.oclfilePath.toUri();
  }


}


