package c05_BitManipulation.p07_PairwiseSwap;
import static java.lang.System.out;
public class PairwiseSwap_01_DouebleFences {

	public static int swapOddEvenBits(int number) {
		
		/**
		 * IMAGINATION: 
		 * each pair swaps at a time, iterate through all pairs
		 * = all the  left part of pairs( which are odd indexes) move to right in one move
		 * , and then whole right part( which are even indexes) of pairs move to left in one move
		 * , and then put two moves together 
		 * 
		 * 
		 Part A: Under premise that even bits are erased, move odd bits to right by one
		   ... 6  5  4  3  2  1  0
		   ... g  f  e  d  c  b  a
		   ... 0  1  0  1  0  1  0 : 0xaaaaaaaa
		                ----------
		   AND ) ---------------------
		   ... 0  f  0  d  0  b  0
		   >>>1) --------------------- DETAIL: 0th bit is even and erased, so it's ok to be erased after shifting right
		   ... 0  0  f  0  d  0  b
		 * 
		 * 
		 * Part B: Under premise that odd bits are erased, move even bits to left by one
		   ... 6  5  4  3  2  1  0
		   ... g  f  e  d  c  b  a
		   ... 1  0  1  0  1  0  1 : 0x55555555
		    			----------
		   AND ) ---------------------
		   ... g  0  e  0  c  0  a
		   <<1 ) --------------------- DETAIL: 31th bit is odd and erased, so it's ok to be overflowed after shifting left
		   ... 0  e  0  c  0  a  0
		   
	
		   part A | part B
		   ... 6  5  4  3  2  1  0
		   ... 0  e  0  c  0  a  0
		   ... 0  0  f  0  d  0  b
		   OR  ) ---------------------
		   ... 0  e  f  c  d  a  b
		   
		 */
		
		//left part of pairs move to right
		int leftPartToRight = ( number & 0xaaaaaaaa ) >>> 1;
		int rightPartToLeft = ( number & 0x55555555 ) << 1;
		int result = leftPartToRight | rightPartToLeft;
		
		return result;
	}
	
}


