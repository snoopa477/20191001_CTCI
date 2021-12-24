package c10_SortingAndSearching.p04_SortedSearchNoSize;
import static java.lang.System.out;
public class _Practice_SortedSearchNoSize {

	private static final boolean IS_DEBUG_ON = true;
	
	public static int search(Listy listy, int key) {
		
		
		int right = findRightBound(listy, key);
		int left = right/2;
		//REASONING: we're now sure that key falls between left and right
		if(IS_DEBUG_ON) out.println("hi");
		int result = binarySearch(listy, left, right, key);
		
		return result;
	}
	
	//PURPOSE: the rightBound such that rightBound is at the right side of the key
	public static int findRightBound(Listy listy, int key) {
		
		int rightBound = 1;
		
		//REASONING: compared to situation where index must lie within array length, there are two cases that right index is at the right side of a key: 1: arr[right] > key 2. right is out of boundary
		//DETAIL: I feel like handling special value -1 is like handing checking object is null? gotta deal with special value -1 FIRST, before doing something else 
		//MISTAKE
		//while( listy.elementAt(rightBound) != -1 || listy.elementAt(rightBound) < key   ) {
		while( (listy.elementAt(rightBound) == -1 ||  key < listy.elementAt(rightBound)) == false ) {
			rightBound <<= 1;
		}
		
		
		return rightBound;
	}
	
	
	
	private static int binarySearch( Listy listy, int left, int right, int key ) {
		
		int mid = left + (right - left) /2;
		
		while( left <= right ) {
			
			 mid = left + (right - left) /2;
			
			if( listy.elementAt(mid) == key ) {
				return mid;
			}
			else if( isKeySmaller(listy, key, mid)   ) {
				right = mid -1;
			}
			//key is larger
			else {
				left = mid + 1;
			}
		}
		
		return -1;
	}
	
	
	//REASONING: if I treat index which is greater than array's length as an extension of sorted array, then I can say arr[index] is also larger than key
	private static boolean isKeySmaller( Listy listy, int key, int pivot ) {
		
		if( listy.elementAt(pivot) == -1 || key < listy.elementAt(pivot) ) {
			return true;
		}
		
		return false;
		
	}
	
	
}


