package c08_RecursionDynamicProgramming.p14_BooleanEvaluation;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

//20191119(Tue
public class TestBooleanEvaluation {

	public static void main(String[] args) {
		
		String[] chosenOptions = { "1" , "2" };
		HashSet<String> options = new HashSet<>( Arrays.asList(chosenOptions) );
//		out.println("BooleanEvaluation_Way1");
//		out.println( BooleanEvaluation_Way1.countEval("1^0|0|1", false) );
//		out.println( BooleanEvaluation_Way1.countEval("0&0&0&1^1|0", true) );
//		out.println("MyBooleanEvaluation_Way1");
//		out.println( MyBooleanEvaluation_Way1.getNumberOfEvaluations("1^0|0|1", false) );
//		out.println( MyBooleanEvaluation_Way1.getNumberOfEvaluations("0&0&0&1^1|0", true) );
//		out.println("MyBooleanEvaluation_Way1_1_Concise");
//		out.println( MyBooleanEvaluation_Way1_1_Concise.getNumberOfEvaluations("1^0|0|1", false) );
//		out.println( MyBooleanEvaluation_Way1_1_Concise.getNumberOfEvaluations("0&0&0&1^1|0", true) );
//		out.println("BooleanEvaluation_Way2");
//		out.println( BooleanEvaluation_Way2.countEval("1^0|0|1", false, new HashMap<>()) );
//		out.println( BooleanEvaluation_Way2.countEval("0&0&0&1^1|0", true, new HashMap<>()) );
		
//		out.println("BooleanEvaluation_Way2");
//		out.println( MyBooleanEvaluation_Way2.getNumberOfEvaluations("1^0|0|1", false, new HashMap<>()) );
//		HashMap<String, Integer> expr_to_count = new HashMap<>();
//		out.println( MyBooleanEvaluation_Way2.getNumberOfEvaluations("0&0&0&1^1|0", true, expr_to_count ) );
//		printMapObject(expr_to_count);
		
		if(options.contains("1"))
		{
			out.println("BooleanEvaluation_Way1_Freq02");
			out.println(BooleanEvaluation_Way1_Freq02.numberOfEvaluations("1^0|0|1", false));
			out.println(BooleanEvaluation_Way1_Freq02.numberOfEvaluations("0&0&0&1^1|0", true));
		}
		
		
		if(options.contains("2"))
		{
			out.println("_Practice_BooleanEvaluation");
			out.println(_Practice_BooleanEvaluation.numberOfbooleanEvaluation("1^0|0|1", false));
			out.println(_Practice_BooleanEvaluation.numberOfbooleanEvaluation("0&0&0&1^1|0", true));
		}
		
		out.println("end");
		
	}
	
	static void printMapObject(HashMap<String, Integer> map) {
		
		for( String key : map.keySet() ) {
			out.println(key + "  "+map.get(key));
		}
		
	}

}
