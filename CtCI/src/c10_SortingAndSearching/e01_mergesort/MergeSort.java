package c10_SortingAndSearching.e01_mergesort;

//20191124(Sun
public class MergeSort {

	public static void mergesort(int[] array) {
		int[] helper = new int[array.length];
		mergesort(array, helper, 0, array.length -1);
	}

	private static void mergesort(int[] array, int[] helper, int low, int high) {
		
		if(low < high) {
			int middle = (low + high) / 2 ;
			mergesort(array, helper, low, middle);//sort the left half
			mergesort(array, helper, middle + 1, high);//sort the right half
			merge(array, helper, low, middle, high);//merge them
		}
		
	}

	private static void merge(int[] array, int[] helper, int low, int middle, int high) {
		/*copy both halves into a helper array*/
		for(int i = low; i <=high; i++) {
			helper[i] = array[i];
		}
		
		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;
		
		/*iterate thru helper array, Compare the left and right half, copy back the smaller
		 * element from the 2 halves into the original array.
		 * */
		
		while( helperLeft <= middle && helperRight <= high) {
			
			if(helper[helperLeft] <= helper[helperRight]) {
				array[current] = helper[helperLeft];
				helperLeft++;
			}
			else {//if right elment is smaller than left elt
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}
		
		/*Copy the rest of the left side of the array into the target array
		 * 
		 * */
		int remaining = middle - helperLeft;
		for(int i =0; i <=remaining; i++) {
			array[current + i] = helper[helperLeft + i];
		}
		
	}
	
}
