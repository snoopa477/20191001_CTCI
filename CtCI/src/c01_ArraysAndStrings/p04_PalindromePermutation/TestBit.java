package c01_ArraysAndStrings.p04_PalindromePermutation;
import static java.lang.System.out;
public class TestBit {
	
	public static final int MAX_LENTH = 8;
	
	public static void main(String[] args) {
		
		int numbers[] = {
			
			//1100
			12,
			//0111
			7,
			//0101
			5,
			8,
			9,
			16
		};
		
		
		for( int number : numbers ) {
			for( int i = 0; i < MAX_LENTH/2; i++ ) {
				
				out.printf("%d 's %d th bit is set? %s\n",
						number,
						i,
						isBitSet(number,i));
			}
		}
		
		
		for( int number : numbers ) {
			out.printf("%d has only one bit? %s \n",
					number,
					hasOnlyOneBit(number));
		}
		
	}
	
	
	
	public static boolean isBitSet( int num, int i ) {
		
		//get: and 1
		int mask = 1 << i;
		/* suppose that
		  0 0 0 0 1 0 0 0 - mask
		  1 0 1 0 x 0 1 0 - num
		  ------------------------AND
		  0 0 0 0 x 0 0 0 - result
		  
		 */
		int result = num & mask;
		
		/**
		 * if result > 0, ith bit x is 1
		 * if result = 0, ith bit x is 0 
		 */
		return result > 0;
		
		//if familiar enough, can do in one line
		//return  ( num & (1 << i) ) > 0 
	}
	
	
	public static boolean hasOnlyOneBit(int num ) {
		
		/**
		 * given x
		 * clear rightmost( least significant ) bit
		 * X & (X-1) 
		 */
		
		/**
		 * REASONING :
		 * 1 0 1 0 0 0 0 0 0 - X
		 * 1 0 0 1 1 1 1 1 1 - X-1
		 * --------------------------and 
		 * 1 0 0 0 0 0 0 0 0 - result
		 */
		
		//if after clearing rightmost bit is 0, meaning x only has 1 bit
		
		return ( num & ( num -1 ) ) == 0;
	}
}


