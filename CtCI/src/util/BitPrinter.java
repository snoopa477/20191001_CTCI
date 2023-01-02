package util;
import static java.lang.System.out;

import java.util.StringJoiner;
public class BitPrinter {

	private static final int INTEGER_LENGTH = 32;
	private static final int TOKEN_LENGTH = 4;
	
	public static String bitString(int number, boolean isReadHelper) {
		
		//Integer.toBinaryString(number);
		/**
		 * x3  x2  x1  x0  -X
		 * 
		 * to get x3:
		 * (X >> 3) %2
		 * 
		 * to get x2:
		 * (X >> 2) %2
		 * 
		 * to get x0:
		 * (x >>  0) %2
		 */
		
		/**
		 *  1  1  1  1 = X = -1
		 *  1  1  1  1 = X >>3 = -1
		 * 
		 *  
		 */
		
		StringJoiner sj = new StringJoiner(" ");
		for( int i = INTEGER_LENGTH -1; i >= 0; i-- ) {
			
			//WRONG if there's leading one, see above example
			//WRONG example result : -1 =>  -1 -1 -1 -1
			//sj.add( String.valueOf( (number >> i)% 2 ) );
			
			//WRONG example result : -1 =>  0 1 1 1
			//sj.add( String.valueOf(  ( number & (1 << i) ) > 0? 1 : 0 )   );
			
			sj.add( String.valueOf(  ( number & (1 << i) ) != 0? 1 : 0 )   );
			
			//31 30 29 28 _ 27 26 25 24 _
			if( i % TOKEN_LENGTH == 0 ) {
				if( isReadHelper == false) {
					sj.add(" ");
				}
				else {
					sj.add(" (" + String.valueOf(i) + ")" );
				}
			}
			
		}
		
		return sj.toString();
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		int[] numbers = { 1, 3, 5, 7, 16, 127, 0b111000111, -1};
		
		for( int number : numbers ) {
			out.println( "number: " + number + ": " + bitString( number, true ) );
		}
		
	}
	
}


