package c08_RecursionDynamicProgramming._0805_RecursiveMultiply;
import static java.lang.System.out;
public class Test_0805 {

	public static void main(String[] args) {
		
		{
			out.println("case 1: RecursiveMultiply_01");
			int a = 3;
			int b = 5;
			out.println(RecursiveMultiply_01.minProduct( a , b ));
		}
		
		{
			out.println("\ncase 2: RecursiveMultiply_02");
			int a = 3;
			int b = 5;
			out.println(RecursiveMultiply_02.minProduct( a , b ));
		}
		
		{
			out.println("\ncase 3: RecursiveMultiply_03");
			int a = 3;
			int b = 5;
			out.println(RecursiveMultiply_03.minProduct( a , b ));
		}
		
		{
			out.println("\ncase 4: My_RecursiveMultiply_02_DP");
			int a = 3;
			int b = 5;
			out.println(My_RecursiveMultiply_02_DP.multiply(a, b));
		}
		
		{
			out.println("\ncase 5: My_RecursiveMultiply_03_DP");
			int a = 3;
			int b = 5;
			out.println(My_RecursiveMultiply_03_DP.multiply(a, b));
		}
		
	}

}


