package c10_SortingAndSearching.e02_quickSort.practice;
import static java.lang.System.out;
public class TestSwap {

	public static void main(String[] args) {
		
		int a = 1;
		int b = 3;
		out.println("a :" + a + "; b: " + b);
		
		a =  ( a + b ) - ( b = a );
		
		out.println("a :" + a + "; b: " + b);
		
	}

}


