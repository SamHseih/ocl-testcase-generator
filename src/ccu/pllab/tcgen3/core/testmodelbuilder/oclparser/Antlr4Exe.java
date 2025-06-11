package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Utility class that programmatically invokes the ANTLR v4 grammar compiler
 * ({@code org.antlr.v4.Tool}).
 * <p>
 * The <strong>main</strong> method assembles and executes the command:<br>
 * {@code java -cp <antlr‑jar> org.antlr.v4.Tool <grammar-file> -o <out-dir> -visitor}<br>
 * via PowerShell so the same call works inside the Windows environment in which
 * the <em>tcgen3</em> project is typically developed.
 * </p>
 * <h3>Expected directory layout</h3>
 * <pre>
 *  src/ccu/pllab/tcgen3/core/testmodelbuilder/oclparser/Ocl.g4      ← grammar
 *  src/ccu/pllab/tcgen3/core/testmodelbuilder/oclparser/antlrgen/   ← generated sources
 * </pre>
 * <p>
 * Adjust {@link #ANTLR_JAR_WITH_MAIN} if you relocate or rename the ANTLR JAR.
 * </p>
 */
public class Antlr4Exe {
	
	/** Absolute path to the ANTLR tool JAR followed by its main class. */
    private static final String ANTLR_JAR_WITH_MAIN =
            "C:\\Javalib\\antlr-4.13.2-complete.jar org.antlr.v4.Tool";
    
    /**
     * Entry point that spawns the grammar-generation process and streams its
     * output to {@code System.out}.
     *
     * @param args not used — kept for future extensibility (e.g., dynamic paths)
     */
    public static void main(String[] args) {
    	try {
            /* -----------------------------------------------------------------
             * 1. Resolve key paths relative to the current working directory.
             * ----------------------------------------------------------------- */
            String projectDir = System.getProperty("user.dir");

            // Path to the *.g4 grammar file
            String g4FilePath = projectDir +
                    "\\src\\ccu\\pllab\\tcgen3\\core\\testmodelbuilder\\oclparser\\Ocl.g4";

            // Destination directory for generated lexer/parser/visitor classes
            String outputDir = projectDir +
                    "\\src\\ccu\\pllab\\tcgen3\\core\\testmodelbuilder\\oclparser\\antlrgen";

            /* -----------------------------------------------------------------
             * 2. Compose the command and launch it via PowerShell.
             * ----------------------------------------------------------------- */
            ProcessBuilder builder = new ProcessBuilder(List.of(
                    "powershell.exe", "-Command",
                    "java -cp " + ANTLR_JAR_WITH_MAIN + ' ' + g4FilePath +
                            " -o " + outputDir + " -visitor"));

            builder.redirectErrorStream(true);  // merge stderr into stdout
            Process process = builder.start();

            /* -----------------------------------------------------------------
             * 3. Relay ANTLR's console output line‑by‑line.
             * ----------------------------------------------------------------- */
            try (BufferedReader reader =
                         new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

            /* -----------------------------------------------------------------
             * 4. Await termination and report the exit status.
             * ----------------------------------------------------------------- */
            int exitCode = process.waitFor();
            System.out.println("Process exited with code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            // Fail fast but preserve the thread's interrupt status
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
