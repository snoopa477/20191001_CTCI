package c08_RecursionDynamicProgramming.p14_BooleanEvaluation;
import static java.lang.System.out;

import java.util.HashMap;

//2020 1223(Tue
public class BooleanEvaluation_Way1_Freq02 {
	
	public static int numberOfEvaluations(String expression, boolean desiredValue) {
		
		HashMap<String, Integer> exprAndBoolean_to_count = new HashMap<String, Integer>();
		
		int result = numberOfEvaluations(expression, desiredValue, exprAndBoolean_to_count);
//		printMapObject(exprAndBoolean_to_count);
		return result;
	}
	
	//backbone
	static int numberOfEvaluations(String expression, boolean desiredValue
			, HashMap<String, Integer> exprAndBoolean_to_count) {
		
		//base case 1
		if( expression.length() == 0 ) {
			return 0;
		}
		
		//base case 2
		if(expression.length() == 1) {
			boolean isZero = expression.equals("0")? true: false; 
			if( desiredValue == false ) {
				if( isZero ) { return 1; }
				else { return 0; }
			}
			else {
				if( isZero ) { return 0; }
				else { return 1; }
			}
		}
		
		if(exprAndBoolean_to_count.containsKey(expression)) {
			return exprAndBoolean_to_count.get(expression);
		}
		
		int results = 0;
		for( int operatorIndex = 1; operatorIndex < expression.length(); operatorIndex += 2 ) {
			
			char operator = expression.charAt(operatorIndex);
			String left_expr = expression.substring(0, operatorIndex);
			String right_expr = expression.substring(operatorIndex +1 );
			
			int left_T_count = numberOfEvaluations(left_expr, true, exprAndBoolean_to_count);
			int left_F_count = numberOfEvaluations(left_expr, false, exprAndBoolean_to_count);
			
			int right_T_count = numberOfEvaluations(right_expr, true, exprAndBoolean_to_count);
			int right_F_count = numberOfEvaluations(right_expr, false, exprAndBoolean_to_count);
			
			int total_count = (left_T_count + left_F_count) * ( right_T_count + right_F_count );
			int expr_T_count = getExpression_T_count(operator, left_T_count, left_F_count
					, right_T_count, right_F_count
					, total_count);
			
			int subResult = desiredValue? expr_T_count : total_count - expr_T_count;
			results += subResult;
			
		}
		
		//wrong, and the naming is suggesting the wrong way. we need both expression and True/False as a key
		//expression_to_count.put(expression, results);
		
		exprAndBoolean_to_count.put(expression + (desiredValue == true? "true": "false"), results);
		return results;
	}
	
	static int getExpression_T_count( char operator, int left_T_count, int left_F_count
			, int right_T_count, int right_F_count
			, int total_count) {
		
		switch( operator ) {
			case '&':
				return left_T_count * right_T_count;
			
			case '|':
				return total_count - left_F_count * right_F_count;
			
			case '^':
				return left_T_count * right_F_count + left_F_count * right_T_count;
				
		}
		
		//it's unreachable
		return 0;
	}
	
	static void printMapObject(HashMap<String, Integer> map) {
		
		for( String key : map.keySet() ) {
			out.println(key + "  "+map.get(key));
		}
		
	}
	
}


