package ccu.pllab.tcgen3.core.testcasegen;

/**
 * �ʸ˨�q CLP ���͵��G�G
 *  - returnString  : �Ω�D����
 *  - methodString  : �B�~���ͪ����U�z��
 */
public record ClpCode(String returnString, String methodString) {
	@Override
	public String toString() {
		return  methodString + returnString;
	}
}

