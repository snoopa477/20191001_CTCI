package c08_RecursionDynamicProgramming._0805_RecursiveMultiply;
//import static java.lang.System.out;

import java.util.Arrays;
public class My_RecursiveMultiply_03_DP {
public static int multiply(int a, int b) {
		
		int smallerSide = a < b? a : b;
		int biggerSide = a < b? b : a;
		int[] smallerSide_To_Multiplication = new int[smallerSide + 1];
		Arrays.fill(smallerSide_To_Multiplication, -1);
		
		return multiply(smallerSide, biggerSide, smallerSide_To_Multiplication);
		
	}
	
	private static int multiply(int a, int b, int[] smallerSide_To_Multiplication) {
		
		//base cases
		if( a == 0 || b ==0 ) {
			return 0;
		}
		
		//base cases
		if( a == 1 ) {
			return b;
		}
		
		//base cases
		if( b == 1 ) {
			return a;
		}
		
		int smallerSide = a < b? a : b;
		int biggerSide = a < b? b : a;
		
		//DP part
		if( smallerSide_To_Multiplication[smallerSide] != -1) {
			return smallerSide_To_Multiplication[smallerSide];
		}
		
		int result = multiply( smallerSide >> 1, biggerSide, smallerSide_To_Multiplication) 
				+ multiply( smallerSide >> 1, biggerSide, smallerSide_To_Multiplication)
				+ (isEven(smallerSide)? 0 : biggerSide);
		/*
		if( isEven(smallerSide) ) {
			result =  multiply( smallerSide / 2, biggerSide, smallerSide_To_Multiplication) 
					+ multiply( smallerSide / 2, biggerSide, smallerSide_To_Multiplication);
		}
		else {
			result =  multiply( smallerSide / 2, biggerSide, smallerSide_To_Multiplication) 
					+ multiply( smallerSide / 2, biggerSide, smallerSide_To_Multiplication)
					+ biggerSide;
		}
		*/
		
		smallerSide_To_Multiplication[smallerSide] = result;
		
		return result;
	}
	
	private static boolean isEven(int a ) {
		return a%2 == 0;
	}
}


