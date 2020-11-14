package c08_RecursionDynamicProgramming._0804_PowerSet;
//import static java.lang.System.out;

import java.util.ArrayList;
//20201104
public class My_PowerSet_01_Recursion_02 {

	
	public static ArrayList<ArrayList<String>> getAllSubSets( ArrayList<String> input_Set){
		
		return getAllSubSets( input_Set.size() , input_Set );
	}
	
	static ArrayList<ArrayList<String>> getAllSubSets( int kindsOfElements, ArrayList<String> input_Set){
		
		//base case
		if( kindsOfElements == 0 ) {
			ArrayList<ArrayList<String>> empty_Sets = new ArrayList<>();
			empty_Sets.add(new ArrayList<>());
			return empty_Sets;
		}
		
		ArrayList<ArrayList<String>> small_Sets = getAllSubSets(kindsOfElements -1, input_Set);
		
		ArrayList<ArrayList<String>> small_Sets_NewElement = deepClone(small_Sets);
		addNewElement( small_Sets_NewElement, input_Set.get(kindsOfElements - 1));
		
		ArrayList<ArrayList<String>> result = small_Sets;
		result.addAll(small_Sets_NewElement);
		
		return result;
	}
	
	static ArrayList<ArrayList<String>> deepClone(ArrayList<ArrayList<String>> input_Sets){
		
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		
		for( ArrayList<String> set : input_Sets) {
			result.add( new ArrayList<>( set ) );
		}
		
		return result;
	}
	
	static void addNewElement( ArrayList<ArrayList<String>> input_Sets, String newElement ) {
		
		for(ArrayList<String> set : input_Sets) {
			set.add(newElement);
		}
		
	}
	
}


