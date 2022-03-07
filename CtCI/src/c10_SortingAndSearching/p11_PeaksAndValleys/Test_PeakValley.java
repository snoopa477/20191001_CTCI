package c10_SortingAndSearching.p11_PeaksAndValleys;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;
public class Test_PeakValley {

	public static void main(String[] args) {
		
		
		HashSet<String> options = new HashSet<String>( Arrays.asList("2") );
		
		int[][] inputs = {
				{ 2,5, 9, -3, 8, 10, -3, -4}
		};
		
		
		if( options.contains("1") ){
			
			for( int[] input: inputs ) {
				printArray(input);
				_Practice_PeaksAndValleys_01_swapTwoElt.makePeakValley(input);
				printArray(input);
				out.println();
			}
		}
		else if( options.contains("2") ) {
			
			for( int[] input: inputs ) {
				printArray(input);
				_Practice_PeaksAndValleys_02_swapThreeElt.makePeakValley(input);
				printArray(input);
				out.println();
			}
			
		}
		
		
	}
	
	
	private static void printArray(int[] arr) {
		
		for(int i =0; i < arr.length; i++) {
			out.printf("%d ", arr[i]);
		}
		out.println();
	}

}


