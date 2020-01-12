package c10_SortingAndSearching.e02_quickSort;

public class QuickSort_2_pivotAtMiddle {
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length -1);
	}
	
	
	public static void quickSort(int[] arr, int left, int right) {
		if(left < right) {
		int index= partition(arr, left, right);
//		if( left < index -1) {
			quickSort(arr, left, index -1 );
//		}
//		if( index < right) {
			
			quickSort(arr, index, right);
//		}
		}
		
	}
	
	private static int partition(int[] arr, int left, int right) {

		int pivot = arr[ (left + right) / 2 ];
		
		while( left <= right ) {
			
			//TestQuickSort.printArray(arr);
			while(arr[left] < pivot )
				left++;
			
			while(arr[right] > pivot )
				right--;
			
			if(left<=right) {
				
				//this is wrong
				swap(arr, left, right);
//				if( arr[left] !=pivot) 
//					left++;
//				if( arr[left] !=pivot) 
//					right--;
				
				left++;
				right--;
			}
		}
		//System.out.println("pivot is "+ pivot);
		//TestQuickSort.printArray(arr);
		return left;
	}
	
	private static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
}
