package c10_SortingAndSearching.p08_FindDuplicates;
import static java.lang.System.out;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
public class _Practice_FindDuplicates {
	
	final private boolean isDebugOn = false;
	
	public int findDuplicate(String fileName, int maxValue, int minValue) {
		
		
		
		try {
			Scanner scanner = new Scanner( new FileReader(  fileName ));
			BitSet bitSet = new BitSet(maxValue, minValue);
			
			if( isDebugOn )  out.println("array size is " + bitSet.arraySize);
			
			while( scanner.hasNextInt() ) {
				
				int num = scanner.nextInt();
				if( isDebugOn )  out.printf("num is %d", num );
				if( bitSet.contains(num) ) {
					return num;
				}
				else {
					bitSet.set(num);
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return -1;
		
	}
	
	
	private class BitSet{
		
		private int[] valueToOccurence;
		private int arraySize;
		private int offset;
		
		public BitSet(int max_Value, int min_Value) {
			this.offset = min_Value;
			//this.arraySize = (( maxValue - maxValue ) + 1 - 1 ) >> 5 + 1;
			//MISTAKE, that would cause the size as 1, and then other number would fall outside the range
			//this.arraySize = (( maxValue - maxValue ) + 1 - 1 ) /Integer.SIZE + 1;
			this.arraySize = (( max_Value - min_Value ) + 1 - 1 ) /Integer.SIZE + 1;
			this.valueToOccurence = new int[ arraySize ];
		}
		
		
		public void set(int key) {
			int normalizedKey = key - offset;
			if(isWithinRange(normalizedKey) == false ) {
				return ;
			}
			
			valueToOccurence[ normalizedKey / Integer.SIZE ] =
				//valueToOccurence[ normalizedKey / Integer.SIZE ] | (1 << ( normalizedKey &0b111 ) );
				valueToOccurence[ normalizedKey / Integer.SIZE ] | (1 << normalizedKey%Integer.SIZE);
		}
		
		
		public boolean contains(int key ) {
			int normalizedKey = key - offset;
			if(isWithinRange(normalizedKey) == false ) {
				return false;
			}
			
			//ERROR: The operator & is undefined for the argument type(s) int, boolean. FIX: add parenthesis
			//boolean result = valueToOccurence[ normalizedKey / Integer.SIZE ] & (1 << normalizedKey%Integer.SIZE)!= 0? true : false;
			
			boolean result = (valueToOccurence[ normalizedKey / Integer.SIZE ] & (1 << normalizedKey%Integer.SIZE)) != 0? true : false;
			//ERROR IllegalFormatConversionExceptoin
			//out.printf("normalizedKey %4d, result %4d\n", normalizedKey, result);
			if( isDebugOn ) out.printf("normalizedKey %4d, result %b\n", normalizedKey, result);
			return result;
		}
		
		
		public void remove(int key ) {
			int normalizedKey = key - offset;
			if(isWithinRange(normalizedKey) == false ) {
				return ;
			}
			
			valueToOccurence[ normalizedKey / Integer.SIZE ] =
					valueToOccurence[ normalizedKey / Integer.SIZE ] & ~(1 << normalizedKey%Integer.SIZE);
		}
		
		
		private boolean isWithinRange(int normalizedKey) {
			
			int index = normalizedKey / Integer.SIZE;
			if( index < 0 || index >= arraySize ) {
				return false;
			}
			return true;
		}
		
	}
	
}


