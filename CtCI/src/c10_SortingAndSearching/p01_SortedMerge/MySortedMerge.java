package c10_SortingAndSearching.p01_SortedMerge;

//20191212(Thur
public class MySortedMerge {

	public static void mergeFromBackEnd(int[] dest_array, int[] src_array
			, int length_dest, int length_src) {
		
		int dest_idx = length_dest - 1;
		int src_idx = length_src - 1;
		int merge_idx = length_dest + length_src - 1;
		
		//用while而非for, 因為未必每一次都會--
		while( src_idx >= 0 ) {
			
			//第一個與main logic無觀, 但只是用來檢察further access 不會造成nullPointerException
			//不需要檢核src_idx, 因為外層已經做了
			if(  dest_idx >= 0 && dest_array[dest_idx] > src_array[src_idx] ) {
				dest_array[merge_idx] = dest_array[dest_idx];
				dest_idx--;
			}
			else {
				dest_array[merge_idx] = src_array[src_idx];
				src_idx--;
			}
			
			merge_idx--;
		}
		
		
	}
	
	
}
