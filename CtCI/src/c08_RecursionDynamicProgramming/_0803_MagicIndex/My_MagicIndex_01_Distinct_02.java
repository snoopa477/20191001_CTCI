package c08_RecursionDynamicProgramming._0803_MagicIndex;
//import static java.lang.System.out;
public class My_MagicIndex_01_Distinct_02 {
	
	static int findMagicIndex(int[] arr) {
		
		int leftIdx = 0;
		int rightIdx = arr.length -1;
		
		while( leftIdx <= rightIdx ) {
			
			int midIdx = leftIdx + (rightIdx - leftIdx) /2;
			
			if( arr[midIdx] == midIdx ) {
				return midIdx;
			}
			
			if( arr[midIdx] > midIdx ) {
				rightIdx = midIdx -1;
			}
			else {
				leftIdx = midIdx +1;
			}
			
		}
		
		
		return -1;
	}
	

}


