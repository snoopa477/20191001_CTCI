package c08_RecursionDynamicProgramming.p14_BooleanEvaluation;

import static java.lang.System.out;

import java.util.HashMap;

//20191119(Tue
public class TestBooleanEvaluation {

	public static void main(String[] args) {
		out.println("BooleanEvaluation_Way1");
		out.println( BooleanEvaluation_Way1.countEval("1^0|0|1", false) );
		out.println( BooleanEvaluation_Way1.countEval("0&0&0&1^1|0", true) );
		out.println("MyBooleanEvaluation_Way1");
		out.println( MyBooleanEvaluation_Way1.getNumberOfEvaluations("1^0|0|1", false) );
		out.println( MyBooleanEvaluation_Way1.getNumberOfEvaluations("0&0&0&1^1|0", true) );
		out.println("MyBooleanEvaluation_Way1_1_Concise");
		out.println( MyBooleanEvaluation_Way1_1_Concise.getNumberOfEvaluations("1^0|0|1", false) );
		out.println( MyBooleanEvaluation_Way1_1_Concise.getNumberOfEvaluations("0&0&0&1^1|0", true) );
		out.println("BooleanEvaluation_Way2");
		out.println( BooleanEvaluation_Way2.countEval("1^0|0|1", false, new HashMap<>()) );
		out.println( BooleanEvaluation_Way2.countEval("0&0&0&1^1|0", true, new HashMap<>()) );
		
		out.println("BooleanEvaluation_Way2");
		out.println( MyBooleanEvaluation_Way2.getNumberOfEvaluations("1^0|0|1", false, new HashMap<>()) );
		out.println( MyBooleanEvaluation_Way2.getNumberOfEvaluations("0&0&0&1^1|0", true, new HashMap<>()) );
		
	}

}
