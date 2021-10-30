package c08_RecursionDynamicProgramming._0804_PowerSet;
import static java.lang.System.out;
import java.util.*;


public class _Practice_My_PowerSet_01_Recursion_02 {

	public static ArrayList<ArrayList<String>> getAllSubsets(ArrayList<String> set){
		
		int setSize = set.size();
//		temp
		/*REPLACED
		return getAllSubSets(set, setSize);
		*/
		
		ArrayList<ArrayList<String>> results = new ArrayList<>();
		getAllSubSets(results, set, setSize);
		return results;
		
	}
	
	/*
	 THINK_FURTHER
	 if recursion we call would be multiple, then DP might be needed, since sub call with same argument will appear multiple times
	 * */
	private static void getAllSubSets(ArrayList<ArrayList<String>> results, ArrayList<String> set, int setSize) {
		
		//WRONG stack overflow
		//getAllSubSets(results, set, setSize - 1);
		
		//virtual invalid case
		//if( setSize < 0 ) {
		//	return ;
		//}
		
		//base case
		if( setSize == 0 ) {
			ArrayList<String> emptySet = new ArrayList<String>();
			results.add(emptySet);
			return;
		}
		
		getAllSubSets(results, set, setSize - 1);
		
		ArrayList<ArrayList<String>> cloneWithNewElt = new ArrayList<>();
		for( ArrayList<String> subSet : results ) {
			ArrayList<String> cloneSubSetWithNewElt = new ArrayList<>(subSet);
			String newElement = set.get( setSize - 1 );
			cloneSubSetWithNewElt.add( newElement );
			cloneWithNewElt.add(cloneSubSetWithNewElt);
		}
		
		results.addAll(cloneWithNewElt);
		
		//MISTAKE Order is important. inorder or post order?
		//getAllSubSets(results, set, setSize - 1);
		
		
	}

	
	/*
	 THINK_FURTHER
	 using this way, have to instantiate an object of ArrayList<ArrayList<String>> at base case; However, I prefer to do so( new object of ArrayList<ArrayList<String>> ) at the beginning of calling this function.
	 * */
	/*REPLACED
	private ArrayList<ArrayList<String>> getAllSubSets(ArrayList<String> set, int setSize) {
	*/
	
	
}


