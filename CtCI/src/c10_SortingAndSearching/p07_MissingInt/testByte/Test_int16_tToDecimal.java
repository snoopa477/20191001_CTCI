package c10_SortingAndSearching.p07_MissingInt.testByte;
import static java.lang.System.out;
public class Test_int16_tToDecimal {
	
	private final static int INT16_LEADING_BIT_IDNEX = 15;
	
	
	public static void main(String[] args) {
		
		/*
		1111 0000 0000 0000 : F000
		0111 1111 1111 1111 : 7FFF
		1000 0000 0000 0000 : 8000
		 * */
		 
		
		String[] hexes = {"0000", "FFFF", "000F", "F000", "7FFF", "8000", "BD05", "3711", "0909", "1B1B", "0438", "0CA8", "3804", "A80C", "FA74", "EF5C"};
		
		int counter = 0;
		for(String hex : hexes) {
			if(counter % 2 == 0) {
				out.println("----------------------");
			}
			//out.printf("hex:%5s number:%8d", hex, Integer.parseInt(hex,16));
			int number = Integer.parseInt(hex,16);
			out.printf("hex:%5s number:%8d isLeadingBitIsSet: %5s, int_16_t_number : %8d"
					, hex, number, checkLeadingBitIsSet(number, INT16_LEADING_BIT_IDNEX), parseInt_int16_t(hex) );
			out.println();
			
			counter++;
		}
		
	}
	
	private static int parseInt_int16_t(String hex) {
		
		int number_int = Integer.parseInt(hex,16);
		
		int number_int16_t = number_int;
		if( checkLeadingBitIsSet(number_int, INT16_LEADING_BIT_IDNEX) ) {
			int offset = (int) Math.pow(2, INT16_LEADING_BIT_IDNEX);
			number_int16_t -= offset * 2;
			
		}
		
		return number_int16_t;
	}
	
	private static boolean checkLeadingBitIsSet( int number, int index ) {
		
		boolean isLeadingBitIsSet = (number &  (1 << index) ) > 0? true: false;
		return isLeadingBitIsSet;
	}
	
}


