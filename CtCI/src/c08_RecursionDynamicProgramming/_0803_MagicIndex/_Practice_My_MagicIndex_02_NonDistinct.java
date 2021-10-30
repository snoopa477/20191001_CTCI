package c08_RecursionDynamicProgramming._0803_MagicIndex;
import static java.lang.System.out;
public class _Practice_My_MagicIndex_02_NonDistinct {

	public static int getMagicIndex(int[] arr) {
		
		int left = 0;
		int right = arr.length -1;
		
		return getMagicIndexHelper(arr, left, right);
	}
	
	private static int getMagicIndexHelper(int[] arr, int left, int right) {
		
		// not found
		if( left > right ) {
			return -1;
		}
		
		int mid = left + (right - left) /2;
		
		if(arr[mid] == mid ) {
			return mid;
		}
		
		//REASONING in this case, the section [ mid, arr[mid] ] is impossible to find magix index, we try to search other 2 sections instead
		if(arr[mid] > mid) {
			
			//section 1
			int result = getMagicIndexHelper(arr, left, mid -1);
			
			//if we fail to find magic index in section 1, seek further in section 2
			if( result == -1 ) {
				result = getMagicIndexHelper(arr, arr[mid] + 1, right);
			}
			
			return result;
		}
		
		//DETAIL if(arr[mid] < mid)
		
		//section 1
		int result = getMagicIndexHelper(arr, left, arr[mid] - 1 );
		
		//if we fail to find magic index in section 1, seek further in section 2
		if( result == -1 ) {
			result = getMagicIndexHelper(arr, mid + 1, right);
		}
		
		return result;
	}
	
	
}


