package c10_SortingAndSearching.e02_quickSort;
//20191127(Wed
public class QuickSort {

	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length -1);
	}
	
	
	public static void quickSort(int[] arr, int left, int right) {
		
		int index= partition(arr, left, right);
		if( left < index -1) {
			quickSort(arr, left, index -1 );
		}
		if( index < right) {
			quickSort(arr, index, right);
		}
	}
	
	private static int partition(int[] arr, int left, int right) {
		//int pivot = arr[ (left + right) / 2 ];
		//int pivot = arr[ left + (right - left)/10 ];//this works fine
		int pivot = arr[ left  ];//this works fine
		//this will cause error
		//int pivot = arr[ right ];
		while( left <= right ) {
			//TestQuickSort.printArray(arr);
			while(arr[left] < pivot )
				left++;
			
			while(arr[right] > pivot )
				right--;
			
			if(left<=right) {
				
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
	}
	
	private static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
}
