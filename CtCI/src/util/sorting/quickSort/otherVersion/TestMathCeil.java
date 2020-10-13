package util.sorting.quickSort.otherVersion;
import static java.lang.System.out;
public class TestMathCeil {

	public static void main(String[] args) {
		
		double[] inputs = { 2.2, -2.3, 4.52 , 5};
		
		for(double input : inputs) {
			out.println( Math.ceil(input) );
		}
		
		//0, I thought it's 1
		out.println( (int)Math.ceil( (1 - 0)/2 ) );
		
		//1
		out.println( (int)Math.ceil( (1.0 - 0)/2 ) );
		
		//1
		out.println( (int)Math.ceil( (double)(1 - 0)/2 ) );
		
	}

}


