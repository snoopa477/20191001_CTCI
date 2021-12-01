package c08_RecursionDynamicProgramming.p14_BooleanEvaluation;
import static java.lang.System.out;

import java.util.HashMap;
public class _Practice_BooleanEvaluation {

	public static int numberOfbooleanEvaluation(String expression, boolean evaluation) {
		
		 HashMap<String, Integer> expressionToWays = new HashMap<>();
		
		return waysOfbooleanEvaluation(expression, evaluation, expressionToWays);
	}
	
	private static int waysOfbooleanEvaluation(String expression, boolean evaluation, HashMap<String, Integer> expressionToWays) {
		
		
		
		//base case: no operator, the operand itself yields evaluation
		if( expression.length() == 1 ) {
			
			//DETAIL: if evaluation is true, and expression is 1, there are 1 way( don't get confused)
			if( evaluation == true ) {
				if(expression.equals("1")) {
				//if( expression == "1" ) {
					//number of way
					return 1;
				}
				else {
					return 0;
				}
			}
			else {
				if(expression.equals("1")) {
				//if( expression == "1" ) {
					return 0;
				}
				else {
					return 1;
				}
			}
		}
		
		if( expressionToWays.containsKey(expression) ) {
			return expressionToWays.get(expression);
		}
		
		//general case
		//DETAIL 'i' stands for indexOfOperator : ^, |, &
		
		int result = 0;
		//for(int i = 0; i < expression.length(); i+=2) {
		for(int i = 1; i < expression.length(); i+=2) {
			
			
			/*
			 DETAIL:
			 'operator': under index 'i''s operator
			 'leftExpression': under index 'i''s leftExpression
			 * */
			int currentResult = 0;
			char operator = expression.charAt(i); 
			String leftExpression = expression.substring(0, i);
			String rightExpression = expression.substring(i+1);
			//String rightExpression = expression.substring(i);
			
			int left_evaluation_true = numberOfbooleanEvaluation(leftExpression, true);
			int left_evaluation_false = numberOfbooleanEvaluation(leftExpression, false);
			int right_evaluation_true = numberOfbooleanEvaluation(rightExpression, true);
			int right_evaluation_false = numberOfbooleanEvaluation(rightExpression, false);
			//out.println(leftExpression + "; left_evaluation_true :" + left_evaluation_true +" " + rightExpression + "; right_evaluation_true :" + right_evaluation_true);
			
			int totalResult = ( left_evaluation_true + left_evaluation_false) * ( right_evaluation_true + right_evaluation_false );
			
			int current_true_result = 0;
			int current_false_result = 0;
			if( operator == '&' ) {
				current_true_result = left_evaluation_true * right_evaluation_true;
				if( evaluation == true ) {
					result += current_true_result;
				}
				else {
					result +=  totalResult - current_true_result ;
				}
			}
			else if( operator == '|') {
				current_false_result =  left_evaluation_false * right_evaluation_false;
				if( evaluation == false ) {
					result += current_false_result;
				}
				else {
					result +=  totalResult - current_false_result;
				}
				
			}else if( operator == '^') {
				current_true_result = left_evaluation_true * right_evaluation_false
						+  left_evaluation_false * right_evaluation_true;
				if( evaluation == true ) {
					result += current_true_result;
				}
				else {
					result +=  totalResult - current_true_result ;
				}
			}
			//result += currentResult; 
		}
		
		expressionToWays.put( expression, result );
		
		return result;
	}
	
}


