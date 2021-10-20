package c10_SortingAndSearching.p02_GroupAnagrams;
//import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;

import util.*;
//2020 1227(Sun
public class AnagramSorter {
	
	static public void sort(String[] array) {
		
		MyHashMapList<String, String> mapList = new MyHashMapList<>();
		
		/* Group words by anagram */
		for(String s : array) {
			String key = sortChars(s);
			mapList.put(key, s );
		}
		
		/* Convert hash table to array */
		int index = 0 ;
		for( String key : mapList.keySet() ) {
			
			ArrayList<String> list = mapList.get(key);
			for(String t : list) {
				array[index] = t;
				index++;
			}
		}
		
	}
	
	static private String sortChars(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

}


