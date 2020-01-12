package c10_SortingAndSearching.e01_mergesort;


//20191127(Wed
public class MyMergeSort {

	
	public static void mergeSort(int[] array) {
		int[] helperArray = new int[array.length];
		mergeSort(array, helperArray, 0, array.length-1);
	}
	
	
	private static void mergeSort(int[] array, int[] helperArray,int lowIndex, int highIndex) {
		
		if(lowIndex < highIndex) {
			//avoid from overflow
			int middleIndex = (highIndex - lowIndex)/2 + lowIndex;
			
			mergeSort(array, helperArray, lowIndex, middleIndex);
			mergeSort(array, helperArray, middleIndex + 1, highIndex);
			merge(array, helperArray, lowIndex, highIndex);
		}
	}

	//我的變數命名原則: 不要用大腦運算答出context meaning 
	private static void merge(int[] array, int[] helper_arr, int low_idx, int high_idx) {
		
		int middle_idx = (high_idx - low_idx)/2 + low_idx;
		
		int left_idx = low_idx;
		final int left_bound_idx = middle_idx;
		
		int right_idx = middle_idx+1;
		final int right_bound_idx = high_idx;
		
		int current_idx = low_idx;
		
		for(int i = low_idx; i <= high_idx; i++) {
			helper_arr[i] = array[i];
		}
		
		while( left_idx <= left_bound_idx 
				&& right_idx <= right_bound_idx) {
			
			int left_min = helper_arr[left_idx] ;
			int right_min =  helper_arr[right_idx] ;
			
			if( left_min <= right_min )  {
				array[current_idx] = left_min;
				left_idx++;
			}
			else {
				array[current_idx] = right_min;
				right_idx++;
			}
			current_idx++;
		}
		
		for(int i = left_idx; i <=left_bound_idx; i++, current_idx++) {
			array[current_idx] = helper_arr[i];
		}
		
		
		
	}
	
	
}
