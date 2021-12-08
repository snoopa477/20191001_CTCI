package c10_SortingAndSearching.e01_mergesort;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;

//20191124(Sun
public class TestMergeSort {

	public static void main(String[] args) {
		
		String[] chosenOptions = {"3"};
		HashSet<String> options = new HashSet<>( Arrays.asList(chosenOptions) );
		
		if(options.contains("1"))
		{
			int[] inputs = { 2, 6, 1, 3, 0, -2, 12 };
			printArray(inputs);
			MergeSort.mergesort(inputs);
			printArray(inputs);
		}
		
		
		if(options.contains("2"))
		{
			int[] inputs = { 2, 6, 1, 3, 0, -2, 12 };
			printArray(inputs);
			MyMergeSort.mergeSort(inputs);
			printArray(inputs);
		}
		
		
		if(options.contains("3")) {
			int[] inputs = { 2, 6, 1, 3, 0, -2, 12 };
			printArray(inputs);
			_Practice_MergeSort.sort(inputs);
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
