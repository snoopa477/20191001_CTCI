package c10_SortingAndSearching.p11_PeaksAndValleys.mine.optimal;
//import static java.lang.System.out;

import util.MyArrays;
public class PeaksAndValleys

{

	public void sortAsPeaksAndValleys(int[] array) {
		
		for( int i = 0; i < array.length; i+=2 ) {
			int maxValueIndex = getMaxValueIndex(array, i);
			MyArrays.swap(array, i, maxValueIndex);
		}
		
	}
	
	public int getMaxValueIndex(int[] array, int mid) {
		
		int left = mid -1;
		int	right = mid + 1;
		
		int left_value = isWithinRange(array, left)? 
				array[left] : Integer.MIN_VALUE;
		int right_value = isWithinRange(array, right)? 
				array[right] : Integer.MIN_VALUE;
		int mid_value = isWithinRange(array, mid)? 
				array[mid] : Integer.MIN_VALUE;
		
		int maxValue = Math.max(left_value
				,  Math.max(mid_value, right_value) );
		
		if( maxValue == left_value ) {
			return left;
		}
		else if( maxValue == mid_value ) {
			return mid;
		}
		else {
			return right;
		}
		
	}
	
	private boolean isWithinRange(int[] array, int idx) {
		return 0 <= idx && idx < array.length;
	}
	
}


