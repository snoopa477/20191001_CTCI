package c05_BitManipulation.p07_PairwiseSwap;
import static java.lang.System.out;

import util.BitPrinter;
public class Test_PairwiseSwap {

	
	public static void main(String[] args) {
	
		int numbers[] = {
			0b10101010,
			0b1,
			0b1101010010,
			0};
		
		for( int number : numbers ) {
			out.println("\n---------------");
			out.println(BitPrinter.toBitStringWithHeader(number));
			out.println("after conversion");
			out.println(BitPrinter.toBitStringWithHeader(
				PairwiseSwap_01_DouebleFences.swapOddEvenBits(number) ));
			
		}
	
	}
	
}


