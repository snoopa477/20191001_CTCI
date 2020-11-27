package c08_RecursionDynamicProgramming.p08_PermutationsWithDuplicates;

import static java.lang.System.out;
//20190812(Mon
public class P08Test {

	public static void main(String[] args) {
//		out.println(PermutationsWithDuplicates.printPerms("abcc"));
		{
			out.println("textbook 1: ");
			out.println(MyPermutationWithDuplicates.printPermutations("abccc"));
		}
		
		{
			out.println("my way 01: ");
			out.println(My_PermutationsWithDuplicates_way01.getPerms("abccc"));
		}
		
		{
			out.println("my way 02: ");
			out.println(My_PermutationsWithDuplicates_way02.getPerms("abccc"));
		}
		
		out.println("end");
		
	}

}
