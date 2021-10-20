package c10_SortingAndSearching.e02_quickSort.practice;
import static java.lang.System.out;

//2021 0403(Sat)
public class QuickSort_textbook_freq01 {
	
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
				int smallGroupRightBound = partition_getSmallGroupRightBound(arr, left, right);
				quickSort(arr, left, smallGroupRightBound );
				quickSort(arr, smallGroupRightBound + 1, right);
			}
			
		}
		
		
		//the meat
		//target: partial array, defined by ( arr, left, right)
		//goal: partition 2 group, 1 st group is smaller than 2nd group
		//return: pivot. left side of pivot is group1, right side of pivot is group2
		private static int partition_getSmallGroupRightBound(int[] arr, int left, int right ) {
			
			int smallerGroup_exclusiveIdx = left;
			int largerGroup_exclusiveIdx = right;
			
			int pivotIndex = left + (right - left)/2;
			int pivotValue = arr[ left + (right - left)/2 ];
			
			while( smallerGroup_exclusiveIdx <= largerGroup_exclusiveIdx ) {
				
				//stop by large/ or equal to pivot index
				while( arr[smallerGroup_exclusiveIdx] < pivotValue ) {
//				while( arr[smallerGroup_exclusiveIdx] < arr[pivotIndex] ) {
					//if statement valid -> elt valid -> get the elt(no operation need to be explicitly specified)
					//-> proceed idx
					smallerGroup_exclusiveIdx++;
				}
				
				//stop by small/ or equal to pivot index
				//it's wrong, why?
				while( arr[largerGroup_exclusiveIdx] > pivotValue ) {
				//it's right, why?
//				while( arr[largerGroup_exclusiveIdx] > arr[pivotIndex] ) {
					largerGroup_exclusiveIdx--;
				}
				
				if( smallerGroup_exclusiveIdx <= largerGroup_exclusiveIdx ) {
					swap(arr, smallerGroup_exclusiveIdx, largerGroup_exclusiveIdx);
					//after swapping, each group get wat they want, so idx++
					largerGroup_exclusiveIdx--;
					smallerGroup_exclusiveIdx++;
				}
			}
			
			
			
			//we chanve our assumption: groups don't overlap--if that happens-- and we add pivot to small group 
			int smallerGroup_inclusiveIdx = smallerGroup_exclusiveIdx -1;
			
			// will cause out of index error
			//int smallerGroup_inclusiveIdx = smallerGroup_exclusiveIdx +1;
			return smallerGroup_inclusiveIdx;
		}
		
		private static void swap(int[] arr, int i, int j) {
			int temp_value = arr[i];
			arr[i] = arr[j];
			arr[j] = temp_value;
		}

}


