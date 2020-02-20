package c10_SortingAndSearching.p03_SearchInRotatedArray;

public class _1003_02_MySearchInRotatedArray {

	public static int binarySearch(int[] A, int key) {
		return binarySearch(A, 0, A.length-1, key);
	}
	
	public static int binarySearch(int[] A, int leftBound, int rightBound, int key) {
		
		//middle index is also my pivot index
		int middleIndex = leftBound + (rightBound - leftBound)/2;
		
		//when matched
		if(A[middleIndex] == key) {
			return middleIndex;
		}
		//non-sense
		if( leftBound > rightBound ) {
			return -1;
		}
		
		//left side is ordered, use that section to do the further inspection
		if(A[leftBound] <A[middleIndex]) {
			
			//use the left side to inspect
			if( A[leftBound] < key && key < A[middleIndex] ) {
				return binarySearch(A, leftBound, middleIndex-1, key);
			}
			else {
				return binarySearch(A, middleIndex + 1, rightBound, key);
			}
		}
		//right side is ordered
		else if(A[leftBound] > A[middleIndex]) {
			
			if( A[middleIndex] < key && key < A[rightBound] ) {
				return binarySearch(A, middleIndex + 1, rightBound, key);
			}
			else {
				return binarySearch(A, leftBound, middleIndex-1, key);
			}
			
		}
		//case when A[leftBound] == A[middleIndex]
		//, need further information. e.g.: A[rightBound]
		else {
			
			//that means the left side all the same, yet !=key => search right side
			if( A[middleIndex] != A[rightBound] ) {
				return binarySearch(A, middleIndex + 1, rightBound, key);
			}
			//A[middleIndex] == A[rightBound]
			//we still cannot decide => try all sections (A[middle] already tried
			else {
				int resultIndex = binarySearch(A, leftBound, middleIndex -1 , key);
				
				if(resultIndex == -1) {
					resultIndex =  binarySearch(A, middleIndex + 1, rightBound, key);
				}
				return resultIndex;
				
			}
			
		}
		
	}
	
	
}
