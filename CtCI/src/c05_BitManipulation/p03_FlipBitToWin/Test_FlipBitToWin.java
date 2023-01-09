package c05_BitManipulation.p03_FlipBitToWin;
import static java.lang.System.out;
public class Test_FlipBitToWin {

	public static void main(String[] args) {
		
		int[] numbers = {
			0b111,
			
			0b10111,
			0b100111,
			
			0b11110011,
			
			0b111011100,
			0b110011100,
			
			0b11011101111
		};
		
		/*
		7 111 4
		23 10111 5
		39 100111 4
		243 11110011 5
		476 111011100 7
		412 110011100 4
		1775 11011101111 8
		 * */
		FlipBitToWin_01_Counting0And1.IS_DEBUG = false;
		out.println("---------FlipBitToWin_01_Counting0And1");
		for( int number: numbers ) {
			out.println(number + " "+ Integer.toBinaryString(number) + " " + FlipBitToWin_01_Counting0And1.longestSequence(number));
		}
		
		
		out.println("\n\n---------FlipBitToWin_02_ProcessAndForget");
		for( int number: numbers ) {
			out.println(number + " "+ Integer.toBinaryString(number) + " " + FlipBitToWin_02_ProcessAndForget.longestSequence(number));
		}
		
	}

}


