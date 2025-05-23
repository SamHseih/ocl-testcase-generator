package ccu.pllab.tcgen3.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileWriter {
	/**
     * 將內容寫入指定檔案（預設覆蓋）
     *
     * @param path   the file path to write to
     * @param lines  the lines of text to write
     * @throws IOException if an I/O error occurs
     */
    public static void write(Path path, final List<String> lines) throws IOException {
        write(path, lines, false);
    }

    /**
     * 將內容寫入指定檔案，可指定是否附加（append）
     *
     * @param path   the file path to write to
     * @param lines  the lines of text to write
     * @param append true to append to the file; false to overwrite it
     * @throws IOException if an I/O error occurs
     */
    public static void write(Path path, final List<String> lines, final boolean append) throws IOException {
    	// 若是資料夾，則補上預設檔名
        if (Files.isDirectory(path)) {
            path = path.resolve("default_output.txt");
        }
    	// Ensure the parent directory exists
        if (path.getParent() != null) {
            Files.createDirectories(path.getParent());
        }

        if (append) {
            Files.write(path, lines, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } else {
            Files.write(path, lines, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        }
    }
    
    /* Test*/
    public static void main(String[] args) {
    	String outputPath = System.getProperty("user.dir")+"\\output\\AST";
    	System.out.println(System.getProperty("user.dir"));
        Path path = Paths.get(outputPath);
        List<String> content = List.of("YOOO", "OOOOO");

        try {
            // 覆蓋寫入
            write(path, content);

            // 或：附加寫入
            // write(path, content, true);

            System.out.println("寫入完成！");
        } catch (Exception e) {
            System.err.println("寫入失敗：" + e.getMessage() +"\n");
            e.printStackTrace();
        }
    }
}
