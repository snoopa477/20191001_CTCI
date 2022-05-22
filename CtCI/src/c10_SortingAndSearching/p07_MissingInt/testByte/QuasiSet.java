package c10_SortingAndSearching.p07_MissingInt.testByte;
import static java.lang.System.out;

import java.util.ArrayList;

/**
 * maxValue: only records value between 0 to maxValue( inclusive)  
 */
public class QuasiSet {
	
	private final static int BYTE_SIZE_BITS = 8;
	
	private int maxValue ;
	public byte[] indexToExistence;
	

	public QuasiSet(int maxValue) {
		this.maxValue = maxValue;
		int totalElement = maxValue + 1;
		//DETAIL: given x and y, x == x / y + x % y
		int arraySize = ( totalElement -1 ) / BYTE_SIZE_BITS + 1;
		indexToExistence = new byte[ arraySize ];
	}
	
	
	public void put(int value) {
		if( value >= 0 && value <= maxValue ) {
			int blocksIndex = value / BYTE_SIZE_BITS;
			int indexInBlock = value % BYTE_SIZE_BITS;
			//WRONG this would replace other set bit as 0
			//indexToExistence[ blocksIndex ] = (byte) ( 1 << indexInBlock );
			
			//MISTKAE the whole evaluation is treated as int
			//indexToExistence[ blocksIndex ] = indexToExistence[ blocksIndex ] | (byte) ( 1 << indexInBlock );
			//TIP to set, or 1
			indexToExistence[ blocksIndex ] = (byte)(indexToExistence[ blocksIndex ] | (byte) ( 1 << indexInBlock ));
		}
	}
	
	
	public boolean contains( int value ) {
		if( value >= 0 && value <= maxValue ) {
			int blocksIndex = value / BYTE_SIZE_BITS;
			int indexInBlock = value % BYTE_SIZE_BITS;
			
			boolean result = ( indexToExistence[ blocksIndex ] & (byte)( 1 << indexInBlock ) )> 0? true : false;
			return result;
		}
		else {
			return false;
		}
	}
	
	
	public void remove(int value) {
		if( value >= 0 && value <= maxValue ) {
			int blocksIndex = value / BYTE_SIZE_BITS;
			int indexInBlock = value % BYTE_SIZE_BITS;
			//ERROR: connot convert from int to type
			//indexToExistence[ blocksIndex ] = (indexToExistence[ blocksIndex ] & (byte) (~( 1 << indexInBlock )));
			
			//REASONING: since we cannot move 0 >> indexInBlock directly, we use complement instead
			//TIP: to set, AND 0
			indexToExistence[ blocksIndex ] = (byte)(indexToExistence[ blocksIndex ] & (byte) (~( 1 << indexInBlock )));
		}
	}
	
	
	public void printIndexToExistence() {
		
		int size = indexToExistence.length;
		for( int i = size -1; i >=0; i-- ) {
			out.print(  String.format("%8s",  Integer.toBinaryString( (int)indexToExistence[i] )).replace(' ', '0')  + " ");
		}
		out.println();
	}
	
	
	public ArrayList<Integer> getAllPutNumbers(){
		
		ArrayList<Integer> result = new ArrayList<>();
		/*
		for( int i = 0; i < indexToExistence.length; i++ ) {
			for(int j = 0; j < BYTE_SIZE_BITS; j++) {
				if( contains()   )
			}
		}*/
		
		for(int i = 0; i <= maxValue; i++) {
			if(contains(i)) {
				result.add(i);
			}
		}
		
		return result;
	}

}


