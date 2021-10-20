package c08_RecursionDynamicProgramming.p08_PermutationsWithDuplicates;

import java.util.ArrayList;
import java.util.HashMap;

//import static java.lang.System.out;
//2020 1119(Thur)
public class My_PermutationsWithDuplicates_way02 {

	
	public static ArrayList<String> getPerms(String str) {
		
		ArrayList<String> results = new ArrayList<String>();
		HashMap<Character, Integer> leftCharToCount = getLeftCharToCount(str);
		results = getPerms(str.length(), leftCharToCount);
		
		return results;
		
	}
	
	//backbone
	static ArrayList<String> getPerms(int leftCharsToProccess, HashMap<Character, Integer> leftCharToCount){
		
		ArrayList<String> results = new ArrayList<String>();
		
		
		if( leftCharsToProccess == 0) {
			 results.add("");
			 return results;
		}
		
		for( Character character: leftCharToCount.keySet() ) {
			
			int count = leftCharToCount.get(character);
			if( count > 0 ) {
				count--;
				leftCharToCount.put(character, count);
				ArrayList<String> result = getPerms(leftCharsToProccess -1 , leftCharToCount);
				//MISTAKE: forget to append character to result
				addCharacter(character, result);
				
				count++;
				leftCharToCount.put(character, count);
				results.addAll(result);
			}
		}
		
		
		return results;
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
	
	static void addCharacter( Character character, ArrayList<String> strs) {
		
		for(int i = 0; i < strs.size(); i++) {
			String str = strs.get(i);
			strs.set(i, character + str);
		}
	}
	
}


