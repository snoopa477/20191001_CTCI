package c08_RecursionDynamicProgramming.p08_PermutationsWithDuplicates;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;
//20190812(Mon
public class P08Test {

	public static void main(String[] args) {
//		out.println(PermutationsWithDuplicates.printPerms("abcc"));
		
		String[] chosenOptions = { "1", "4"};
		HashSet<String> options = new HashSet<>( Arrays.asList(chosenOptions) );
		
		if(options.contains("1"))
		{
			out.println("textbook 1: ");
			out.println(MyPermutationWithDuplicates.printPermutations("abccc"));
		}
		
		
		if(options.contains("2"))
		{
			out.println("case 2 my way 01: ");
			out.println(My_PermutationsWithDuplicates_way01.getPerms("abccc"));
		}
		
		
		if(options.contains("3"))
		{
			out.println("case 3 my way 02: ");
			out.println(My_PermutationsWithDuplicates_way02.getPerms("abccc"));
		}
		
		if(options.contains("4"))
		{
			out.println("case 4 _Practice_My_PermutationsWithDuplicates_way01: ");
			out.println(_Practice_My_PermutationsWithDuplicates_way01.getPermDuplicates("abccc"));
		}
		
		out.println("end");
		
	}

}
