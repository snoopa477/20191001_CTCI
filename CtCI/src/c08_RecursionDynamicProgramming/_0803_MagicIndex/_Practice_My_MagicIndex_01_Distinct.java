package c08_RecursionDynamicProgramming._0803_MagicIndex;
import static java.lang.System.out;
public class _Practice_My_MagicIndex_01_Distinct {
	
	//PURPOSE return -1 means not found
	//REASONING sorted array is good for binary search
	public static int getMagicIndex(int[] arr) {
		
		int left = 0;
		int right = arr.length -1;
		//DETAIL avoid overflowing
		int mid = left + (right - left) /2;
		
		//PURPOSE index mid is our pivot index, where we inspect its value, and decide what to do next
		while( left <= right ) {
			
			//PURPOSE to search for first round, or the next round, update mid
			mid = left + (right - left) /2;
			
			  
			if(arr[mid] == mid) {
				return mid;
			}
			
			//DETAIL since magic index's line x = y. x-axis = mid, then y-axis = mid as well
			//REASONING there's no chance magic index lies at index, which is greater than mid; so we search for left by resetting the boundary: left/ right
			if( arr[mid] > mid ) {
				
				right = right -1;
			}
			else {
				left = left + 1;
			}
		}
		
		
		//temp
		return -1;
	}
	
	
}


