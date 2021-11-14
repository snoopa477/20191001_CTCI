package c08_RecursionDynamicProgramming.p11_Coins;


import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
public class TestCoins {

	public static void main(String[] args) {
		String[] chosenOptions = { "2" , "4" , "5" };
		HashSet<String> options = new HashSet<>( Arrays.asList(chosenOptions) );
		
		if(options.contains("1"))
		{
			out.println("MyCoins 1: ");
			out.println(MyCoins.waysToMakeChange(50));
		}
		
		if(options.contains("2"))
		{
			out.println("MyCoins 2: ");
			out.println( MyCoins_02.waysToGetCoins(50, new int[]{ 50, 10, 1 }));
		}
		
		if(options.contains("3"))
		{
			out.println("MyCoins_way02_recursionType02: ");
			ArrayList<Integer[]> results = MyCoins_way02_recursionType02.
					waysToGetCoins(50, new int[]{ 50, 10, 1 });
			printArrayListOfArray(results);
		}
		
		if(options.contains("4"))
		{
			out.println("case 4: _Practice_coin_way01_number: ");
			out.println("MyCoins 2: ");
			int money = 50;
			Integer[] coinValues = {50,10,1};
			out.println("money: " + money + "; coinValues: " + arrToString(coinValues));
			out.println( _Practice_coin_way01_number.getWaysOfSpendingMoney(money, coinValues));
			
			money = 50;
			coinValues = new Integer[]{20,15,1};
			out.println("money: " + money + "; coinValues: " + arrToString(coinValues));
			out.println( _Practice_coin_way01_number.getWaysOfSpendingMoney(money, coinValues));
			
			money = 50;
			coinValues = new Integer[]{15,20,3};
			out.println("money: " + money + "; coinValues: " + arrToString(coinValues));
			out.println( _Practice_coin_way01_number.getWaysOfSpendingMoney(money, coinValues));
			
		}
		
		if(options.contains("5"))
		{
			out.println("case 5: _Practice_coin_way02_number: ");
			ArrayList<ArrayList<Integer>> results ;
			int money = 50;
			Integer[] coinValues = {50,10,1};
			out.println("money: " + money + "; coinValues: " + arrToString(coinValues));
			results = _Practice_coin_way02_ways.getWaysOfSpendingMoney(money, coinValues);
			printArrArr(results);
			
			money = 50;
			coinValues = new Integer[]{20,15,1};
			out.println("money: " + money + "; coinValues: " + arrToString(coinValues));
			results = _Practice_coin_way02_ways.getWaysOfSpendingMoney(money, coinValues);
			printArrArr(results);
			
			
			money = 50;
			coinValues = new Integer[]{20,15,3};
			out.println("money: " + money + "; coinValues: " + arrToString(coinValues));
			results = _Practice_coin_way02_ways.getWaysOfSpendingMoney(money, coinValues);
			printArrArr(results);
			
			
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
	
	//ERROR :Erasure of method printArrayListOfArray(ArrayList<ArrayList<Integer>>) is the same as another method in type TestCoins
	//public static void printArrayListOfArray( ArrayList<ArrayList<Integer>> arrs) {
	public static void printArrArr( ArrayList<ArrayList<Integer>> arrs) {
		
		for(ArrayList<Integer> arr : arrs) {
			for(int i = 0; i < arr.size(); i++) {
				out.print(arr.get(i) + " ");
			}
			out.println();
		}
		
	}
	
	private static String arrToString(Integer[] arr) {
		String str = "";
		for(int i = 0; i < arr.length; i++) {
			str += " " + arr[i];
		}
		
		return str;
	}

}
