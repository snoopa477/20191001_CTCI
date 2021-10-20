package c08_RecursionDynamicProgramming.p08_PermutationsWithDuplicates;
//import static java.lang.System.out;

import java.util.ArrayList;
import java.util.HashMap;
//2020 1119(Wed)
public class My_PermutationsWithDuplicates_way01 {
	

	public static ArrayList<String> getPerms(String str) {
		
		ArrayList<String> results = new ArrayList<String>();
		HashMap<Character, Integer> leftCharToCount = getLeftCharToCount(str);
		getPerms(str.length(), leftCharToCount, "", results);
		
		return results;
		
	}
	
	//backbone
	static void getPerms(int leftCharsToProccess, HashMap<Character, Integer> leftCharToCount
			, String result, ArrayList<String> results) {
		
		//input depletes, results harvest
		if(leftCharsToProccess == 0 ) {
			results.add(result);
		}
	
		//general case
		for( Character leftChar : leftCharToCount.keySet() ) {
			
			//consume/ deplete input, and put it in result
			int count = leftCharToCount.get(leftChar);
			if( count > 0) {
				count--;
				leftCharToCount.put( leftChar, count );
				
				
				getPerms(leftCharsToProccess -1, leftCharToCount, leftChar + result, results);
				
				//MISTAKE: passing object, it will change through recursion stack, so keep in mind
				//to change it back to original later
				count++;
				leftCharToCount.put( leftChar, count );
				
			}
		}
		
	}
	
	static HashMap<Character, Integer> getLeftCharToCount(String str){
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i = 0; i < str.length(); i++) {
			Character character = str.charAt(i);
			
			if( map.containsKey(character) == false ) {
				map.put(character, 1);
			}
			else {
				int count = map.get(character);
				count++;
				map.put(character, count);
			}
		}
		
		return map;
	}

}


