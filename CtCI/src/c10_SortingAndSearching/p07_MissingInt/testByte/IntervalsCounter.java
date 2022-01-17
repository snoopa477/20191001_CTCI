package c10_SortingAndSearching.p07_MissingInt.testByte;
import static java.lang.System.out;
public class IntervalsCounter {
	private int valueRange;
	private int[] intervalToCounter;
	
	//PURPOSE: decide how many elements should a array have
	public IntervalsCounter(int valueRange) {
		super();
		this.valueRange = valueRange;
		
		//MISTAKE: think before writing it
		//this.intervalToCounter = new int[ ( valueRange + 1 -1 ) / Integer.SIZE + 1 ];
		this.intervalToCounter = new int[ ( Integer.MAX_VALUE + 1 -1 ) / valueRange + 1 ];
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


