package ccu.pllab.tcgen3.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class FileUtil {
  /**
   * 刪除指定的 .ecl 檔案（僅限檔案，不遞迴刪除目錄）。
   * <p>
   * 支援三種輸入：
   * </p>
   * <ol>
   * <li>完整檔名，例如 <code>"C:/tmp/grade_path.ecl"</code></li>
   * <li>不含副檔名，例如 <code>"C:/tmp/grade_path"</code>（自動補 <code>.ecl</code>）</li>
   * <li>純目錄，例如 <code>"C:/tmp"</code>（預設鎖定 <code>output.ecl</code>）</li>
   * </ol>
   *
   * @param rawPath 要刪除的路徑
   * @return <code>true</code> - 已成功刪除<br>
   *         <code>false</code> - 檔案不存在，未執行刪除
   * @throws IOException 若目標為目錄（且未套用預設檔案）、權限不足或 I/O 錯誤
   */
  public static boolean deleteEclFile(Path rawPath) throws IOException {

    // 1. 參數檢查
    Objects.requireNonNull(rawPath, "Path 不可為 null");

    // 2. 解析最終目標路徑（補副檔名 / 目錄 → output.ecl）
    Path target;
    if (Files.isDirectory(rawPath)) {
      target = rawPath.resolve("output.ecl"); // 目錄 → 刪除 output.ecl
    } else if (rawPath.toString().endsWith(".ecl")) {
      target = rawPath; // 已含 .ecl
    } else {
      target = rawPath.resolveSibling(rawPath.getFileName() + ".ecl"); // 自動補 .ecl
    }

    // 3. 確保目標不是目錄
    if (Files.isDirectory(target)) {
      throw new IOException("目標為資料夾，僅支援刪除檔案：" + target);
    }

    // 4. 嘗試刪除
    boolean deleted = Files.deleteIfExists(target);

    // 5. 結果提示
    if (deleted) {
      // System.out.println("CLP(ECLiPSe) Code-file deleted successfully： " + target);
    } else {
      System.out.println("檔案不存在，無需刪除： " + target);
    }
    return deleted;
  }

  /**
   * 刪除指定的檔案（僅限檔案，不處理目錄遞迴）。
   *
   * @param target 要刪除的檔案路徑
   * @return true - 已成功刪除 false - 檔案不存在，未執行刪除
   * @throws IOException 若目標為目錄、無足夠權限，或刪除時發生 I/O 錯誤
   */
  public static boolean deleteEclFile_no(Path target) throws IOException {

    // 1. 參數檢查
    Objects.requireNonNull(target, "Path 不可為 null");

    // 2. 僅允許刪除檔案，若為目錄直接拒絕
    if (Files.isDirectory(target)) {
      throw new IOException("目標為資料夾，僅支援刪除檔案：" + target);
    }

    // 3. 嘗試刪除，若不存在則回傳 false
    boolean deleted = Files.deleteIfExists(target);

    // 4. 訊息提示
    if (deleted) {
      System.out.println("CLP(ECLiPSe)  Code-file deleted successfully： " + target);
    } else {
      System.out.println("檔案不存在，無需刪除： " + target);
    }
    return deleted;
  }

  public static boolean filecoverwrite(String fileName, String content) {

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
      writer.write(content);
      System.out.println("成功寫入檔案: " + fileName);
      return true;
    } catch (IOException e) {
      System.err.println("寫入檔案時發生錯誤: " + e.getMessage());
      return false;
    }
  }

}
