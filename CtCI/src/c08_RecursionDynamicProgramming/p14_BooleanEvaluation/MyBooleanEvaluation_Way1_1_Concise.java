package c08_RecursionDynamicProgramming.p14_BooleanEvaluation;

public class MyBooleanEvaluation_Way1_1_Concise {
public static  int getNumberOfEvaluations(String expression, boolean desiredValue) {
		
		//base case
		if( expression == null || expression.length() <= 1 )
			return baseCaseHelper(expression, desiredValue);
		
		int totalNumberOfEvaluations = 0;
		for(int i = 1; i < expression.length(); i+=2) {
			
			char operator = expression.charAt(i);
			String left_expression = expression.substring(0, i);
			String right_expression = expression.substring(i+1);
			
			int number_left_true = getNumberOfEvaluations(left_expression, true);
			int number_left_false = getNumberOfEvaluations(left_expression, false);
			int number_right_true = getNumberOfEvaluations(right_expression, true);
			int number_right_false = getNumberOfEvaluations(right_expression, false);
			
			int numberOfEvaluations = normalCaseHelper(
					number_left_false, number_left_true,
					number_right_false, number_right_true,
					operator, desiredValue
					);
			
			
			
			//it's like list.add(element) in a for loop
			totalNumberOfEvaluations += numberOfEvaluations;
		}
		
		
		
		return totalNumberOfEvaluations;
	}
	
	static private int baseCaseHelper(String expression, boolean desiredValue) {
		
		
		if( expression == null || expression.length() == 0)
			return 0;
		
		//我覺得這裡不好, 因為length 其實為1, 但是必須要透過上下文來得知; 且是在這個method被一個地方call得
		//情況下才成立
		if (desiredValue == true) {
			if (expression.equals("1"))
				// the value is this method's return value: numberOfEvaluation
				return 1;
			else
				return 0;
		}
		if (expression.equals("0"))
			return 1;
		else
			return 0;
	}
	
	static private int normalCaseHelper(int left_false, int left_true
			,int right_false, int right_true, char operator, boolean desiredValue) {
		
		int numberOfEvaluations = 0;
		if( desiredValue == true ) {
			// oops! I forget the break
			switch (operator) {
			case '&':
				numberOfEvaluations = left_true * right_true;
				break;
			case '|':
				numberOfEvaluations = left_true * right_true 
					+ left_false * right_true
					+ left_true * right_false;
				break;
			case '^':
				numberOfEvaluations = left_false * right_true
						+ left_false * right_false;
				break;
			}
		}
		else if( desiredValue == false ) {
			switch (operator) {
			case '&':
				numberOfEvaluations = left_false * right_true
					+ left_true * right_false
					+ left_false * right_false; 
				break;
			case '|':
				numberOfEvaluations = left_false * right_false ;
				break;
			case '^':
				numberOfEvaluations = left_true * right_true
						+ left_false * right_false;
				break;
			}
		}
		return numberOfEvaluations;
		
	}

}
