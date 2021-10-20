package c08_RecursionDynamicProgramming._0807_PermutationWithoutDups.subString;
import static java.lang.System.out;
public class Test_subString {

	public static void main(String[] args) {
		
		
		{
			String str= "012345";
			out.println( "str.substring(0,0) " + "[" + str.substring(0,0) + "]");
			out.println( "str.substring(2,2) " +"[" + str.substring(2,2) + "]");
			out.println( "str.substring(0,1) " +"[" + str.substring(0,1) + "]");
		}
		
		{
			String str= "012345";
			out.println( "[" + str.substring(str.length()) + "]" );
		}
		
	}

}


