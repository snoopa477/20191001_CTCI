package c10_SortingAndSearching.p08_FindDuplicates._01_NumToExist;
import static java.lang.System.out;
public class Test_shiftNumberMinus {

	public static void main(String[] args) {
		
		int num = 16;
		
		/*
		 RESULT: 
		number is 16 = 10000, shfit << by -8, result is 268435456 = 10000000000000000000000000000
		number is 16 = 10000, shfit << by -7, result is 536870912 = 100000000000000000000000000000
		number is 16 = 10000, shfit << by -6, result is 1073741824 = 1000000000000000000000000000000
		number is 16 = 10000, shfit << by -5, result is -2147483648 = 10000000000000000000000000000000
		number is 16 = 10000, shfit << by -4, result is 0 = 0
		number is 16 = 10000, shfit << by -3, result is 0 = 0
		number is 16 = 10000, shfit << by -2, result is 0 = 0
		number is 16 = 10000, shfit << by -1, result is 0 = 0
		number is 16 = 10000, shfit << by 0, result is 16 = 10000
		 */
		
		for( int i = -8; i <=0 ; i++) {
			out.printf("number is %d = %s, shfit << by %d, result is %d = %s\n"
				, num, Integer.toBinaryString(num), i, num <<i, Integer.toBinaryString(num<<i) );
		}
		
	}

}


