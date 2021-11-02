package c08_RecursionDynamicProgramming._0805_RecursiveMultiply;
import static java.lang.System.out;

import java.util.Arrays;


 
public class _Practice_My_RecursiveMultiply_01_DP {
	
	static final boolean isDebugOn = false;
	
	public static int getArea(int length, int width) {
		
		int shortSide = length < width? length : width;
		int longSide = length < width? width : length;
		/*
		 * full name: given fixed longer side, recording of each short side to area ( length * width ). 
		 * we set -1 if there's no recording yet
		 */
		/*WRONG
		 * length = shortSide, maxIndex shortSide -1; however, the actual maxIndex is up to shortSide
		 * ArrayIndexOutOfBoudnsExceptoin
		 * int[] sideToArea = new int[shortSide];
		 */
		int[] sideToArea = new int[shortSide +1 ];
		Arrays.fill(sideToArea, -1);
		
		/*
		 PURPOSE
		 generally speaking, shortSide needs less times to be halved to base case than long side does
		 * */
		return getAreaHelper(shortSide, longSide, sideToArea); 
	}
	
	/*
	 DETAIL
	 in recursion with multi-call, the method might be visited several times
	 * */
	private static int getAreaHelper(int sideToDivide, int fixedSide, int[] sideToArea) {
		
		//ERROR: ArrayIndexOutOfBoudnsExceptoin
		if( isDebugOn ) out.println(sideToDivide);
		
		/*
		 PURPOSE
		 for those who visited here more than twice
		 * */
		if( sideToArea[sideToDivide] != -1 ) {
			return sideToArea[sideToDivide];
		}
		
		if(sideToDivide == 0) {
			return 0;
		}
		
		if(sideToDivide == 1) {
			return fixedSide;
		}
		
		/*
		 DETAIL
		 to halve, >>1 is better than /2
		 * */
		int dividedSide_01 = sideToDivide >> 1;
		int subArea_01 = getAreaHelper(dividedSide_01, fixedSide, sideToArea);
		
		
		int dividedSide_02 = sideToDivide - dividedSide_01;
		if(dividedSide_01 == dividedSide_02) {
			return subArea_01 + subArea_01;
		}
		
		int subArea_02 = getAreaHelper(dividedSide_02, fixedSide, sideToArea);
		
		return subArea_01 + subArea_02;
	}
	
}


