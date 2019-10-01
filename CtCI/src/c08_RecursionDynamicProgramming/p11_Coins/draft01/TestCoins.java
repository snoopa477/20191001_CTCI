package c08_RecursionDynamicProgramming.p11_Coins.draft01;

import static java.lang.System.out;

public class TestCoins {

	public static void main(String[] args) {
		
		{
			out.println(MyCoins.waysToMakeChange(new int[] {50,10,1},50));
		}
		{
			out.println(MyCoins.waysToMakeChange_dynamic(new int[] {50,10,1},50));
		}
		
		{
			MyCoins.waysToMakeChange_usingMap(new int[] {50,10,1},50);
		}
		
		{
			MyCoins.waysToMakeChange_usingMap(new int[] {50,10,5,1},50);
		}
		
		{
			MyCoins.waysToMakeChange_usingMap(new int[] {37},50);
		}
		
	}

}
