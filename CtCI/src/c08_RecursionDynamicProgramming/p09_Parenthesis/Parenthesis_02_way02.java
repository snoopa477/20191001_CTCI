package c08_RecursionDynamicProgramming.p09_Parenthesis;
//import static java.lang.System.out;

import java.util.ArrayList;
//2020 1124(Tue)
public class Parenthesis_02_way02 {
	
	public static ArrayList<String> getParens(int pairsOfParens){
		
		//temp 
		ArrayList<String> results = new ArrayList<String>();
		addParens(pairsOfParens, 0, 0, "", results  );
		return results;
	}
	
	//backbone
	//recursion type 2: harvest
	static void addParens(int maxNum, int leftParen, int rightParen, String parens, ArrayList<String> results) {
		
		//invalid
		if( rightParen > leftParen ) {
			return ;
		}
		
		if( leftParen > maxNum || rightParen > maxNum ) {
			return ;
		}
		
		if( leftParen == maxNum && rightParen == maxNum ) {
			results.add(parens);
			//careful... ok, this line can be omitted in this problem
			return ;
		}
		
		addParens(maxNum, leftParen + 1, rightParen, parens + "(", results);
		addParens(maxNum, leftParen, rightParen + 1, parens + ")", results);
		
		//Wrong concept: trying to insert single paren in any position in str
		//careful: it's <=
//		for(int i = 0; i <= parens.length(); i++) {
//			String newParens = addOneSidedParen(parens, i, "(");
//			addParens(maxNum, leftParen + 1, rightParen, newParens, results);
//		}
		
//		for(int i = 0; i <= parens.length(); i++) {
//			String newParens = addOneSidedParen(parens, i, ")");
//			addParens(maxNum, leftParen, rightParen + 1, newParens, results);
//		}
		
	}
	
	//this is not needed
	static String addOneSidedParen(String str, int index, String oneSidedParen) {
		
		if( index < 0 || index > str.length() ) {
			return null;
		}
		
		String leftPart = str.substring(0,index);
		String rightPart = str.substring(index);
		
		
		return leftPart + oneSidedParen + rightPart;
	}
	
}


