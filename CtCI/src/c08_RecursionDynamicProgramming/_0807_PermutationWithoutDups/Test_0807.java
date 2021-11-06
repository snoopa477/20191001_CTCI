package c08_RecursionDynamicProgramming._0807_PermutationWithoutDups;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;
public class Test_0807 {

	public static void main(String[] args) {
		
		String[] chosenOptions = { "1", "5", "6"};
		HashSet<String> options = new HashSet<>( Arrays.asList(chosenOptions) );
		
		if(options.contains("1"))
		{
			out.println("textbook way 1: ");
			String str = getString();
			out.println( PermutationWithoutDups_way01.getPerms(str) );
		}
		
		if(options.contains("2"))
		{
			out.println("textbook way 2: ");
			String str = getString();
			out.println( PermutationWithoutDups_way02.getPerms(str) );
		}
		
		
		if(options.contains("3"))
		{
			out.println("textbook way my 1: ");
			String str = getString();
			out.println( My_PermutationWithoutDups_way01.getPerms(str) );
		}
		
		
		if(options.contains("4"))
		{
			out.println("textbook way my 2: ");
			String str = getString();
			out.println( My_PermutationWithoutDups_way02.getPerms(str) );
		}
		
		if(options.contains("5"))
		{
			out.println("case 5: _Practice_My_PermutationWithoutDups_way01: ");
			String str = getString();
			out.println( _Practice_My_PermutationWithoutDups_way01.getAllPermutatoins(str) );
		}
		
		if(options.contains("6"))
		{
			out.println("case 6: _Practice_My_PermutationWithoutDups_way02: ");
			String str = getString();
			out.println( _Practice_My_PermutationWithoutDups_way02.getAllPermutatoins(str) );
		}
		
		out.println("end");
		
	}
	
	static String getString() {
		return "abcd";
	}

}


