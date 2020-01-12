package c10_SortingAndSearching.p02_GroupAnagrams;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import util.HashMapList;


public class Sort {

	public static void sort(String[] array) { 
	
		HashMapList<String, String>  mapList  = new HashMapList<String, String>();

		for (String s : array) {
			String key = sortChars(s);
			mapList.put(key, s);
		}
		
		int index = 0;
		for(String key: mapList.keySet()) {
			ArrayList<String> list = mapList.get(key);
			
			for(String t : list) {
				array[index] = t;
				index++;
			}
		}
	}
	
	private static String sortChars(String s) {
		
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
		
	}
	
}
