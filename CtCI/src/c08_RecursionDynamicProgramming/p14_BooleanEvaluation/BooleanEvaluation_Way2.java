package c08_RecursionDynamicProgramming.p14_BooleanEvaluation;

import java.util.HashMap;

//20191123(Sat
public class BooleanEvaluation_Way2 {

	public static int countEval(String s, boolean result, HashMap<String, Integer> memo) {
		
		if( s.length() == 0) return 0;
		if( s.length() ==1 ) {
			return stringToBool(s) == result?
					1: 0;
		}
		
		if( memo.containsKey(result + s) )
			return memo.get(result + s);
	
		int ways = 0;
		for( int i = 1; i < s.length(); i += 2 ) {
			
			char c = s.charAt(i);
			
			String left = s.substring(0,i);
			String right = s.substring(i+1, s.length());
			
			int leftTrue = countEval(left, true, memo);
			int leftFalse = countEval(left, false, memo);
			int rightTrue = countEval(right, true, memo);
			//wrong: 
			//int rightFalse = countEval(left, false, memo);
			int rightFalse = countEval(right, false, memo);
			
			int total = ( leftTrue + leftFalse ) * ( rightTrue + rightFalse );
			
			int totalTrue = 0;
			if( c == '^' ) {
				totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
			}
			else if ( c == '&') {
				totalTrue = leftTrue * rightTrue;
			}
			else if ( c == '|') {
				totalTrue = leftTrue * rightTrue 
						  + leftFalse * rightTrue 
						  + leftTrue * rightFalse;
			}
			
			//wrong
			int subWays = result ? totalTrue : total - totalTrue;
			
			ways += subWays;
			
		}
		
		memo.put(result + s, ways);
		return ways;
	}
	
	private static boolean stringToBool(String c ) {
		return c.equals("1")? true: false;
	}
	
}
