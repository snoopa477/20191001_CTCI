package c05_BitManipulation.p08_Conversion;
import static java.lang.System.out;

import util.BitPrinter;
public class Test_byteShiftment {

	
	public static void main(String[] args) {
		
		{
			//cannot convert from int to byte
			//byte a = 0xFF;
			
			byte a = (byte)0xFF;
			byte b = -1;
			
			int ia = a;
			int iaa = 0xFF;
			
			/**
a: -1
  7  6  5  4  3  2  1  0
  1  1  1  1  1  1  1  1 
			 */
			out.println("a: " + ( a ));
		    out.println( BitPrinter.toBitStringWithHeader(a) );
		    
		    /*
b: -1
  7  6  5  4  3  2  1  0
  1  1  1  1  1  1  1  1
		     * */
		    out.println("b: " + ( b ));
		    out.println( BitPrinter.toBitStringWithHeader(b) );
		    
		    /**
ia: -1
 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10  9  8  7  6  5  4  3  2  1  0
  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1 
		     */
		    out.println("ia: " + ( ia ));
		    out.println( BitPrinter.toBitStringWithHeader(ia) );
		    
		    /*
iaa: 255
 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10  9  8  7  6  5  4  3  2  1  0
  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  1  1  1  1  1  1  1  1
-
		     */
		    out.println("iaa: " + ( iaa ));
		    out.println( BitPrinter.toBitStringWithHeader(iaa) );
			
		}
		
		out.println("------------------------------");
		
		{
			//https://stackoverflow.com/questions/36454932/weird-behaviour-of-bit-shifting-with-byte-in-java
			byte b1 = Byte.MIN_VALUE; //b1 = -128
		    
		    out.println("b1");
		    out.println( BitPrinter.toBitStringWithHeader(b1) );
		    out.println("b1 >> 7");
		    out.println( BitPrinter.toBitStringWithHeader(b1 >> 7) ); //b1 = -1
		    

		    byte b2 = Byte.MIN_VALUE; //b2 = -128
		    
		    out.println("b2");
		    out.println( BitPrinter.toBitStringWithHeader(b2) );
		    
		    out.println("b2 >>> 0: " + ( b2 >>> 0 ));
		    out.println( BitPrinter.toBitStringWithHeader(b2 >>> 0) );
		    
		    out.println("b2 >>> 6: " + ( b2 >>> 6 ));
		    out.println( BitPrinter.toBitStringWithHeader(b2 >>> 6) );
		    
		    out.println("(byte)( b2 >>> 6 ): " + (byte)( b2 >>> 6 ));
		    out.println( BitPrinter.toBitStringWithHeader( (byte)( b2 >>> 6 )) );
		    
		    out.println("b2 >>> 7: " + ( b2 >>> 7 ));
		    out.println( BitPrinter.toBitStringWithHeader(b2 >>> 7) );
		    
		    out.println("(byte)( b2 >>> 7 ): " + (byte)( b2 >>> 7 ));
		    out.println( BitPrinter.toBitStringWithHeader((byte)( b2 >>> 7 )) );
		    
		    out.println("(b2 & 0xFF) >>> 7: " + ( (b2 & 0xFF) >>> 7 ));
		    out.println( BitPrinter.toBitStringWithHeader((b2 & 0xFF) >>> 7) );
		    
		    out.println("b2 >>> 8");
		    out.println( BitPrinter.toBitStringWithHeader(b2 >>> 8) );
			
		}
		
		

	}
	
}


