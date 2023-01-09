package c05_BitManipulation.p03_FlipBitToWin;
import static java.lang.System.out;

import java.util.ArrayList;
public class FlipBitToWin_02_ProcessAndForget {

public static boolean IS_DEBUG = false;
	
	private static final int ONE = 1;
	private static final int ZERO = 0;
	private static final int TWO = 2;
	private static final int INTEGER_SIZE = Integer.BYTES * 8;

	
	public static int longestSequence(int number ) {
		
		
		int currentCounterOf1s = 0;
		int previousCounterOf1s = 0;
		int result = Integer.MIN_VALUE;
		
		/* PURPOSE: whenever we encounter clear bit, calculate the current result, and prepare for the next loop
		 * */
		while( number > 0 ) {
			
			 
			if( (number & ONE ) == ONE ) {
				currentCounterOf1s++;
			}
			// (number & ONE ) == ZERO
			else {
				
				//PURPOSE: calculate the current result
				
				//REASONING: the reason I comment this is two different logic shares same operation, that's confusing
				//result = Math.max(currentCounterOf1s + ONE + previousCounterOf1s,result);
				
				/*  DETAIL: the arrangement matters to me
				 *  c: current bit
				 *  []: bit to flip
				 *  <>: currentCounterOf1s
				 *  {}: previousCounterOf1s
				 *  
				 * previousCounterOf1s == ZERO 
				 *  c
				 * [0]<1  1  1>
				 * [1]<1  1  1> - 0 flipped to 1  
				 * 
				 *  c
				 * [0]<1  1  1> 0  0  0
				 * [1]<1  1  1> 0  0  0 - 0 flipped to 1
				 * 
				 * 
				 * previousCounterOf1s > ZERO
				 *  c
				 *  0 <1  1>[0]{1  1  1} 
				 *  0 <1  1>[1]{1  1  1} - 0 flipped to 1
				 *  
				 *  Note that the flipped bit is not the current bit
				 *  
				 */
				if( previousCounterOf1s == ZERO ) {
					result = Math.max(
							ONE /*0 flipped to 1*/ + currentCounterOf1s + previousCounterOf1s,result);
				}
				//previousCounterOf1s > ZERO
				else {
					result = Math.max(
							currentCounterOf1s + ONE + previousCounterOf1s,result);
				}
				
				
				//PURPOSE: prepare for the next loop
				/**
				 * REASONING:  
				 * if there's only one clear bit between 1s, which is ( number & 0b10 ) != ZERO
				 * then we can reuse  currentCounterOf1s as new previousCounterOf1s;
				 * 
				 * if there are more than one clear bit between 1s 
				 * , namely, at least two clear bits, which is number & 0b10 == ZERO, 
				 * we can reuse nothing
				 * 
				 * 
				 * ( number & 0b10 ) != ZERO
				 *  p  c
				 *  1  0 <1  1>[0]{1  1  1}
				 *  1 [0]{1  1} 0  1  1  1  - next loop status 
				 * 
				 * 
				 * number & 0b10 == ZERO
				 *  p  c
				 *  0  0 <1  1>[0]{1  1  1}
				 *  0 [0] 1  1  0  1  1  1 
				 *  
				 */
				//prepare for next loop
				if( ( number & 0b10 ) != ZERO ) {
					//reuse
					previousCounterOf1s = currentCounterOf1s;
					currentCounterOf1s = 0;
				}
				// number & 0b10 == ZERO
				else {
					previousCounterOf1s = 0;
					currentCounterOf1s = 0;
				}
			}
			
			
			/* WRONG: I forget to add this line
			 * reaching here meaning 0 is encountered as well
			 * 
			 * e.g. 
			 * 0 1 1 1 would wrong if I don't add this line
			 */
			result = Math.max(
					ONE /*0 flipped to 1*/ + currentCounterOf1s + previousCounterOf1s,result);
			
			number >>>= 1;
		}
		
		return result;
	}
	
	
}


