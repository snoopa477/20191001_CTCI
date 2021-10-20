package c01_ArraysAndStrings.p02_CheckPermutatoin;

import static java.lang.System.out;

public class _0102_00_CheckPermutation {

	String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}

	boolean permutation(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		return sort(s).equals(sort(t));
	}

}
