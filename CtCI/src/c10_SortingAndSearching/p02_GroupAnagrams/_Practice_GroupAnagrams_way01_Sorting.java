package c10_SortingAndSearching.p02_GroupAnagrams;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
public class _Practice_GroupAnagrams_way01_Sorting {

	
	public static String[] group(String[] strs) {
		
		
		ArrayList<String> list =  new ArrayList<String>(Arrays.asList(strs));
		
		list.sort( new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String o1_sorted = getStringSortedAlphabetically(o1);
				String o2_sorted = getStringSortedAlphabetically(o2);
				return o1_sorted.compareTo(o2_sorted);
			}
		});
		
		return listToArray(list);
	}
	
	
	private static String getStringSortedAlphabetically(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		String result = String.copyValueOf(chars);
		return result;
	}
	
	
	private static String[] listToArray(ArrayList<String> list) {
		
		String[] result = list.toArray( new String[0] );
		return result;
	}
	
}


