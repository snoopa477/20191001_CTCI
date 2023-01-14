package c05_BitManipulation.p04_NextNumber;
import static java.lang.System.out;
public class PreviousNumber_02_arithmetic {

	private static final int ZERO = 0;
	private static final int ONE = 1;
	
	public static int previousNumberSameBits(int number) {
		
		/**
		 * 1  0  0  1  1  1  1  0  0  0  0  0  1  1
		 * 1  0  0  1  1  1 [1]<0  0  0  0  0>{1  1}
		 * 
		 * pivot bit index = 7
		 * countsOf1 = 2
		 * countsOf0 = 5
		 * 
		 * result: 
		 * 1  0  0  1  1  1 [0] 1  1  1  0  0  0  0
		 * 
		 * ----------------------------------------------
		 * arithmetic operation: 
		 * 
		 * 1  0  0  1  1  1  1  0  0  0  0  0  1  1
		 *                                     1  1 : (1 << countsOf1 ) -1 
		 * - ) -------------------------------------  
		 * 1  0  0  1  1  1  1  0  0  0  0  0  0  0
		 *                                        1 : 1
		 * - ) -------------------------------------                              
		 * 1  0  0  1  1  1 [0] 1  1  1  1  1  1  1
		 *                               1  1  1  1 : ( 1 << (countsOf0 -1 ) )
		 * - ) -------------------------------------
		 * 1  0  0  1  1  1 [0] 1  1  1  0  0  0  0
		 */
		
		 /**special cases that we don't handle
		  * 
		  * special case 1:
		  * 0  0  0  0  0  0  0  0  0  0  0  0  0  0
		  * 
		  * special case 2
		  * 0  0  0  0  0  0  0  0  0  0  0  1  1  1
		  */
		
		//PURPOSE: before go step1, collects countsOf 0 & 1 first, which constitutes pivot bit index
		int countOf0 = 0;
		int countOf1 = 0;
		int tempNumber = number;
		
		while( ( tempNumber & ONE ) == ONE) {
			countOf1 ++;
			tempNumber >>= 1;
		}
		
		
		while( tempNumber > 0 && ( tempNumber & ONE ) == ZERO ) {
			countOf0 ++;
			tempNumber >>= 1;
		}
		
		
		//DETAIL: special case 1 & 2 falls into this
		if( tempNumber == 0 ) {
			return -1;
		}
		
		
		
		/**
		 * ----------------------------------------------
		 * arithmetic operation: 
		 * 
		 * 1  0  0  1  1  1  1  0  0  0  0  0  1  1
		 *                                     1  1 : (1 << countsOf1 ) -1 
		 * - ) -------------------------------------  
		 * 1  0  0  1  1  1  1  0  0  0  0  0  0  0
		 *                                        1 : 1
		 * - ) -------------------------------------                              
		 * 1  0  0  1  1  1 [0] 1  1  1  1  1  1  1
		 *                               1  1  1  1 : ( 1 << (countsOf0 -1 ) ) -1 //so many 1, so confusing
		 * - ) -------------------------------------
		 * 1  0  0  1  1  1 [0] 1  1  1  0  0  0  0
		 */
		return number 
			- ( (1 << countOf1 ) -1  )
			-( 1 )
			-( ( 1 << (countOf0 -1 ) ) -1 );
	}
	
}


