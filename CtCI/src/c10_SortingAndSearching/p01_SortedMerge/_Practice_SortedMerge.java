package c10_SortingAndSearching.p01_SortedMerge;
import static java.lang.System.out;
public class _Practice_SortedMerge {
	
	
	
	/*
	 * DETAIL
	 * arr_dest: an array that arr_src would merge into
	 */
	public static void merge(int[] arr_dest, int lastIdx_dest, int[] arr_src, int lastIdx_src) {
		
		//checking if condition meets our assumption
		//DETAIL: arr_dest's room left to be filled by arr_src
		int room = arr_dest.length - ( lastIdx_dest + 1 );
		int elementsToFill = (lastIdx_src + 1); 
		if( room < elementsToFill ) {
			return ;
		}
		
		/*
		 * THINK_FURTHER reaching here means arr_dest has enough room for arr_src to fill 
		 */
		
		//REASONING the overwriting from backward is not going to discard any unused element in arr_dest, so no copy of arr_dest is needed, which is different from mergeSort
		/*
		 * DETAIL 
		 * i: index of arr_dest
		 * j: index of arr_src
		 * targetIdx: we start by the last index of mergedArr, which is effective_len(arr_dest) + effective_len(arr_src) -1
		 */
		int targetIdx =  (lastIdx_dest + 1) + (lastIdx_src + 1) -1;
		int i = lastIdx_dest;
		int j = lastIdx_src;
		
		/*
		 * Treat the one of overwriting members: arr_dest is different from to be overwritten target: arr_dest, which is itself
		 */
		int[] arr_i = arr_dest;
		int[] arr_j = arr_src;
		
		//PURPOSE: depletes one of overwriting member
		while( i >= 0 && j >= 0 ) {
			
			if( arr_i[i] > arr_j[j] ) {
				arr_dest[targetIdx] = arr_i[i];
				i--;
				targetIdx--;
			}
			else {
				arr_dest[targetIdx] = arr_j[j];
				j--;
				targetIdx--;
			}
		}
		
		//REASONING if i>= 0, meaning arr_j depletes; however, arr_i = arr_dest, which is exact the same as arr_dest, overwriting is not needed
//		while( i >= 0 ) {
			//do nothing
//		}
		
		
		// j >= 0 meaning arr_i depletes; we continue to depletes another: arr_j
		while( j >= 0 ) {
			arr_dest[targetIdx] = arr_j[j];
			j--;
			targetIdx--;
		}
		
	}
	
}


