package c10_SortingAndSearching.p09_SortedMatrixSearch;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;

public class TestSortedMatrixSearch {

	public static void main(String[] args) {
		
		HashSet<String> options = new HashSet<String>( Arrays.asList("2") );
		
		int[][] sortedMatrix= { {15, 20, 40, 85},
								{20, 35, 80, 95},
								{30, 55, 95, 105},
								{40, 80, 100, 120}};
		
		int[] numsToSearch = {15, 55, 102, 121, 40};
		
		if(options.contains("0")) {
		out.println("- - - - - - - -_1009_00_SortedMatrixSearch");
			for(int elem: numsToSearch) {
				out.println(elem + " can be found? " 
						+ _1009_00_SortedMatrixSearch.findElement(sortedMatrix, elem));
			}
			
			out.println("- - - - - - - -_1009_01_SortedMatrixSearch");
			for(int elem: numsToSearch) {
				out.println(elem + " can be found? " 
						+ _1009_01_SortedMatrixSearch.findElement(sortedMatrix,elem));
			}
		}
		
		
		if(options.contains("1")) {
			out.println("- - - - - - - -MySortedMatrixSearch_freq02");
			for(int elem: numsToSearch) {
				out.println(elem + " can be found? " 
						+ MySortedMatrixSearch_way_02_freq02.searchElement(sortedMatrix,elem));
			}
			
			out.println("- - - - - - - -MySortedMatrixSearch_way_01_freq02");
	//		MySortedMatrixSearch_way_01_freq02
			for(int elem: numsToSearch) {
				out.println(elem + " can be found? " 
						+ MySortedMatrixSearch_way_01_freq02.findElement(sortedMatrix,elem));
			}
		}
		
		
		if(options.contains("2")) {
			out.println("- - - - - - - -_Practice_SortedMatrixSearch_01_Corner");
			for(int elem: numsToSearch) {
				out.println(elem + " can be found? " 
						+ _Practice_SortedMatrixSearch_01_Corner.find(sortedMatrix,elem));
			}
			
			out.println("- - - - - - - -_Practice_SortedMatrixSearch_02_BinarySearch");
	//		MySortedMatrixSearch_way_01_freq02
			for(int elem: numsToSearch) {
				out.println(elem + " can be found? " 
						+ _Practice_SortedMatrixSearch_02_BinarySearch.find(sortedMatrix,elem));
			}
		}
		
	}

}
