package c01_ArraysAndStrings.p01_IsUnique;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;

public class isUnique_02_ASCIISet {
	
	static final public int NUMBER_VISIBLE_CHARS = 128;
	
	static boolean isUniqu(String str) {
		
		//if( str == null || str.length() == 0) {
		//REASONING: all presentatable number of chars is 128; over that number meaning there must exist duplication
		//if( str == null || str.length() == 0 || str.length() > 128) {
		if( str == null || str.length() == 0 || str.length() > NUMBER_VISIBLE_CHARS) {
			return true;
		}
		
		
		ASCIISet set = new ASCIISet();
		for( int i = 0; i < str.length(); i++ ) {
			//DETAIL: we'd like to process in each iteration
			char currentChar = str.charAt(i);
			
			if( set.contains(currentChar) ) {
				return false;
			}
			
			set.put( currentChar );
			
		}
		
		
		//THINK_FURTHER: reaching here meaning none of char duplicates -> unique
		return true;
	}
	
	
	
	//ERROR: No enclosing instance is accessible. Must qualify the allocation with an enclosing instance of type (e.g. x.new A() where x is an instance of )
	//class ASCIISet{
	
	/** each bit of integers's value ( 1 or 0 ) indicates whether that mapped value from corresponding index exist or not? 
	 * <br> if mapping is not specified, there's implicit one: a key value == index of a bit
	 * <br> 
	 */
	static class ASCIISet{
		
		public static final int MAX_ASCII_CODE = 127;
		public static final int MIN_ASCII_CODE = 0;
		//integer size in bits
		private static final int BLOCK_SIZE = Integer.SIZE;
		private int totalElements;
		private int blocks[];
		
		public ASCIISet() {
			
			this.totalElements = MAX_ASCII_CODE - MIN_ASCII_CODE + 1;
			/* REASONING: about blocks, or basket that holds apples
			 * in Java language, given x is number of apple, y is number of apple that a basket can hold
			 * if x < y, x / y = 0; that doesn't meet our need that y should be 1
			 * 
			 * To do so, we separate apples into two groups: x-1, and 1
			 * number of basket of group1 is (x-1) / y
			 * number of basket of group2 is 1. We use another basket to hold this one apple, and those group1 apples which cannot be crammed into group1 basket 
			 * 
			 * Therefore, if x < y 
			 * then number of basket y is (x -1 ) / y + 1 = 0 + 1 = 1
			 * which means group2 basket not only holds single apple but also all group1 apples
			 */
			//NOTICE: -1 is apple, +1 is basket; here we doens't even mention group2 single apple in code. Use your imagination
			int totalBlocks = ( totalElements - 1 ) / BLOCK_SIZE + 1;
			blocks = new int[ totalBlocks ];
			
		}
		
		
		
		public boolean contains( int key ) {
			
			//have to meet the prerequisite before proceeding
			if( key < MIN_ASCII_CODE || key > MAX_ASCII_CODE ) {
				return false;
			}
			
			int block_index = key / BLOCK_SIZE;
			int bitOffset_index = key % BLOCK_SIZE;
			
			//THINK_FURTHER: other bits which index are not bitOffset_index set as 0; those which are not mentioned in code are hardly to be considered at first sight
			/* REASONING
			 * 0?00...0 | 0100...0
			 * if ? is 1, then the evaluation value is 2^(bitIndex of ?); however, how high the value doesn't matter; ? that has 1 shares in common is all evaluation > 0
			 * if ? 0, evaluation is 0
			 */
			return (blocks[ block_index ] & ( 1 << bitOffset_index ) ) > 0;
			
		}
		
		
		
		public void put( int key ) {
			
			if( key < MIN_ASCII_CODE || key > MAX_ASCII_CODE ) {
				return;
			}
			
			int block_index = key / BLOCK_SIZE;
			int bitOffset_index = key % BLOCK_SIZE;
			
			/* DETAIL: too much steps that serve different concepts all at once, that make things difficult and confusing, because recognizing and differentiating takes effort  
			 * however, due to language limitation, steps cannot be described by several lines.
			 */
			blocks[ block_index ] = blocks[ block_index ]  | ( 1 << bitOffset_index );
			
		}
		
		
		
		public void remove( int key ) {
			
			if( key < MIN_ASCII_CODE || key > MAX_ASCII_CODE ) {
				return;
			}
			
			int block_index = key / BLOCK_SIZE;
			int bitOffset_index = key % BLOCK_SIZE;
			
			//THINK_FURTHER: &0 means set 0; however & ~1 is used instead because unspecified bits have to be 1
			blocks[ block_index ] = blocks[ block_index ]  & ~( 1 << bitOffset_index );
			
		}
		

		
		public String toString() {
			
			StringBuffer stringBuffer = new StringBuffer();
//			Arrays.asList( blocks ).forEach( block -> stringBuffer.append( String.format( "%s ", Integer.toBinaryString( block )) ) );
			
			for( int i = blocks.length-1; i >=0 ; i-- ) {
				stringBuffer.append( String.format("%s ", Integer.toBinaryString( blocks[i] ) ) );
			}
			
			return stringBuffer.toString();
		}
		
		
	}
	
	
	
	//PURPOSE: test ASCIISet
	public static void main(String[] args) {
		ASCIISet as = new ASCIISet();
		out.println( as.toString() );
		
		out.println("\nset 11");
		as.put(11);
		out.println( as.toString() );
		
		out.println("\nset 9");
		as.put( 9 );
		out.println( as.toString() );
		
		out.println("\nremove 11");
		as.remove( 11 );
		out.println( as.toString() );
		
		out.println("\nset 1008( which is out of boundary) ");
		as.put( 1008 );
		out.println( as.toString() );
		
		out.println("\nset 97");
		as.put(97);
		out.println( as.toString() );
		
		out.println("\nset 127");
		as.put(127);
		out.println( as.toString() );
		
		
		out.println("\ncontains 0");
		out.println(as.contains(0));
		
		out.println("\nset 0");
		as.put(0);
		out.println( as.toString() );
		
		out.println("\ncontains 0");
		out.println(as.contains(0));
		
	}
	
	
}


