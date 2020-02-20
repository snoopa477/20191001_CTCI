package c10_SortingAndSearching.p04_SortedSearchNoSize;


public class Listy {
	
	
	int[] array;
	
	public Listy(int... args) {
		array = args;
	}
	
	
	public int  elementAt(int index) {
		
		if( index >= array.length || index < 0 ) {
			return -1;
		}
		return array[index];
		
	}
	

}
