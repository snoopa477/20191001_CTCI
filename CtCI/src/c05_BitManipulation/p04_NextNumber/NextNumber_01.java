package c05_BitManipulation.p04_NextNumber;
import static java.lang.System.out;
public class NextNumber_01 {

	private static final int ZERO = 0;
	private static final int ONE = 1;
	private static final int INTEGER_SIZE = 32;
	
	public static boolean IS_DEBUG = false;
	
	public static int nextNumberSameBits(int number) {
		
		/* PURPOSE
		 * 1  1  0  1  1  0  0  1  1  1  1  1  0  0
		 * 1  1  0  1  1  0 [0]<1  1  1  1  1>{0  0}
		 * []: pivot bit index = 7
		 * <>: countsOf1 = 5
		 * {}: countsOf0 = 2
		 * 
		 * ----------------------------------------------
		 * Result: 
		 * 1  1  0  1  1  0 [1] 0  0 <1  1  1  1  1>
		 * 
		 * step1:
		 * pivot bit is flipped from 0 to 1 ( get larger than original number in minimum scale
		 * 
		 * step2:
		 * bunch of 1 is moved to rightmost ( under the premise it's larger, get as small as possible 
		 * 
		 */
		
		/* special cases that we don't handle
		 * special case 1: 
		 * 1  1  1  1  1  0  0  0  0  0  0  0  0  0
		 * 
		 * special case 2: 
		 * 0  0  0  0  0  0  0  0  0  0  0  0  0  0
		 * 
		 */
		
		int tempNumber = number;
		
		/*PURPOSE: before step1, to get pivot bit index, we need get countsOf0&1 first, because
		 * pivot bit index = countsOf0 + countsOf1
		 */
		int countsOf0 = 0;
		int countsOf1 = 0;
		
		while( tempNumber > 0 
			&& ( tempNumber & ONE ) == ZERO ) {
			countsOf0 ++ ;
			//DETAIL: since we only handle number > 0, no leading bit 1, >>> is not required
			//tempNumber >>>= 1;
			tempNumber >>= 1;
		}
		
		
		while( ( tempNumber & ONE ) == ONE  ) {
			countsOf1 ++ ;
			//DETAIL: since we only handle number > 0, no leading bit 1, >>> is not required
			//tempNumber >>>= 1;
			tempNumber >>= 1;
		}
		
		if(IS_DEBUG) {
			out.println("c1: " + countsOf1 + "; c0: " + countsOf0);
		}
		
		/*REASONING: special case 2: no bit to flip*/
		if( number == 0
			/*REASONING: special case 1: cannot get bigger, since no zero, which right side is 1, to flip*/
			/*WRONG: the leading 1 means negative number in 2 sign. all 32 1's means -1 in decimal. 
				under the premise of 2 sign, all 1's max number has 32 -1 bits, letting the leading bit as 0 
			*/  
			//|| countsOf1 + countsOf0 == INTEGER_SIZE 
			|| countsOf1 + countsOf0 == INTEGER_SIZE -1	
			) {
			return -1;
		}
		
		
		/* PURPOSE
		 * step1:
		 * pivot bit is flipped from 0 to 1
		 * */
		int pivotIndex = countsOf1 + countsOf0;
		int nextNumber = number | (1 << pivotIndex); //flip = set pivot bit as 1
		
		
		/* PURPOSE
		 * step2:
		 *  bunch of 1 is moved to rightmost
		 * */
		//clear bits right from pivot bit
		nextNumber &= reverseMaskOfCounts1And0( countsOf1, countsOf0);
		//move set bits to rightmost
		nextNumber |= rightmost1s( countsOf1 );

		
		return nextNumber;
	}
	
	
	
	private static int reverseMaskOfCounts1And0(int countsOf1, int countsOf0) {
		
		/**
		 * 1  1  0  1  1  0 [0]<1  1  1  1  1>{0  0}
		 * 0  0  0  0  0  0  1  0  0  0  0  0  0  0 :  1 << (countsOf1 + countsOf0)
		 * 0  0  0  0  0  0  0  1  1  1  1  1  1  1 :  
		 * 1  1  1  1  1  1  1  0  0  0  0  0  0  0
		 * 
		 * or
		 * 0  0  0  0  0  0  0  0  0  0  0  0  0  0 : 0
		 * 1  1  1  1  1  1  1  1  1  1  1  1  1  1 : ~0
		 * 1  1  1  1  1  1  1  0  0  0  0  0  0  0 : (~0) << ( countsOf1 + countsOf0 )
		 */
		
		return (~0) << ( countsOf1 + countsOf0 );
	}
	
	
	
	private static int rightmost1s( int countsOf1 ) {
		
		/** REASONING: since we used up one set bit at pivot index, 
		 * instead of countsOf1 bits, we have to move
		 * another ( countsOf1 - 1 ) bits to rightmost  
		 * 
		 * 1  1  0  1  1  0 [0]<1  1  1  1  1>{0  0}
		 * 0  0  0  0  0  0  0  0  0  1  0  0  0  0 : 1 << ( countsOf1 -1 )
		 * 0  0  0  0  0  0  0  0  0  0  1  1  1  1 : ( 1 << ( countsOf1 -1 ) ) -1
		 */
		
		return ( 1 << ( countsOf1 -1 ) ) -1;
	}
	
	
	
}


