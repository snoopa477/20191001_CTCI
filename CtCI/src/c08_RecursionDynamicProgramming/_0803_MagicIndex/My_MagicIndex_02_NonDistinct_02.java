package c08_RecursionDynamicProgramming._0803_MagicIndex;
//import static java.lang.System.out;
//20201106(Thur
public class My_MagicIndex_02_NonDistinct_02 {

	public static int findMagicIndex(int[] arr) {
		
		return findMagicIndex(arr, 0, arr.length -1);
	}
	
	static int findMagicIndex(int[] arr, int leftBound, int rightBound) {
		
		if( leftBound > rightBound )
			return -1;
		
		int mid = leftBound + (rightBound - leftBound) /2;
		
		if( arr[mid] == mid)
			return mid;
		
		if( arr[mid] > mid ) {
			int leftResult = findMagicIndex(arr, leftBound, mid -1);
			if(leftResult > -1)
				return leftResult;
			
			//int rightResult = findMagicIndex(arr, Math.min(arr[mid] , rightBound), rightBound);
			//int rightResult = findMagicIndex(arr, Math.min(arr[mid] + 1, rightBound), rightBound);
			int rightResult = findMagicIndex(arr, arr[mid] , rightBound);
			
			return rightResult;
		}
		// arr[mid] < mid
		else {
			//int leftResult = findMagicIndex(arr, leftBound,  Math.max( arr[mid] , mid-1));
			//int leftResult = findMagicIndex(arr, leftBound,  Math.max( arr[mid] , leftBound));
			int leftResult = findMagicIndex(arr, leftBound,   arr[mid] );
			if(leftResult > -1)
				return leftResult;
			
			int rightResult = findMagicIndex(arr, mid + 1, rightBound);
			return rightResult;
		}
		
	}
	
}


