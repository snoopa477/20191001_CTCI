package c01_ArraysAndStrings.p09_StringRotation;

import static java.lang.System.out;

public class _0109_00_StringRotation {
	boolean isRotation(String s1, String s2) {
		int len = s1.length();
		/* Check that 51 and 52 are equal length and not empty */
		if (len == s2.length() && len > 0) {
			/* Concatenate 51 and sl within new buffer */
			String s1s1 = s1 + s1;
			return isSubstring(s1s1, s2);
		}
		return false;
	}
}
