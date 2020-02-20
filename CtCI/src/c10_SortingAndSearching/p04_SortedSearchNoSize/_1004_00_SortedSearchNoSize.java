package c10_SortingAndSearching.p04_SortedSearchNoSize;



public class _1004_00_SortedSearchNoSize {

	public static int  search( Listy list , int key) {
		int index = 1;
		while(list.elementAt(index) != -1 && 
				list.elementAt(index) < key) {
			index *= 2;
		}
		
		return binarySearch(list, key, index/2, index);
			
	}

	private static int binarySearch(Listy list, int key, int leftBound, int rightBound) {
		
		int midIndex;
		
		while(leftBound <= rightBound) {
			midIndex = ( leftBound + rightBound)/2;
			int midValue = list.elementAt(midIndex);
			
			if(midValue > key || midValue == -1) {
				rightBound = midIndex -1;
			
			}
			else if( midValue < key) {
				leftBound = midIndex + 1;
				
			}
			else {
				return midIndex;
			}
			
		}
		
		return -1;
	}
	
}
