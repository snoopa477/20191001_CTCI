package c10_SortingAndSearching.e02_quickSort;

//20191202(Mon
public class MyQuickSort {
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length -1);
	}
	
	
	public static void quickSort(int[] arr, int left, int right) {
		
		if(left < right) {
			int small_section_right_bound= partition(arr, left, right);
			int large_section_left_bound = small_section_right_bound + 1;
			quickSort(arr, left, small_section_right_bound );
			quickSort(arr, large_section_left_bound, right);
		}
	}
	
	private static int partition(int[] arr, int left, int right) {
		int pivot = arr[ left + (right - left)/2 ];
		while( left <= right ) {
			
			while(arr[left] < pivot )
				left++;
			
			while(arr[right] > pivot )
				right--;
			
			//��if(left<=right)comment ���|���~: �]���S��pivot�i�H�P�_�O�_�w�g'�V�ɨ��L�϶�'
			//�٬O�ȶȭn�⤣�n��swap��ﭱ�h
			if(left<=right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		int small_section_right_bound = left -1;
		return small_section_right_bound;
	}
	
	private static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
}
