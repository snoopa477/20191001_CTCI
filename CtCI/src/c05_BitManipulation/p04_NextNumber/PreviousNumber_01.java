package c05_BitManipulation.p04_NextNumber;
import static java.lang.System.out;
public class PreviousNumber_01 {
	
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
		 * step1: flip the pivot bit from 1 to 0 ( so it becomes smaller than original number in minimum scale
		 * step2: move bunch of bits, which is right from pivot bit, left to right of 
		 * 	pivot bit( under the premise it's smaller, it becomes as large as possible 
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
		
		int pivotIndex = countOf0 + countOf1;
		int previousNumber = 0;
		
		//set pivot index as 0
		previousNumber = number & ~(1 << pivotIndex); 
		//clear bits
		previousNumber &= reverseMaskcountOf0And1( countOf0, countOf1 );
		//move bunch of bits right to pivot bit
		previousNumber |= bunchOfBitsRightBeforePivotBit( countOf0, countOf1 );
		
		return previousNumber;
	}
	
	
	
	private static int reverseMaskcountOf0And1( int countOf0, int countOf1 ) {
		
		/*
		 	1  0  0  1  1  1  1  0  0  0  0  0  1  1 
		 	                                       0 -  0
		 	1  1  1  1  1  1  1  1  1  1  1  1  1  1 -  ~0
		 	1  1  1  1  1  1  1  0  0  0  0  0  0  0 -  ( ~0 ) << ( countOf0 + countOf1 )
		 	
		 */
		return ( ~0 ) << ( countOf0 + countOf1 );
	}
	
	
	
	private static int bunchOfBitsRightBeforePivotBit( int countOf0, int countOf1 ) {
		
		/*
		 	1  0  0  1  1  1 [1] 0  0  0  0  0  1  1 
		 	1  0  0  1  1  1 [0] 0  0  0  0  0  1  1
		 	
		 	0  0  0  0  0  0  0  0  0  0  1  0  0  0 - 1 << ( countOf1 + 1 )
		 	0  0  0  0  0  0  0  0  0  0  0  1  1  1 - ( 1 << ( countOf1 + 1 )) - 1
		 	0  0  0  0  0  0  0  1  1  1  0  0  0  0 - ( ( 1 << ( countOf1 + 1 )) - 1 ) << ( countOf0 -1 )
	 	
		 */
		//DETAIL: every ONE serves different purposes and meanings
		return ( ( 1 << ( countOf1 + 1 )) - 1 ) << ( countOf0 -1 );
	}
	
}








