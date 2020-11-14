package c08_RecursionDynamicProgramming._0801_TripleStep;
//import static java.lang.System.out;

import java.util.Arrays;
public class My_TripleStep_02_DynamicProgramming_02 {
	
	public static int waysToReachStep(int steps) {
		
		int[] stepsToWays = new int[steps + 1];
		//we take -1 as not visited yet
		Arrays.fill(stepsToWays, -1);
		
		return waysToReachStep(steps, stepsToWays);
	}
	
	static int waysToReachStep(int steps, int[] stepsToWays) {
		
		//base case
		if (steps < 0) {
			return 0;
		}
		// base case
		if (steps == 0) {
			return 1;
		}

		//DP
		//MISTAKE: index cannot be negative, otherwise there is exception:
		// java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 11
		if(stepsToWays[steps] != -1) {
			return stepsToWays[steps];
		}
		
//		//base case
//		if(steps < 0) {
//			return 0;
//		}
//		//base case
//		if(steps == 0) {
//			return 1;
//		}
//		
		
		int result = waysToReachStep(steps -1, stepsToWays )
				+  waysToReachStep(steps -2, stepsToWays )
				+  waysToReachStep(steps -3, stepsToWays );
		
		stepsToWays[steps] = result;
		
		return result;
	}
	

}


