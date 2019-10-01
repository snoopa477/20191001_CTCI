package c08_RecursionDynamicProgramming.p09_Parenthesis.draft01;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
//20190930
public class MyParenthesis {

	public static Set<String> allParenthesisWithLayer(int layer) {
		
		if(layer == 0) {
			Set<String>	 initialSet = new HashSet<String>();
			initialSet.add("");
			return initialSet;
		}
		
		//should I clone?
		Set<String> currentSet = allParenthesisWithLayer( layer -1);
		
		Set<String> resultSet = new HashSet<>();
		for( String parenthesis : currentSet ) {
			//if i wanna describe/name this operation, I would use method
			resultSet.addAll( generateParensByInsertionAtEveryIndex(parenthesis) );
		}
		
		
		return resultSet;
	}

	private static Set<String> generateParensByInsertionAtEveryIndex(String parenthesis) {
		
		Set<String> resultSet = new HashSet<>();
		
		
		for(int i =0; i < parenthesis.length(); i++) {
			String newParenthesis = parenthesis.substring(0,i) + "()" + parenthesis.substring(i);
			resultSet.add(newParenthesis);
		}
		
		//corner case
		resultSet.add( parenthesis + "()" );
		
		
		
		return resultSet;
	}
	
}
