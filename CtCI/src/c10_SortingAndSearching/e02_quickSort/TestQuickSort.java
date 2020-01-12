package c10_SortingAndSearching.e02_quickSort;

import static java.lang.System.out;

public class TestQuickSort {

	public static void main(String[] args) {
		
		int inputs[][] = {
				{ 2, 6, 1, 3, 0, -2, 12 }
			   ,{1, 7, 5, 6, 4, 2, 8, 3 }
			   ,{3, 8, 2, 4, 6, 5, 7, 1 }
			   ,{-5, 8, 7, -12, 0, 45, 89, -87}
			   ,{-3, -2, 0, 2, 12, 32, 54, 99}
		};
		
//		for(int[] input : inputs) {
//			out.println("-----------------------------");
//			printArray(input);
//			QuickSort.quickSort(input);
//			printArray(input);
//		}
		
//		for(int[] input : inputs) {
//			out.println("-----------------------------");
//			printArray(input);
//			QuickSort_2_pivotAtMiddle.quickSort(input);
//			printArray(input);
//		}
		
//		for(int[] input : inputs) {
//			out.println("-----------------------------");
//			printArray(input);
//			MyQuickSort.quickSort(input);
//			printArray(input);
//		}
		
//		for(int[] input : inputs) {
//			out.println("-----------------------------");
//			printArray(input);
//			MyQuickSort_textbook.quickSort(input);
//			printArray(input);
//		}
		
		for(int[] input : inputs) {
			out.println("-----------------------------");
			printArray(input);
			MyQuickSort_classicVersion.quickSort(input);
			printArray(input);
		}
	}
	
	public static void printArray(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			out.printf("%d ", arr[i]);
		}
		out.println();
	}

}
