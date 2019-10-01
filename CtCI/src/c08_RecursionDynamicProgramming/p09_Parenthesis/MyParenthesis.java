package c08_RecursionDynamicProgramming.p09_Parenthesis;

import java.util.HashSet;
import java.util.Set;

public class MyParenthesis {

	public static Set<String> generateParenthesis(int leftToProcess) {

		//On the first look, you might though the base case and general case share the 
		//whole function, but no!
		
		Set<String> resultSet = new HashSet<>();
		// base case
		if (leftToProcess == 0) {
			resultSet.add("");
			return resultSet;
		}

		// other cases
		Set<String> prevSet = generateParenthesis(leftToProcess - 1);
		for (String parenthesis : prevSet) {
			//be careful about the iteration boundary
			for (int i = 0; i <= parenthesis.length(); i++) {
				String currentParenthesis = insertSingleParenthesis( parenthesis, i );
				resultSet.add(currentParenthesis);
			} 
		}

		return resultSet;
	}

	//knowing what exactly the argument to plug into subString is based on experiment
	//and the experiment has three phases: 1. general case 2. boundary case
	private static String insertSingleParenthesis(String parenthesis, int index) {
		
		String firstPart = parenthesis.substring(0,index);
		String lastPart = parenthesis.substring(index);
		
		
		return firstPart + "()" + lastPart;
	}

}
