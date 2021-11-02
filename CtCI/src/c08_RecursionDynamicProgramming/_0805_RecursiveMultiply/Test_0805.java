package c08_RecursionDynamicProgramming._0805_RecursiveMultiply;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;
public class Test_0805 {

	public static void main(String[] args) {
		
		String[] chosenOptions = { "1", "7" };
		HashSet<String> options = new HashSet<>( Arrays.asList(chosenOptions) );
		
		if( options.contains("1") )
		{
			out.println("case 1: RecursiveMultiply_01");
			int a = 3;
			int b = 5;
			out.println(RecursiveMultiply_01.minProduct( a , b ));
		}
		
		
		if( options.contains("2") )
		{
			out.println("\ncase 2: RecursiveMultiply_02");
			int a = 3;
			int b = 5;
			out.println(RecursiveMultiply_02.minProduct( a , b ));
		}
		
		
		if( options.contains("3") )
		{
			out.println("\ncase 3: RecursiveMultiply_03");
			int a = 3;
			int b = 5;
			out.println(RecursiveMultiply_03.minProduct( a , b ));
		}
		
		
		if( options.contains("4") )
		{
			out.println("\ncase 4: My_RecursiveMultiply_02_DP");
			int a = 3;
			int b = 5;
			out.println(My_RecursiveMultiply_02_DP.multiply(a, b));
		}
		
		
		if( options.contains("5") )
		{
			out.println("\ncase 5: My_RecursiveMultiply_03_DP");
			int a = 3;
			int b = 5;
			out.println(My_RecursiveMultiply_03_DP.multiply(a, b));
		}
		
		
		if( options.contains("6") )
		{
			out.println("\ncase 6: My_RecursiveMultiply_03_DP_02");
			int a = 3;
			int b = 5;
			out.println(My_RecursiveMultiply_03_DP_02.multiply(a, b));
			
			out.println(My_RecursiveMultiply_03_DP_02.multiply(9, 7));
		}
		
		
		if( options.contains("7") )
		{
			out.println("\ncase 7: _Practice_My_RecursiveMultiply_01_DP");
			int a = 3;
			int b = 5;
			out.println(_Practice_My_RecursiveMultiply_01_DP.getArea(a, b));
		}
		
	}

}


