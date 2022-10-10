package c01_ArraysAndStrings.p04_PalindromePermutation;
import static java.lang.System.out;
public class PalindromePermutation_02_charToCountOneIteration {
	
	private static final int LENGTH = 1 << 7;
	
	public static boolean isPermutationOfPalindrome(String phrase) {
		return isPermutationOfPalindromeHelper(phrase);
	}

	
	
	private static boolean isPermutationOfPalindromeHelper(String phrase) {
		
		/**
		 * PURPOSE: do two things at the same time( in one iteration)
		 * 1 make char to count
		 * 2 count the char that has odd count
		 */
		
		int numberOfOddCounts = 0;
		int[] charToCount = new int[ LENGTH ];
		for( char c : phrase.toCharArray() ) {
			int ascii_c = c;
			charToCount[ ascii_c ]++;
			
			//odd
			if( charToCount[ ascii_c ] % 2 == 1 ) {
				numberOfOddCounts++;
			}
			else {
				numberOfOddCounts--;
			}
		}
		
		
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
		return numberOfOddCounts <= 1;
	}


}


