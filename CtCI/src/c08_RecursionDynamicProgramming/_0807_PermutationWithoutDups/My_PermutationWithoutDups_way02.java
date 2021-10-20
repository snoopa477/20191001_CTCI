package c08_RecursionDynamicProgramming._0807_PermutationWithoutDups;
import static java.lang.System.out;

import java.util.ArrayList;
public class My_PermutationWithoutDups_way02 {
	
	static ArrayList<String> getPerms(String str){
		
		ArrayList<String> results = new ArrayList<>();
		
		//base case
		if(str.length() == 0) {
			results.add("");
			return results;
		}
		
		for(int i = 0; i < str.length(); i++) {
			char target = str.charAt(i);
			String beforeTarget = str.substring(0,i);
			String afterTarget = str.substring(i + 1);
			String withoutTarget = beforeTarget + afterTarget;
			
			ArrayList<String> withoutTargetPerms = getPerms( withoutTarget ); 
			for( String result : withoutTargetPerms) {
				result = target + result;
				results.add(result);
			}
			
		}
		
		return results;
	}

}


