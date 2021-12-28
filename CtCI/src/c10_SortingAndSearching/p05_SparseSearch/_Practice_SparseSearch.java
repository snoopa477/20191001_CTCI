package c10_SortingAndSearching.p05_SparseSearch;
import static java.lang.System.out;
public class _Practice_SparseSearch {

	
	public static int search(String[] sortedStrs, String key) {
		
		return sparseSearch(sortedStrs, 0, sortedStrs.length -1, key);
	}
	
	
	
	private static int sparseSearch(String[] sortedStrs, int left, int right, String key ) {
	
		while( left <= right ) {
			/*
			 * mid: index point that might points to null String, index value is left + ( right - left ) /2
			 * validMid: index that actually points to non-null String; however, index value deviates from mid
			 */
			int validMid = getValidMid(sortedStrs, left, right);
			
			//That means no validMid to use within left and right => end search
			if( validMid == -1 ) {
				return -1;
			}
			
			if(sortedStrs[validMid].compareTo(key) == 0) {
				return validMid;
			}
			if( sortedStrs[validMid].compareTo(key) < 0 ) {
				left = validMid + 1;
			}
			//sortedStrs[validMid].compareTo(key) > 0
			else {
				right = validMid - 1;
			}
			
		}
		
		
		//temp
		return -1;
	}
	
	
	
	//REASONING: if we cannot get board on valid values, then using mid to compare is meaningless
	private static int getValidMid(String[] sortedStrs, int left, int right) {
		
		int mid = left + ( right - left ) /2;
		//WRONG: emptry string is not null
		//if( sortedStrs[mid] != null ) {
		if( sortedStrs[mid].isEmpty() == false ) {
			return mid;
		}
		
		
		int left_ValidMid = mid - 1;
		//REASONING: left_ValidMid has to lies between left and right; since we move left, the right boundary won't be violated -> don't have to be checked
		//while( leftValidMid >= 0 && sortedStrs[leftValidMid].isEmpty() ) {
		while( left_ValidMid >= left && sortedStrs[left_ValidMid].isEmpty() ) {
			left_ValidMid--;
		}
		
		if( left_ValidMid >= left && sortedStrs[left_ValidMid].isEmpty() == false ) {
			return left_ValidMid;
		}
		
		
		//REASONING: reaching here meaning leftValidMid is not found; we attempt to find rightValid mid in the same way, with opposite direction.
		int right_ValidMid = mid + 1;
		//while( rightValidMid < sortedStrs.length && sortedStrs[rightValidMid].isEmpty() ) {
		while( right_ValidMid <= right && sortedStrs[right_ValidMid].isEmpty() ) {
			right_ValidMid++;
		}
		
		if(right_ValidMid <= right && sortedStrs[right_ValidMid].isEmpty() == false ) {
			return right_ValidMid;
		}
		
		
		//REASONING: reaching here meaning both rightValidMid and leftValidMid is not found,d
		return -1;
	}
	
	
	
	
	
	
}


