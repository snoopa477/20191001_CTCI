package c10_SortingAndSearching.p11_PeaksAndValleys;
import static java.lang.System.out;
public class _Practice_PeaksAndValleys_01_swapTwoElt {

	public static final boolean IS_DEBUG_ON = false;
	
	public static void makePeakValley(int[] arr) {
		
		_Practice_MergSort.sort(arr);
		
		/* REASONING
		 * now we have sorted array
		 * a1, a2, a3, a4, a5, a6
		 * 
		 * make peak and valley
		 * 
		 * before:
		 * 0  , 1  ,  2 , 3  ,  4 , 6
		 * [a1, a2], [a3, a4], [a5, a6]
		 * 
		 * after:
		 * 0  , 1  ,  2 , 3  ,  4 , 6
		 * [a2, a1], [a4, a3], [a6, a5]
		 * 
		 * index i, where i % 2 ==0, compared to left neighbor, its value get even greater; and for right neighbor, its value now greater than right neighbor => index i is peak
		 * index i, where i % 2 == 1, its value get smaller, and smaller than left neighbor; and for right neighbor, either they swapped or not, still greater than index i value => index i is valley
		 * 
		 */
		
		//PURPOSE: swap the element with the previous one
		for( int i = 1; i < arr.length; i+=2 ) {
			swap( arr, i , i-1 );
		}
		
	}
	
	
	
	private static void swap(int[] arr, int i, int j) {
		
		if( IS_DEBUG_ON ) {
			out.printf("Before: %d\t%d\t", arr[i], arr[j]);
		}
		
		//MISTAKE: sometimes what I typed doesn't follow what I actually think
		//arr[j] = ( arr[i] + arr[j] ) + (arr[i] = arr[j]);
 
		arr[j] = ( arr[i] + arr[j] ) - (arr[i] = arr[j]);
		
		if( IS_DEBUG_ON ) {
			out.printf("After: %d\t%d\n", arr[i], arr[j]);
		}
		
	}
}



