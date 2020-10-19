package c08_RecursionDynamicProgramming._0804_PowerSet;
import java.util.ArrayList;
public class PowerSet_02_Combinatorics {
	
	public static ArrayList<ArrayList<Integer>> getSubserts2(ArrayList<Integer> set){
		
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size();
		
		for( int k =0; k < max; k++) {
			ArrayList<Integer> subset = convertIntToSet(k,set);
			allsubsets.add(subset);
		}
		return allsubsets;
		
	}
	
	private static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set){
		
		ArrayList<Integer> subset = new ArrayList<>();
		
		int index = 0;
		
		for(int k =x ; k> 0; k >>= 1) {
			if( (k&1) == 1 ) {
				subset.add(set.get(index));
			}
			index++;
		}
		return subset;
		
	}

}


