package c10_SortingAndSearching.p11_PeaksAndValleys.textbook.suboptimal;

import java.util.Arrays;

import util.MyArrays;

public class PeaksAndValleys {

	public void PeaksAndValleys(int[] array) {
		
		Arrays.sort( array );
		for( int i = 1; i < array.length; i +=2) {
			MyArrays.swap(array, i - 1, i );
		}
	}
}
