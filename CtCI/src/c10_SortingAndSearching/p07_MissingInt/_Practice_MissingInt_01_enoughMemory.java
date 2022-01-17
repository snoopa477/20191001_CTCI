package c10_SortingAndSearching.p07_MissingInt;
import static java.lang.System.out;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
public class _Practice_MissingInt_01_enoughMemory {

	public int findMissingInteger( String fileName ) {
		
		BitSet bitSet = new BitSet();
		int result = -1;
		
		try {
			//PURPOSE: read numbers from file, and get them recorded in bitSet 
			Scanner scanner = new Scanner( new FileReader(fileName) );
			while( scanner.hasNextInt() ) {
				int number = scanner.nextInt();
				bitSet.set( number );
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			
		//PURPOSE: examine number from 0 to Integer.MAX, see if any integer missed
		for(int number = 0; number <=Integer.MAX_VALUE; number++) {
			if( bitSet.contains(number) == false ) {
			//if( bitSet.contains(number) ) {
				result = number;
				break;
			}
		}
		
		
		//bitSet.showBitSet();
		//REASONING: reaching here meaning bitSet is exhausted and every element( number) is contained -> no missing 
		return result;
	}
	
	
	
	
	private class BitSet{
		
		private byte[] valueToOccurence;
		private int maxKey;
		
		/**
		 * max value would be Integer.Max, which is 2^31 -1 
		 */
		public BitSet() {
			
			/*REASONING: we have 0 to Integer.MAX_VALUE to record, so add 1
			 */
			valueToOccurence = new byte[ (Integer.MAX_VALUE + 1 - 1)/ Byte.SIZE + 1];
			maxKey = -1;
			
		}
		
		
		
		public void set(int key) {
			valueToOccurence[ key/ Byte.SIZE ] = 
					//ERROR Type mismatch: cannot convert from int to byte. the result data type is integer, downcast might change its decimal value
					//(valueToOccurence[ key/ Byte.SIZE ] | ( 1 << ( key%Byte.SIZE ) ) ) ;
					(byte)(valueToOccurence[ key/ Byte.SIZE ] | ( 1 << ( key%Byte.SIZE ) ) ) ;
			
			if( key > maxKey) {
				maxKey = key;
			}
			
		}
		
		
		
		public boolean contains( int key ) {
			/*WRONG: When number is 7, the valueToOccurence is 1000 0000, if we CAST the data type as byte, it is translated as negative.
			However, to decide its real type, the former evaluation  valueToOccurence[ key/ Byte.SIZE ]' type is byte; later evaluation  ( 1 << ( key%Byte.SIZE ) ) is integer. Before two evaluations get calculated by &, the former part's data type is ascended to integer, so the data type is integer
			Therefore, 1000 0000 in type integer is positive
			 * 
			 */
			// WRONG WRONG: when number is 7, if dataType is byte, the 1111 wo
			//return (byte)(valueToOccurence[ key/ Byte.SIZE ] & ( 1 << ( key%Byte.SIZE ) ) ) >0? true: false;
			return (valueToOccurence[ key/ Byte.SIZE ] & ( 1 << ( key%Byte.SIZE ) ) ) >0? true: false;
		}
		
		
		
		public void remove(int key) {
			valueToOccurence[ key/ Byte.SIZE ] = 
					(byte)(valueToOccurence[ key/ Byte.SIZE ] & ~( 0 << ( key%Byte.SIZE ) ) ) ;
		}
		
		
		
		public void showBitSet() {
			//MISTAKE: if maxKey is 99, then it will only print 95
			//for( int i = 0; i < ( maxKey + 1 -1 )/Byte.SIZE; i++ ) {
			for( int i = 0; i < ( maxKey + 1 -1 )/Byte.SIZE + 1; i++ ) {
				for( int j = 0; j < Byte.SIZE; j++ ) {
					int number = i * Byte.SIZE + j;
					out.println(number + ": " + ( (valueToOccurence[ i ] & ( 1 << j ) ) > 0? "1": "0")  );
				}
			}
		}
	}
}


