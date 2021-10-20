package c08_RecursionDynamicProgramming.p09_Parenthesis;
//import static java.lang.System.out;

import java.util.ArrayList;
//2020 1121(Sat
public class Parenthesis_way02 {
	
	static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index) {
		
		//invalid state
		if( leftRem < 0 || rightRem < leftRem ) {
			return ;
		}
		
		if( leftRem == 0 && rightRem == 0 ) {
			list.add( String.copyValueOf(str) );
		}
		else {
			
			//add left and recurse
			str[index] = '(';
			addParen(list, leftRem -1, rightRem, str, index + 1);
			
			//add right and recurse
			str[index] = ')';
			addParen(list, leftRem, rightRem -1, str, index + 1);
		}
	}
	
	public static ArrayList<String> generateParens(int count){
		
		char[] str = new char[count*2];
		ArrayList<String> list = new ArrayList<>();
		addParen(list, count, count, str, 0);
		return list;
		
	}

}


