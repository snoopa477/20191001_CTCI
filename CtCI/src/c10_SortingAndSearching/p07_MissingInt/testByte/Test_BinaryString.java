package c10_SortingAndSearching.p07_MissingInt.testByte;
import static java.lang.System.out;
public class Test_BinaryString {

	public static void main(String[] args) {
		
		String[] str_bits = {"1010011", "1001", "101"};
		
		for( String str_bit :str_bits ) {
			int number = Integer.parseInt( str_bit , 2);
			String str_number = Integer.toBinaryString(number);
			out.println("original str: " + str_bit + "; number: " +number + "; str_number: " + str_number);
			out.println("original str: " + str_bit + "; number: " +number 
					+ "; str_number: " + String.format("%8s", str_number)) ;
			
			out.println("original str: " + str_bit + "; number: " +number 
					+ "; str_number: " + String.format("%8s", str_number).replace(' ', '0') ) ;
			
			out.println();
		}
		
		
	}

}


