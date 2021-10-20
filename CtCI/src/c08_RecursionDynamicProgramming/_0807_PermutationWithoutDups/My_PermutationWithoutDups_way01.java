package c08_RecursionDynamicProgramming._0807_PermutationWithoutDups;
import static java.lang.System.out;

import java.util.ArrayList;
public class My_PermutationWithoutDups_way01 {
	
	static ArrayList<String> getPerms(String str){
		
		ArrayList<String> results = new ArrayList<>();
		
		//base case
		if(str.length() == 0) {
			results.add("");
			return results;
		}
		
//		String firstChar = str.substring(0,1);
		char firstChar = str.charAt(0);
		ArrayList<String> remaindersOfStr= getPerms(str.substring(1));
		
		for( String remainder : remaindersOfStr ) {
			
			for(int i = 0; i <= remainder.length(); i++) {
				String result = insertCharAt(remainder, firstChar, i);
				results.add(result);
			}
			
		}
		
		return results;
	}
	
	static String insertCharAt(String str, char target, int index ){
		
		String before = str.substring(0, index);
		String after = str.substring(index);
		
		
		return before + target + after;
	}

}


