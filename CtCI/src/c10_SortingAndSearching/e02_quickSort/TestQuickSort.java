package c10_SortingAndSearching.e02_quickSort;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;

import c10_SortingAndSearching.e02_quickSort.practice.QuickSort_classic_01;
import c10_SortingAndSearching.e02_quickSort.practice.QuickSort_textbook_freq01;

public class TestQuickSort {

	public static void main(String[] args) {
		
		int inputs[][] = {
				{ 2, 6, 1, 3, 0, -2, 12 }
			   ,{1, 7, 5, 6, 4, 2, 8, 3 }
			   ,{3, 8, 2, 4, 6, 5, 7, 1 }
			   ,{-5, 8, 7, -12, 0, 45, 89, -87}
			   ,{-3, -2, 0, 2, 12, 32, 54, 99}
			   ,{3, 2}
		};

		String[] chosenOptions = {"4"};
		HashSet<String> options = new HashSet<>( Arrays.asList(chosenOptions) );
		
		
		if(options.contains("1")) {
			for(int[] input : inputs) {
				out.println("-----------------------------");
				int[] copiedArr = Arrays.copyOf(input, input.length);
				printArray(copiedArr);
				QuickSort_textbook_freq01.quickSort(copiedArr);
				printArray(copiedArr);
			
			}
		}
		
		if(options.contains("2")) {
			for(int[] input : inputs) {
				out.println("-----------------------------_Practice_QuickSort_leftRight");
				int[] copiedArr = Arrays.copyOf(input, input.length);
				
				printArray(copiedArr);
				_Practice_QuickSort_leftRight.sort(copiedArr);
				printArray(copiedArr);
			
			}
		}
		
		if(options.contains("3")) {
			for(int[] input : inputs) {
				out.println("-----------------------------_Practice_QuickSort_PivotAtLast_Strict");
				int[] copiedArr = Arrays.copyOf(input, input.length);
				printArray(copiedArr);
				_Practice_QuickSort_PivotAtLast_Strict.sort(copiedArr);
				printArray(copiedArr);
			
			}
		}
		
		
		if(options.contains("4")) {
			for(int[] input : inputs) {
				out.println("-----------------------------_Practice_QuickSort_PivotAtLast_Loose");
				int[] copiedArr = Arrays.copyOf(input, input.length);
				printArray(copiedArr);
				_Practice_QuickSort_PivotAtLast_Loose.sort(copiedArr);
				printArray(copiedArr);
			
			}
		}
		
		
	}
	
	public static void printArray(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			out.printf("%d ", arr[i]);
		}
		out.println();
	}

}
