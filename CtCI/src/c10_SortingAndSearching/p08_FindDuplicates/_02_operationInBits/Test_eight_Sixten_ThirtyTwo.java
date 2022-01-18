package c10_SortingAndSearching.p08_FindDuplicates._02_operationInBits;
import static java.lang.System.out;
public class Test_eight_Sixten_ThirtyTwo {

	public static void main(String[] args) {
		
		int[] numbers = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
		
		for( int num : numbers ) {
			out.printf("number: %4d, multi by 4: %4d, divideByFour %d, remainderOf4: %4d , %d\n"
					, num, multiplyBy_Four(num), dividBy_Four(num), remainderOf_Four_byBit(num), remainderOf_Four_byHex(num) );
			out.printf("number: %4d, multi by 8: %4d, divideBy8 %d, remainderOf8: %4d, %d\n"
					, num, multiplyBy_Eight(num), dividBy_Eight(num), remainderOf_Eight_byBit(num), remainderOf_Eight_byHex(num) );
			out.printf("number: %4d, multi by 16: %4d, divideBy16 %d, remainderOf16: %4d, %d\n\n"
					, num, multiplyBy_sixteen(num), dividBy_sixteen(num), remainderOf_sixteen_byBit(num), remainderOf_sixteen_byHex(num) );
		}
		
	}
	
	
	private static int multiplyBy_Four(int num) {
		return num << 2;
	}
	
	
	private static int dividBy_Four(int num) {
		return num >> 2;
	}
	
	
	private static int remainderOf_Four_byBit(int num) {
		//0b100 -1 = 0b11, data type is integer
		//0x4 - 1 = 0x3
		//MISTAKE
		//return num & 0b100;
		return num & (0b100 - 1);
	}
	
	
	private static int remainderOf_Four_byHex(int num) {
		//0b100, data type is integer
		//0x4 -1 
		//MISTAKE
		//return num & 0x4;
		return num & (0x4 -1);
	}
	
	
	private static int multiplyBy_Eight(int num) {
		return num << 3;
	}
	
	
	private static int dividBy_Eight(int num) {
		return num >> 3;
	}

	
	private static int remainderOf_Eight_byBit(int num) {
		//0b1000 -1 = 0b111
		//0x8 -1 = 0x7
		return num & (0b1000 -1 );
	}
	
	
	private static int remainderOf_Eight_byHex(int num) {
		//0b1000 -1 = 0b111
		//0x8 -1 = 0x7
		return num & ( 0x8 - 1);
	}
	
	
	private static int multiplyBy_sixteen(int num) {
		return num << 4;
	}
	
	
	private static int dividBy_sixteen(int num) {
		return num >> 4;
	}

	
	private static int remainderOf_sixteen_byBit(int num) {
		//0b10000 -1  = 0b1111, data type is integer
		//0x10 -1 = 0xF
		return num & ( 0b10000 -1);
	}
	
	
	private static int remainderOf_sixteen_byHex(int num) {
		//0b10000 -1  = 0b1111, data type is integer
		//0x10 -1 = 0xF
		return num & (0x10 -1);
	}
	

}


