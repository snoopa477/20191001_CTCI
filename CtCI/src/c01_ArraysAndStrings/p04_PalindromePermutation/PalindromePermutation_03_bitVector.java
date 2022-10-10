package c01_ArraysAndStrings.p04_PalindromePermutation;
import static java.lang.System.out;
public class PalindromePermutation_03_bitVector {

	private static final int INTEGER_LENGTH = 32 ;
	private static boolean IS_DEBUG_ON = false;
	
	
	public static boolean isPermutationOfPalindrome(String phrase) {
		
		int[] bitToOddNumExistence = getBitToOddNumExistence( phrase );
		
		//PURPOSE: if is permutation of palindrome, number of odd count is <= 1, which means removing least significant bit is 0
		/**
		 * REASONING: if there's only one single bit
		 * then removing the least significant bit would be 0
		 * 
		 * if there's none single bit
		 * then removing then removing the least significant bit would be 0
		 */
		// if there's only one bucket: bitVector & ( bitVector -1 )
		
		int result = 0;
		for( int bitVector : bitToOddNumExistence ) {
			if( IS_DEBUG_ON ) {
				out.printf("%s\n", Integer.toBinaryString(bitVector));
			}
			
			result += bitVector & ( bitVector -1 );
		}
		
		return result == 0;
	}
	
	
	
	private static  int[] getBitToOddNumExistence( String phrase ) {
		//int[] bitToWhetherOddCountOrNot
		//DETAIL: natural limitation: it only has 32 bits, so it's necessary to adjust the
		//ascii mapping for 'a': 0, 'A': 0
		
		int[] bitToOddNumExistence = new int[3]; 
		
		for( char c : phrase.toCharArray() ) {
			int ascii_c = c;
			int bitIndex = asciiToBitIndex( ascii_c );
			toggle( bitToOddNumExistence, bitIndex );
		}
		
		return bitToOddNumExistence;
	}
	
	
	
	/* 
	 * '0' for first bucket
	 * 'A' for second bucket
	 * 'a' for third bucket
	 */
	//THINK_FURHTER: the mapping method should be independent from toggle, which should know nothing about this method
	private static int asciiToBitIndex( int ascii_c ) {
		
		if( '0' <= ascii_c && ascii_c <= '9' ) {
			if( IS_DEBUG_ON) out.printf("%c, %d\n", ascii_c,  ascii_c - (int)'0' + INTEGER_LENGTH * 0);
			return ascii_c - (int)'0' + INTEGER_LENGTH * 0; 
		}
		
		if( 'A' <= ascii_c && ascii_c <= 'Z' ) {
			if( IS_DEBUG_ON) out.printf("%c, %d\n", ascii_c,  ascii_c - (int)'A' + 1 + INTEGER_LENGTH * 1);
			return ascii_c - (int)'A' + 1 + INTEGER_LENGTH * 1;
		}
		
		//WRONG: Typo
		//if( 'a' <= ascii_c && ascii_c <= 'a' ) {
		if( 'a' <= ascii_c && ascii_c <= 'z' ) {
			if( IS_DEBUG_ON) out.printf("%c, %d\n", ascii_c,  ascii_c - (int)'a' + 1 + INTEGER_LENGTH * 2);
			return ascii_c - (int)'a' + 1 + INTEGER_LENGTH * 2;
		}
		
		return -1;
	}


	
	//toggle: switch to 1 if odd count; switch to 0 of even count
	private static void toggle(int[] bitToOddNumExistence, int bitIndex) {
		
		/** CORRECTION
		 *Java Operator Precedence
			Operators	Precedence
			postfix increment and decrement	++ --
			prefix increment and decrement, and unary	++ -- + - ~ !
			multiplicative	* / %
			additive	+ -
			shift	<< >> >>> 
		 */
		
		//get: and 1
		/**
		 * 0 0 0 0 1 0 0 0 - 1 << i
		 * x1x2x3x4xix2x1x0 - bitToOddNumExistence
		 * -----------------------------------------and
		 * 0 0 0 0xi 0 0 0 - result
		 */
		//boolean hasBitSet = ( bitToOddNumExistence & ( 1 << bitIndex ) ) > 0;
		//WROGN: boolean hasBitSet = ( bitToOddNumExistence[ bitIndex / INTEGER_LENGTH ] & ( 1 << bitIndex % INTEGER_LENGTH ) ) > 0;
		boolean hasBitSet = ( bitToOddNumExistence[ bitIndex / INTEGER_LENGTH ] & ( 1 << (bitIndex % INTEGER_LENGTH) ) ) > 0;
		
		if( hasBitSet ) {
			//set: clear bit: and 0
			/**
			 * 1 1 0 1 1 - ~( 1 << i )
			 * x1x2xix1x0 - bitToOddNumExistence
			 * --------------------- and
			 * x1x20 x1x0 
			 */
			//bitToOddNumExistence = bitToOddNumExistence & ~( 1 << bitIndex ) ;
			//bitToOddNumExistence[ bitIndex / INTEGER_LENGTH ] &= ~( 1 << bitIndex % INTEGER_LENGTH  ) ;
			bitToOddNumExistence[ bitIndex / INTEGER_LENGTH ] &= ~( 1 << (bitIndex % INTEGER_LENGTH)  ) ;
		}
		else {
			//set: set bit: or 1 
			/**
			 * 0 0 1 0 0 - ( 1 << i )
			 * x1x2xix1x0 - bitToOddNumExistence
			 * --------------------- or
			 * x1x21 x1x0
			 */
			//bitToOddNumExistence = bitToOddNumExistence | ( 1 << bitIndex ) ;
			bitToOddNumExistence[ bitIndex / INTEGER_LENGTH ] |= ( 1 << (bitIndex % INTEGER_LENGTH)  ) ;
		}
	}
	
}





