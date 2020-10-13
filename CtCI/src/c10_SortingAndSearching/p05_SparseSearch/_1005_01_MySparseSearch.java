package c10_SortingAndSearching.p05_SparseSearch;


//20200218(Tue
public class _1005_01_MySparseSearch {

	public static int search(String[] sparsedSortedStrings, String key) {
		return quasiBinarySearch(sparsedSortedStrings, key, 0, sparsedSortedStrings.length-1);
	}
	
	public static int quasiBinarySearch(String[] sparsedSortedStrings, String key,
			int leftBound, int rightBound) {
		
		int midIndex = leftBound + (rightBound - leftBound)/2;
		
		if(sparsedSortedStrings[midIndex].isEmpty()) {
			midIndex = getIndexWhereStringNotEmpty(sparsedSortedStrings, 
					midIndex, leftBound, rightBound);
			
			if(midIndex == -1) {
				return -1;
			}
		}
		
		if(sparsedSortedStrings[midIndex].compareTo(key) == 0 ) {
			return midIndex;
		}
		else if(sparsedSortedStrings[midIndex].compareTo(key) < 0 ) {
			return quasiBinarySearch(sparsedSortedStrings, key, midIndex + 1, rightBound);
		}
		else {
			return quasiBinarySearch(sparsedSortedStrings, key, leftBound, midIndex - 1);
		}
		
	}

	private static int getIndexWhereStringNotEmpty(String[] sparsedSortedStrings, 
			int midIndex, int leftBound, int rightBound) {
		
		int leftExlorer = midIndex;
		int rightExplorer = midIndex;
		
		
		while(leftBound <= leftExlorer) {
			
			if(sparsedSortedStrings[leftExlorer].isEmpty() == false) {
				return leftExlorer;
			}
			leftExlorer --;
		}
		
		while(rightExplorer <= rightBound) {
			
			if(sparsedSortedStrings[rightExplorer].isEmpty() == false) {
				return rightExplorer;
			}
			rightExplorer ++;
		}
		
		//temp
		return -1;
	}
	
	
	
	
}
