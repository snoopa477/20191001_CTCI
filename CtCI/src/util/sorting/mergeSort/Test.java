package util.sorting.mergeSort;
import static java.lang.System.out;

import util.MyArrays;
public class Test {

	public static void main(String[] args) {
		
		int[][] inputs = { {12, 43, 33, 94, 18,0 ,3, 94}, 
				{12, 543, 23, 12,99, 4, -1, 34, -77},
				{34, 87, 122, 98, 122, 75, -98, -78, -2},
				{-2, 65, -2, -84, 83, 7, 48},
				{0,1,1,10,0, 1}};
		
		for( int i = 0; i < inputs.length; i++ ) {
			out.println( "original " + MyArrays.toString(inputs[i]) );
			MergeSort.sort(inputs[i]);
			out.println( "sorted " + MyArrays.toString(inputs[i]) );
			out.println();
		}
		
	}

}


