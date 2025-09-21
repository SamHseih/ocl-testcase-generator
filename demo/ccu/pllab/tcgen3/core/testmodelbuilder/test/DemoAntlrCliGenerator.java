package ccu.pllab.tcgen3.core.testmodelbuilder.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Invokes the ANTLR&nbsp;v4 code‑generator **via an external PowerShell process** so that the
 * grammar can be rebuilt with a single <em>Run</em> action inside Eclipse.
 * <p>
 * The class constructs and executes the following command (line breaks added for readability):
 * </p>
 *
 * <pre>{@code
 * powershell.exe -Command \
 *     java -cp <projectDir>\lib\antlr-4.13.2-complete.jar org.antlr.v4.Tool \
 *          <projectDir>\src\...\Ocl.g4 \
 *          -o <projectDir>\src\...\antlrgen \
 *          -visitor
 * }</pre>
 *
 * <h2>Directory layout assumptions</h2>
 * 
 * <pre>
 * ${projectDir}/
 * ├─ lib/
 * │  └─ antlr-4.13.2-complete.jar       ← ANTLR tool JAR (with main‑class)
 * └─ src/ccu/pllab/tcgen3/core/testmodelbuilder/oclparser/
 *    ├─ Ocl.g4                           ← input grammar
 *    └─ antlrgen/                       ← generated lexer/parser/visitor
 * </pre>
 * <p>
 * The paths are resolved at runtime using the {@code user.dir} system property; adjust
 * {@link #ANTLR_JAR_WITH_MAIN} or the source / output directories if the layout changes.
 * </p>
 *
 * <h3>When to use this class</h3>
 * <ul>
 * <li>Rapid prototyping on <strong>Windows</strong> where PowerShell is available.</li>
 * <li>Projects that have <em>not</em> yet migrated to Maven/Gradle plugins.</li>
 * </ul>
 * <strong>Limitations:</strong> the implementation is platform‑specific (Windows only) and incurs
 * the overhead of spawning a new JVM. For cross platform builds consider
 * {@link AntlrInProcessGenerator} or a build-tool plugin instead.
 */
public class DemoAntlrCliGenerator {

  /** Absolute path to the project root directory (<code>user.dir</code>). */
  private static final String PROJECT_Dir = System.getProperty("user.dir");

  /**
   * Class‑path entry plus main‑class of the ANTLR tool JAR.
   * <p>
   * <strong>Note:</strong> keep the space between the JAR path and the main class name; it is
   * required by the PowerShell <code>java -cp</code> invocation.
   * </p>
   */
  private static final String ANTLR_JAR_WITH_MAIN =
      PROJECT_Dir + "\\lib\\antlr-4.13.2-complete.jar org.antlr.v4.Tool";

  /**
   * Spawns the external process, streams its combined <em>stdout/stderr</em> to the console, and
   * prints the resulting exit code.
   *
   * @param args currently unused — reserved for future parameters such as alternative grammar paths
   *        or output directories
   */
  public static void main(String[] args) {
    try {
      /*
       * ----------------------------------------------------------------- 1. Resolve key paths
       * relative to the current working directory.
       * -----------------------------------------------------------------
       */
      // Path to the *.g4 grammar file
      String g4FilePath =
          PROJECT_Dir + "\\src\\ccu\\pllab\\tcgen3\\core\\testmodelbuilder\\oclparser\\Ocl.g4";

      // Destination directory for generated lexer/parser/visitor classes
      String outputDir =
          PROJECT_Dir + "\\src\\ccu\\pllab\\tcgen3\\core\\testmodelbuilder\\oclparser\\antlrgen";

      /*
       * ----------------------------------------------------------------- 2. Compose the command
       * and launch it via PowerShell.
       * -----------------------------------------------------------------
       */
      ProcessBuilder builder = new ProcessBuilder(List.of("powershell.exe", "-Command",
          "java -cp " + ANTLR_JAR_WITH_MAIN + ' ' + g4FilePath + " -o " + outputDir + " -visitor"));

      builder.redirectErrorStream(true); // merge stderr into stdout
      Process process = builder.start();

      /*
       * ----------------------------------------------------------------- 3. Relay ANTLR's console
       * output line‑by‑line. -----------------------------------------------------------------
       */
      try (BufferedReader reader =
          new BufferedReader(new InputStreamReader(process.getInputStream()))) {
        String line;
        while ((line = reader.readLine()) != null) {
          System.out.println(line);
        }
      }

      /*
       * ----------------------------------------------------------------- 4. Await termination and
       * report the exit status. -----------------------------------------------------------------
       */
      int exitCode = process.waitFor();
      System.out.println("Process exited with code: " + exitCode);
    } catch (IOException | InterruptedException e) {
      // Fail fast but preserve the thread's interrupt status
      e.printStackTrace();
      Thread.currentThread().interrupt();
    }
  }
}
