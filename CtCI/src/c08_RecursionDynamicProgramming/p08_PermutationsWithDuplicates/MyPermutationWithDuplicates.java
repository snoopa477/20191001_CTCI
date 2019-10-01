package c08_RecursionDynamicProgramming.p08_PermutationsWithDuplicates;

import java.util.ArrayList;
import java.util.HashMap;
//20190812(Mon
public class MyPermutationWithDuplicates {
	
	
	public static ArrayList<String> printPermutations(String inputStr){
		ArrayList<String> result = new ArrayList<>();
		HashMap<Character, Integer> charToFrequency = buildCharToFreqTable(inputStr);
		printPermutations(charToFrequency, "", inputStr.length(), result);
		
		return result;
	}

	private static void printPermutations(HashMap<Character, Integer> charToFrequency,
			String prefixOfResult, int lengthToProcess, ArrayList<String> result) {
		
		
		//since it's 0, it's time to reap the result
		if(lengthToProcess == 0) {
			result.add(prefixOfResult);
			return;
		}
		
		for( Character c : charToFrequency.keySet() ) {
			
			final int frequency = charToFrequency.get(c);
			if( frequency > 0 ) {
				/*this part is wrong, because they will modify not once!
				frequency --;
				charToFrequency.put( c , frequency);
				prefixOfResult += c;
				lengthToProcess--;
				*/
				charToFrequency.put( c , frequency -1);
				
				printPermutations(charToFrequency, c + prefixOfResult, lengthToProcess -1, result);
				//caution: since map object is pass by reference, I have to update back to original
				//state once the previous function ends
				charToFrequency.put(c, frequency);
			}
		}
		
		
	}

	private static HashMap<Character, Integer> buildCharToFreqTable(String inputStr) {
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(Character c : inputStr.toCharArray()) {
			
			
			if( map.containsKey(c) == false ) {
				map.put(c, 0);
			}
			//let this statement be shared with 2 cases => reduce one {} layer
			map.put(c, map.get(c) + 1);
			
		}
		
		return map;
	}

}
