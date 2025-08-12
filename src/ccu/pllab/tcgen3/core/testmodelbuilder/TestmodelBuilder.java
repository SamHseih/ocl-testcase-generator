package ccu.pllab.tcgen3.core.testmodelbuilder;

import java.util.List;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.io.FileLoader;
import ccu.pllab.tcgen3.symboltable.scope.Scope;

public class TestmodelBuilder {
  private FileLoader fileLoader;
  private ASTBuilder astbuilder;
  private CLGbuilder clgbuilder;
  private String projectname;
  public static Criterion criterion;

  /**
   * Run Configuration > Arguments<br>
   * arg1: &lt; Papyrus WorkSpace dir &gt;<br>
   * arg2: &lt; projectname &gt;<br>
   * arg3: &lt; "DC"/"DCC"/"MCC" &gt;<br>
   */
  public TestmodelBuilder(String[] args) {
    if (args.length > 1 && args.length < 3) {
      System.out.println("Enter DC/DCC/MCC");
      System.exit(1);
    } else {
      fileLoader = new FileLoader(args);
      criterion = switch (args[2]) {
        case "DC" -> Criterion.DC;
        case "DCC" -> Criterion.DCC;
        case "MCC" -> Criterion.MCC;
        default -> throw new IllegalArgumentException("Unexpected value: " + args[2]);
      };
    }

    projectname = args[1];
  }

  public void buildAST() {
    this.astbuilder = new ASTBuilder(fileLoader.getOclPath(), fileLoader.getUmlPath());
    astbuilder.build();
  }

  public void buildCLG() {
    this.clgbuilder = new CLGbuilder(astbuilder.getAST(), astbuilder.getSymboltable(), criterion);
    clgbuilder.build();
  }

  public void genASTGraph() {
    astbuilder.genASTGraph();
  }

  public void genCLGGraph() {
    clgbuilder.genCLGGraph();
  }

  public ASTree getAST() {
    return astbuilder.getAST();
  }

  public Scope getSymbolTable() {
    return astbuilder.getSymboltable();
  }

  public List<CLGGraph> getCLGs() {
    return clgbuilder.getCLGGrapies();
  }

  public String getProjectName() {
    return this.projectname;
  }
}
