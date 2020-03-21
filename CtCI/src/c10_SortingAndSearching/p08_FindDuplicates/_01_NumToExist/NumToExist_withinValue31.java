package c10_SortingAndSearching.p08_FindDuplicates._01_NumToExist;

import static java.lang.System.out;

public class NumToExist_withinValue31{
	
	private static int LOWER_BOUND = 0;
	private static int UPPER_BOUND = 31;
	
	//0x0000
	private int numToExist = 0;
	
	//0000
	//|
	//0001
	public void set(int num) {
		if( LOWER_BOUND <= num && num <= UPPER_BOUND) {
			numToExist |= 1 << num;
		}
		else {
			out.println("cannot set the value");
		}
	}
	
	//0010
	//&
	//0010
	public boolean isExist(int num) {
		if( LOWER_BOUND <= num && num <=UPPER_BOUND ) {
			//wrong:
			//return (numToExist &= 1 << num) == 1 ;
			return (numToExist & 1 << num) != 0 ;
		}
		return false;
	}
	
	//0010
	//&
	//1101
	
	public void erase(int num) {
		if( LOWER_BOUND <= num && num <=UPPER_BOUND ) {
			numToExist &= ~(1 << num);
		}
	}

}
