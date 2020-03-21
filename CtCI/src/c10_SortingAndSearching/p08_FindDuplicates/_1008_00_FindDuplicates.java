package c10_SortingAndSearching.p08_FindDuplicates;

//import java.util.BitSet;

import static java.lang.System.out;

public class _1008_00_FindDuplicates {

	public static void checkDuplicates(int[] array) {
		
		BitSet bs = new BitSet(32000);
		
		for(int i = 0; i < array.length; i++) {
			
			int num = array[i];
			int num0 = num -1;//bitset starts at 0, numbsers start at 1
			
			if(bs.get(num0)) {
				out.println(num);
			}
			else {
				bs.set(num0);
			}
		}
	}
	
	static  class BitSet{
		
		int[] bitset;
		
		public BitSet(int size) {
			bitset = new int[(size>>5) + 1];//divide by 32
		}
		
		boolean get(int pos) {
			
			int wordNumber = ( pos >> 5);
			int bitNumber = ( pos & 0x1F );//mod 32
			return (bitset[wordNumber] & ( 1 << bitNumber ) ) != 0;
		}
		
		void set(int pos) {
			
			int wordNumber = ( pos >> 5 );
			int bitNumber = ( pos & 0x1F );
			bitset[wordNumber] |= 1 << bitNumber;
			
		}
	}
}
