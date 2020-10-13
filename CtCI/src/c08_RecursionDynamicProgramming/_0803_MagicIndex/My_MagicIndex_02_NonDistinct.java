package c08_RecursionDynamicProgramming._0803_MagicIndex;
//import static java.lang.System.out;

public class My_MagicIndex_02_NonDistinct {
	
	public static int findMagicIndex(int[] arr) {
		return findMagicIndex(arr, 0, arr.length -1 );
	}
	
	//since we're gonna use quasi-BST search, need start and end index
	private static int findMagicIndex(int[] arr, int start_Index, int end_Index){
		
		//other case
		if( start_Index > end_Index ) {
			return -1;
		}
		
		int mid_Index = start_Index + (end_Index - start_Index) / 2;
		
		int leftResult = -1;
		int rightResult = -1;
		
		if(arr[mid_Index] == mid_Index) {
			return mid_Index;
		}
		//compared to textbook, theirs is slightly better
		//, because texbook's answer will cut off as long as the left side has answer(which is >= 0)
		else if( arr[mid_Index] > mid_Index ) {
			leftResult = findMagicIndex(arr, 0, mid_Index -1);
			rightResult = findMagicIndex(arr, arr[mid_Index] +1, end_Index);
		}
		else {
			leftResult = findMagicIndex(arr, 0, arr[mid_Index] -1);
			rightResult = findMagicIndex(arr, mid_Index + 1, end_Index);
		}
		
		if(leftResult >= 0) {
			return leftResult;
		}
		
		if(rightResult >= 0) {
			return rightResult;
		}
		
		return -1;
	}
	
	
}


