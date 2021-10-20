package c10_SortingAndSearching.p08_FindDuplicates._01_NumToExist;

import static java.lang.System.out;

/*
 *
 * set 1: x | 1
 * set 0: x & 0
 * 
 * get x: x | 0
 * 		  x & 1 
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
	
	// xxYx              
	//&
	// 0010
	// 00Y0
	public boolean isExist(int num) {
		
		if(num >= maxNum) {
			return false;
		}
		
		int wordIndex = getWordIndex(num);
		int offsetIndex = getOffsetIndex(num);
		
		return (numToExist[wordIndex] & ( 1 << offsetIndex ) ) != 0;
	}
	
	// xxxx
	//|
	// 0010
	// xx1x
	public void set(int num) {
		
		if(num >= maxNum) {
			out.println("out of boundary, cannot set the value " + num);
			return ;
		}
		
		int wordIndex = getWordIndex(num);
		int offsetIndex = getOffsetIndex(num);
		
		numToExist[wordIndex] |= 1 << offsetIndex;
	}
	
	// xxxx
	//&
	// 1101
	// xx0x
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
