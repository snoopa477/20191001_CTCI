package c10_SortingAndSearching.p04_SortedSearchNoSize;


public class _1004_01_MySortedSearchNoSize {

	//usually, an array is with size, so I know the LB, and RB; then,
	//I can use binary search.
	
	//But
	//since there's no size, then I don't no the right boundary.
	//So, I have to get to know the right boundary
	//But, what is right boundary? that at least bigger than the the size of an array ( 
	// so it must be right side of the key
	
	public static int search(Listy listy, int key) {
		
		//search for left and right boundary, that key lies within
		int rightBound = 0;
		//use exclusion method to search the first rightBound, just like how I find pointer
		//wrong: while( listy.elementAt(rightBound) < key || listy.elementAt(rightBound) != -1) {
		while( (listy.elementAt(rightBound) > key 
				|| listy.elementAt(rightBound) == -1 ) == false) {
			rightBound +=1;
			rightBound <<=1;
		}
		//quitting the while loop means we found the rightBound
		//found the rightBound, and we can infer the leftBound based on rightBound
		int leftBound = rightBound >> 1;
		
		
		return binarySearch(listy, key, leftBound, rightBound);
	}
	
	//regular binary search, with extra care with imaginary area, which has value -1
	private static int binarySearch(Listy listy, int key, int leftBound, int rightBound) {
		
		int midIndex = 0;
		
		while(leftBound <= rightBound) {
			midIndex = leftBound + (rightBound - leftBound)/2;
			
			//extra care, the later part 
			if( key < listy.elementAt(midIndex) || listy.elementAt(midIndex) == -1) {
				rightBound = midIndex -1;
				
			}
			else if( listy.elementAt(midIndex) < key) {
				leftBound = midIndex + 1;
			}
			else {
				//"only" if(listy.elementAt(midIndex == key) will go to this block
				//cut off and quit
				return midIndex;
			}
		}
		//cause and effect
		//quitting the while loop means no found
			
		return -1;
		
	}
	
}

