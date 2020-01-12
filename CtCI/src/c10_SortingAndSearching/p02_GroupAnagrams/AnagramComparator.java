package c10_SortingAndSearching.p02_GroupAnagrams;

import java.util.Arrays;
import java.util.Comparator;

//20191212(Thur
public class AnagramComparator implements Comparator<String>{

	private String sortChars(String s) {
		//要先轉換成以char 處理的單位, 才能以char來sort
		//String 本身是不能處理char ( 儘管有charAt())
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	@Override
	public int compare(String s1, String s2) {
		return sortChars(s1).compareTo(sortChars(s2));
	}

}
