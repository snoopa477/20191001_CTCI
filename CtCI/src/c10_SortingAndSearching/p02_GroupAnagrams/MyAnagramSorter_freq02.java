package c10_SortingAndSearching.p02_GroupAnagrams;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
public class MyAnagramSorter_freq02 {
	
	static public String[] sort(String[] strs) {
		
		HashMap_valueList<String, String> sorted_to_anagrams = getSorted_to_anagrams(strs);
		
		ArrayList<String> sorted_anagrams = new ArrayList<>();
		
		for( String key : sorted_to_anagrams.keySet()) {
			ArrayList<String> groupOfAnagrams = sorted_to_anagrams.get(key);
			sorted_anagrams.addAll(groupOfAnagrams);
		}
		//I'm not certain if this is good
		//Exception in thread "main" java.lang.ClassCastException
//		String[] results = (String[]) sorted_anagrams.toArray();
		
		String[] results = sorted_anagrams.toArray(new String[0]);
	
		
		return results;
//		return null;
	}
	
	//backbone
	static HashMap_valueList<String, String> getSorted_to_anagrams(String[] strs){
		
		HashMap_valueList<String, String> sorted_to_anagrams = new HashMap_valueList<>();
		
		for( String str : strs ) {
			String key_sorted = getSortedString(str);
			String listElement_anagram = str;
			sorted_to_anagrams.put( key_sorted, listElement_anagram );
		}
		
		return sorted_to_anagrams;
	}
	
	static String getSortedString(String str) {
		
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		
		return new String (chars);
	}

}


