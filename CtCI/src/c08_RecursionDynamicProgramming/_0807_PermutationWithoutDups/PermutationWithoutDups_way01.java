package c08_RecursionDynamicProgramming._0807_PermutationWithoutDups;
//import static java.lang.System.out;

import java.util.ArrayList;
public class PermutationWithoutDups_way01 {

	static public ArrayList<String> getPerms(String str){
		
		if( str == null ) {
			return null;
		}
		
		ArrayList<String> permutations = new ArrayList<>();
		if(str.length() == 0) { // base case
			permutations.add("");
			return permutations;
		}
		
		char first = str.charAt(0); // get the first char
		String remainder = str.substring(1);//remove the first char
		ArrayList<String> words = getPerms(remainder);
		
		for( String word : words ) {
			//MISTAKE
			//for( int j = 0; j < word.length(); j++) {
			for( int j = 0; j <= word.length(); j++) {
				String s = insertCharAt(word, first, j);
				permutations.add(s);
			}
		}
		return permutations;
	}
	
	/*insert char c at index i in word.*/
	static String insertCharAt(String word, char c, int i) {
		String start = word.substring(0,i);
		String end = word.substring(i);
		return start + c + end;
	}
	
	
}


