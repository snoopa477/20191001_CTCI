package util.sorting.mergeSort;

public class MergeSort {
	
	public static void sort(int[] arr) {
		
		int helper[] = new int[arr.length];
		sort( arr, helper, 0, arr.length -1 );
	}

	public static void sort(int[] arr, int[] helper, int low, int high) {
		//strict smaller than, since it's unnecessary to merge when arr length =1
		//, which means left = right
		if( low < high ) {
			//I guess the var could be replaced with anything, e.g.: low + (high - low)/2
			//the point is to partition the arr into two parts
			int mid = low + ( high - low ) / 2;
			//sort left part
			sort(arr, helper, low, mid);
			//sort right part
			sort(arr, helper, mid + 1, arr.length -1);
			//prerequisite: sort left part and right part BEFORE merge
			mergeLeftAndRightSortedArray(arr, helper, low, high);
			
		}
	}
	
	//given that we have right and left sorted part array stored in array var arr
	//merge the right sorted part array and left sorted part array into a whole array.
	//left sorted array idx range: 0 ~ mid
	//right sorted array idx range: mid + 1 ~ arr.length
	//whole 
	//we merge by replacing the original arr with helper arr
	public static void mergeLeftAndRightSortedArray(int[] arr, int[] helper
			, int low, int high) {
		
		//initialize helper array
		for(int i = 0 ; i < arr.length; i ++) {
			helper[i] = arr[i];
		}
		
		//we assume that the mid is the partition that left is sorted, and right 
		//is sorted
		int mid = low + ( high - low ) /2;
		
		int left_curr = low;
		final int left_bound = mid;
		int right_curr = mid + 1;
		final int right_bound = arr.length -1;
		int curr = low;
		
		while( left_curr <= left_bound && right_curr <= right_bound ) {
			
			if( helper[left_curr] < helper[right_curr] ) {
				arr[curr] = helper[left_curr];
				left_curr++;
			}
			else {
				arr[curr] = helper[right_curr];
				right_curr++;
			}
			curr++;
		}
		
		//people usually cannot observe the invisible part, so here I show it:
		//and, we don't know whether left_curr or right_curr reach their bound
		//if( left_curr <= left_bound ) {
		while(left_curr <= left_bound) {
			arr[curr] = helper[left_curr];
			left_curr++;
			curr++;
		}
		//}
		//invisible part, which will never have to be reached
		//else{
//		while(right_curr <= right_bound) {
//			arr[curr] = helper[right_curr];
//			right_curr++;
//			curr++;
//		}
//		}
		
		
	}
		
}


