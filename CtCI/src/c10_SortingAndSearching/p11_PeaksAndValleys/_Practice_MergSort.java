package c10_SortingAndSearching.p11_PeaksAndValleys;
import static java.lang.System.out;

import java.util.Arrays;



public class _Practice_MergSort {
	
	public static void sort(int[] arr) {
		sort( arr, 0, arr.length -1 );
	}
	
	
	private static void sort(int[] arr, int left, int right) {
		
		if( left > right ) {
			return ;
		}
		
		//MISTAKE
		if( left == right ) {
			return ;
		}
		
		
		int mid = left + (right - left)/ 2;
		
		sort(arr, left, mid);
		sort(arr, mid + 1, right);
		
		merge(arr, left, right);
		
		
	}
	
	
	
	//THINK_FURTHER: prerequisite: there are two sorted arrays
	private static void merge(int[] arr, int left, int right) {
		
		
		if( left > right ) {
			return ;
		}
		
		int mid = left + (right - left)/ 2;
		
		//int leftArr_rightBound = mid;
		//int rightArr_rightBound = right;
		
		//int leftArr_idx = left;
		// rightArr_idx = mid + 1;
		
		int leftArr_rightBound = mid - left;
		int rightArr_rightBound = right - left;
				
		int leftArr_idx = left - left;
		int rightArr_idx = mid + 1 - left;
		
		int[] copiedArr = new int[ right - left + 1 ];
		
		for(int j = 0, i = left; i <= right; i++, j++ ) {
			copiedArr[j] = arr[i];
		}
		
		
		//pivotIdx: the index that points to merged arr
		int pivotIdx = left;
		
		//PURPOSE: merge under the circumstance that both idx not run out of.
		while( leftArr_idx <= leftArr_rightBound 
			&& rightArr_idx <= rightArr_rightBound  ) {
			
			//if( arr[leftArr_idx] < arr[rightArr_idx] ) {
			if( copiedArr[leftArr_idx] < copiedArr[rightArr_idx] ) {
				arr[pivotIdx] = copiedArr[leftArr_idx ];
				pivotIdx++;
				leftArr_idx++;
			}
			else {
				arr[pivotIdx] = copiedArr[rightArr_idx ];
				pivotIdx++;
				rightArr_idx++;
			}
		}
		
		
		//that means rightArr_idx is run out of
		while( leftArr_idx <= leftArr_rightBound ) {
			arr[pivotIdx] = copiedArr[leftArr_idx ];
			pivotIdx++;
			leftArr_idx++;
		}
		
		//that means leftArr_idx is run out of; however, the remaining arr is already sorted => so we do nothing
		//while( rightArr_idx <= rightArr_rightBound ) { ... }
		
		
	}
	
}




