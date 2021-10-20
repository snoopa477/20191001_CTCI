package c10_SortingAndSearching.e02_quickSort;
import static java.lang.System.out;
public class MyQuickSort_textbook_02_loose {
	static public void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}
	
	static public void quickSort(int[] arr, int left, int right) {
		
		//�n����ƥ��z��, �~����Ϥ��X��ɭn< �٬O <=
		//�o�̬O�u�������elt �N�i�H��
		if(left < right) {
			
			int small_section_right_bound = partition(arr, left, right);
			quickSort(arr, left, small_section_right_bound);
			quickSort(arr, small_section_right_bound + 1, right);
			
		}
		
	}
	
	//the meat
	//���]�e��: �S��pivot, �u����Ӱ϶�
	static private int partition(int[] arr,int left_bound_index, int right_bound_index) {
		
		int pivot_index = left_bound_index + ( right_bound_index - left_bound_index )/2;
		//exclusive
		int small_section_bound_index = left_bound_index;
		int large_section_bound_index = right_bound_index;
		
		//�o�̫h�O, �@�w�n�g�L�����~��⵲��
		while( small_section_bound_index <= large_section_bound_index) {
			
			out.println("small_section_bound_index: " + small_section_bound_index + " pivot_index: " + pivot_index);
			while( arr[small_section_bound_index] <= arr[pivot_index] ) 
				small_section_bound_index++;
			
			out.println("large_section_bound_index: " + large_section_bound_index + " pivot_index: " + pivot_index);
			while(arr[large_section_bound_index] >= arr[pivot_index])
				large_section_bound_index--;
			
			if(small_section_bound_index <= large_section_bound_index) {
				swap(arr, small_section_bound_index, large_section_bound_index);
				small_section_bound_index++;
				large_section_bound_index--;
			}
			
		}
		
		int small_section_right_bound = small_section_bound_index - 1;
		return small_section_right_bound;
		
	}

	private static void swap(int[] arr, int i, int j) {
		int temp_value = arr[i];
		arr[i] = arr[j];
		arr[j] = temp_value;
	}
	
}


