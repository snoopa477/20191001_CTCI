package c08_RecursionDynamicProgramming._0801_TripleStep;
public class TripleStep_01_NoDynamicProgramming {
	
	static int countWays(int n ) {
		
		if(n < 0) {
			return 0;
		}
		else if ( n == 0) {
			return 1;
		}else {
			return countWays(n-1 ) + countWays(n-2) + countWays(n-3);
		}
		
	}

}


