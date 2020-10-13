package util.sorting.quickSort.otherVersion;

//import static java.lang.System.out;
import util.MyArrays;

public class QuickSort {

	public static void sort(int[] arr) {
		sort(arr, 0, arr.length-1);
	}
	
	public static void sort(int arr[], int low, int high) {
		
		
		int leftBound = partitionByPivot_returnLeftEnd(arr, low, high);
		int rightStart = leftBound + 1;
		
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
	
	
	public static int partitionByPivot_returnLeftEnd(int arr[], int low, int high){
		
		//make pivot_index righter when (high - low)%2 == 1
		//and for syntax it's quite complex! 
		int pivot_index = low + (int)Math.ceil( (double)(high - low ) /2 ) ;
		final int pivot = arr[  pivot_index ];
		
		int smaller = low;
		int greater = high;
		
		while( smaller <= greater ) {
			
			while( arr[smaller] < pivot )
				smaller++;
			
			while( arr[greater] > pivot )
				greater--;
			
			if( smaller <= greater ) {
				MyArrays.swap(arr, greater, smaller);
				smaller++;
				greater--;
			}
			
		}
		//ultmiate result RL or R_L
		int leftEnd = greater;
		return leftEnd;
	}
	
}


