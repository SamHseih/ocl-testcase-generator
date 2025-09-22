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
   * �N "ClassA :: ClassB" �� "ClassA.ClassB" �ন "ClassA_ClassB"�C �]�䴩�s��h�q�G�Ҧp "A.B.C" -> "A_B_C"�B"A ::
   * B :: C" -> "A_B_C"�C
   */
  public static String mergeClassRefs(String s) {
    if (s == null)
      return null;
    String regex = "\\b([A-Z][A-Za-z0-9_]*)\\s*(?:::|\\.)\\s*([A-Z][A-Za-z0-9_]*)\\b";
    String out = s, prev;
    do {
      prev = out;
      out = out.replaceAll(regex, "$1_$2");
    } while (!out.equals(prev)); // ���N����S���i���N�����q�]�B�z���|���^
    return out;
  }

  /**
   * �N�r�ꪺ���r���ର�j�g�C
   *
   * @param str ���B�z���r��
   * @return �B�z�᪺�r��A�Y��r�ꬰ null �Ϊūh�^�ǭ�r��
   */
  public static String tocapitalizeFirstLetter(String str) {
    if (str == null || str.isEmpty()) {
      return str;
    }
    return Character.toUpperCase(str.charAt(0)) + str.substring(1);
  }

  /**
   * �N��J�r�ꪺ�Ĥ@�� Unicode �r���ର�p�g�C
   * <p>
   * �Y�r�ꬰ null �ΪŦr��A�h�����^�ǭ�ȡC
   * </p>
   *
   * @param s ��l�r��
   * @return �r����p�g�᪺�s�r��
   */
  public static String todecapitalizeFirstLetter(String s) {
    if (s == null || s.isEmpty()) {
      return s;
    }
    int firstCodePoint = s.codePointAt(0);
    int lowerFirst = Character.toLowerCase(firstCodePoint);

    // �Y�Ĥ@�� code point �u���@�� char�]�D�N�z��^�A������ substring�C
    if (Character.charCount(firstCodePoint) == 1) {
      return (char) lowerFirst + s.substring(1);
    }

    // �N�z�ﱡ�p�G�Ĥ@�� code point ����� char
    return new StringBuilder().appendCodePoint(lowerFirst)
        .append(s.substring(Character.charCount(firstCodePoint))).toString();
  }

  /**
   * �N Map �ഫ���榡�ƪ��r���ܡA�䴩�_�� Map �M List�C
   * <p>
   * �C�h�Y�ƨ��A�K��\Ū�C
   * </p>
   *
   * @param map ���ഫ�� Map
   * @param indent ��e�Y�Ƽh�š]0 ���̥~�h�^
   * @return �榡�ƫ᪺�r��
   */
  public static String mapToString(Map<?, ?> map, int indent) {
    StringBuilder sb = new StringBuilder();
    String indentStr = "  ".repeat(indent); // �C�h�Y�ƨ��

    sb.append("\n");
    for (Map.Entry<?, ?> entry : map.entrySet()) {
      sb.append(indentStr).append("  ").append(entry.getKey()).append(":\n\t");

      Object value = entry.getValue();
      if (value instanceof Map) {
        // �p�G�ȬO Map�A���j�B�z
        sb.append(mapToString((Map<?, ?>) value, indent + 1));
      } else if (value instanceof List) {
        // �p�G�ȬO List�A�B�z List
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
   * �N "[dim, var, sam]" �ഫ�� "[Dim, Var, Sam]".
   *
   * @param input �ӷ��r��A�榡�������H���A���]�СB�H�r���M�Ů���j���M��
   * @return �B�z�᪺�r��
   */
  public static String capitalizeElements(String input) {
    if (input == null || input.length() < 2 || input.charAt(0) != '['
        || input.charAt(input.length() - 1) != ']') {
      throw new IllegalArgumentException("��J�榡������ [item1, item2, ...]");
    }

    // �h�����k���A���A�A���r������
    String body = input.substring(1, input.length() - 1);
    String[] parts = body.split("\\s*,\\s*"); // �P�ɮ����i�઺�h�l�Ů�

    // �N�C�Ӥ��q���r��j�g
    for (int i = 0; i < parts.length; i++) {
      if (!parts[i].isEmpty()) {
        parts[i] = parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1);
      }
    }

    // ���s�ո˨å[�^���A��
    return "[" + String.join(", ", parts) + "]";
  }

  /**
   * �P�_��J�r��O�_���u�¾�ƲM��v�G - �䴩�i��Ů�A�p "[1, 2, 3]" - ��ƥi�a���t���A�p "-8" - �u�n���@�����D��Ʃή榡���ŧY�^�� false
   *
   * @param input ���ˬd���M��r��
   * @return true = ��������ơFfalse = �_
   */
  public static boolean isPureIntegerList(String input) {
    // �ˬd�̰򥻪��榡�G�����H '[' �}�Y�B�H ']' ����
    if (input == null || input.length() < 2 || input.charAt(0) != '['
        || input.charAt(input.length() - 1) != ']') {
      return false;
    }

    // ���X���A�������r��A�A�γr�����Ρ]���\���N�ťա^
    String body = input.substring(1, input.length() - 1).trim();
    if (body.isEmpty()) { // �ŲM���_
      return false;
    }

    String[] parts = body.split("\\s*,\\s*"); // �P�ɲ����r���ǪŮ�

    // �ˬd�C�ӳ����O�_�ŦX��ƥ��h�]�i�� +/-�A�ܤ֤@��Ʀr�^
    for (String part : parts) {
      if (!part.matches("[+-]?\\d+")) { // �u�n�@�Ӥ��ŴN���O�¼Ʀr
        return false;
      }
    }
    return true;
  }

  /**
   * �N "[dim, var]" �ন List<String>�A�ç⤸�����r���j�g�C
   *
   * @param input �����O "[...]" �Φ��B�r�����j���r��
   * @return �ഫ�᪺ List�A�Ҧp ["Dim", "Var"]
   * @throws IllegalArgumentException �榡���Ůɥ�X�ҥ~
   */
  public static List<String> toCapitalizedList(String input) {
    if (input == null || input.length() < 2 || input.charAt(0) != '['
        || input.charAt(input.length() - 1) != ']') {
      throw new IllegalArgumentException("��J�榡������ [item1, item2, ...]");
    }

    // �h�����A���ä��ΡF\\s* ��ܹL�o�r���e�᪺�Ҧ��ť�
    String body = input.substring(1, input.length() - 1);
    return Arrays.stream(body.split("\\s*,\\s*")).filter(s -> !s.isEmpty()) // �קK�Ŧr��
        .map(s -> Character.toUpperCase(s.charAt(0)) // ���r�j�g
            + s.substring(1))
        .collect(Collectors.toList());
  }

  /**
   * �N�r��Φp "[dim1,dim2,dim3]" �����ײM��A ���C�Ӻ��ץ[�W prefix_�A�ëO�����A���γr���榡�C
   *
   * @param dims �ӷ��r��A�榡������ [item1,item2,...]�]���\�ťա^
   * @param prefix �n�[��C�Ӷ��ثe���r�� (�Ҧp "Arg")
   * @return �[�u�᪺�r��A�Ҧp "[Arg_dim1,Arg_dim2,Arg_dim3]"
   */
  public static String addPrefix(String dims, String prefix) {
    if (dims == null || prefix == null) {
      throw new IllegalArgumentException("��J���i�� null");
    }

    // �h���������A�������
    String content = dims.trim();
    if (content.startsWith("[") && content.endsWith("]")) {
      content = content.substring(1, content.length() - 1);
    } else {
      throw new IllegalArgumentException("�榡���~�G�д��ѥH [ ] �]�Ъ��r��");
    }

    // �w��C�Ӥ����[�W prefix_
    String[] parts = content.split("\\s*,\\s*"); // �䴩�t�ť�
    for (int i = 0; i < parts.length; i++) {
      parts[i] = prefix + "_" + parts[i];
    }

    // ���s�ո˦� [item1,item2,...] �Φ�
    return "[" + String.join(",", parts) + "]";
  }

  /** Input String "[1,2,3]" Output String : 1,2,3 */
  public static String formatListString(String input) {
    if (input == null || input.isEmpty()) {
      return "";
    }
    // �h���}�Y�M������ [ ]
    String trimmed = input.replaceAll("[\\[\\]]", "");
    // �h���h�l�ť�
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
   * �Y�r��ŦX "[ <array> , <dimension> ]" ���T�w�榡�A�^�� <array>�F �_�h�^�ǭ�r��]�h�������ťա^�C
   *
   * �W�h�G 1) �̥~�h�����O���A���]��B�u����ӳ��h�����C 2) �Ĥ@�Ӥ��������O�u�ܤ֤G���v���}�C�]�]�N�O�������������٧t�� '['�^�C 3) �ĤG�Ӥ��������O�u�@����ư}�C�v�A�Ҧp [2,
   * 2]�]�������o�A�����A���^�C
   */
  public static String extractArrayIfPair(String input) {
    if (input == null)
      return null;
    String s = input.trim();
    if (s.length() < 2 || s.charAt(0) != '[' || s.charAt(s.length() - 1) != ']') {
      return s; // ���O�H [ ... ] �]��A�����^��
    }

    // ���X�̥~�h���e
    int start = 1, end = s.length() - 1;

    // ���Φ��u���h�����v�M��]�H depth==0 ���r�����^
    java.util.List<int[]> spans = new java.util.ArrayList<>(); // �C�Ӥ����� [from, to)
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
        return s; // �A�������šA�������ŦX�A��˦^��
    }

    // ���� token
    if (tokenStart <= end) {
      spans.add(new int[] {tokenStart, end});
    }

    // ���O��n��ӳ��h���� -> �D [array, dimension]�A��˦^��
    if (spans.size() != 2)
      return s;

    String first = s.substring(spans.get(0)[0], spans.get(0)[1]).trim(); // <array>
    String second = s.substring(spans.get(1)[0], spans.get(1)[1]).trim(); // <dimension>
    // ���� �Y�ԡG�ˬd����
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

  /** �ȷ��J�� [ <array(�ܤ֤G��)> , <dimension(�@����ư}�C)> ] �ɦ^�� true */
  public static boolean isArrayPairArrayAndDimension(String input) {
    if (input == null)
      return false;
    String s = input.trim();
    if (s.length() < 2 || s.charAt(0) != '[' || s.charAt(s.length() - 1) != ']')
      return false;

    // ��̥~�h�A����A�̡u���h�r���v������Ӥ���
    int start = 1, end = s.length() - 1;
    java.util.List<int[]> spans = splitTopLevelByComma(s, start, end);
    if (spans.size() == 2)
      return true;
    else
      return false;
  }

  // �X�X Helpers �X�X

  /** �H�u�A���`�׬� 0 ���r���v���� [start, end) ���e�����h���� spans�G[from, to) */
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
        return java.util.Collections.emptyList(); // �A��������
    }
    if (depth != 0)
      return java.util.Collections.emptyList(); // �A��������
    if (tokenStart < end)
      res.add(new int[] {tokenStart, end});
    return res;
  }


  /** �^�ǰ}�C�r�ꪺ���פj�p�A�Ҧp [1756, 29789] -> [2], [[-9063, 23362], [41687, -22394]] -> [2,2] */
  private static List<Integer> getDimensions(String input) {
    if (input == null)
      return Collections.emptyList();
    String s = input.trim();
    if (s.isEmpty() || s.charAt(0) != '[' || s.charAt(s.length() - 1) != ']') {
      return Collections.emptyList(); // �D�}�C�榡
    }
    return parseArray(s);
  }

  // ���j�ѪR�}�C
  private static List<Integer> parseArray(String s) {
    List<String> elements = splitTopLevel(s.substring(1, s.length() - 1).trim());
    List<Integer> dims = new ArrayList<>();
    dims.add(elements.size()); // ���O���o�@�h���j�p

    // �ˬd�Ĥ@�Ӥ����O�_�٬O�}�C�A�p�G�O�h���j�]���]���c�W�h�^
    if (!elements.isEmpty()) {
      String first = elements.get(0).trim();
      if (first.startsWith("[") && first.endsWith("]")) {
        dims.addAll(parseArray(first));
      }
    }
    return dims;
  }

  // �H�u�`��=0 ���r���v�����r��
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
        return true; // �@�����Ʀr�N�^�� true
      }
    }
    return false; // ���S���Ʀr
  }

  public static void main(String[] args) {
    String original = "[dim, var, sam]";
    String result = capitalizeElements(original);
    System.out.println(result); // ��X: [Dim, Var, Sam]
    System.out.println(isPureIntegerList("[1,2,3,4,5]")); // true
    System.out.println(isPureIntegerList("[1, 2, -3, 4]")); // true
    System.out.println(isPureIntegerList("[dim, var]")); // false
    System.out.println(isPureIntegerList("[1, var]")); // false
    String example = "[dim, var]";
    List<String> list = toCapitalizedList(example);
    System.out.println(list); // ��X: [Dim, Var]
    int[][][] data = {{{19590, -51754, -34838, -50622, 51653, 7299, -38466, -2143}}};

    System.out.println(data.length); // 1 (�� 1 ��)
    System.out.println(data[0].length); // 1 (�� 2 ��)
    System.out.println(data[0][0].length); // 8 (�� 3 ��)
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
