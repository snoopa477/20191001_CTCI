package c01_ArraysAndStrings.p04_PalindromePermutation;
import static java.lang.System.out;
public class Test_isPermutationOfPalindrome {

	public static void main(String[] args) {
		
		String[] inputs = {
				"Evanescence",
				"EvanescenceEvanescence", //perm of palindrome
				"EanesEencevanesccneecv", //perm of palindrome
				"aaabbb",
				"ababab"
		};
		
		out.println("\n\n--------------PalindromePermutation_01_charToCount");
		for( String input: inputs ) {
			out.printf("'%s' is perm of palindrome? %s\n",
					input,
					PalindromePermutation_01_charToCount.isPermutationOfPalindrome(input) );
		}
		
		out.println("\n\n--------------PalindromePermutation_02_charToCountOneIteration");
		for( String input: inputs ) {
			out.printf("'%s' is perm of palindrome? %s\n",
					input,
					PalindromePermutation_02_charToCountOneIteration.isPermutationOfPalindrome(input) );
		}
		
		out.println("\n\n--------------PalindromePermutation_03_bitVector");
		for( String input: inputs ) {
			out.printf("'%s' is perm of palindrome? %s\n",
					input,
					PalindromePermutation_03_bitVector.isPermutationOfPalindrome(input) );
		}
		
		
	}

}


