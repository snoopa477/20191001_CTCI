package c08_RecursionDynamicProgramming._0804_PowerSet;
import java.util.ArrayList;
public class My_PowerSet_02_Combinatorics {
	
	public static ArrayList<ArrayList<String>> getSubSets(ArrayList<String> set){
		
		//e.g.: maxBit ==4
		int maxBit = set.size();
		//I sometimes get confused between position and exponent
		//2 ^ ( 0 + maxBit )
		int maxNumber = 1 << maxBit; 
		
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		
		//e.g. 0 <= i && i < 16 
		for(int i = 0; i < maxNumber; i++) {
			result.add(convertIntegerToSubSet( set, i ));
		}

		return result;
		
	}
	
	private static ArrayList<String> convertIntegerToSubSet(ArrayList<String> set, int num ) {
		
		ArrayList<String> result = new ArrayList<>();
		//1111 0111
		// 111  011
		//  11   01
		//   1    0
		//
		
		//int exponent = 0;
		//while( num > 0) {
		//MISTAKE num >= 0
		//for(int exponent = 0; num >=0; num>>=1, exponent++) {
		for(int exponent = 0; num >0; num>>=1, exponent++) {
			//      1111
			//&        1
			//result   1
			if( (num & 1) == 1 ) {
				result.add( set.get(exponent) );
			}
			
//			out.println("hi");
			//num >>= 1;
			//exponent++;
		}
		
		return result;
		
	}
	
}


