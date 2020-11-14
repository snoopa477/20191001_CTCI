package c08_RecursionDynamicProgramming._0804_PowerSet;
import java.util.ArrayList;
//import static java.lang.System.out;
//2020 1104
public class My_PowerSet_02_Combinatorics_02 {

	static ArrayList<ArrayList<String>> getAllSubSets(ArrayList<String> input_Set){
		
		int maxBits = input_Set.size();
		
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		// 2^( 0 + maxBits )
		int num = 1 << maxBits;
		for(int i = 0; i < num; i++) {
			//MISTAKE
			//result.add( convertNumToSubSet( num , input_Set) );
			result.add( convertNumToSubSet(i, input_Set) );
		}
		
		return result;
	}
	
	static ArrayList<String> convertNumToSubSet( int num, ArrayList<String> input_Set ) {
		
		ArrayList<String> subSet = new ArrayList<>();
		
		int exponent = 0;
		for ( ; num > 0; num >>= 1, exponent++ ) {
			if( (num & 1) == 1 ) {
				subSet.add(input_Set.get(exponent));
			}
		}
		
		return subSet;
	}
	
}


