package c10_SortingAndSearching.p08_FindDuplicates._02_operationInBits;

public class DivideAndModInBit {

	
	public static int getRemainder(int dividend, int divisor) {
		
		if(isPowerOfTwo(divisor)) {
			return ( dividend & (divisor-1) );
		}
		else {
			return dividend % divisor;
		}
	}
	
	public static int getQuotient(int dividend, int divisor) {
		
		if(isPowerOfTwo(divisor)) {
			return ( dividend >> getExponentOfTwo(divisor) );
		}
		else {
			return dividend /divisor;
		}
		
	}
	
	
	//
	public static boolean isPowerOfTwo(int num) {
		
		boolean isDuplicateOfOne = false;
		
		while( num > 0 ) {
			
			if ( (getLeastSigBit(num)) != 0b0000) {
				
				if(isDuplicateOfOne == false) {
					isDuplicateOfOne = true;
				}
				else {
					return false;
				}
			}
			num >>= 1;
		}
		
		return true;
	}
	
	private static int getLeastSigBit(int num) {
		return (num & 0b0001);
	}
	
	//0100
	//0010
	//0001
	//0000
	
	public static int getExponentOfTwo(int num) {
		
		if(isPowerOfTwo(num) == false) {
			return -1;
		}
		
		//wrong. better use the view point of position/ counts
//		int exponent = 0;
//		
//		//用因果來思考 => 順序代表因果
//		while(num > 0) {
//			
//			num>>=1;
//			exponent++;
//		}
		
		int positionOfSetBit = 0;
		
		//用因果來思考 => 順序代表因果
		while(num > 0) {
			
			num>>=1;
			positionOfSetBit++;
		}
		
		int exponent = positionOfSetBit -1;
		
		return exponent;
	}
	
	
}
