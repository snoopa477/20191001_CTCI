package c05_BitManipulation.p06_Conversion;
import static java.lang.System.out;
public class Conversion_02_removalOfLeastSignificantSetBit {

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
		/**
		  1  0  0  1  0  0 [1] 0  0  0 : 
		  1  0  0 [1] 0  0  0  0  0  0 : 1
		 [1] 0  0  0  0  0  0  0  0  0 : 2
		  0  0  0  0  0  0  0  0  0  0 : 3
		 */
		while( num > 0 ) {
			result ++;
			
			//PURPOSE remove least significant bits 
			num &= (num -ONE );
		}
		
		return result;
	}

	
}


