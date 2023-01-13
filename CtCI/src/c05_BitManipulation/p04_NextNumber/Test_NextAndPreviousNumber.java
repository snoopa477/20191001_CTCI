package c05_BitManipulation.p04_NextNumber;
import static java.lang.System.out;

import c05_BitManipulation.p03_FlipBitToWin.FlipBitToWin_01_Counting0And1;
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
		
	}

}


