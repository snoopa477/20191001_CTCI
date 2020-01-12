package c10_SortingAndSearching.e01_mergesort;

import static java.lang.System.out;

//20191124(Sun
public class TestMergeSort {

	public static void main(String[] args) {
		{
			int[] inputs = { 2, 6, 1, 3, 0, -2, 12 };
			printArray(inputs);
			MergeSort.mergesort(inputs);
			printArray(inputs);
		}
		
		{
			int[] inputs = { 2, 6, 1, 3, 0, -2, 12 };
			printArray(inputs);
			MyMergeSort.mergeSort(inputs);
			printArray(inputs);
		}
		
	}
	
	private static void printArray(int[] arr) {
		
		for(int i =0; i < arr.length; i++) {
			out.printf("%d ", arr[i]);
		}
		out.println();
	}

}
