package c10_SortingAndSearching.p02_GroupAnagrams;
//import static java.lang.System.out;

import java.util.Arrays;
import java.util.Comparator;

//2020 1228(Mon)
public class MyAnagramComparator_freq02 implements Comparator<String>{

	private String sortedChars(String str) {
		
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		
		return new String(chars);
	}
	
	@Override
	public int compare(String str1, String str2) {
		
		String sorted_str1 = sortedChars(str1);
		String sorted_str2 = sortedChars(str2);

		int comparedResult = sorted_str1.compareTo(sorted_str2);
		return comparedResult;
	}

}


