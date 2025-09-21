package ccu.pllab.tcgen3.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

  /** Input String "[1,2,3]" Output String : 1,2,3 */
  public static String formatListString(String input) {
    if (input == null || input.isEmpty()) {
      return "";
    }
    // 去掉開頭和結尾的 [ ]
    String trimmed = input.replaceAll("[\\[\\]]", "");
    // 去掉多餘空白
    trimmed = trimmed.replaceAll("\\s+", "");
    return trimmed;
  }

  /**
   * Input String "[[-25259, -7735], [2412, -6050]]" Output String : {{-25259, -7735}, {2412,
   * -6050}}
   */
  public static String replaceBrackets(String input) {
    if (input == null) {
      return null;
    }
    return input.replace("[", "{").replace("]", "}");
  }

  /**
   * 若字串符合 "[ <array> , <dimension> ]" 的固定格式，回傳 <array>； 否則回傳原字串（去除首尾空白）。
   *
   * 規則： 1) 最外層必須是中括號包住且只有兩個頂層元素。 2) 第一個元素必須是「至少二維」的陣列（也就是它本身的內部還含有 '['）。 3) 第二個元素必須是「一維整數陣列」，例如 [2,
   * 2]（內部不得再有中括號）。
   */
  public static String extractArrayIfPair(String input) {
    if (input == null)
      return null;
    String s = input.trim();
    if (s.length() < 2 || s.charAt(0) != '[' || s.charAt(s.length() - 1) != ']') {
      return s; // 不是以 [ ... ] 包住，直接回傳
    }

    // 取出最外層內容
    int start = 1, end = s.length() - 1;

    // 分割成「頂層元素」清單（以 depth==0 的逗號切）
    java.util.List<int[]> spans = new java.util.ArrayList<>(); // 每個元素的 [from, to)
    int depth = 0;
    int tokenStart = start;
    for (int i = start; i < end; i++) {
      char c = s.charAt(i);
      if (c == '[')
        depth++;
      else if (c == ']')
        depth--;
      else if (c == ',' && depth == 0) {
        spans.add(new int[] {tokenStart, i});
        tokenStart = i + 1;
      }
      if (depth < 0)
        return s; // 括號不平衡，視為不符合，原樣回傳
    }

    // 末尾 token
    if (tokenStart <= end) {
      spans.add(new int[] {tokenStart, end});
    }

    // 不是恰好兩個頂層元素 -> 非 [array, dimension]，原樣回傳
    if (spans.size() != 2)
      return s;

    String first = s.substring(spans.get(0)[0], spans.get(0)[1]).trim(); // <array>
    String second = s.substring(spans.get(1)[0], spans.get(1)[1]).trim(); // <dimension>
    // 條件 嚴謹：檢查維度
    List<Integer> check = getDimensions(first);
    StringBuilder sb = new StringBuilder();
    sb.append("[ ");
    for (int i = 0; i < check.size(); i++) {
      sb.append(check.get(i));
      if (i != check.size() - 1)
        sb.append(", ");
    }
    sb.append(" ]");
    if (second.toString().equals(sb.toString()))
      return first;
    else
      return s;
  }

  /** 僅當輸入為 [ <array(至少二維)> , <dimension(一維整數陣列)> ] 時回傳 true */
  public static boolean isArrayPairArrayAndDimension(String input) {
    if (input == null)
      return false;
    String s = input.trim();
    if (s.length() < 2 || s.charAt(0) != '[' || s.charAt(s.length() - 1) != ']')
      return false;

    // 拆掉最外層括號後，依「頂層逗號」切成兩個元素
    int start = 1, end = s.length() - 1;
    java.util.List<int[]> spans = splitTopLevelByComma(s, start, end);
    if (spans.size() == 2)
      return true;
    else
      return false;
  }

  // —— Helpers ——

  /** 以「括號深度為 0 的逗號」切分 [start, end) 內容成頂層元素 spans：[from, to) */
  private static java.util.List<int[]> splitTopLevelByComma(String s, int start, int end) {
    java.util.List<int[]> res = new java.util.ArrayList<>();
    int depth = 0, tokenStart = start;
    for (int i = start; i < end; i++) {
      char c = s.charAt(i);
      if (c == '[')
        depth++;
      else if (c == ']')
        depth--;
      else if (c == ',' && depth == 0) {
        res.add(new int[] {tokenStart, i});
        tokenStart = i + 1;
      }
      if (depth < 0)
        return java.util.Collections.emptyList(); // 括號不平衡
    }
    if (depth != 0)
      return java.util.Collections.emptyList(); // 括號不平衡
    if (tokenStart < end)
      res.add(new int[] {tokenStart, end});
    return res;
  }


  /** 回傳陣列字串的維度大小，例如 [1756, 29789] -> [2], [[-9063, 23362], [41687, -22394]] -> [2,2] */
  private static List<Integer> getDimensions(String input) {
    if (input == null)
      return Collections.emptyList();
    String s = input.trim();
    if (s.isEmpty() || s.charAt(0) != '[' || s.charAt(s.length() - 1) != ']') {
      return Collections.emptyList(); // 非陣列格式
    }
    return parseArray(s);
  }

  // 遞迴解析陣列
  private static List<Integer> parseArray(String s) {
    List<String> elements = splitTopLevel(s.substring(1, s.length() - 1).trim());
    List<Integer> dims = new ArrayList<>();
    dims.add(elements.size()); // 先記錄這一層的大小

    // 檢查第一個元素是否還是陣列，如果是則遞迴（假設結構規則）
    if (!elements.isEmpty()) {
      String first = elements.get(0).trim();
      if (first.startsWith("[") && first.endsWith("]")) {
        dims.addAll(parseArray(first));
      }
    }
    return dims;
  }

  // 以「深度=0 的逗號」切分字串
  private static List<String> splitTopLevel(String inner) {
    List<String> result = new ArrayList<>();
    if (inner.isEmpty())
      return result;

    int depth = 0;
    int start = 0;
    for (int i = 0; i < inner.length(); i++) {
      char c = inner.charAt(i);
      if (c == '[')
        depth++;
      else if (c == ']')
        depth--;
      else if (c == ',' && depth == 0) {
        result.add(inner.substring(start, i).trim());
        start = i + 1;
      }
    }
    result.add(inner.substring(start).trim());
    return result;
  }

  public static boolean containsDigit(String input) {
    if (input == null || input.isEmpty()) {
      return false;
    }
    for (char c : input.toCharArray()) {
      if (Character.isDigit(c)) {
        return true; // 一旦找到數字就回傳 true
      }
    }
    return false; // 都沒找到數字
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
    String s4 = "[1,2,3,4]";
    String s5 = "[ [[-15516, -3624,122], [2581, 29592,132]], [ 2, 3 ] ]";
    System.out.println(mergeClassRefs(s1)); // see ClassA_ClassB here
    System.out.println(StringTool.mergeClassRefs(s2));
    System.out.println(StringTool.mergeClassRefs(s3));// see ClassA_ClassB here
    System.out.println(StringTool.formatListString(s4));
    System.out.println(StringTool.extractArrayIfPair(s5));
    System.out.println(StringTool.isArrayPairArrayAndDimension(s4));
    System.out.println(StringTool.isArrayPairArrayAndDimension(s5));
  }

}
