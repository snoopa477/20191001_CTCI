package c01_ArraysAndStrings.p01_IsUnique;

import static java.lang.System.out;

public class _0101_01_isUnique {
	boolean isUniqueChars(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}
}
