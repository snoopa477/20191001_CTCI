package c10_SortingAndSearching.p02_GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;

import util.HashMapList;
import util.MyHashMapList;

//20191219(Thur
public class MySort {

	public static void sort(String[] strs) {
		
		MyHashMapList<String,String> hashMapList = new MyHashMapList<>();
		
		for(String str: strs) {
			String sortedStr = getSortedStringByChar(str);
			hashMapList.put(sortedStr, str);
		}
		
		int strs_index = 0;
		for( String sortedStr : hashMapList.keySet() ) {
			
			ArrayList<String> list = hashMapList.get(sortedStr);
			
			for(String str : list) {
				//�i�H�л\, �]���Ҧ��F��w�g�s��map object�z�F, �åB�ڭ̷|iterate thru ��
				//�Ҧ��Amap object��elts
				strs[strs_index] = str;
				strs_index++;
			}
			
		}
		
	}
	
	private static String getSortedStringByChar(String str) {
		char[] sortedChars = str.toCharArray();
		Arrays.sort(sortedChars);
		return new String(sortedChars);
	}
}
