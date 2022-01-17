package c10_SortingAndSearching.p07_MissingInt.testByte;
import static java.lang.System.out;
public class Test_CastByte {

	public static void main(String[] arg) {
		
		byte byte1 = 3;
		byte byte2 = 4;
		//ERROR: Type mismatch: cannot convert from int to byte
		//byte byte3 = byte1 | byte2;
		
		byte byte3 = (byte) (byte1 | byte2);
		
		//ERROR: Type mismatch: cannot convert from int to byte
		//byte byte4 = (byte)byte1 | (byte)(byte2);
		
		byte byte4 = (byte) ((byte)byte1 | (byte)(byte2));
		
		
	}
	
}


