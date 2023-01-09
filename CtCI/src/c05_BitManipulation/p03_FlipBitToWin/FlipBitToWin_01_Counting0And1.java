package c05_BitManipulation.p03_FlipBitToWin;
import static java.lang.System.out;

import java.util.*;



public class FlipBitToWin_01_Counting0And1 {
	
	public static boolean IS_DEBUG = false;
	
	private static final int ONE = 1;
	private static final int ZERO = 0;
	private static final int TWO = 2;
	private static final int INTEGER_SIZE = Integer.BYTES * 8;

	
	public static int longestSequence(int number ) {
		
		ArrayList<Integer> alternatingCounts = getAlternatingCounts( number );
		
		return longestSequenceHelper( alternatingCounts );
	}
	
	
	
	/*
	 * e.g. 
	 * 0111 1001 0111
	 * 1      2  1    0 -counts of 0
	 *      4  1    3   -counts of 
	 * 
	 * is stored as [0, 3, 1, 1, 2, 4, 1, 0]
	 * odd index for counts of 0
	 * even index for counts of 1
	 * 
	 */
	private static ArrayList<Integer> getAlternatingCounts( int number ){
		
		
		ArrayList<Integer> alternativeCounts = new ArrayList<>();
		
		int numberOfBits = 0;
		
		//only consider bit at index 0, each iteration move right whole number by one bit
		int targetBit = ZERO;
		//could either store number of 1 or 0
		int counter = 0;
		while( number > 0 ) {
			
			if( (number & ONE ) == targetBit ) {
				counter++;
			}
			else {
				//sum up and store the result
				alternativeCounts.add(counter);
				
				//prepare for the alternative bit
				counter = 0;
				
				//change to alternative bit
				targetBit = targetBit == ZERO ? ONE : ZERO;
				counter++;
			}
			
			numberOfBits++;
			
			number >>>= 1; 
		}
		
		//reaching here, there's a chance that the counter hasn't store to result yet, do it
		if( counter != 0 ) {
			alternativeCounts.add( counter );
		}
		
		//TRICKY 
		/*
		 * e.g. 
		 * 0000 00011 |
		 * 0000 000 | 11
		 * 
		 * we have to record the remaining 0
		 */
		alternativeCounts.add( INTEGER_SIZE - numberOfBits );
		
		
		if( IS_DEBUG ) {
			out.println("getAlternatingCounts");
			out.println(alternativeCounts);
		}
		
		return alternativeCounts;
	}
	
	
	
	private static int longestSequenceHelper( ArrayList<Integer> alternativeCounts ) {
		
		int result = Integer.MIN_VALUE;
		
		//iterating bit that has number of 0 bits => iterate even index
		for( int i = ZERO; i < alternativeCounts.size(); i += TWO ) {
			
			int numberOf0 = alternativeCounts.get( i );
			
			int left = i + 1;
			int right = i - 1;
			
			int left_numberOf1 = left < alternativeCounts.size()? //left bound 
				alternativeCounts.get( left ): ZERO;
				
			int right_numberOf1 = right >= ZERO ? //right bound
				alternativeCounts.get( right ): ZERO;
			
				
			/* e.g. 
			 * numberOf1 1 
			 * 111  0  111
			 * 111 [1] 111
			 * 
			 * numberOf1 0
			 * 111  x
			 * nothing can be flipped
			 * 
			 * numberOf1 > 1
			 * 1111  0 0  111
			 * 1111 [1]0  111
			 * 1111  0[1] 111
			 **/
			if( numberOf0 == ZERO ) {
				result = Math.max( left_numberOf1 + ZERO, result );
			}
			else if ( numberOf0 == 1 ) {
				result = Math.max( left_numberOf1 + ONE + right_numberOf1, result );
			}
			// numberOf 0 > 1
			else {
				result = Math.max( left_numberOf1 + ONE , result );
				result = Math.max( ONE + right_numberOf1, result );
			}
			
		}
		
		
		return result;
	}
	
	
}


