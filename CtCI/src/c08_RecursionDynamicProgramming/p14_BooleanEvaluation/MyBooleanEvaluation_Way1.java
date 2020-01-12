package c08_RecursionDynamicProgramming.p14_BooleanEvaluation;

//20191121(Thur
public class MyBooleanEvaluation_Way1 {

	
	
	public static  int getNumberOfEvaluations(String expression, boolean desiredValue) {
		
		//base case
		if( expression == null || expression.length() == 0)
			return 0;
		
		//so verbose
		
		if(expression.length() == 1) {
			
			if(desiredValue == true) {
				if(expression.equals("1"))
					//the value is this method's return value: numberOfEvaluation
					return 1;
				else
					return 0;
			}
			if(desiredValue == false) {
				if(expression.equals("0"))	
					return 1;
				else	
					return 0;
			}
		}
		
		//T F 0
		//T T 1
		//F F 1
		//F T 0
		//不好, 思緒混淆 就得重來; 必須一步一步
//		if(expression.length() == 1) {
//			
//			return expression.equals("1") == desiredValue? 1: 0;
//			
//		}
		
		
		int totalNumberOfEvaluations = 0;
		for(int i = 1; i < expression.length(); i+=2) {
			
			char operator = expression.charAt(i);
			String left_expression = expression.substring(0, i);
			String right_expression = expression.substring(i+1);
			
			int number_left_true = getNumberOfEvaluations(left_expression, true);
			int number_left_false = getNumberOfEvaluations(left_expression, false);
			int number_right_true = getNumberOfEvaluations(right_expression, true);
			int number_right_false = getNumberOfEvaluations(right_expression, false);
			
			int numberOfEvaluations = 0;
			
			if( desiredValue == true ) {
				// oops! I forget the break
				switch (operator) {
				case '&':
					numberOfEvaluations = number_left_true * number_right_true;
					break;
				case '|':
					numberOfEvaluations = number_left_true * number_right_true 
						+ number_left_false * number_right_true
						+ number_left_true * number_right_false;
					break;
				case '^':
					numberOfEvaluations = number_left_false * number_right_true
							+ number_left_false * number_right_false;
					break;
				}
			}
			else if( desiredValue == false ) {
				switch (operator) {
				case '&':
					numberOfEvaluations = number_left_false * number_right_true
						+ number_left_true * number_right_false
						+ number_left_false * number_right_false; 
					break;
				case '|':
					numberOfEvaluations = number_left_false * number_right_false ;
					break;
				case '^':
					numberOfEvaluations = number_left_true * number_right_true
							+ number_left_false * number_right_false;
					break;
				}
			}
			
			//it's like list.add(element) in a for loop
			totalNumberOfEvaluations += numberOfEvaluations;
		}
		
		
		
		return totalNumberOfEvaluations;
	}
	
	
}
