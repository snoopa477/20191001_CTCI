package util.sorting.quickSort;

//import static java.lang.System.out;
import util.MyArrays;

//I prefer to call it: partition by pivot sort
public class QuickSort {

	public static void sort(int[] arr) {
		sort(arr, 0, arr.length-1);
	}
	
	public static void sort(int arr[], int low, int high) {
		
//		if (low < high == false)
//			return ;
		
		int rightStart = partitionByPivot_returnRightStart(arr, low, high);
		int leftBound = rightStart - 1;
		
		//sort the left half
		//I forgot this line
		if(low < leftBound) {
//			out.println("rightStart " + rightStart + " high " + high);
			sort(arr, low, leftBound);
		}
		
		//sort the right half
		if(rightStart < high) {
//			out.println("rightStart " + rightStart + " high " + high);
			sort(arr, rightStart, high);
		}
	}
	
	
	public static int partitionByPivot_returnRightStart(int arr[], int low, int high){
		
		
		final int pivot = arr[ low + (high - low ) / 2 ];
		//smaller than pivot
		int smaller = low;
		//greater than pivot
		int greater = high;
		
		//repeat operations until low > high,
		//which means the process length decrease to 0 => completion of task 
		while( smaller <= greater ) {
			
			//stop when find the element that is NOT sammller than pivot
			while( arr[smaller] < pivot )
				smaller++;
			
			while( arr[greater] > pivot )
				greater--;
			
			
			if( smaller <= greater ) {
				MyArrays.swap(arr, greater, smaller);
				//since swap, arr[smaller] < pivot && arr[greater] > pivot
				//both index can move on
				smaller++;
				greater--;
			}
			
		}
		//ultmiate result RL or R_L
		//wrong: int left_bound = smaller;
		int rightStart = smaller;
		return rightStart;
	}
	
}


