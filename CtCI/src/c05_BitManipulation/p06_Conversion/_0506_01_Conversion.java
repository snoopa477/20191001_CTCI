package c05_BitManipulation.p06_Conversion;

import static java.lang.System.out;

public class _0506_01_Conversion {
	int bitSwapRequired(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c = c & (c - 1)) {
			count++;
		}
		return count;
	}
}
