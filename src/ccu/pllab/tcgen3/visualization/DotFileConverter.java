package ccu.pllab.tcgen3.visualization;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DotFileConverter {

    /**
     * Converts a .dot file into an image file (SVG or PNG).
     *
     * @param dotPath     Path to the input .dot file
     * @param outputPath  Path to the output image file (.svg or .png)
     * @throws IOException           If the dot process fails to start
     * @throws InterruptedException  If the process is interrupted
     */
    public static void convertDotToImage(Path dotPath, Path outputPath)
            throws IOException, InterruptedException {

        if (!Files.exists(dotPath)) {
            throw new IllegalArgumentException("DOT file not found: " + dotPath);
        }

        String format = getFormatFromExtension(outputPath);
        if (format == null) {
            throw new IllegalArgumentException("Unsupported output format: " + outputPath);
        }

        // Build the command: dot -T<format> <input.dot> -o <output.file>
        ProcessBuilder pb = new ProcessBuilder(
                "dot", "-T" + format, dotPath.toString(), "-o", outputPath.toString()
        );
        pb.redirectErrorStream(true); // Merge stderr with stdout

        Process process = pb.start();
        int exitCode = process.waitFor();

        if (exitCode != 0) {
            throw new RuntimeException("dot command failed with exit code " + exitCode);
        }

        System.out.println("Conversion successful: " + outputPath);
    }

    /**
     * Extracts the image format from the output file extension.
     * Supported formats: .svg and .png
     */
    private static String getFormatFromExtension(Path path) {
        String filename = path.getFileName().toString().toLowerCase();
        if (filename.endsWith(".svg")) return "svg";
        if (filename.endsWith(".png")) return "png";
        return null;
    }

    public static void main(String[] args) {
        try {
            // Replace these with your actual file paths
            Path dotPath = Paths.get("ast.dot");
            Path outputPath = Paths.get("ast.svg"); // or Paths.get("ast.png")

            convertDotToImage(dotPath, outputPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

