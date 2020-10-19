package c08_RecursionDynamicProgramming._0804_PowerSet;
//import static java.lang.System.out;

import java.util.ArrayList;
public class My_PowerSet_01_Recursion {
	
	public static  ArrayList<ArrayList<String>> getAllSubsets(ArrayList<String> set){
		
		return getAllSubsets(set, set.size());
		
	}
	
	private static ArrayList<ArrayList<String>> getAllSubsets(ArrayList<String> set, int maxSizeOfSet){
		
		if(maxSizeOfSet == 0) {
			//with no element
			
			//MISTAKE
			//since there's no ArrayList<String> object in Arr<Arr<String>>
			//return new ArrayList<>();
			
			ArrayList<ArrayList<String>> emptySets = new ArrayList<>();
			emptySets.add(new ArrayList<String>() );
			return emptySets;
			
		}
		
		ArrayList<ArrayList<String>> smallerSets = getAllSubsets(set, maxSizeOfSet -1 );
		
		//GUESS it's wrong becuase it's not DEEP copy, it only copy the refernce to ArrayList<String>
		//ArrayList<ArrayList<String>> smallerSets_withNewElt = new ArrayList<ArrayList<String>>(smallerSets);
		ArrayList<ArrayList<String>> smallerSets_withNewElt = deepClone( smallerSets );
		addNewElement(smallerSets_withNewElt, set.get(maxSizeOfSet - 1));
		
		ArrayList<ArrayList<String>> resultSets = smallerSets;
		resultSets.addAll(smallerSets_withNewElt);
		
		return resultSets;
	}
	
	private static void addNewElement(ArrayList<ArrayList<String>> sets, String newElt) {
		
		for(ArrayList<String> set : sets) {
			set.add(newElt);
		}
		
	}
	
	private static ArrayList<ArrayList<String>> deepClone(ArrayList<ArrayList<String>> sets) {
		
		ArrayList<ArrayList<String>> sets2 = new ArrayList<>();
		for( ArrayList<String> set: sets) {
			sets2.add( new ArrayList<>( set ) );
		}
		
		return sets2;
		
	}
}


