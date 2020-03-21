package c10_SortingAndSearching.p08_FindDuplicates._02_operationInBits;

import static java.lang.System.out;

public class TestDivideAndModInBit {

	public static void main(String[] args) {
		
		{
			out.println("------------------------getExponentOfTwo");
			int[] inputs = { 0, 1, 2, 4, 8, 16, 25, 67 };
			for( int num :  inputs) {
				out.println( num + "'s exponent is " 
						+ DivideAndModInBit.getExponentOfTwo(num) );
			}
		}
		
		{
			out.println("------------------------Quotient and Remainder");
			int divisor = 8;
			for(int i = 0; i < 20; i++) {
				
				out.println(i + " = " + divisor  + " * " + 
				DivideAndModInBit.getQuotient(i, divisor)
				+ " + " 
				+  DivideAndModInBit.getRemainder(i, divisor));
			}
		}
		
		{
			out.println("------------------------isPowerOfTwo");
			
			for(int i = 0; i < 20; i++) {
			
				if( DivideAndModInBit.isPowerOfTwo(i) ) {
					out.println(i + " is power of 2");
				}
			}
		}
		
	}
	

}
