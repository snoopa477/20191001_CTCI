package c08_RecursionDynamicProgramming._0805_RecursiveMultiply;
//import static java.lang.System.out;
public class RecursiveMultiply_03 {
	
	public static int minProduct(int a, int b) {
		
		int bigger = a < b ? b : a;
		int smaller = a < b ? a : b;
		return minProductHelper(smaller, bigger);
		
	}

	private static int minProductHelper(int smaller, int bigger) {
		
		if( smaller == 0 ) {
			return 0;
		}
		else if( smaller == 1 ) {
			return bigger;
		}
		
		int s = smaller >> 1; //divide by 2
		int halfProd = minProductHelper(s, bigger);
		
		if(smaller % 2 == 0) {
			return halfProd + halfProd;
		}
		else {
			return halfProd + halfProd + bigger;
		}
		
		
	}

}


