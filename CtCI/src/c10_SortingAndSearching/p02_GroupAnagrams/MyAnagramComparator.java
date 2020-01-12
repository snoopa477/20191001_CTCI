package c10_SortingAndSearching.p02_GroupAnagrams;

import java.util.Arrays;
import java.util.Comparator;

//20191219(Thur
//comparable 與comparator的差異? 
//我目前的猜測, 是comparable給需要augmented loop
//comparator則是sort的 方法
public class MyAnagramComparator implements Comparator<String>{

	private String getSortedStringByChar(String str) {
		
		char[] sortedChars = str.toCharArray();
		Arrays.sort(sortedChars);
		//雖然就(數學上)值都是一樣的, 但是type卻不同; 因此得做轉換
		return new String(sortedChars);
	}

	@Override
	//希望用不管char順序的層面來比較(這是我心裡的形式, 但數學無法接受
	//換言之, 就是把所有char順序都改成一樣: 從小到大(這是數學可以接受的型式
	public int compare(String o1, String o2) {
		return getSortedStringByChar(o1).compareTo(getSortedStringByChar(o2));
	}
	
}
