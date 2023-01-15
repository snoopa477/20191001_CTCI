package c05_BitManipulation.p06_Conversion;
import static java.lang.System.out;
public class Test_Conversion {

	public static void main(String[] args) {
		
		int[] a = {
			0b1110101101,
			0b11101
		};
		
		int[] b = {
			0b0111100101,
			0b01111
		};
		
		
		out.println("\n--------------Conversion_01_cuttingBoard");
		for( int i = 0; i < a.length; i++ ) {
			out.println("a: " + a[i] + "; b: " + b[i] 
				+ " ; bits to swap to another number: " + Conversion_01_cuttingBoard.bitSwapRequired(a[i], b[i]));
		}
		
		
		out.println("\n--------------Conversion_02_removalOfLeastSignificantSetBit");
		for( int i = 0; i < a.length; i++ ) {
			out.println("a: " + a[i] + "; b: " + b[i] 
				+ " ; bits to swap to another number: " + Conversion_02_removalOfLeastSignificantSetBit.bitSwapRequired(a[i], b[i]));
		}
		
	}

}


