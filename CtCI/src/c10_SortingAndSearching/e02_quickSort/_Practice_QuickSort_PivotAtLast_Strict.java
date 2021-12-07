package c10_SortingAndSearching.e02_quickSort;
import static java.lang.System.out;
public class _Practice_QuickSort_PivotAtLast_Strict {

	
	public static void sort(int[] arr) {
		sort(arr, 0, arr.length -1);
	}
	
	
	
	public static void sort(int[] arr, int left, int right) {
		
		if( left > right ) {
			return;
		}
		
		if( left == right) {
			return ;
		}
		//THINK_FURTHER reaching here meaning that the arr's size is at least 2
		
		//DETAIL: pivot: the last index in small area
		int pivot = partition(arr, left, right);
		sort( arr, 0, pivot );
		//THINK_FURTHER reaching here meaning that the arr's size is at least 2
		sort( arr, pivot + 1, right);
		
	}
	
	
	/*
	 * DETAIL
	 * return small arrs' last index
	 * It is assumed that arr's smallest size = 2
	 */
	public static int partition(int[] arr, int left, int right) {
		
		//impossible case; however, we should never reach to this case actually
		if( left >= right ) {
			return -1;
		}
		
		
		//PURPOSE step 1: collect small elements and put them left side
		/* DETAIL: 
		 * this index collect elements which value is smaller than pivot ( equal to is not included, so I coin it strict ).
		 * the index itself is inclusive
		 */
		//MISTAKE: we start at leftmost, which index is 0, not 1
		//int smallAreaRightBound = 1;
		int smallAreaRightBound = 0;
		/* DETAIL
		 * 'i': explorer's index ranges from 0 to right-1, since we assume last index ('right') as pivot index, which should not be affected by i.
		 */
		//DETAIL accentuate by denoting i <= right -1
		for(int i = 0; i <= right -1; i++) {
			
			//MISTAKE: type: sometimes hands are not fully following my mind, so document is important to have double check if I execute correctly 
			//if( arr[i] < arr[smallAreaRightBound]) {
			if( arr[i] < arr[ right ] ) {
				swap( arr, i, smallAreaRightBound );
				smallAreaRightBound++;
			}
		}
		
		//PURPOSE step 2: left side is done, now put the pivot to the right bound of small area
		swap( arr, smallAreaRightBound, right );
		
		/*DETAIL: now small smallAreaRightBound points to pivot value, which is not accepted by small area
		 * so the last element in small area is at  smallAreaRightBound -1
		 */
		return smallAreaRightBound -1;
	}
	
	
	
	private static void swap(int[] arr, int i, int j) {
		arr[j] = ( arr[i] + arr[j] ) - ( arr[i] = arr[j] );
	}
	
}


