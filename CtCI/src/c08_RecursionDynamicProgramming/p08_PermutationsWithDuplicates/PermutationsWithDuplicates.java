package c08_RecursionDynamicProgramming.p08_PermutationsWithDuplicates;

import java.util.ArrayList;
import java.util.HashMap;
//20190812(Mon
public class PermutationsWithDuplicates {


	public static ArrayList<String> printPerms(String s){
		ArrayList<String> result = new ArrayList<>();
		HashMap<Character, Integer> map = buildFreqTables(s);
		printPerms(map, "", s.length(), result);
		
		return result;
	}
	
	private static HashMap<Character, Integer> buildFreqTables(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for(char c: s.toCharArray()) {
			if(!map.containsKey(c)) {
				map.put(c,0);
			}
			map.put(c,map.get(c) + 1);
		}
		return map;
	}

	public static void printPerms(HashMap<Character, Integer> map, 
			String prefix, int remaining,ArrayList<String> result) {
		
		//
		if(remaining == 0) {
			result.add(prefix);
			return;
		}
		
		for(Character c : map.keySet()) {
			int count = map.get(c);
			if(count > 0) {
				map.put(c, count -1);
				
				//
				printPerms(map, prefix + c, remaining -1, result);
				map.put(c, count);
			}
		}
	}
	
	

}
