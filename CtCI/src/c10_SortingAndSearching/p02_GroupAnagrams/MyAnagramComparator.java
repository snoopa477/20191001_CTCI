package c10_SortingAndSearching.p02_GroupAnagrams;

import java.util.Arrays;
import java.util.Comparator;

//20191219(Thur
//comparable �Pcomparator���t��? 
//�ڥثe���q��, �Ocomparable���ݭnaugmented loop
//comparator�h�Osort�� ��k
public class MyAnagramComparator implements Comparator<String>{

	private String getSortedStringByChar(String str) {
		
		char[] sortedChars = str.toCharArray();
		Arrays.sort(sortedChars);
		//���M�N(�ƾǤW)�ȳ��O�@�˪�, ���Otype�o���P; �]���o���ഫ
		return new String(sortedChars);
	}

	@Override
	//�Ʊ�Τ���char���Ǫ��h���Ӥ��(�o�O�ڤ߸̪��Φ�, ���ƾǵL�k����
	//������, �N�O��Ҧ�char���ǳ��令�@��: �q�p��j(�o�O�ƾǥi�H����������
	public int compare(String o1, String o2) {
		return getSortedStringByChar(o1).compareTo(getSortedStringByChar(o2));
	}
	
}
