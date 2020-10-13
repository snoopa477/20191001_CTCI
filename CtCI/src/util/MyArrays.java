package util;

import static java.lang.System.out;

public class MyArrays {

	public static void swap(int[] array, int a_idx, int b_idx) {
		int temp = array[a_idx];
		array[a_idx] = array[b_idx];
		array[b_idx] = temp;
	}
	
	public static void print(int[] array) {
		for(int i = 0; i < array.length; i++) {
			out.printf(array[i] + " ");
		}
		out.println();
	}
	
	public static String toString(int[] array) {
		
		StringBuffer sb = new StringBuffer();  
		
		for(int i = 0; i < array.length; i++) {
			sb.append(array[i]);
			sb.append(" ");
		}
		return sb.toString();
	}
	
}
