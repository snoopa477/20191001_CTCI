package c10_SortingAndSearching.e02_quickSort.practice;
import static java.lang.System.out;
//2021 0403(Sat)
public class QuickSort_classic_01 {
	
	//the user interface
	//they wo't decide how partial to process, they want em all, so the default is quite... simple
	public static void quickSort(int[] arr) {
		//the unit in parameter we accept is idx
		//while the last idx = arr.length -1 ( becare the unit)
		quickSort(arr, 0, arr.length-1 );
	}
	
	
	//the caller
	//wat should we give to the meat? or let the meat do the raw data, and and proceed on next
	//in quickSort cases, let the meat process the raw data first
	private static void quickSort(int[] arr, int left, int right) {
		
		//if left == right, that means one elt, no further operation needed
		//if left > right, arr is not logically existent
		if(left < right) {
			int pivot = partition(arr, left, right);
			quickSort(arr, left, pivot -1);
			quickSort(arr, pivot + 1, right);
		}
		
	}
	
	
	//the meat
	//target: partial array, defined by ( arr, left, right)
	//goal: partition 2 group, 1 st group is smaller than 2nd group
	//return: pivot. left side of pivot is group1, right side of pivot is group2
	private static int partition(int[] arr, int left, int right ) {
		
	
		int tempPivotIdx = right;
		int pivotValue = arr[tempPivotIdx];
		
		//WRONG!
//		int currIdx = 0;
		int currIdx = left;
		
		//doesn't have any small elt yet
		int smallerGroup_idx_inclusive = left -1;
		//goal: collect small elt to 
		//consider domain: among all partial arr, except the index where pivot locates
		for(; currIdx <= right -1; currIdx++) {
			
			if( arr[currIdx] <= pivotValue ) {
				//give group1_Idx dat small elt
				// + 1, its meaning is different from the following swap, idx + 1
				swap(arr, currIdx, smallerGroup_idx_inclusive + 1);
				//smaller group get the elt, so idx ++
				smallerGroup_idx_inclusive++;
			}
		}
		
		//make pivotValue's where it belongs: right to the small group idx
		int pivotIdx = smallerGroup_idx_inclusive + 1;
		swap(arr, tempPivotIdx, pivotIdx);
		
				
		//temp
		return pivotIdx;
	}
	
	private static void swap(int[] arr, int left, int right) {
		
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
		
	}

}


