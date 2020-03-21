package c10_SortingAndSearching.p08_FindDuplicates._01_NumToExist;

import static java.lang.System.out;

/*
 *
 * set 1: x | 1
 * set 0: x & 0
 * 
 * get x: x & 1
 * 		  x | 0 
 * 
 * 
*/
public class NumToExist {

	static final int SIZE_INTEGER = 32;
	
	private int[] numToExist;
	private int maxNum;

	public NumToExist(int maxNum) {
		this.maxNum = maxNum;
		int size = maxNum / SIZE_INTEGER +1;
		numToExist = new int[size];
	}
	
	// 0010
	//&
	// 0010
	public boolean isExist(int num) {
		
		if(num >= maxNum) {
			return false;
		}
		
		int wordIndex = getWordIndex(num);
		int offsetIndex = getOffsetIndex(num);
		
		return (numToExist[wordIndex] & ( 1 << offsetIndex ) ) != 0;
	}
	
	// 0000
	//|
	// 0010
	
	public void set(int num) {
		
		if(num >= maxNum) {
			out.println("out of boundary, cannot set the value " + num);
			return ;
		}
		
		int wordIndex = getWordIndex(num);
		int offsetIndex = getOffsetIndex(num);
		
		numToExist[wordIndex] |= 1 << offsetIndex;
	}
	
	// 0011
	//&
	// 1101
	
	public void erase(int num) {
		
		if(num >= maxNum) {
			out.println("out of boundary, cannot set the value " + num);
			return ;
		}
		
		int wordIndex = getWordIndex(num);
		int offsetIndex = getOffsetIndex(num);
		
		numToExist[wordIndex] &=  ~( 1 << offsetIndex);
	}
	
	private int getWordIndex(int num) {
		return num / SIZE_INTEGER;
	}
	private int getOffsetIndex(int num) {
		return num % SIZE_INTEGER;
	}
	
	
}
