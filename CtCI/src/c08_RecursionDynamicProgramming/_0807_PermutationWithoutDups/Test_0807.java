package c08_RecursionDynamicProgramming._0807_PermutationWithoutDups;
import static java.lang.System.out;
public class Test_0807 {

	public static void main(String[] args) {
		
		{
			out.println("textbook way 1: ");
			String str = getString();
			out.println( PermutationWithoutDups_way01.getPerms(str) );
		}
		
		{
			out.println("textbook way 2: ");
			String str = getString();
			out.println( PermutationWithoutDups_way02.getPerms(str) );
		}
		
		{
			out.println("textbook way my 1: ");
			String str = getString();
			out.println( My_PermutationWithoutDups_way01.getPerms(str) );
		}
		
		{
			out.println("textbook way my 2: ");
			String str = getString();
			out.println( My_PermutationWithoutDups_way02.getPerms(str) );
		}
		
	}
	
	static String getString() {
		return "abcd";
	}

}


