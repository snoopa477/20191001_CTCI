package c08_RecursionDynamicProgramming.p09_Parenthesis;

//import java.util.ArrayList;
import java.util.HashSet;

//import static java.lang.System.out;
//2020 1124(Tue)
public class Parenthesis_01_way02 {
	
	
	//backbone, recursion type1
	static HashSet<String> getParens(int pairsOfParens){
		
		//MISTAKE: since there are duplicates, we use HashSet instead
		//ArrayList<String> results = new ArrayList<>();
		HashSet<String> results = new HashSet<>();
		
		if( pairsOfParens == 0 ) {
			results.add("");
			return results;
		}
		
		HashSet<String> subResults = getParens(pairsOfParens - 1);
		
		for( String subResult : subResults ) {
			//careful, it's <=
			for( int i = 0; i <= subResult.length(); i ++) {
				String result = addPairOfParen(subResult, i);
				results.add(result);
			}
		}
		
		return results;
	}
	
	static String addPairOfParen(String str, int index) {
		
		if( index < 0 || index > str.length() ) {
			return null;
		}
		
		String leftPart = str.substring(0,index);
		String rightPart = str.substring(index);
		
		
		return leftPart + "()" + rightPart;
	}

}


