package c08_RecursionDynamicProgramming._0801_TripleStep;
public class My_TripleStep_01_NoDynamicProgramming {
	
	//number of ways to reach position n from position 0
	public static int waysToReachPosition(int position) {
		
		//exclusion of meaningless positions, since general case
		//formula is f(n) = f(n-1) + f(n-2) + f(n-3), make sure none of parameter
		// < 0
		if( position < 0 ) {
			return 0;
		}
		
		//base case
		if( position == 0 ) {
			return 1;
		}
		
		//general cases
		return waysToReachPosition(position -1) 
				+ waysToReachPosition(position -2 ) 
				+ waysToReachPosition(position -3);
		
	}

}


