package ccu.pllab.tcgen3.core.testmodelbuilder.test;

import ccu.pllab.tcgen3.core.testmodelbuilder.ASTBuilder;
import ccu.pllab.tcgen3.io.FileLoader;

/**
 * Run Configuration ¡V Program arguments arg1: <Papyrus workspace directory> arg2: <project name>
 * arg3: <"DC" | "DCC" | "MCC">
 */
public class DemoASTBuilder {

  public static void main(String[] args) {
    /*
     * ------------------------------------------------------------------ 0. Load UML / OCL model
     * paths ------------------------------------------------------------------
     */
    FileLoader Loader = new FileLoader(args);
    if (args.length > 1 && args.length < 3) {
      System.out.println("Enter DC/DCC/MCC");
      System.exit(1);
    }
    /*
     * ------------------------------------------------------------------ 1. Build the original AST
     * from the model files ------------------------------------------------------------------
     */
    ASTBuilder astbuilder = new ASTBuilder(Loader.getOclPath(), Loader.getUmlPath());
    astbuilder.build();

    astbuilder.genASTGraph();

  }

}
