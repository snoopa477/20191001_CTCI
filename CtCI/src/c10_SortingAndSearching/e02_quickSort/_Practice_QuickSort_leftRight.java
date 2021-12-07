package c10_SortingAndSearching.e02_quickSort;
import static java.lang.System.out;
public class _Practice_QuickSort_leftRight {
	
	public static void sort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
	}
	

	
	//DETAIL: recursion post order iterative
	private static void quickSort(int[] arr, int left, int right) {
		
		//ERROR: uncaught stackOverFlow
		//REASONING: forgetting specify base case to stop, causing it calling method with arr len1 infinitely
		//if( left > right ) {
		/*DETAIL
		 * if left > right: invalid situation
		 * if left == right: base case: arr lenght is one, arr itself is already sorted 
		 */
		if( (left >  right) || (left == right) ) {
			return;
		}
		
		//DETAIL: pivot: index Of last small arr elements 
		int pivot = partition(arr, left, right);
		
		quickSort(arr, left, pivot);
		quickSort(arr, pivot+1, right);
	}
	
	
	
	/*DETAIL:
	 * left: 
	 * 	it's a small element collector: left side of left pointer are small elements; however, the left pointer itself is exclusive.
	 * 	elements, which index ranges from 0 to left -1, has value lower than or equal to pivot value
	 * 
	 * right:
	 * 	it'a a big element collector: right side of right pointer are bit elements; however, the right pointer itself is exclusive
	 * 	elements, which index ranges from right+1 to arr.len-1, has value greater than or equal to pivot value
	 * 
	 * return: the small elements last element index
	 */
	private static int partition(int[] arr, int left, int right) {
		
		if( left > right ) {
			out.println("-1");
			return -1;
		}
		
		//DETAIL: pivot is to used as a threshold to divide arr into two: left side arr has values which are smaller than or equal to pivot; likewise, right side arr has values which are greater than or equal to pivot
		int pivot = arr [left + (right-left)/2];
		
		/*PURPOSE: the section between left and right is undecided area. To determine both small arr and big arr, undecided area's size has to be 0
		 * 
		 * step 1: both left and right points to invalid element, ready to trade by swapping
		 * step 2: after trading by swapping, since both of right and left get what they want -> proceed by one index
		 */
		while( left <= right ) {
			
			//step1
			while( arr[left] < pivot ) {
				left++;
			}
			while( arr[right] > pivot ) {
				right--;
				//MISTAKE: 
				//right++;
			}
			
			//step2
			if( left <= right ) {
				swap( arr, left, right );
				left++;
				right--;
			}
		}
		
		
		return left-1;
	}
	
	
	
	private static void swap(int[] arr, int i, int j) {
		//a =  ( a + b ) - ( b = a );
		arr[i] = ( arr[i] + arr[j] ) - ( arr[j] = arr[i] );
	}
}


