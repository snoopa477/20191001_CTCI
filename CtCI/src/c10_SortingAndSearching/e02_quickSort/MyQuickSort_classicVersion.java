package c10_SortingAndSearching.e02_quickSort;
//20191209(Mon
public class MyQuickSort_classicVersion {

	
	
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}
	
	
	private static void quickSort(int[] arr, int left, int right) {
		
		if(left < right) {
			
			int pivotIdx = partition(arr, left, right);
			
//			if(left < pivotIdx -1)
				quickSort(arr, left, pivotIdx - 1);
			
//			if(pivotIdx + 1 < right)
				quickSort(arr, pivotIdx + 1, right);
			
		}
		
	}
	
	
	private static int partition(int[] arr, int left_bound_idx, int right_bound_idx) {
		
		int temp_pivot = arr[right_bound_idx];
		
		//wrong!
//		int temp_pivot = arr[left_bound_idx];
		//inclusive
		int small_sectoin_right_bound = left_bound_idx - 1;
		for(int current_idx = left_bound_idx; current_idx <= right_bound_idx -1; current_idx++) {
			//collect, not expel elt
			if( arr[current_idx] < temp_pivot ) {
				swap(arr, current_idx, small_sectoin_right_bound + 1);
				small_sectoin_right_bound += 1;
			}
		}
		
		int pivot_idx = small_sectoin_right_bound +1;
		swap(arr, pivot_idx, right_bound_idx);
		
		return pivot_idx;
		
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp_value = arr[i];
		arr[i] = arr[j];
		arr[j] = temp_value;
	}
	
}
