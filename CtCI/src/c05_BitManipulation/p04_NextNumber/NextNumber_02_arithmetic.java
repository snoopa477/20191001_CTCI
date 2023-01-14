package c05_BitManipulation.p04_NextNumber;
import static java.lang.System.out;
public class NextNumber_02_arithmetic {
	
	
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
		 * arithmetic operation: 
		 * 1  1  0  1  1  0  0  1  1  1  1  1  0  0
		 *                                  1  0  0  : 1 << countsOf0
		 * + ) -------------------------------------
		 * 1  1  0  1  1  0 [1] 0  0  0  0  0  0  0
		 *                               1  1  1  1 : ( 1 << ( countsOf1 -1 ) ) -1
		 * + ) -------------------------------------
		 * 1  1  0  1  1  0 [1] 0  0 <1  1  1  1  1>
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
			|| countsOf1 + countsOf0 == INTEGER_SIZE -1	
			) {
			return -1;
		}
		
		/*
		 * arithmetic operation: 
		 * 1  1  0  1  1  0  0  1  1  1  1  1  0  0
		 *                                  1  0  0  : 1 << countsOf0
		 * + ) -------------------------------------
		 * 1  1  0  1  1  0 [1] 0  0  0  0  0  0  0
		 *                               1  1  1  1 : ( 1 << ( countsOf1 -1 ) ) -1
		 * + ) -------------------------------------
		 * 1  1  0  1  1  0 [1] 0  0 <1  1  1  1  1> 
		 * 
		 */
		return number 
			+ (1 << countsOf0 ) 
			+ ( 1 << ( countsOf1 -1 ) ) -1 ;
	}
	
	
	
}


