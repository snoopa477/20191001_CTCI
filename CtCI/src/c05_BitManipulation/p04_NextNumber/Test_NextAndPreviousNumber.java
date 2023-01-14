package c05_BitManipulation.p04_NextNumber;
import static java.lang.System.out;

public class Test_NextAndPreviousNumber {

	public static void main(String[] args) {
		
		
		int[] numbers = {
				0,
				Integer.MAX_VALUE,
				0b11011001111100,
				0b10011110000011,
				
				0b111,
				
				0b10111,
				0b100111,
				
				0b11110011,
				
				0b111011100,
				0b110011100,
				
				0b11011101111
			};
		
		/*
		 ---------NextNumber_01
		0= 0 next: -1= 11111111111111111111111111111111
		2147483647= 1111111111111111111111111111111 next: -1= 11111111111111111111111111111111
		13948= 11011001111100 next: 13967= 11011010001111
		10115= 10011110000011 next: 10117= 10011110000101
		7= 111 next: 11= 1011
		23= 10111 next: 27= 11011
		39= 100111 next: 43= 101011
		243= 11110011 next: 245= 11110101
		476= 111011100 next: 483= 111100011
		412= 110011100 next: 419= 110100011
		1775= 11011101111 next: 1783= 11011110111
		 * */
		
		out.println("---------NextNumber_01");
		NextNumber_01.IS_DEBUG = false;
		for( int number: numbers ) {
			int result = NextNumber_01.nextNumberSameBits(number);
			out.println(number + "= "+ Integer.toBinaryString(number) 
				+ " next: " + result
				+ "= " + Integer.toBinaryString(result));
		}
		
		
		/**
		 ---------PreviousNumber_01
		0= 0 next: -1= 11111111111111111111111111111111
		2147483647= 1111111111111111111111111111111 next: -1= 11111111111111111111111111111111
		13948= 11011001111100 next: 13946= 11011001111010
		10115= 10011110000011 next: 10096= 10011101110000
		7= 111 next: -1= 11111111111111111111111111111111
		23= 10111 next: 15= 1111
		39= 100111 next: 30= 11110
		243= 11110011 next: 238= 11101110
		476= 111011100 next: 474= 111011010
		412= 110011100 next: 410= 110011010
		1775= 11011101111 next: 1759= 11011011111 
		 */
		out.println("\n---------PreviousNumber_01");
		NextNumber_01.IS_DEBUG = false;
		for( int number: numbers ) {
			int result = PreviousNumber_01.previousNumberSameBits(number);
			out.println(number + "= "+ Integer.toBinaryString(number) 
				+ " next: " + result
				+ "= " + Integer.toBinaryString(result));
		}
		
		
		out.println("\n---------NextNumber_02_arithmetic");
		NextNumber_01.IS_DEBUG = false;
		for( int number: numbers ) {
			int result = NextNumber_02_arithmetic.nextNumberSameBits(number);
			out.println(number + "= "+ Integer.toBinaryString(number) 
				+ " next: " + result
				+ "= " + Integer.toBinaryString(result));
		}
		
		
		out.println("\n---------PreviousNumber_02_arithmetic");
		NextNumber_01.IS_DEBUG = false;
		for( int number: numbers ) {
			int result = PreviousNumber_02_arithmetic.previousNumberSameBits(number);
			out.println(number + "= "+ Integer.toBinaryString(number) 
				+ " next: " + result
				+ "= " + Integer.toBinaryString(result));
		}
		
	}

}


