package c10_SortingAndSearching.p07_MissingInt.testByte;
import static java.lang.System.out;
public class Test_Parse {

	public static void main(String[] args) {
		/*
		  	 parseInt("0", 10) returns 0
			 parseInt("473", 10) returns 473
			 parseInt("+42", 10) returns 42
			 parseInt("-0", 10) returns 0
			 parseInt("-FF", 16) returns -255
			 parseInt("1100110", 2) returns 102
			 parseInt("2147483647", 10) returns 2147483647
			 parseInt("-2147483648", 10) returns -2147483648
			 parseInt("2147483648", 10) throws a NumberFormatException
			 parseInt("99", 8) throws a NumberFormatException
			 parseInt("Kona", 10) throws a NumberFormatException
			 parseInt("Kona", 27) returns 411787
		 * 
		 * */
		String str1 = "101101";
		out.println( "str1 " + str1 + " Integer.parseInt(str1, 2) " + Integer.parseInt(str1, 2) );
		
		str1 = "FE1ABD7";
		out.println( "str1 " + str1 + " Integer.parseInt(str1, 16) " + Integer.parseInt(str1, 16) );
		
		out.println( "Integer.toBinaryString(45) " + Integer.toBinaryString(45) );
		out.println( "Integer.toOctalString(45) " + Integer.toOctalString(45) );
		out.println( "Integer.toHexString(45) " + Integer.toHexString(45) );
		
		int binary_45 = 0b101101;
		int hex_45 = 0x2D;
		int octal_45 = 055;
		
		out.println("binary_45 " + binary_45);
		out.println("hex_45 " + hex_45);
		out.println("octal_45 " + octal_45);
		
		
		
		
	}

}


