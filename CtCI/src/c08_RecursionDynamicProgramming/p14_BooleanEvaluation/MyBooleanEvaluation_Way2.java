package c08_RecursionDynamicProgramming.p14_BooleanEvaluation;

import java.util.Map;

//21091124(Sun
public class MyBooleanEvaluation_Way2 {

	
	public static int getNumberOfEvaluations(String expression, boolean result
			, Map<String, Integer> exprAppendResultToEvals) {
		
		if( expression == null || expression.length() == 0) {
			return 0;
		}
		
		if( expression.length() == 1 ) {
			return stringToBool(expression) == result? 1: 0;
		}
		
		if( exprAppendResultToEvals.containsKey(expression + result) ) {
			return exprAppendResultToEvals.get(expression + result);
		}
		
		//currentIndex ���G�Φr�� i �γ~��j�P�@��
		int totalEval = 0;
		for(int currentIndex = 1; currentIndex < expression.length(); currentIndex += 2) {
			
			char operator = expression.charAt(currentIndex);
			String leftExp = expression.substring(0, currentIndex);
			String rightExp = expression.substring(currentIndex + 1 );
			
			int numEvalLeftFalse = getNumberOfEvaluations(leftExp, false, exprAppendResultToEvals);
			int numEvalLeftTrue = getNumberOfEvaluations(leftExp, true, exprAppendResultToEvals);
			int numEvalRightFalse = getNumberOfEvaluations(rightExp, false, exprAppendResultToEvals);
			int numEvalRightTrue = getNumberOfEvaluations(rightExp, true, exprAppendResultToEvals);
			
			//first layer: true or false. second layer: '^', '&', '|' => 2 x 3 = 6
			//we reduce one layer by using totalEval
			int numEval = ( numEvalLeftFalse + numEvalLeftTrue ) 
					* ( numEvalRightFalse + numEvalRightTrue );
			int numEvalRight = 0;
			switch(operator) {
			case '^':
				numEvalRight = numEvalLeftFalse * numEvalRightTrue 
							 + numEvalLeftTrue * numEvalRightFalse;
				break;
			case '&':
				numEvalRight = numEvalLeftTrue * numEvalRightTrue;
				break;
			case '|':
				numEvalRight = numEvalLeftFalse * numEvalRightTrue 
				 			 + numEvalLeftTrue * numEvalRightFalse
				 			 + numEvalLeftTrue * numEvalRightTrue;
				break;
			}
			
			int currentTotalEval = result == true? numEvalRight : numEval - numEvalRight;
			totalEval += currentTotalEval;
		}
		
		exprAppendResultToEvals.put(expression + result, totalEval);
		return totalEval;
	}
	
	
	
	//�o�����ӬO����@�b�~�Q�쪺�F �Ӥ��O�@�}�l�N�X�{
	private static boolean stringToBool(String str) {
		
		return str.equals("1")? true : false;
		
	}
	
}
