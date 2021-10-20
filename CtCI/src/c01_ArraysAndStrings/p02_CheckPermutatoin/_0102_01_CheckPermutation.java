package c01_ArraysAndStrings.p02_CheckPermutatoin;

import static java.lang.System.out;

public class _0102_01_CheckPermutation {

	boolean permutation(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] letters = new int[128]; // Assumption
		char[] s_array = s.toCharArray();
		for (char c : s_array) { // count number of each char i n s.
			letters[c]++;
		}
		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
			letters[c]--;
			if (letters[c] < 0) {
				return false;
			}
		}
		return true;
	}
}
