package c10_SortingAndSearching.p04_SortedSearchNoSize;
//import static java.lang.System.out;

//2021 0106(Wed)
public class MySortedSearchNoSize_freq02 {
	
	
	//I feel like adding final modifier would be better, helping debugging for the future
	public static int binarySearch(Listy listy, final int key) {
		
		int rightBound = findRightBound(listy, key);
		int leftBound = findLeftBound(rightBound);
		
		
		while( leftBound <= rightBound ) {
			
			int mid_Index = leftBound + ( rightBound - leftBound ) /2;
			int mid_Value = listy.elementAt(mid_Index);
			
//			out.println("mid index: " + mid_Index + "; mid value: " + mid_Value + "; key: " + key);
			
			//mistake: didn't take mid_value == -1 into account, that will cause midIndex move right
//			if( mid_Value < key ) {
			if( mid_Value < key && mid_Value != -1 ) {
				leftBound = mid_Index + 1;
			}
			else if( key < mid_Value || mid_Value == -1 ) {
				rightBound = mid_Index -1 ;
			}
			//if ( key == midValue )
			else{
				return mid_Index;
			}
		}
		
		return -1;
	}
	
	
	
	//backbone
	static int findRightBound(Listy listy, int key) {
		
		int rightBound = 1;
		
		int val_rightBound = listy.elementAt(rightBound);
		//mistake : must think the assumption clearly
		//while( !( val_rightBound < key || val_rightBound == -1 ) ){
		while( !( key < val_rightBound || val_rightBound == -1 ) ){
			rightBound <<= 1;
			val_rightBound = listy.elementAt(rightBound);
		}
		
		return rightBound;
	}
	
	
	
	static int findLeftBound(int rightBound) {
		return rightBound >> 1;
	}
}


