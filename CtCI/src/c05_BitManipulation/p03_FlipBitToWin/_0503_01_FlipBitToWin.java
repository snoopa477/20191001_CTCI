package c05_BitManipulation.p03_FlipBitToWin;

import static java.lang.System.out;

public class _0503_01_FlipBitToWin {
	int flipBit(int a) {
		/* If all 1S, this is already the longest sequence. */
		if (~a == 0)
			return Integer.BYTES * 8;

		int currentLength = 0;
		int previousLength = 0;
		int maxLength = 1; // We can always have a sequence of at least one 1
		while (a != 0) {
			if ((a & 1) == 1) { // Current bit is a 1
				currentLength++;
			} else if ((a & 1) == 0) { // Current bit is a 0

				/* Update to a (if next bit is a) or currentLength (if next bit is 1). */
				previousLength = (a & 2) == 0 ? 0 : currentLength;
				currentLength = 0;

			}

		}

		maxLength = Math.max(previousLength + currentLength + 1, maxLength);
		a >>>= 1;

		return maxLength;
	}
}
