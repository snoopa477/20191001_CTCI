package c05_BitManipulation.p08_Conversion;
import static java.lang.System.out;

import util.BitPrinter;


public class DrawLine {

	
	private static int ONE = 1;
	private static int BYTE_SIZE = 8;
	
	private static int BYTE_INDEX_FIRST = 0;
	private static int BYTE_INDEX_LAST = 7;
	
	public static boolean IS_DEBUG = false;
	
	public static void drawLine(byte[] screen, int x1, int x2, int y, int width) {
		
		/**
		 * example input:
		 * x1 = 5
		 * x2 = 20
		 * width = 24
		 * 
		 * 
		 * byteIndex:
		 *  0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23
		 * [0  0  0  0  0  0  0  0][0  0  0  0  0  0  0  0][0  0  0  0  0  0  0  0] 
		 * [0  0  0  0  0  1  1  1][1  1  1  1  1  1  1  1][1  1  1  1  1  0  0  0]
		 * [0  0  0  0  0  0  0  0][0  0  0  0  0  0  0  0][0  0  0  0  0  0  0  0]
		 * [0  0  0  0  0  0  0  0][0  0  0  0  0  0  0  0][0  0  0  0  0  0  0  0]
		 * 
		 * 
		 * screenIndex:
		 * [ 9                    ][10                    ][11                    ] 
		 * [ 6                    ][ 7                    ][ 8                    ]
		 * [ 3                    ][ 4                    ][ 5                    ]
		 * [ 0                    ][ 1                    ][ 2                    ]
		 * 
		 * ---------------------------------------------------------------------------
		 * x1:						5
		 * byteIndex_x1:			5
		 * screenIndex_zeroTo_x1:	0
		 * 
		 * x2:						20
		 * byteIndex_x2:			6
		 * screenIndex_zeroTo_x2:	2
		 * 
		 */
		
		int byteIndex_x1 = x1 % BYTE_SIZE;
		int screenIndex_zeroTo_x1 = x1 / BYTE_SIZE;
		
		
		int byteIndex_x2 = x2 % BYTE_SIZE;
		int screenIndex_zeroTo_x2 = x2 / BYTE_SIZE;
		
		
		/**
		 * PURPOSE
		 * step 1.0:
		 * find the first and last screen indeces that has full byte, which are set as 1 
		 */
		
		int screenIndex_zeroTo_fullByte_first = byteIndex_x1 == BYTE_INDEX_FIRST?
				screenIndex_zeroTo_x1: 
					screenIndex_zeroTo_x1 + ONE; //next screen index
		
		
		int screenIndex_zeroTo_fullByte_last = byteIndex_x2 == BYTE_INDEX_LAST?
				screenIndex_zeroTo_x2: 
					screenIndex_zeroTo_x2 - ONE; //previous screen index
		
		if( IS_DEBUG ) {
			out.println("byteIndex_x1 " + byteIndex_x1
					+"\nscreenIndex_zeroTo_x1 " + screenIndex_zeroTo_x1
					
					+"\n\nbyteIndex_x2 " + byteIndex_x2
					+"\nscreenIndex_zeroTo_x2 " + screenIndex_zeroTo_x2 
					
					+"\n\nscreenIndex_zeroTo_fullByte_first " + screenIndex_zeroTo_fullByte_first
					+"\nscreenIndex_zeroTo_fullByte_last " + screenIndex_zeroTo_fullByte_last);
		}
		
		
		/**
		 * PURPOSE
		 * step 1.1:
		 * values that has indeces ranges from screenIndex_fullByte_first to screenIndex_fullByte_last
		 * are set to be 1, in one operation
		 */
		int screenIndex_base = ( width / BYTE_SIZE ) * y;
		
		for( int i = screenIndex_zeroTo_fullByte_first; i <= screenIndex_zeroTo_fullByte_last; i++ ) {
			screen[screenIndex_base + i ] |= (byte) 0xFF;
		}
		
		
		/**
		 * PURPOSE
		 * step 2.0:
		 * values that has indeces which byte is not all set, are set based on x1, x2
		 */
		
		/**
		 * PURPOSE:
		 * step 2.1
		 * make mask of byteIndex_x1
		 * 
		 * byteIndex_x1:			5
		 * 
		 *  0  1  2  3  4  5  6  7
		 * [0  0  0  0  0  1  1  1]
		 * 
		 *  1  1  1  1  1  1  1  1 : (byte)0xFF
		 *  0  0  0  0  0  1  1  1 : ((byte)0xFF) >> byteIndex_x1
		 */
		byte mask_byteIndex_x1 = (byte) ( 
			//WRONG not considering leading bit is set as 1, making sh
			//((byte)0xFF) >> byteIndex_x1
			//WRONG: didn't consider the promotion issue when leading bit is set
			//((byte)0xFF) >>> byteIndex_x1
			//0xFF  >>> byteIndex_x1
			0xFF << byteIndex_x1
				);
		
		
		if( IS_DEBUG ) {
			out.println("mask_byteIndex_x1: ");
			out.println( BitPrinter.toBitStringWithHeader(mask_byteIndex_x1) );
		}
		
		
		/**
		 * PURPOSE: 
		 * step 2.2
		 * make mask of byteIndex_x2
		 * 
		 * byteIndex_x2:			6
		 * 
		 *  0  1  2  3  4  5  6  7
		 * [1  1  1  1  1  0  0  0] 
		 * 
		 *  1  1  1  1  1  1  1  1 : (byte)0xFF
		 *  1  1  1  1  1  0  0  0 : (byte)0xFF << ( BYTE_SIZE - (byteIndex_x2 -1) )
		 * 
		 */
		byte mask_byteIndex_x2 = (byte) ( 
			//(byte)0xFF << ( BYTE_SIZE - (byteIndex_x2 - ONE) )
			//0xFF >>  ( byteIndex_x2 - ONE )
			0xFF >>  (  BYTE_SIZE - ( byteIndex_x2 + ONE ) )
				);
		
		if( IS_DEBUG ) {
			out.println("mask_byteIndex_x2: ");
			out.println( BitPrinter.toBitStringWithHeader(mask_byteIndex_x2) );
		}
		
		
		//DETAIL: it's so hard find out this case should be handled separately, unless scrutinize carefully.
		//If both x1 and x2 lies in the same screenIndex, have to merge both masks into one before using it
		if( screenIndex_zeroTo_x1 == screenIndex_zeroTo_x2  ) {
			
			/**
			 * EXAMPLE 
			 * byteIndex_x1:			4
			 * byteIndex_x2:			6
			 * 
			 * 0  1  2  3  4  5  6  7
			 * 0  0  0  0  1  1  1  1
			 * 1  1  1  1  1  1  1  0
			 * AND ) ------------------
			 * 0  0  0  0  1  1  1  0
			 */
			
			byte mask_byteIndex_x1_x2 = (byte) ( mask_byteIndex_x1 & mask_byteIndex_x2 );
			screen[ screenIndex_base + screenIndex_zeroTo_x1 ] |= mask_byteIndex_x1_x2;
		}
		//Set those separately
		else {
			
			screen[ screenIndex_base + screenIndex_zeroTo_x1 ] |= mask_byteIndex_x1;
			screen[ screenIndex_base + screenIndex_zeroTo_x2 ] |= mask_byteIndex_x2;
		}
		
		
	}
	
	
}


