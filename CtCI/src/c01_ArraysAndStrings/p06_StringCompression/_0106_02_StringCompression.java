package c01_ArraysAndStrings.p06_StringCompression;

import static java.lang.System.out;

public class _0106_02_StringCompression {
	String compress(String str) {

		/* Check final length and return input string if it would be longer. */
		int finalLength = countCompression(str);
		if (finalLength >= str.length())
			return str;
		StringBuilder compressed = new StringBuilder(finalLength); // initial capacity
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;
			/* If next character is different than current, append this char to result. */
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.toString();
	}

	int countCompression(String str) {
		int compressedLength = 0;
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;
			/* If next character is different than current, increase the length. */
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressedLength += 1 + String.valueOf(countConsecutive).length();
				countConsecutive = 0;
			}
		}
		return compressedLength;
	}
}
