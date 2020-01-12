package c10_SortingAndSearching.p02_GroupAnagrams;

import java.util.Arrays;
import java.util.Comparator;

//20191212(Thur
public class AnagramComparator implements Comparator<String>{

	private String sortChars(String s) {
		//�n���ഫ���Hchar �B�z�����, �~��Hchar��sort
		//String �����O����B�zchar ( ���ަ�charAt())
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	@Override
	public int compare(String s1, String s2) {
		return sortChars(s1).compareTo(sortChars(s2));
	}

}
