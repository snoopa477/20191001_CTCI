package c01_ArraysAndStrings.p02_CheckPermutatoin;
import static java.lang.System.out;
public class CheckPermutation_02_Map {
	
	public static boolean checkPermutation(String s1, String s2) {
		
		/* REASONING:
		 * string s1 and s2 have the same permutation if
		 * must suffice the following:
		 * 1. the both have same length
		 * 2. charToCount are the same
		 * 
		 * condition 2 itself implies same permutation
		 * condition 1 itself cannot implies same permutation
		 * However, we use condition 1 to rule out the impossible case,
		 * because to prove condition 2 require complicated computation 
		 */
		
		if( s1.length() != s2.length() ) {
			return false;
		}
		
		//REASONING: reaching here meaning s1. length == s2.length
		
		//make charToCount of s1
		/*DETAIL: 0x30 = 48, start of number 0; 0x40 = 64, start of capital alphabet; 0x60 = 96, start of small case alphabet. 96 + 26 = 122 < 2^7 = 128
		 * Three of them are smaller than 2^7 = 128
		 */
		int upperBound = 1 << 7; 
		int[] charIdxToCount = new int[upperBound];
		
		for( int i = 0; i < s1.length(); i++ ) {
			char currChar = s1.charAt( i );
			charIdxToCount[ currChar ] ++; 
		}
		
		
		/* REASONING: 
		 * s1 and s2 have the same permutation if and only if
		 * 1. same length
		 * 2. for every i charIdxToCount, none of charIdxToCount[ i ] < 0 after subtraction from s2
		 * how to prove that? 
		 */
		
		for( int i = 0 ; i < s2.length(); i++ ) {
			char currChar = s2.charAt( i );
			
			charIdxToCount[ currChar ]--;
			if( charIdxToCount[ currChar ] < 0 ) {
				return false;
			}
			
		}
		return true;
	}

}


