package c08_RecursionDynamicProgramming.p09_Parenthesis;

import static java.lang.System.out;

public class P09Test {

	public static void main(String[] args) {
		{
			out.println(Parenthesis.generateParens(3));
			out.println(MyParenthesis.generateParenthesis(3));

			out.println("[" + "01234".substring(0, 0) + "]");
			out.println("[" + "01234".substring(0, 1) + "]");
			// out.println( "[" + "01234".substring(2, -3) + "]");
		}
		
		{
			out.println("textbook way 2:");
			out.println( Parenthesis_way02.generateParens(3) );
		}
		
		{
			out.println("my way 1:");
			out.println( Parenthesis_02_way02.getParens(3) );
		}
		
		{
			out.println("my way 2:");
			out.println( Parenthesis_02_way02.getParens(3) );
		}
	}

}
