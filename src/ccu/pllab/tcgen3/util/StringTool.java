package ccu.pllab.tcgen3.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/** All Static Method*/
public abstract class StringTool {
	/**
	 * 將 "[dim, var, sam]" 轉換為 "[Dim, Var, Sam]".
	 *
	 * @param input 來源字串，格式必須為以中括號包覆、以逗號和空格分隔的清單
	 * @return 處理後的字串
	 */
	public static String capitalizeElements(String input) {
	    if (input == null || input.length() < 2 || input.charAt(0) != '[' ||
	        input.charAt(input.length() - 1) != ']') {
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
	 * 判斷輸入字串是否為「純整數清單」：
	 *  - 支援可選空格，如 "[1, 2, 3]"
	 *  - 整數可帶正負號，如 "-8"
	 *  - 只要任一元素非整數或格式不符即回傳 false
	 *
	 * @param input 欲檢查的清單字串
	 * @return true = 全部為整數；false = 否
	 */
	public static boolean isPureIntegerList(String input) {
	    // 檢查最基本的格式：必須以 '[' 開頭、以 ']' 結尾
	    if (input == null || input.length() < 2 ||
	        input.charAt(0) != '[' || input.charAt(input.length() - 1) != ']') {
	        return false;
	    }

	    // 取出中括號內部字串，再用逗號分割（允許任意空白）
	    String body = input.substring(1, input.length() - 1).trim();
	    if (body.isEmpty()) {             // 空清單算否
	        return false;
	    }

	    String[] parts = body.split("\\s*,\\s*"); // 同時移除逗號旁空格

	    // 檢查每個部分是否符合整數正則（可選 +/-，至少一位數字）
	    for (String part : parts) {
	        if (!part.matches("[+-]?\\d+")) {     // 只要一個不符就不是純數字
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
        if (input == null || input.length() < 2 ||
            input.charAt(0) != '[' || input.charAt(input.length() - 1) != ']') {
            throw new IllegalArgumentException("輸入格式必須為 [item1, item2, ...]");
        }

        // 去掉中括號並切割；\\s* 表示過濾逗號前後的所有空白
        String body = input.substring(1, input.length() - 1);
        return Arrays.stream(body.split("\\s*,\\s*"))
                     .filter(s -> !s.isEmpty())                    // 避免空字串
                     .map(s -> Character.toUpperCase(s.charAt(0))  // 首字大寫
                                + s.substring(1))
                     .collect(Collectors.toList());
    }
	
	public static void main(String[] args) {
	    String original = "[dim, var, sam]";
	    String result = capitalizeElements(original);
	    System.out.println(result);  // 輸出: [Dim, Var, Sam]
	    System.out.println(isPureIntegerList("[1,2,3,4,5]"));   // true
	    System.out.println(isPureIntegerList("[1, 2, -3, 4]")); // true
	    System.out.println(isPureIntegerList("[dim, var]"));    // false
	    System.out.println(isPureIntegerList("[1, var]"));      // false
	    String example = "[dim, var]";
        List<String> list = toCapitalizedList(example);
        System.out.println(list);  // 輸出: [Dim, Var]
        int[][][] data = {{{ 19590, -51754, -34838, -50622, 51653, 7299, -38466, -2143 }}};

        System.out.println(data.length);         // 1  (第 1 維)
        System.out.println(data[0].length);      // 1  (第 2 維)
        System.out.println(data[0][0].length);   // 8  (第 3 維)
        System.out.println(data[0][0][0]);       // 19590
	}

}
