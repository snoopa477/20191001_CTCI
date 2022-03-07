package c10_SortingAndSearching.p11_PeaksAndValleys;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;

public class TestMergeSort {
public static void main(String[] args) {
		
		String[] chosenOptions = {"3"};
		HashSet<String> options = new HashSet<>( Arrays.asList(chosenOptions) );
		
		
		if(options.contains("3")) {
			
			int[][] inputs = {
				{ 2, 6, 1, 3, 0, -2, 12 }
				,{-4, -3, -2, -1}
				,{-1, -2, -3, -4}
				, {0}
			};
			
			
			for( int[] input : inputs) {
				printArray(input);
				_Practice_MergSort.sort(input);
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


