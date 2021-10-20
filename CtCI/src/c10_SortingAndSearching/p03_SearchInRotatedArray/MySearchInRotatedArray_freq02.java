package c10_SortingAndSearching.p03_SearchInRotatedArray;
//import static java.lang.System.out;

//2020 0103(Sun)
public class MySearchInRotatedArray_freq02 {
	
	public static int search(int arr[], int key) {
		
		return quasiBinarySearch(arr, 0, arr.length -1, key);
	}
	
	
	
	//backbone
	static int quasiBinarySearch(int arr[], int leftBound, int rightBound, int key) {
		
		int middleIndex = leftBound + ( rightBound - leftBound )/ 2;
		
		
		if( leftBound > rightBound ) {
			return -1;
		}
		
		
		if( arr[middleIndex] == key ) {
			return middleIndex;
		}
		
		
		if( arr[leftBound] < arr[middleIndex] ) {
		
			if( arr[leftBound] < key && key < arr[middleIndex] ) {
				return quasiBinarySearch(arr, leftBound, middleIndex -1, key);
			}
			else {
				return quasiBinarySearch(arr, middleIndex + 1, rightBound, key);
			}
		}
		else if( arr[leftBound] > arr[middleIndex] ) {
			
			if( arr[middleIndex] < key && key < arr[rightBound] ) {
				return quasiBinarySearch(arr, middleIndex + 1, rightBound, key);
			}
			else {
				return quasiBinarySearch(arr, leftBound, middleIndex -1, key);
			}
		}
		//if( arr[leftBound] == arr[middleIndex] )
		else {
			
			if( arr[rightBound] > arr[middleIndex] ) {
				
				return quasiBinarySearch(arr, leftBound, middleIndex -1, key); 
			}
			else if( arr[rightBound] < arr[middleIndex] ) {
				
				return quasiBinarySearch(arr, leftBound, middleIndex -1, key); 
			}
			//arr[rightBound] == arr[middleIndex]
			else {
				
				int left_Result = quasiBinarySearch(arr, leftBound, middleIndex -1, key); 
				if( left_Result == -1) {
					int right_Result = quasiBinarySearch(arr, middleIndex + 1, rightBound, key);
					return right_Result;
				}
				return left_Result;
			}
			
		}
		
	}
}


