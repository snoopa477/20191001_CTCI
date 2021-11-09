package c08_RecursionDynamicProgramming.p09_Parenthesis;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;

public class P09Test {

	public static void main(String[] args) {
		
		
		String[] chosenOptions = { "1", "6"};
		HashSet<String> options = new HashSet<>( Arrays.asList(chosenOptions) );
		
		
		if(options.contains("1"))
		{
			out.println(Parenthesis.generateParens(3));
			out.println(MyParenthesis.generateParenthesis(3));

			out.println("[" + "01234".substring(0, 0) + "]");
			out.println("[" + "01234".substring(0, 1) + "]");
			// out.println( "[" + "01234".substring(2, -3) + "]");
		}
		
		if(options.contains("2"))
		{
			out.println("textbook way 2:");
			out.println( Parenthesis_way02.generateParens(3) );
		}
		
		if(options.contains("3"))
		{
			out.println("my way 1:");
			out.println( Parenthesis_02_way02.getParens(3) );
		}
		
		if(options.contains("4"))
		{
			out.println("my way 2:");
			out.println( Parenthesis_02_way02.getParens(3) );
		}
		
		if(options.contains("5"))
		{
			out.println("my way 2:");
			out.println( Parenthesis_02_way02.getParens(2) );
		}
		
		if(options.contains("6"))
		{
			out.println("case 6. _Practice_Parenthesis_way02:");
			out.println( _Practice_Parenthesis_way02.getAllParenSeqs(3) );
		}
		
	}

}
