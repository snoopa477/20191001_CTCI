package c08_RecursionDynamicProgramming.p08_PermutationsWithDuplicates;
import static java.lang.System.out;
import java.util.*;

public class _Practice_My_PermutationsWithDuplicates_way01 {
	
	static final boolean IS_DEBUG_ON = true;

	public static ArrayList<String> getPermDuplicates(String sequence){
		
		/* REASONING
		 * since we don't consider the order: which char is behind or after which char
		 * I decompose sequence into map, which only records
		 * 1. how many kinds of char
		 * 2. given a kind of char, its frequency
		 * 3. NO ORDER
		 */
		HashMap<Character, Integer> charToCount = getCharToCount(sequence);
		
		/*
		 * PURPOSE
		 * to quickly count total count of char without referencing the map object
		 */
		int sequenceSize = getLengthOfSequence(charToCount);
		
		//if(IS_DEBUG_ON) printMap(charToCount);
		
		return getPermDuplicatesHelper(sequenceSize, charToCount);
	}
	
	
	
	private static ArrayList<String> getPermDuplicatesHelper(int sequenceSize, HashMap<Character, Integer> charToCount){
		
		//base case, no sub call needed to determine the result.
		if(sequenceSize == 1) {
			for( Character pickedChar : charToCount.keySet() ) {
				
				if( charToCount.get(pickedChar) == 1 ) {
					ArrayList<String> results = new ArrayList<String>();
					results.add( String.valueOf( pickedChar ));
					
					return results;
				}
				
			}
		}
		
		
		ArrayList<String> results = new ArrayList<String>();
		
		/* PURPOSE
		 * iterate through all kinds of character
		 */
		for( Character pickedChar : charToCount.keySet() ) {
			
			/* PURPOSE
			 * each sequence has its own charToCount map object.
			 * If we are going to use only one map object to represent all sequence in subcalls, 
			 * we need to restore to its original state after sub call, see My_PermutationsWithDuplicates_way01
			 */
			HashMap<Character, Integer> sub_charToCount = new HashMap<Character, Integer>(charToCount);
			
			int count = sub_charToCount.get(pickedChar);
			
			if( count > 0 ) {
				
				/* THINK_FURTHER
				 * It's not so obvious that the argument is getting smaller over each calling.
				 * e.g. f(n) = ... f(n-1)
				 */
				int remainingCharCount = count - 1;
				sub_charToCount.put(pickedChar, remainingCharCount);
				
				ArrayList<String> subResult = getPermDuplicatesHelper(sequenceSize - 1, sub_charToCount);
				
				for(String subSeq : subResult) {
					//PURPOSE the actual operation
					String result = pickedChar + subSeq;
					results.add(result);
				}
			}
			/*
			 * else
			 * since count == 0, we don't do anything 
			 * we don't bother to remove the unused key
			 */
		}
		
		//MISTAKE
		//return null;
		return results;
	}
	
	/*
	 * This data structure is important and essential for this problem 
	 */
	public static HashMap<Character, Integer> getCharToCount(String sequence){
		
		HashMap<Character, Integer> charToCount = new HashMap<Character, Integer>();
		
		for(int i = 0 ; i < sequence.length(); i++) {
			
			Character ch = sequence.charAt(i);
			
			if( charToCount.containsKey(ch) ) {
				int count = charToCount.get(ch);
				count++;
				charToCount.put(ch, count);
			}
			else {
				//WRONG
				//charToCount.put(ch, 0);
				charToCount.put(ch, 1);
			}
			
		}
		
		return charToCount;
	}
	
	
	
	public static int getLengthOfSequence( HashMap<Character, Integer> charToCount ) {
		
		int sequenceSize = 0;
		
		for( Character ch : charToCount.keySet() ) {
			int count = charToCount.get(ch);
			sequenceSize += count;
		}
		return sequenceSize;
	}
	
	
	
	private static void printMap( HashMap<Character, Integer> map ) {
		
		for( Character ch : map.keySet() ) {
			out.println( ch + ": " + map.get(ch) );
		}
		
	}
	
}


