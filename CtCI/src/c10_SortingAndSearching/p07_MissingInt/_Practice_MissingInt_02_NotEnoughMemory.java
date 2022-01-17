package c10_SortingAndSearching.p07_MissingInt;
import static java.lang.System.out;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
public class _Practice_MissingInt_02_NotEnoughMemory {
	
	static final boolean IS_DEBUG_ON = true;

	/**
	 * return : -1 meaning failure 
	 */
	public int findMissingInt( String fileName ) throws FileNotFoundException {
		
		Scanner scanner = null;
		scanner = new Scanner( new FileReader(fileName) );
	
		
		/* step1
		 * due to limited memory, we use IntervalsCounter, rather than bitSet
		 */
		int valueRange = 10;
		IntervalsCounter intervalsCounter = new IntervalsCounter(valueRange);
		
		
		/* step2
		 * we store all the numbers in intervals Counter; compared to bitSet, we cannot tell which number exactly missing, but we can tell  which interval the missing number lies within
		 */
		while( scanner.hasNext() ) {
			int number = scanner.nextInt();
			intervalsCounter.addToCounter(number);
		}
		scanner.close();
		
		
		/* step3
		 * find the interval, which missing int lies within. pick it; the interval is small enough to use bitSet
		 */
		//REASONING: if there's no missing int int the interval, that interval's counter = valueRange; likewise, there must exists missing int if counter < valueRange
		int missingIntIdx = -1;
		for( int idx = 0; idx < intervalsCounter.getSize(); idx++) {
			if( intervalsCounter.getCounterAtInterval(idx) < intervalsCounter.getValueRange() ) {
				//if( IS_DEBUG_ON ) out.printf("idx: %4d, counter: %4d \n", idx, intervalsCounter.getCounterAtInterval(idx));
				missingIntIdx = idx;
				break;
			}
		}
		
		
		if( missingIntIdx != -1 ) {
			/* step 4
			 * read file again; using bitSet, this time only record numbers that lies within that interval.  
			 */
			int max_ValueAtInterval = intervalsCounter.get_MaxValueAtInterval(missingIntIdx);
			int min_ValueAtInterval = intervalsCounter.get_MinValueAtInterval(missingIntIdx);
			
			BitSet bitSet = new BitSet(max_ValueAtInterval, min_ValueAtInterval);
			scanner = new Scanner( new FileReader(fileName) );
			
			while( scanner.hasNext() ) {
				int number = scanner.nextInt();
				bitSet.set(number);;
			}
			scanner.close();
			
			
			/* step 5
			 * find the missing integer
			 */
			for( int number = min_ValueAtInterval; number <= max_ValueAtInterval; number++ ) {
				if( bitSet.contains(number) == false ) {
					return number;
				}
			}
		}//if( missingIntIdx != -1 )
		
		return -1;
	}
	
	
	
	private class BitSet{
		
		//PURPOSE: every key is normalized by being subtracted from baseNumber
		private int baseNumber;
		private byte[] indexToOccurence;
		
		
		public BitSet(int maxNumber, int minNumber) {
			
			int numberOfNumbers = maxNumber - minNumber;
			this.baseNumber = minNumber;
			indexToOccurence = new byte[ (numberOfNumbers - 1) /Byte.SIZE + 1];
			
		}
		
		
		public void set(int key) {
			
			//CAUTION don't forget about it
			int normalizedKey = key - baseNumber;
			if( isWithinBoundary(normalizedKey) == false ) {
				return ;
			}
			
			indexToOccurence[ normalizedKey / Byte.SIZE ] = 
					//DETAIL every bit operator's result's type is integer
					(byte) (indexToOccurence[ normalizedKey / Byte.SIZE ] | (byte)(1 << (normalizedKey%Byte.SIZE) ));
		}
		
		
		public boolean contains( int key) {
			
			int normalizedKey = key - baseNumber;
			if( isWithinBoundary(normalizedKey) == false ) {
				return false;
			}
			
			return (byte) (indexToOccurence[ normalizedKey / Byte.SIZE ] & (byte)(1 << (normalizedKey%Byte.SIZE) )) > 0? 
					true : false;
			
		}
		
		
		public void remove( int key) {
			int normalizedKey = key - baseNumber;
			if( isWithinBoundary(normalizedKey) == false ) {
				return ;
			}
			
			indexToOccurence[ normalizedKey / Byte.SIZE ] = 
					(byte) (indexToOccurence[ normalizedKey / Byte.SIZE ] & (byte)~(1 << (normalizedKey%Byte.SIZE) ));
			
		}
		
		
		private boolean isWithinBoundary(int normalizedKey) {
			int index = normalizedKey / Byte.SIZE;
			if( index < 0 || index >= indexToOccurence.length ) {
				return false;
			}
			return true;
		}
	}
	
	
	
	private class IntervalsCounter{
		
		private int valueRange;
		private int[] intervalToCounter;
		private int size;
		
		
		//PURPOSE: decide how many elements should a array have
		public IntervalsCounter(int valueRange) {
			super();
			this.valueRange = valueRange;
			
			//MISTAKE: think before writing it
			//this.intervalToCounter = new int[ ( valueRange + 1 -1 ) / Integer.SIZE + 1 ];
			
			//MISTAKE
			//int size =  ( Integer.MAX_VALUE + 1 -1 ) / valueRange + 1 ;
			this.size =  ( Integer.MAX_VALUE + 1 -1 ) / valueRange + 1 ;
			this.intervalToCounter = new int[ size ];
		}
		
		
		public int getSize() {
			return size;
		}
		
		
		public int getValueRange() {
			return valueRange;
		}
		
		
		public void addToCounter(int value) {
			intervalToCounter[ value/ valueRange ]++;
		}
		
		
		public int get_MaxValueAtInterval(int idx) {
			if( checkBoundary(idx) == false ) {
				return -1;
			}
			return valueRange * idx + valueRange -1;
		}
		
		
		public int get_MinValueAtInterval(int idx) {
			if( checkBoundary(idx) == false ) {
				return -1;
			}
			return valueRange * idx;
		}
		
		
		public int getCounterAtInterval(int idx) {
			if( checkBoundary(idx) == false ) {
				return -1;
			}
			return intervalToCounter[idx];
		}
		
		
		
		private boolean checkBoundary(int idx) {
			if( idx < 0 || idx >= intervalToCounter.length ) {
				return false;
			}
			return true;
		}
	}
	
}


