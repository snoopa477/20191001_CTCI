package c10_SortingAndSearching.p07_MissingInt.testByte;
import static java.lang.System.out;
public class Test_BitSet {

	public static void main(String[] args) {
		
		int[] numbers = { 34, 16, 23, 12, 6, 9};
		
		BitSet bitSet = new BitSet(max(numbers), min(numbers));
		
		for( int i = 0; i < numbers.length; i++ ) {
			bitSet.set(numbers[i]);
		}
		
		
		for( int i = 0; i < 30; i++ ) {
			out.printf("is number %4d contained in bitSet? %s\n", i, bitSet.contains(i)? "true" : "false");
		}
		
		
	}
	
	
	
	public static int max(int[] a) {
		
		int max = Integer.MIN_VALUE;
		
		for( int i = 0; i < a.length; i++) {
			if( a[i] > max ) {
				max = a[i];
			}
		}
		return max;
	}
	
	
	
	public static int min(int[] a) {
		
		int min = Integer.MAX_VALUE;
		
		for( int i = 0; i < a.length; i++) {
			if( a[i] < min ) {
				min = a[i];
			}
		}
		return min;
	}

}


