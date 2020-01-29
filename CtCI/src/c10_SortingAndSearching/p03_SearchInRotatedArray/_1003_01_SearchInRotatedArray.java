package c10_SortingAndSearching.p03_SearchInRotatedArray;


/**
 * 
 * 20200116(Thur 
 */
public class _1003_01_SearchInRotatedArray {
	
	public static int search(int a[], int left, int right, int x) {
		
		int mid = (left + right) / 2;
		
		if( x == a[mid]) {//found element
			return mid;
		}
		
		if( right < left) {
			return -1;
		}
		
		/* Either the left or right half must be normally ordered. Find out which side
		 * is normally ordered, and then use the normal ordered half to figure out 
		 * which side to search to find x.
		 */
		
		if(a[left] < a[mid]) {//left is normally ordered
			if( x >=a[left] && x < a[mid]) {
				return search(a, left, mid -1, x);//search left
			}
			else {
				return search(a, mid + 1, right, x);//search right
			}
			
		}  
		else if( a[mid] < a[left] ) {//right is normally ordered
			if(x > a[mid] && x <= a[right]) {
				return search(a, mid +1, right, x);//search right
			}
			else {
				return search(a, left, mid -1, x);//search left
			}
		}
		else if( a[left] == a[mid]) {//left or irght half is all repeats
			if(a[mid] != a[right]) {//if right is different, search it
				return search(a, mid +1, right, x);//search right
			}
			else {
				int result = search(a, left, mid -1, x);//search left
				if(result == -1) {
					return search(a, mid +1, right,x);//search right
				}
				else {
					return result;
				}
			}
		}
		return -1;
	}
	
}
