package c05_BitManipulation.p02_BinaryToString;
import static java.lang.System.out;
public class Test_BinaryToString {

	public static void main(String[] args) {
		
		double[] numbers = { 0.5, 0.25, 0.125, 0.625, 0.7, 0.9};
		
		_0502_00_BinaryToString bts = new _0502_00_BinaryToString();
		
		out.println("_0502_00_BinaryToString");
		for( double number: numbers ) {
			out.printf("%f, %s\n", number, bts.printBinary(number));
		}
		
		
		
		out.println("\nBinaryToString_01_ShiftToOne");
		for( double number: numbers ) {
			out.printf("%f, %s\n", number, BinaryToString_01_ShiftToOne.toString(number));
		}
		
	}

}


