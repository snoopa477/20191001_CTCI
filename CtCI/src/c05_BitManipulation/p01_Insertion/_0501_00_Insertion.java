package c05_BitManipulation.p01_Insertion;

import static java.lang.System.out;

public class _0501_00_Insertion {
	int updateBits(int n, int m, int i, int j) {
		/*
		 * Create a mask to clear bits i through j in n. EXAMPLE: i = 2, j = 4. Result
		 * should be 11100011. For simplicity, we'll use just 8 bits for the example.
		 */
		int allOnes = ~0; // will equal sequence of all is
		// 1s before position j, then 0s. left = lll00000
		int left = allOnes << (j + 1);
		// 1's after position i. right 000000ll
		int right = ((1 << i) - 1);

		// All is, except for as between i and j. mask lll000ll
		int mask = left | right;
		/* Clear bits j through i then put m in there */
		int n_cleared = n & mask; // Clear bits j through i.
		int m_shifted = m << i; // Move m into correct position.
		return n_cleared | m_shifted; // OR them, and we're done!
	}
}
