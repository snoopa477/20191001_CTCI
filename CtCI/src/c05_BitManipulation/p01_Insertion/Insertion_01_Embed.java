package c05_BitManipulation.p01_Insertion;
import static java.lang.System.out;

import util.BitPrinter;

public class Insertion_01_Embed {
	
	public static boolean IS_DEBUG = false;
	
	private static final int ONE = 1;
	
	public static int embed(int number_N, int number_M, int leftBit, int rightBit) {
		
		//PURPOSE: make rooms for number_M to embed in 
		int mask = makeMask(leftBit, rightBit);
		//WRONG
		//int masked_N = number_N | mask; 
		int masked_N = number_N & mask;
		
		if(IS_DEBUG) {
			out.println("masked_N\n" + BitPrinter.bitString(masked_N, true));
		}
		
		//PURPOSE: move number_M to the right place to embed in masked_N
		/*THINK_FURTHER under the premise that number_M 's effective bit's length is
		 * shorter than (leftBit - rightBit + 1), don't need to mask out redundant bits of number_M 
		 * to fit in masked_N 
		 */
		int shifted_M = number_M << rightBit;
		
		//PURPOSE: embed shifted_M into masked_N
		int result = masked_N | shifted_M; 
		
		return result;
	}
	
	
	
	private static int makeMask(int leftBit, int rightBit) {
		
		//PURPOSE: mask consists of rightOnes and leftOnes, leaving 0's in between them 
		//REASONING: use 0's to clear bits of number_N, leaving rooms for numberM to set bits
		
		//DETAIL: don't get confused with index and length/position
		//DETAIL: even one bit difference matters. To make clearer picture in mind, it's good to write down comment 
		
		/**
		 * e.g. leftBit: 5, rightBit = 3
		 * 7  6  5  4  3  2  1  0
		 * x  x [x] x [x] x  x  x
		 * 
		 */
		
		/**
		 * 0  0  0  0 
		 * 1  1  1  1  
		 */
		int allOnes = ~0;
		/**
		 * 0 0 0 0 0 0 0 0
		 * 1 1 1 1 1 1 1 1
		 * 1 1 0 0 0 0 0 0 
		 */
		int leftOnes = allOnes << ( leftBit + ONE );
		
		
		/**
		 * given rightBit = 3
		 * 0 0 0 0 0 0 0 1  
		 * 0 0 0 0 1 0 0 0 = 1 << (3)
		 * 0 0 0 0 0 1 1 1 = result -1
		 * 
		 */
	
		//WRONG: typo
		//TODO: look up the operator precedence
		//int rightOnes = 1 << ( leftBit + ONE ) - ONE;
		int rightOnes = (1 << ( rightBit ) ) - ONE;
		int mask =  leftOnes | rightOnes;
		
		if( IS_DEBUG ) {
			out.println("mask\n" + BitPrinter.bitString(mask, true));
		}
		
		//combine two
		return mask;
	}
}


