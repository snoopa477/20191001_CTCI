package c10_SortingAndSearching.p03_SearchInRotatedArray;
import static java.lang.System.out;
public class _Practice_SearchInRotatedArray {
	
	public static int search(int[] arr, int key) {
		
		return search(arr, 0, arr.length -1, key);
		
	}

	private static int search(int[] arr, int left, int right, int key) {
		
		//mid: ONLY this is used for comparing with key
		//THINK_FURTHER using left and right to compare would be redundant, since in the folling sub call the right now left would be futher mid.
		//left, why do we even mention left? because arr[mid] provides not enough information, we need further information: left to decide which part is sorted
		int mid = left + (right - left)/2;
		
		if( arr[mid] == key ) {
			return mid;
		}
		
		if(left > right) {
			return -1;
		}
		
		//boolean isTheSortedAtLeft =  
		
		//DETAIL it's better to write down the reasoning in comment than to coding and thinking reasoing behind it at the same time.
		//left side is sorted -> [left, mid-1] are sorted range. other range is [mid+1, right]
		//sorted value range: arr[left] to arr[mid]
		if( arr[left] < arr[mid] ) {
			
			//sorted side is decided, now, we consider the relationship between key and arr[mid]
			//related: permeates all the options, how you spend all kinds of coins
			if( arr[mid] < key ) {
				//it's non-sorted part, we do it again by calling sub funciton, hopefully this time the key fall into sorted part, which is quick.
				return search(arr, mid+1, right, key);
			}
			else {
				return binarySearch(arr, left, mid -1, key);
			}
			
		}
		//right side is sorted -> [mid + 1, right] are sorted range. other range is [left, mid-1]
		//sorted value range is arr[mid+1] to arr[right]
		else if( arr[left] > arr[mid] ) {
			
			if( arr[mid] < key ) {
				return binarySearch(arr, mid + 1, right, key);
			}
			else {
				return search(arr,left, mid -1, key);
			}
		}
		// arr[left] == arr[mid]
		/*PURPOSE: since arr[left] == arr[mid], index right, and mid cannot provide enough information to decide which side is sorted; 
		 * Therefore, we adopt additional index right to see if we can decide which side is sorted by comparing arr[mid] and arr[right]
		 * However, there is chance that arr[mid] == arr[right] would occur. In this case, we can only rule out indxe mid, and call sun function ranging from all except for mid, hoping that in sub call the key would fall into sorted part.
		 *  
		 */
		//THINK_FURTHER: if additional index 'right' fail to decide which part, how don't we apply furhter additional index '3/4 right', 3/4 left' ...  until we can decide sorted part? That is redundant since we're delegate such job to sub method.
		//THINK_FUTHER 2: if we're going to delegate job sub call, why don't we not use additional index 'right
		else {
			
			//right side is sorted
			if( arr[mid] < arr[right]) {
				if(arr[mid] < key) {
					return binarySearch(arr, mid+1, right, key);
				}
				else {
					return search(arr, left, mid -1, key);
				}
			}
			//left side is sorted
			else if( arr[mid] > arr[right]) {
				if(arr[mid] < key) {
					return search(arr, mid + 1,right, key);
				}
				else {
					return binarySearch(arr, left, mid -1, key);
				}
			}
			//both sides are indeterminate, we can only exclude index mid
			else {
				
				int result = search(arr, left, mid -1, key);
				if(result == -1) {
					return search(arr, mid +1, right, key);
				}
				return result;
				
			}
			
			
		}
	}
	
	
	private static int binarySearch(int[] arr, int left, int right, int key) {
		
		while( left <= right ) {
			
			int mid = left + ( right - left ) /2;
			
			if( arr[mid] == key  ) {
				return mid;
			}
			
			if( arr[mid] < key ) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
			
			
		}
		
		return -1;
	}
	
}


