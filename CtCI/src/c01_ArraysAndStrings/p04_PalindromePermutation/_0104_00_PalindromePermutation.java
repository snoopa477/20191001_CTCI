package c01_ArraysAndStrings.p04_PalindromePermutation;

import static java.lang.System.out;

public class _0104_00_PalindromePermutation {

	boolean isPermutationOfPalindrome(String phrase) {
		int[] table = buildCharFrequencyTable(phrase);
		return checkMaxOneOdd(table);
	}

	/* Check that no more than one character has an odd count. */
	boolean checkMaxOneOdd(int[] table) {
		boolean foundOdd = false;
		for (int count : table) {
			if (count % 2 == 1) {
				if (foundOdd) {
					return false;
				}
				foundOdd = true;
			}
		}
		return true;
	}

	/*
	 * Map each character to a number. a -) 0J b - ) IJ C - ) 2J etc. This is case
	 * insensitive. Non-letter characters map to -1.
	 */
	int getCharNumber(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if (a <= val && val <= z) {
			return val - a;
		}
		return -1;
	}
	/* Count how many times each character appears. */

	int[] buildCharFrequencyTable(String phrase) {
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);

			if (x != -1) {
				table[x]++;
			}
		}
		return table;
	}

}
