package c10_SortingAndSearching.p11_PeaksAndValleys;
import static java.lang.System.out;
import util.MyArrays;

public class _Practice_PeaksAndValleys_02_swapThreeElt {

	//PURPOSE: Test private methods
	public static void main(String[] args) {
		
		int[][] inputs = {
			{-1, 0, 3}
			, {3, 2, 1}
			, {1, 3, 2}
		};
		
		for(int[] input : inputs) {
			MyArrays.print(input);
			putMaxAtMiddleAmongThree(input, 1);
			MyArrays.print(input);
			out.println();
		}
		
	}
	
	
	
	public static void makePeakValley(int[] arr) {
		/* REASONING
		 * equals to make each even index having greatest value, compare to its left and right neighbor
		 * 
		 */
		final int offset = 2;
		for(int i = 0; i < arr.length; i += offset) {
			putMaxAtMiddleAmongThree(arr, i);
		}
		
	}
	
	
	
	private static void putMaxAtMiddleAmongThree(int arr[], int mid) {
		
		int left = mid -1;
		int right = mid + 1;
		
		
		//there's no left
		if( mid == 0 ) {
			 
			if( arr[mid] < arr[right] ) {
				swap(arr, mid, right);
			}
			//else, do nothing
		}
		//there's no right
		else if( mid == arr.length -1) {
			
			if( arr[left] < arr[mid] ) {
				swap(arr, left, mid);
			}
			//else, do nothing
		}
		else {
			
			int largerValueIdx = arr[left] > arr[right]? left : right;
			
			if( arr[mid] < arr[largerValueIdx] ) {
				swap(arr, mid, largerValueIdx);
			}
			//else do nothing
		}
	}
	
	
	
	private static void swap(int[] arr, int i, int j) {
		arr[j] = arr[i]  + arr[j] - (arr[i] = arr[j]);
	}
	
}


