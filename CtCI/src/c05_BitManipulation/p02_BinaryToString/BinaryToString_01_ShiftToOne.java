package c05_BitManipulation.p02_BinaryToString;
import static java.lang.System.out;
public class BinaryToString_01_ShiftToOne {
	
	private static final int ZERO = 0;
	private static final int ONE = 1;
	private static final int TWO = 2;
	
	/*WRONG: and I don't know why.
	 * I guess it gets weird when stringBuffer.append 
	 */
//	private static final double ZERO = 0;
//	private static final double ONE = 1;
//	private static final double TWO = 2;
	
	public static String toString( double number ) {
		
		if( number < ZERO || number > ONE ) {
			return "ERROR";
		}
		
		
		/** EXAMPLE: 
		 * 0. 1  0  1 	(bit (invisible to the program 
		 * 0. 6  2  5 	(digit (visible to the program
		 * 0.			(midResult
		 * 
		 * - - -
		 * 1. 0  1 		(bit 
		 * 1. 2  5  0 	(digit
		 * 0.[1]		(midResult
		 * 
		 * To keep 0, discard one, prepare next loop
		 * 0. 0  1 		(bit
		 * 0. 2  5		(digit
		 * 
		 * - - -
		 * 0. 1			(bit
		 * 0. 5			(digit
		 * 0. 1 [0]		(midResult
		 * 
		 * already 0, no further operation needed
		 * 
		 * - - -
		 * 1. 0			(bit
		 * 1. 0			(digit
		 * 0. 1  0 [1]	(midResult
		 */
		
		/*IMAGINATION: in each iteration, number gets smaller, and string result gets bigger. 
		that's conversion, sum of them is equal to original number
		*/ 
		
		/**
		 * PURPOSE shift left so bits which index are smaller than 0 can move to index 0
		 * 
		 * REASONING 
		 * under the premise among index ranging from 0 to greater than 0, only index 0 can be set
		 * , so the value ranges from 0 to 2(exclusive
		 * to keep this property, we need to -1 when the number ranges from 1 to 2(exclusive 
		 *   
		 */
		StringBuilder result = new StringBuilder();
		while( number > ZERO ) {
			
			if(result.length() > 32 ) {
				return "ERROR. approximation " + result.toString();
			}
			
			number = number * TWO;
			
			//WRONG: I know it should be >= before coding, and forgot the nuances when code. so hard to find out when reviewing
			//if( number > ONE ) {
			if( number >= ONE ) {
				result.append( ONE );
				//one is converted to result, and to keep property, drop one
				number -= ONE;
			}
			//number < ONE
			else {
				result.append( ZERO );
				//already < 1, no further operation needed
			}
		}
		
		return result.toString();
		
	}

}


