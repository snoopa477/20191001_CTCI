package c08_RecursionDynamicProgramming._0805_RecursiveMultiply;

import java.util.Arrays;

//import static java.lang.System.out;
public class My_RecursiveMultiply_03_DP_02 {
	
	public static int multiply(int a, int b) {
		
		//dont forget this line
		int smallSide = a < b ? a : b;
		int[] smallSideToArea = new int[smallSide + 1];
		Arrays.fill(smallSideToArea, -1);
		
		return multiply(a, b, smallSideToArea);
		
	}
	
	
	//backbone
	private static int multiply(int a, int b, int[] smallSideToArea) {
		
		if( a == 0 || b == 0 )
			return 0;
		if( a == 1)
			return b;
		if( b == 1) 
			return a;
		
		
		int smallSide = a < b ? a : b;
		int bigSide = a < b ? b: a;
		
		if( smallSideToArea[smallSide] != -1) 
			return  smallSideToArea[smallSide];
		
		int result = multiply( smallSide >> 1, bigSide, smallSideToArea )
				//+ multiply( bigSide - (smallSide >> 1), bigSide, smallSideToArea);
				+ multiply( smallSide- (smallSide >> 1), bigSide, smallSideToArea);
		
		smallSideToArea[smallSide] = result;
		
		return result;
	}
	
	
}


