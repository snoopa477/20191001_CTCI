package c10_SortingAndSearching.p07_MissingInt.testByte;
import static java.lang.System.out;
public class BitSet{
	
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