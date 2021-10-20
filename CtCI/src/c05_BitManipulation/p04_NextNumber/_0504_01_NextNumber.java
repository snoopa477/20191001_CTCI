package c05_BitManipulation.p04_NextNumber;

import static java.lang.System.out;

public class _0504_01_NextNumber {
	int getPrev(int n) {
		int temp = n;
		int c0 = 0;
		int c1 = 0;
		while ((temp & 1) == 1) {
			c1++;
			temp >>= 1;
		}

		if (temp == 0)
			return -1;
		while (((temp & 1) == 0) && (temp != 0)) {
			c0++;
			temp >>= 1;
		}
		int p = c0 + c1; // position of rightmost non-trailing one
		n &= ((~0) << (p + 1)); // clears from bit p onwards
		int mask = (1 << (c1 + 1)) - 1; // Sequence of (cl+l) ones
		n |= mask << (c0 - 1);
		return n;
	}
}
