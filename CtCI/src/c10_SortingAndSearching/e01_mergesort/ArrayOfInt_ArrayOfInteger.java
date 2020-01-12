package c10_SortingAndSearching.e01_mergesort;
//20191124(Sun

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//20191124(Sun
public class ArrayOfInt_ArrayOfInteger {

	public static void main(String[] args) {
		//wrong: int[] inputs = [2, 6, 1, 3, 0, 2, -2];
		int[] inputs = {2, 6, 1, 3, 0, 2, -2};
		
		Integer[] inputs_Integer = {2, 6, 1, 3, 0, 2, -2};
		
		//ok declare:
//		int[] myIntArray = new int[3];
//		int[] myIntArray = {1, 2, 3};
//		int[] myIntArray = new int[]{1, 2, 3};
		//{} is initialization list
		//can only put size among brackets []
		
		//printList(Arrays.asList(inputs));
		//<int[]> List<int[]> java.util.Arrays.asList(int[]... a)
		//T = int[]
		out.println("sequence is: " + Arrays.asList(new int[]{1,5,2}));
		//Class Integer implements comprable so you can just print the sorted result
		//int[] != Integer[]
		out.println("sequence is: " + Arrays.asList(new Integer[]{2, 6, 1, 3, 0, 2, -2}));
		//<Integer> List<Integer> java.util.Arrays.asList(Integer... a)
		//T = Integer
		List<Integer> list=  Arrays.asList(inputs_Integer);
		
		MergeSort.mergesort(inputs);
		//printList(Arrays.asList(inputs));
		
	}
	
	public static void printList(List<Integer> list) {
		
		for(Integer elt: list) {
			out.printf("%d ", (Integer)elt);
		}
		out.println();
		
	}

}
