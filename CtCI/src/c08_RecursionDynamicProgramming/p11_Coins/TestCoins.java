package c08_RecursionDynamicProgramming.p11_Coins;


import static java.lang.System.out;

import java.util.ArrayList;
public class TestCoins {

	public static void main(String[] args) {
//		out.println(Coins.makeChange(100));
		//out.println(Coins.makeChange(10));
		
//		out.println(Coins.makeChange(50));
		
		{
			out.println("MyCoins 1: ");
			out.println(MyCoins.waysToMakeChange(50));
		}
		{
			out.println("MyCoins 2: ");
			out.println( MyCoins_02.waysToGetCoins(50, new int[]{ 50, 10, 1 }));
		}
		
		{
			out.println("MyCoins_way02_recursionType02: ");
			ArrayList<Integer[]> results = MyCoins_way02_recursionType02.
					waysToGetCoins(50, new int[]{ 50, 10, 1 });
			printArrayListOfArray(results);
		}
	}
	
	public static void printArrayListOfArray( ArrayList<Integer[]> arrs) {
		
		for(Integer[] arr : arrs) {
			for(int i = 0; i < arr.length; i++) {
				out.print(arr[i] + " ");
			}
			out.println();
		}
		
	}

}
