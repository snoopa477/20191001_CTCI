package c10_SortingAndSearching.p02_GroupAnagrams;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
public class _Practice_GroupAnagrams_way02_map {

	
	public static String[] group(String[] strs) {
		
		
		/* DETAIL 
		 * category: sorted char string represents as group of anagrams count as one category, 
		 * e.g. "abc", "bca", "cba" are falls into category: "abc", 
		 */
		//HashMap<String, ArrayList<String>> categoryToAnagrams = new HashMap<>();
		
		HashMapList<String, String>  categoryToAnagrams = new HashMapList<String, String>();
		
		for( String str: strs ) {
			categoryToAnagrams.put(convertToSortedByChar(str), str);
		}
		
		ArrayList<String> result = new ArrayList<>();
		for( String category : categoryToAnagrams.keySet() ) {
			result.addAll( categoryToAnagrams.get(category) );
		}
		
		return result.toArray(new String[0]);
	}
	
	
	
	private static String convertToSortedByChar(String str) {
		
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		String result = String.valueOf(chars);
		
		return result;
		
	}
	
	
	/* REASONING Defining this class would reduce the complexity by just calling this class object and method 
	 * QUESTION wat if I wanna delete the key? should all the list are freed too? 
	 * 
	 */
	
	//WRONG: private class HashMapList<K,V>{
	//ERROR:  No enclosing instance of type _Practice_GroupAnagrams_way02_map is accessible. Must qualify the allocation with an enclosing instance of type 
	//SOLUTION: https://stackoverflow.com/questions/47541459/no-enclosing-instance-is-accessible-must-qualify-the-allocation-with-an-enclosi
	private static class HashMapList<K,V>{
		
		HashMap<K, ArrayList<V>> mapToList ;
		
		public HashMapList() {
			mapToList = new HashMap<>();
		}
		
		public void put(K key, V value) {
			
			if( mapToList.containsKey(key) == false ) {
				mapToList.put(key, new ArrayList<V>());
				mapToList.get(key).add(value);
			}
			else {
				mapToList.get(key).add(value);
			}
		}
		
		
		public ArrayList<V> get( K key ){
			return mapToList.get(key);
		}
		
		
		public Set<K> keySet(){
			return mapToList.keySet();
		}
	}
	
	
}


