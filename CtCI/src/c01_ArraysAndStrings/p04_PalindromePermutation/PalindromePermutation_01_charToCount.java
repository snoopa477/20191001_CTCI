package c01_ArraysAndStrings.p04_PalindromePermutation;
import static java.lang.System.out;
public class PalindromePermutation_01_charToCount {
	
	
	private static final int LENGTH = 1 << 7;
	
	public static boolean isPermutationOfPalindrome(String phrase) {
		
		/**
		 * Since the keys are continuous ( a-zA-Z), we have three 3 options
		 * 1 array of integers -OK
		 * 2 bitVector ( however, it can only store two state) - CAN'T DO
		 * 3 HashMap, for any kind of keys- OK, but not the best
		 */
		int[] charToCount = makeCharToCount( phrase );
		
		/**
		 * REASONING:
		 * if this is permutation of palindrome, 
		 * 	if length is even:
		 *  	number of char that has odd count is 0
		 *  if length is odd:
		 *  	number of char that has odd count is 1
		 * 
		 * its number of char that has odd count is <= 1
		 */
		
		int numberOfOddCount = 0;
		for( int i = 0; i < LENGTH; i++ ) {
			
			int count = charToCount[i];
			//if odd
			if( count % 2 == 1 ) {
				numberOfOddCount++;
			}
			
			//cut-off
			if( numberOfOddCount > 1 ) {
				return false;
			}
		}
		
		//for any numberOfOddCount that > 1, false
		//for all numberOfOddCount that <=1, true
		
		//Reaching here meaning numberOfOddCount <= 1
		return true;
	}

	
	
	private static int[] makeCharToCount(String phrase) {
		
		/**
		 * 0: 0x30: 48, max index 48 + 9 = 57
		 * A: 0x40: 64, max index 64 + 26 = 90
		 * a: 0x60: 96, max index 96 + 26 = 122 
		 */
		//128 > 122
		int[] charToCount = new int[ LENGTH ];
		
		for( char c : phrase.toCharArray() ) {
			
			int ascii_c = c;
			charToCount[ ascii_c ]++;
		}
		return charToCount;
	}

}


