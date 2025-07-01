package ccu.pllab.tcgen3.core.testcasegen;

/**
 * 封裝兩段 CLP 產生結果：
 *  - returnString  : 用於主條件式
 *  - methodString  : 額外產生的輔助述詞
 */
public record ClpCode(String returnString, String methodString) {
	@Override
	public String toString() {
		return  methodString + returnString;
	}
}

