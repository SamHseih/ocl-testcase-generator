package ccu.pllab.tcgen3.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** All Static Method */
public abstract class StringTool {

  /**
   * 將 "ClassA :: ClassB" 或 "ClassA.ClassB" 轉成 "ClassA_ClassB"。 也支援連續多段：例如 "A.B.C" -> "A_B_C"、"A ::
   * B :: C" -> "A_B_C"。
   */
  public static String mergeClassRefs(String s) {
    if (s == null)
      return null;
    String regex = "\\b([A-Z][A-Za-z0-9_]*)\\s*(?:::|\\.)\\s*([A-Z][A-Za-z0-9_]*)\\b";
    String out = s, prev;
    do {
      prev = out;
      out = out.replaceAll(regex, "$1_$2");
    } while (!out.equals(prev)); // 迭代直到沒有可取代的片段（處理重疊比對）
    return out;
  }

  /**
   * 將字串的首字母轉為大寫。
   *
   * @param str 欲處理的字串
   * @return 處理後的字串，若原字串為 null 或空則回傳原字串
   */
  public static String tocapitalizeFirstLetter(String str) {
    if (str == null || str.isEmpty()) {
      return str;
    }
    return Character.toUpperCase(str.charAt(0)) + str.substring(1);
  }

  /**
   * 將輸入字串的第一個 Unicode 字元轉為小寫。
   * <p>
   * 若字串為 null 或空字串，則直接回傳原值。
   * </p>
   *
   * @param s 原始字串
   * @return 字首轉小寫後的新字串
   */
  public static String todecapitalizeFirstLetter(String s) {
    if (s == null || s.isEmpty()) {
      return s;
    }
    int firstCodePoint = s.codePointAt(0);
    int lowerFirst = Character.toLowerCase(firstCodePoint);

    // 若第一個 code point 只佔一個 char（非代理對），直接用 substring。
    if (Character.charCount(firstCodePoint) == 1) {
      return (char) lowerFirst + s.substring(1);
    }

    // 代理對情況：第一個 code point 佔兩個 char
    return new StringBuilder().appendCodePoint(lowerFirst)
        .append(s.substring(Character.charCount(firstCodePoint))).toString();
  }

  /**
   * 將 Map 轉換為格式化的字串表示，支援巢狀 Map 和 List。
   * <p>
   * 每層縮排兩格，便於閱讀。
   * </p>
   *
   * @param map 欲轉換的 Map
   * @param indent 當前縮排層級（0 為最外層）
   * @return 格式化後的字串
   */
  public static String mapToString(Map<?, ?> map, int indent) {
    StringBuilder sb = new StringBuilder();
    String indentStr = "  ".repeat(indent); // 每層縮排兩格

    sb.append("\n");
    for (Map.Entry<?, ?> entry : map.entrySet()) {
      sb.append(indentStr).append("  ").append(entry.getKey()).append(":\n\t");

      Object value = entry.getValue();
      if (value instanceof Map) {
        // 如果值是 Map，遞迴處理
        sb.append(mapToString((Map<?, ?>) value, indent + 1));
      } else if (value instanceof List) {
        // 如果值是 List，處理 List
        sb.append(listToString((List<?>) value, indent + 1));
      } else {
        sb.append(value);
      }
      sb.append("\n");
    }
    sb.append(indentStr);

    return sb.toString();
  }

  private static String listToString(List<?> list, int indent) {
    StringBuilder sb = new StringBuilder();
    String indentStr = "  ".repeat(indent);

    sb.append("[");
    for (Object item : list) {
      sb.append(indentStr).append("  ");
      if (item instanceof Map) {
        sb.append(mapToString((Map<?, ?>) item, indent + 1));
      } else if (item instanceof List) {
        sb.append(listToString((List<?>) item, indent + 1));
      } else {
        sb.append(item);
      }
      sb.append("\n");
    }
    sb.append(indentStr).append("]\n");
    return sb.toString();
  }

  /**
   * 將 "[dim, var, sam]" 轉換為 "[Dim, Var, Sam]".
   *
   * @param input 來源字串，格式必須為以中括號包覆、以逗號和空格分隔的清單
   * @return 處理後的字串
   */
  public static String capitalizeElements(String input) {
    if (input == null || input.length() < 2 || input.charAt(0) != '['
        || input.charAt(input.length() - 1) != ']') {
      throw new IllegalArgumentException("輸入格式必須為 [item1, item2, ...]");
    }

    // 去除左右中括號，再按逗號分割
    String body = input.substring(1, input.length() - 1);
    String[] parts = body.split("\\s*,\\s*"); // 同時拿掉可能的多餘空格

    // 將每個片段首字轉大寫
    for (int i = 0; i < parts.length; i++) {
      if (!parts[i].isEmpty()) {
        parts[i] = parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1);
      }
    }

    // 重新組裝並加回中括號
    return "[" + String.join(", ", parts) + "]";
  }

  /**
   * 判斷輸入字串是否為「純整數清單」： - 支援可選空格，如 "[1, 2, 3]" - 整數可帶正負號，如 "-8" - 只要任一元素非整數或格式不符即回傳 false
   *
   * @param input 欲檢查的清單字串
   * @return true = 全部為整數；false = 否
   */
  public static boolean isPureIntegerList(String input) {
    // 檢查最基本的格式：必須以 '[' 開頭、以 ']' 結尾
    if (input == null || input.length() < 2 || input.charAt(0) != '['
        || input.charAt(input.length() - 1) != ']') {
      return false;
    }

    // 取出中括號內部字串，再用逗號分割（允許任意空白）
    String body = input.substring(1, input.length() - 1).trim();
    if (body.isEmpty()) { // 空清單算否
      return false;
    }

    String[] parts = body.split("\\s*,\\s*"); // 同時移除逗號旁空格

    // 檢查每個部分是否符合整數正則（可選 +/-，至少一位數字）
    for (String part : parts) {
      if (!part.matches("[+-]?\\d+")) { // 只要一個不符就不是純數字
        return false;
      }
    }
    return true;
  }

  /**
   * 將 "[dim, var]" 轉成 List<String>，並把元素首字母大寫。
   *
   * @param input 必須是 "[...]" 形式、逗號分隔的字串
   * @return 轉換後的 List，例如 ["Dim", "Var"]
   * @throws IllegalArgumentException 格式不符時丟出例外
   */
  public static List<String> toCapitalizedList(String input) {
    if (input == null || input.length() < 2 || input.charAt(0) != '['
        || input.charAt(input.length() - 1) != ']') {
      throw new IllegalArgumentException("輸入格式必須為 [item1, item2, ...]");
    }

    // 去掉中括號並切割；\\s* 表示過濾逗號前後的所有空白
    String body = input.substring(1, input.length() - 1);
    return Arrays.stream(body.split("\\s*,\\s*")).filter(s -> !s.isEmpty()) // 避免空字串
        .map(s -> Character.toUpperCase(s.charAt(0)) // 首字大寫
            + s.substring(1))
        .collect(Collectors.toList());
  }

  /**
   * 將字串形如 "[dim1,dim2,dim3]" 的維度清單， 為每個維度加上 prefix_，並保持中括號及逗號格式。
   *
   * @param dims 來源字串，格式必須為 [item1,item2,...]（允許空白）
   * @param prefix 要加到每個項目前的字首 (例如 "Arg")
   * @return 加工後的字串，例如 "[Arg_dim1,Arg_dim2,Arg_dim3]"
   */
  public static String addPrefix(String dims, String prefix) {
    if (dims == null || prefix == null) {
      throw new IllegalArgumentException("輸入不可為 null");
    }

    // 去掉首尾中括號後分割
    String content = dims.trim();
    if (content.startsWith("[") && content.endsWith("]")) {
      content = content.substring(1, content.length() - 1);
    } else {
      throw new IllegalArgumentException("格式錯誤：請提供以 [ ] 包覆的字串");
    }

    // 針對每個元素加上 prefix_
    String[] parts = content.split("\\s*,\\s*"); // 支援含空白
    for (int i = 0; i < parts.length; i++) {
      parts[i] = prefix + "_" + parts[i];
    }

    // 重新組裝成 [item1,item2,...] 形式
    return "[" + String.join(",", parts) + "]";
  }

  public static void main(String[] args) {
    String original = "[dim, var, sam]";
    String result = capitalizeElements(original);
    System.out.println(result); // 輸出: [Dim, Var, Sam]
    System.out.println(isPureIntegerList("[1,2,3,4,5]")); // true
    System.out.println(isPureIntegerList("[1, 2, -3, 4]")); // true
    System.out.println(isPureIntegerList("[dim, var]")); // false
    System.out.println(isPureIntegerList("[1, var]")); // false
    String example = "[dim, var]";
    List<String> list = toCapitalizedList(example);
    System.out.println(list); // 輸出: [Dim, Var]
    int[][][] data = {{{19590, -51754, -34838, -50622, 51653, 7299, -38466, -2143}}};

    System.out.println(data.length); // 1 (第 1 維)
    System.out.println(data[0].length); // 1 (第 2 維)
    System.out.println(data[0][0].length); // 8 (第 3 維)
    System.out.println(data[0][0][0]); // 19590
    System.out.println(addPrefix(original, "Self"));

    // Test mergeClassRefs
    String s1 = "see ClassA :: ClassB here";
    String s2 = "see ClassA.ClassB here";
    String s3 = "ClassA123";
    System.out.println(mergeClassRefs(s1)); // see ClassA_ClassB here
    System.out.println(StringTool.mergeClassRefs(s2));
    System.out.println(StringTool.mergeClassRefs(s3));// see ClassA_ClassB here
  }

}
