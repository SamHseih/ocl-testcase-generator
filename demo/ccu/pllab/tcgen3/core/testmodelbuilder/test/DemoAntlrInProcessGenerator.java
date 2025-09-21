package ccu.pllab.tcgen3.core.testmodelbuilder.test;

import org.antlr.v4.Tool;

/**
 * Utility driver that invokes the ANTLR&nbsp;v4 code generator <em>inside the current JVM</em>
 * instead of spawning an external process.
 * <p>
 * The class resolves both the grammar file (<code>Ocl.g4</code>) and the destination directory for
 * generated sources relative to the project root (obtained from the <code>user.dir</code> system
 * property). It then calls {@link org.antlr.v4.Tool} programmatically with arguments equivalent to
 * the following CLI invocation:
 * </p>
 *
 * <pre>{@code
 * java -cp antlr-4.x-complete.jar org.antlr.v4.Tool -o <outDir> -visitor Ocl.g4
 * }</pre>
 *
 * <h2>Expected directory layout</h2>
 * 
 * <pre>
 * ${projectDir}/
 * └─ src/
 *    └─ ccu/pllab/tcgen3/core/testmodelbuilder/oclparser/
 *       ├─ Ocl.g4      ← input grammar
 *       └─ antlrgen/   ← generated lexer/parser/visitor sources
 * </pre>
 *
 * After successful generation a single confirmation line is printed to standard output. Any runtime
 * errors thrown by ANTLR will propagate to the console, facilitating debugging inside the IDE.
 * 
 * consider {@link AntlrCliGenerator} for a CLI-based approach.
 */
public class DemoAntlrInProcessGenerator {

  /** Absolute path to the project root directory (<code>user.dir</code>). */
  private static final String PROJECT_Dir = System.getProperty("user.dir");

  /**
   * Generates lexer, parser and visitor classes from <code>Ocl.g4</code>.
   * <p>
   * The method constructs the argument array required by {@link org.antlr.v4.Tool} to
   * <ul>
   * <li>write output to <code>outputDir</code>,</li>
   * <li>emit a parse‑tree visitor interface (<code>-visitor</code>), and</li>
   * <li>process the <code>Ocl.g4</code> grammar file.</li>
   * </ul>
   * Finally, it calls {@link org.antlr.v4.Tool#processGrammarsOnCommandLine()} which performs the
   * actual generation. The <code>args</code> parameter is currently ignored but kept for future
   * extension.
   *
   * @param args command‑line arguments (unused)
   */
  public static void main(String[] args) {
    // Path to the *.g4 grammar file
    String g4FilePath =
        PROJECT_Dir + "\\src\\ccu\\pllab\\tcgen3\\core\\testmodelbuilder\\oclparser\\Ocl.g4";

    // Destination directory for generated lexer/parser/visitor classes
    String outputDir =
        PROJECT_Dir + "\\src\\ccu\\pllab\\tcgen3\\core\\testmodelbuilder\\oclparser\\antlrgen";

    // Arguments to mimic the standard CLI usage of org.antlr.v4.Tool
    String[] arggs = {"-o", outputDir, "-visitor", g4FilePath};

    // Invoke ANTLR in‑process
    Tool antlr = new Tool(arggs);
    antlr.processGrammarsOnCommandLine(); // Equivalent to CLI execution

    System.out.println("ANTLR generation finished successfully.");
  }
}
