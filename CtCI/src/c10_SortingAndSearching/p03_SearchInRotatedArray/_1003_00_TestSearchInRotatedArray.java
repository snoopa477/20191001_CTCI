package c10_SortingAndSearching.p03_SearchInRotatedArray;
/**
 * 
 * 20200116(Thur 
 */

import static java.lang.System.out;

import java.util.Arrays;

public class _1003_00_TestSearchInRotatedArray {

	public static void main(String[] args) {

		{
			int[] a = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
			out.println(_1003_01_SearchInRotatedArray.search(a,0, a.length-1,5));
			
		}
		
		{
			int[] a = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
			out.println(_1003_02_MySearchInRotatedArray.binarySearch(a,0, a.length-1,5));
		}
		
	}
	

}
