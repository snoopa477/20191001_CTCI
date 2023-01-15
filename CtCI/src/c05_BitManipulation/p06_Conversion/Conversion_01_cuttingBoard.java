package c05_BitManipulation.p06_Conversion;
import static java.lang.System.out;
public class Conversion_01_cuttingBoard {
	
	private static int ONE = 1;
	
	public static int bitSwapRequired(int a, int b) {
		
		/**
		 * 1  1  1  0  1  0  1  1  0  1
		 * 0  1  1  1  1  0  0  1  0  1
		 * XOR )-------------------------
		 * 1  0  0  1  0  0  1  0  0  0
		 */
		
		/* IMAGINATION: a vector: 1 means difference between bit of a and b; 
		 * 0 means both bits of a and b are the same 
		 */
		int bitsOfDiffertiation = a ^ b;
		
		int result = 0;
		
		int num = bitsOfDiffertiation;
		//PURPOSE: count those set bits
		//I don't like too much logic written in on line
		//for( int num = bitsOfDiffertiation; num > 0; num = num >>>= 1 ) {
		while( num > 0 ) {
			if( (num & ONE) == ONE ) {
				result ++;
			}
			
			num >>>=1;
		}
		
		return result;
	}

}


