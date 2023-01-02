package c05_BitManipulation.p02_BinaryToString;
import static java.lang.System.out;
public class BinaryToString_02_MovingComparator {
	
	
	public static String toString( double number ) {
		
		StringBuilder sb = new StringBuilder(".");
		
		
		/**
		 * REASONING: given a comparator bit at index -i; to make number to be IDENTIFIABLE
		 * by comparing it with comparator, the number's index, which is > -i, 's value has to set ZERO
		 * , so the adjusted number < 2^(-i+1) 
		 * 
		 * identifiable:
		 * when number has comparator bit at index -1, it is larger than or equal to the comparator bit
		 * else, it is smaller
		 
		 * e.g. identifiable
		 * 
		 * 0.[0] 0  1  1
		 * 0. 0  1
		 * <, has no such bit
		 * 
		 * 0.[0] 1  1  1
		 * 0. 0  1
		 * >=, has such bit
		 * 
		 * counter e.g. non-identifiable
		 * 
		 * 0.[1] 0  1  1
		 * 0. 0  1
		 * >=, has no such bit
		 * 
		 * 0.[1] 1  1  1
		 * 0. 0  1
		 * >=, has such bit
		 * 
		 * 
		 * EXAMPLE
		 * 
		 * 0. 1  0  1  1	(number	
		 * 0. 1				(comparator
		 * >=, has such bit, result: .1
		 * 0.[0] 0  1  1	(adjust number, is smaller than 0. 1
		 * 
		 * - - - -
		 * 0. 0  0  1  1	(number	
		 * 0. 0	 1			(comparator
		 * <, no such bit, result: .1  0
		 * 0. 0  0  1  1	(adjust number
		 * 
		 * - - - -
		 * 0. 0  0  1  1	(number	
		 * 0. 0	 0  1		(comparator
		 * >=, has such bit, result: .1  0  1 
		 * 0. 0  0 [0] 1	(adjust number
		 * 
		 */
		
		double currentNumber = number;
		//IMAGINATION: 0.1 in bit, 0.01, 0.001, 0.0001... we call it moving comparator 
		double comparator = 0.5;
		while( currentNumber > 0 ) {
			
			if( currentNumber >= comparator ) {
				sb.append(1);
				currentNumber -= comparator;
			}
			else {
				sb.append(0);
			}
			
			//PURPOSE: prepare for the next loop
			//comparator move right by 1 bit
			comparator /= 2;
			
		}
		
		
		return sb.toString();
	}

}


