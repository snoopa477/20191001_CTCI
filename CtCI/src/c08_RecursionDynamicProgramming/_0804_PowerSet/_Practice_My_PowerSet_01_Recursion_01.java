package c08_RecursionDynamicProgramming._0804_PowerSet;
import static java.lang.System.out;

import java.util.ArrayList;
/*
 PURPOSE pre-order & return
 */
public class _Practice_My_PowerSet_01_Recursion_01 {

	public static ArrayList<ArrayList<String>> getAllSubsets(ArrayList<String> set){
		int setSize = set.size();
		ArrayList<ArrayList<String>> results = getAllSubSets(set, setSize);
		return results;
	}

	
	/*
	 PURPOSE pre-order & return
	 */
	/*
	 DETAIL
	 	compared to pre-order & argument, each sub call would  discard object of ArrayList<ArrayList<String>>
	 * */
	private static ArrayList<ArrayList<String>> getAllSubSets( ArrayList<String> set, int setSize) {
		
		if( setSize == 0 ) {
			ArrayList<ArrayList<String>> subSets = new ArrayList<ArrayList<String>>(); 
			ArrayList<String> emptySet = new ArrayList<String>();
			subSets.add(emptySet);
			return subSets;
		}
		
		ArrayList<ArrayList<String>>  subSets = getAllSubSets( set, setSize -1 );
		
		ArrayList<ArrayList<String>> cloneWithNewElt = new ArrayList<>();
		for( ArrayList<String> subSet : subSets ) {
			ArrayList<String> cloneSubSetWithNewElt = new ArrayList<>(subSet);
			String newElement = set.get( setSize - 1 );
			cloneSubSetWithNewElt.add( newElement );
			cloneWithNewElt.add(cloneSubSetWithNewElt);
		}
		
		ArrayList<ArrayList<String>> results =  cloneWithNewElt;
		results.addAll(subSets);
		return results;
	}
	
	
}


