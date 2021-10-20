package c05_BitManipulation.p07_PairwiseSwap;

import static java.lang.System.out;

public class _0507_00_PairwiseSwap {
	int swapOddEvenBits(int x) {
		return (((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1));
	}
}
