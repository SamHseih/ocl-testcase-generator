package ccu.pllab.tcgen3.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.parctechnologies.eclipse.Atom;
import com.parctechnologies.eclipse.CompoundTerm;
import com.parctechnologies.eclipse.EclipseException;

public class ClpUtil {

  /**
   * 將已轉好的文字內容寫入 .ecl 檔。
   *
   * @param outputPath 輸出位置：可傳入 ① 已含副檔名的完整路徑，例如 "C:/tmp/grade_path.ecl" ② 未加副檔名的路徑，例如
   *        "C:/tmp/grade_path" ③ 目錄路徑，例如 "C:/tmp"（此時預設檔名為 output.ecl）
   * @param content 要寫入的文字內容（UTF-8）
   * @return 實際寫入檔案的完整路徑
   * @throws IOException 檔案建立或寫入失敗時拋出
   */
  public static Path writeEclFile(Path outputPath, String content) throws IOException {

    // 1. 決定最終檔名（確保 .ecl 副檔名）
    Path target;
    if (Files.isDirectory(outputPath)) {
      target = outputPath.resolve("output.ecl"); // 只給目錄 → 建立 output.ecl
    } else if (outputPath.toString().endsWith(".ecl")) {
      target = outputPath; // 已含 .ecl
    } else {
      target = outputPath.resolveSibling(outputPath.getFileName() + ".ecl"); // 自動補 .ecl
    }

    // 2. 建立父目錄（若尚不存在）
    Files.createDirectories(target.getParent());

    // 3. 以 UTF-8 覆寫（若檔案已存在則覆蓋）
    Files.writeString(target, content, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
        StandardOpenOption.TRUNCATE_EXISTING);
    // System.out.println("CLP(ECLiPSe) Code-file output successfully： "+outputPath);
    return target;
  }


  /** 將任一 ECLiPSe RPC 物件轉成 Java String */
  public static String toJavaString(Object obj) {
    StringBuilder sb = new StringBuilder();

    appendTerm(obj, sb);

    return sb.toString();
  }

  /** input []([](2,3),[](4,5)) output = {{2,3},{4,5}} */
  public static String compoundArrayToString_braces(CompoundTerm ct) throws EclipseException {
    StringBuilder sb = new StringBuilder(); // 收集每一列的整數

    for (int i = 1; i <= ct.arity(); i++) {

      Object arg = ct.arg(i);
      if (arg instanceof CompoundTerm innerCt && "[]".equals(innerCt.functor())) {
        // 處理內部的 CompoundTerm
        sb.append('{');
        for (int j = 1; j <= innerCt.arity(); j++) {
          if (j == 1 && i == 1)
            sb.append('{');
          appendTerm(innerCt.arg(j), sb);
          if (j < innerCt.arity())
            sb.append(", ");
        }
        sb.append('}');
      } else {
        // 直接處理非 CompoundTerm 的情況
        if (i == 1)
          sb.append('{'); // 第一個元素前加左大括號
        appendTerm(arg, sb);

      }
      if (i < ct.arity())
        sb.append(", ");
      if (i == ct.arity())
        sb.append("}");
    }

    // sb.append('}');
    return sb.toString();
  }

  /** input []([](2,3),[](4,5)) output = [[2,3],[4,5]] */
  public static String compoundArrayToString_brackets(CompoundTerm ct) throws EclipseException {
    StringBuilder sb = new StringBuilder(); // 收集每一列的整數

    for (int i = 1; i <= ct.arity(); i++) {

      Object arg = ct.arg(i);
      if (arg instanceof CompoundTerm innerCt && "[]".equals(innerCt.functor())) {
        // 處理內部的 CompoundTerm
        sb.append('[');
        for (int j = 1; j <= innerCt.arity(); j++) {
          if (j == 1 && i == 1)
            sb.append('[');
          appendTerm(innerCt.arg(j), sb);
          if (j < innerCt.arity())
            sb.append(", ");
        }
        sb.append(']');
      } else {
        // 直接處理非 CompoundTerm 的情況
        if (i == 1)
          sb.append('['); // 第一個元素前加左大括號
        appendTerm(arg, sb);

      }
      if (i < ct.arity())
        sb.append(", ");
      if (i == ct.arity())
        sb.append("]");
    }

    return sb.toString();
  }

  public static String listToString(List<?> ll) {
    return ll.toString();
  }

  public static String AtomToString(Atom atom) {
    return atom.functor();
  }


  // -----------------------------------------------------------------
  // private helper ── 真正遞迴附加字串的位置
  // -----------------------------------------------------------------
  private static void appendTerm(Object obj, StringBuilder sb) {

    if (obj == null) {
      sb.append("null");
      return;
    }

    // ========= Atomic Java 型別 =========
    else if (obj instanceof Integer || obj instanceof Long || obj instanceof Double
        || obj instanceof Float) {

      sb.append(obj.toString());
      return;
    }

    else if (obj instanceof String str) { // 被 RPC 當作 Java 字串傳回
      sb.append('"').append(str).append('"');
      return;
    }

    // ========= Atom =========
    else if (obj instanceof Atom atom) {
      sb.append(atom.functor()); // 直接印 atom 名稱
      return;
    }

    // ========= LinkList =========
    else if (obj instanceof LinkedList ll) {
      sb.append("[ ");
      for (int i = 0; i < ll.size(); i++) {
        Object item = ll.get(i);
        if (i > 0)
          sb.append(", ");
        appendTerm(item, sb);
      }
      sb.append(" ]");
      return;
    }
    // ========= CompoundTerm =========
    else if (obj instanceof CompoundTerm ct) {

      // --------- 處理空串列 [] ---------
      if ("[]".equals(ct.functor())) {
        try {
          String arr = ClpUtil.compoundArrayToString_brackets(ct);
          sb.append(arr);
          return;
        } catch (EclipseException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }

      // --------- 處理 list cell '.'(Head, Tail) ---------
      else if (".".equals(ct.functor()) && ct.arity() == 2) {
        sb.append('[');
        // 逐一展開 Head/Tail
        CompoundTerm cell = ct;
        while (true) {
          appendTerm(cell.arg(1), sb); // Head

          Object tail = cell.arg(2);
          // 尾端為空串列 -> 結束
          if (tail instanceof Atom at && "[]".equals(at.functor())) {
            sb.append(']');
            break;
          }
          // 尾端仍是 cell -> 加逗號續展開
          if (tail instanceof CompoundTerm t && ".".equals(t.functor()) && t.arity() == 2) {
            sb.append(", ");
            cell = t; // 繼續迴圈
            continue;
          }
          // 部分串列 / 非正規尾端
          sb.append(" | ");
          appendTerm(tail, sb);
          sb.append(']');
          break;
        }
        return;
      } else {
        // --------- 一般 CompoundTerm ---------
        sb.append(ct.functor()).append('(');
        for (int i = 1; i <= ct.arity(); i++) {
          appendTerm(ct.arg(i), sb);
          if (i < ct.arity())
            sb.append(", ");
        }
        sb.append(')');
        return;
      }
    }

    // ========= 其他型別（保底） =========
    // sb.append(obj.toString());
  }

  public static void main(String[] args) throws IOException {
    String clpCode = """
        :- lib(ic).
        :- lib(labeling).

        solve_path(ScorePre, Score) :-
            Score #= ScorePre + 10.
        """;

    // 📂 傳入目錄 → 產生 output.ecl
    Path written1 = writeEclFile(Paths.get("C:/tmp"), clpCode);

    // 📄 傳入檔名（不含副檔名）→ 自動補 .ecl
    Path written2 = writeEclFile(Paths.get("C:/tmp/grade_path"), clpCode);

    // 📄 傳入完整檔名 → 直接覆寫
    Path written3 = writeEclFile(Paths.get("C:/tmp/custom_name.ecl"), clpCode);

    System.out.println("已寫入：");
    System.out.println("  " + written1);
    System.out.println("  " + written2);
    System.out.println("  " + written3);
  }
}
