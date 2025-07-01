package ccu.pllab.tcgen3.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/** All Static Method*/
public abstract class StringTool {
	/**
	 * �N "[dim, var, sam]" �ഫ�� "[Dim, Var, Sam]".
	 *
	 * @param input �ӷ��r��A�榡�������H���A���]�СB�H�r���M�Ů���j���M��
	 * @return �B�z�᪺�r��
	 */
	public static String capitalizeElements(String input) {
	    if (input == null || input.length() < 2 || input.charAt(0) != '[' ||
	        input.charAt(input.length() - 1) != ']') {
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
	 * �P�_��J�r��O�_���u�¾�ƲM��v�G
	 *  - �䴩�i��Ů�A�p "[1, 2, 3]"
	 *  - ��ƥi�a���t���A�p "-8"
	 *  - �u�n���@�����D��Ʃή榡���ŧY�^�� false
	 *
	 * @param input ���ˬd���M��r��
	 * @return true = ��������ơFfalse = �_
	 */
	public static boolean isPureIntegerList(String input) {
	    // �ˬd�̰򥻪��榡�G�����H '[' �}�Y�B�H ']' ����
	    if (input == null || input.length() < 2 ||
	        input.charAt(0) != '[' || input.charAt(input.length() - 1) != ']') {
	        return false;
	    }

	    // ���X���A�������r��A�A�γr�����Ρ]���\���N�ťա^
	    String body = input.substring(1, input.length() - 1).trim();
	    if (body.isEmpty()) {             // �ŲM���_
	        return false;
	    }

	    String[] parts = body.split("\\s*,\\s*"); // �P�ɲ����r���ǪŮ�

	    // �ˬd�C�ӳ����O�_�ŦX��ƥ��h�]�i�� +/-�A�ܤ֤@��Ʀr�^
	    for (String part : parts) {
	        if (!part.matches("[+-]?\\d+")) {     // �u�n�@�Ӥ��ŴN���O�¼Ʀr
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
        if (input == null || input.length() < 2 ||
            input.charAt(0) != '[' || input.charAt(input.length() - 1) != ']') {
            throw new IllegalArgumentException("��J�榡������ [item1, item2, ...]");
        }

        // �h�����A���ä��ΡF\\s* ��ܹL�o�r���e�᪺�Ҧ��ť�
        String body = input.substring(1, input.length() - 1);
        return Arrays.stream(body.split("\\s*,\\s*"))
                     .filter(s -> !s.isEmpty())                    // �קK�Ŧr��
                     .map(s -> Character.toUpperCase(s.charAt(0))  // ���r�j�g
                                + s.substring(1))
                     .collect(Collectors.toList());
    }
	
	public static void main(String[] args) {
	    String original = "[dim, var, sam]";
	    String result = capitalizeElements(original);
	    System.out.println(result);  // ��X: [Dim, Var, Sam]
	    System.out.println(isPureIntegerList("[1,2,3,4,5]"));   // true
	    System.out.println(isPureIntegerList("[1, 2, -3, 4]")); // true
	    System.out.println(isPureIntegerList("[dim, var]"));    // false
	    System.out.println(isPureIntegerList("[1, var]"));      // false
	    String example = "[dim, var]";
        List<String> list = toCapitalizedList(example);
        System.out.println(list);  // ��X: [Dim, Var]
        int[][][] data = {{{ 19590, -51754, -34838, -50622, 51653, 7299, -38466, -2143 }}};

        System.out.println(data.length);         // 1  (�� 1 ��)
        System.out.println(data[0].length);      // 1  (�� 2 ��)
        System.out.println(data[0][0].length);   // 8  (�� 3 ��)
        System.out.println(data[0][0][0]);       // 19590
	}

}
