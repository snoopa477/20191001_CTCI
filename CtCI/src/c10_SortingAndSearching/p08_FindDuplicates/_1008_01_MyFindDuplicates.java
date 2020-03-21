package c10_SortingAndSearching.p08_FindDuplicates;

import static java.lang.System.out;

public class _1008_01_MyFindDuplicates {
	
	static final int MAX_MEMORY_IN_BIT = 32000;
	
	public static void findDuplicate(int[] array) {
		
		NumToExist numToExist = new NumToExist(MAX_MEMORY_IN_BIT);
		
		for(int elt : array) {
			
			if( numToExist.isExist(elt) ) {
				out.printf(elt + " ");
			}
			else {
				numToExist.setBit(elt);
			}
			
		}
		
	}
	
	
	
}

class NumToExist{
	
	private int[] numToExist;

	public NumToExist(int bits) {
		//numToExist = new int[ bits/32 +1 ];
		//succinct way to do this
		numToExist = new int[ bits >> 5 + 1 ];
	}
	
	
	private int getWord(int num) {
		//return num/32
		//succinct way to do this
		return num >> 5;
	}
	
	private int getOffset(int num) {
		//return num%32;
		//succinct way to do this
		return num & (32-1);
	}
	
	public boolean isExist(int num) {
		
		int word = getWord(num);
		int offset = getOffset(num);
		return (numToExist[word] & (1 << offset) ) != 0;
	}
	
	public void setBit(int num) {
		int word = getWord(num);
		int offset = getOffset(num);
		numToExist[word] |= 1 << offset;
	}
	
}