package c08_RecursionDynamicProgramming._0807_PermutationWithoutDups;
//import static java.lang.System.out;

import java.util.ArrayList;
public class PermutationWithoutDups_way02 {
	
	public static ArrayList<String> getPerms(String remainder){
		
		int len = remainder.length();
		ArrayList<String> result = new ArrayList<>();
		
		/*base case*/
		if(len == 0) {
			result.add("");// be sure to return empty string!
			return result;
		}
		
		for( int i = 0; i < len; i++ ) {
			//Remove char i and find permutations of remaining chars.
			String before = remainder.substring(0,i);
			String after = remainder.substring(i+1, len);
			ArrayList<String> partials = getPerms(before + after);
			
			//prepend char i to each permutations
			for(String s : partials) {
				result.add(remainder.charAt(i) + s );
			}
		}
		
		return result;
	}
	

}


