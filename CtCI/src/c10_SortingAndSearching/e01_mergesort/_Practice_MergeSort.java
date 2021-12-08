package c10_SortingAndSearching.e01_mergesort;
import static java.lang.System.out;
public class _Practice_MergeSort {

	
	public static void sort(int[] arr) {
		sort(arr, 0, arr.length -1 );
	}
	
	
	
	/* DETAIL: recursion pre-order will make use of sub method result first
	 */
	private static void sort(int arr[], int left, int right) {
		
		if( left > right ) {
			return ;
		}
		
		//DETAIL: if arr size is one, one element itself is sorted
		if( left == right ) {
			return ;
		}
		
		//THINK_FURTHER reaching here means that the arr's length is at least 2
		
		int mid = left + ( right - left ) /2 ;
		
		sort( arr, left, mid );
		sort( arr, mid + 1, right);
		
		//REASONING so far, both arr[left,mid] and arr[mid+1, right] are sorted, do the merge next
		merge( arr, left , mid, right );
	}
	
	
	
	/* We merge by overwriting 
	 * 
	 * arr:
	 * left sorted part + right sorted part
	 * 
	 * left sorted part, which index ranging from left to mid ( inclusive
	 * right sorted part, which index ranging from mid + 1 to left( inclusive
	 * 
	 * sorted_i: the copy of left sorted part
	 * sorted_j: the copy of right sorted part
	 * the copies of ( left and right sorted part ) will overwrite 'arr' by select the minimum element among copies of both left and right sorted part
	 * 
	 */
	private static void merge(int[] arr, int left, int mid, int right) {
		
		int[] sorted_i = copyArr(arr, left, mid);
		int[] sorted_j = copyArr(arr, mid + 1, right);
		
		//PURPOSE: to merge, either we run out of sorted_A or sorted_B to overwrite the original arr, which combines the left sorted part and right sorted part
		/* DETAIL: 
		 * i : index of sorted i
		 * j : index of sorted j
		 * target: target index points to 'arr' to where sorted_i and sorted_j gonna overwrite 
		 */
		//MISTAKE even initializing value requires vigilance
		//int j = 0, i = 0, target = 0;
		int j = 0, i = 0, target = left;
		//ERROR ArrayIndex out of bounds exception. Sometimes hands fall behind mind, hence typo occurs
		//while( i < sorted_i.length || j < sorted_j.length ) {
		while( i < sorted_i.length && j < sorted_j.length ) {
			
			if( sorted_i[i] < sorted_j[j] ) {
				arr[target] = sorted_i[i];
				i++;
				target++;
			}
			else {
				arr[target] = sorted_j[j];
				j++;
				target++;
			}
		}
		
		//THINK_FURTHER: reaching here meaning either we run out of sorted_i or sorted_j to overwrite the original arr, 
		//PURPOSE since one of the copy depletes, we simply pick minimum element from one single copy, no comparison needed
		
		
		//REASONING: the code is commented because the part of 'arr' that has not yet been overwritten is the exact same as the remaining of sorted_j, which reason is we write from left to right. 
		//if( j < sorted_j.length ) {
			//do nothing
		//}
		
		
		//REASONING sorted_j is already depleted, now depletes the other: sorted_i
		if( i < sorted_i.length ) {
			while( i < sorted_i.length ) {
				arr[target] = sorted_i[i];
				i++;
				target++;
			}
		}
	}
	
	
	
	private static int[] copyArr(int[] arr, int left, int right) {
		
		if(left > right) {
			return null;
		}
		
		int[] result = new int[right - left + 1];
		
		/* DETAIL:
		 * i : index of result arr, ranging from 0 to right - left ( inclusive)
		 * j : index of 'arr' arr, ranging from left to right ( inclusive)
		 */
		//MISTAKE: have to be careful is anything missed
		//for(int i = 0, j = left; j <= right; i++) {
		for(int i = 0, j = left; j <= right; i++, j++) {
			result[i] = arr[j];
		}
		
		return result;
	}
}


