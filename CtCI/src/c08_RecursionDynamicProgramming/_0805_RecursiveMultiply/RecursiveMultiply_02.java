package c08_RecursionDynamicProgramming._0805_RecursiveMultiply;
//import static java.lang.System.out;
public class RecursiveMultiply_02 {
	
	public static int minProduct(int a, int b) {
		int bigger = a < b ? b : a;
		int smaller = a < b ? a : b;
		
		int memo[] = new int[smaller + 1];
		return minProduct(smaller, bigger, memo);
	}

	private static int minProduct(int smaller, int bigger, int[] memo) {
		
		if( smaller == 0 ) {
			return 0;
		}
		else if( smaller ==1 ) {
			return bigger;
		}
		else if ( memo[smaller] > 0 ) {
			return memo[smaller];
		}
		
		/*Compute half. If uneven, compute other half, If even, double it. */
		int s = smaller >> 1; // divide by 2
		int side1 = minProduct(s, bigger, memo); //compute half
		int side2 = side1;
		if( smaller % 2 == 1 ) {
			side2 = minProduct(smaller - s, bigger, memo);
		}
		
		/*Sum and cache. */
		memo[smaller] = side1 + side2;
		
		
		return memo[smaller];
	}

}


