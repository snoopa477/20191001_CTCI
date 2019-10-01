package c08_RecursionDynamicProgramming.p11_Coins.draft01;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.System.out;

//20190923(Mon
public class MyCoins {

	
	
	public static int waysToMakeChange(int[] coinValues, int remainingMoney) {
		
		
		return chargeUsingOneKindOfCoin(coinValues, 0, remainingMoney);
	}
	
	
	private static int chargeUsingOneKindOfCoin(int[] coinValues, int coinIndex, int remainingMoney) {
		
		if(remainingMoney < 0)
			return 0;
		
		if(remainingMoney == 0)
			return 1;
		
		//out of choice
		if( coinIndex >= coinValues.length && remainingMoney > 0)
			return 0;
		
		int ways = 0;
		int coinValue = coinValues[coinIndex];
		for(int numCoins = 0; numCoins * coinValue <= remainingMoney; numCoins++) {
			int currentRemainingMoney = remainingMoney - numCoins * coinValue;
			
			if(coinIndex < coinValues.length)
				ways+= chargeUsingOneKindOfCoin(coinValues, coinIndex +1, currentRemainingMoney);
		}
		
		return ways;
	}
	
	public static int waysToMakeChange_dynamic(int[] coinValues, int remainingMoney) {
		
		
		///error: missing +1
		//e.g.: int[][] moneyAndCoinIndexToWays = new int [remainingMoney][coinValues.length];
		int[][] moneyAndCoinIndexToWays = new int [remainingMoney+1][coinValues.length];
		
		return chargeUsingOneKindOfCoin_dynamic(coinValues, 0, remainingMoney
				, moneyAndCoinIndexToWays);
	}
	
	
	private static int chargeUsingOneKindOfCoin_dynamic(int[] coinValues
			, int coinIndex, int remainingMoney,int[][] moneyAndCoinIndexToWays) {
		
		
		
		if(remainingMoney < 0)
			return 0;
		
		if(remainingMoney == 0)
			return 1;
		
		//error: miss coinIndex < coinValues.length 
		if (coinIndex < coinValues.length 
				&& moneyAndCoinIndexToWays[remainingMoney][coinIndex] != 0)
			return moneyAndCoinIndexToWays[remainingMoney][coinIndex];

		//out of choice
		if( coinIndex >= coinValues.length && remainingMoney > 0)
			return 0;
		
		int ways = 0;
		int coinValue = coinValues[coinIndex];
		for(int numCoins = 0; numCoins * coinValue <= remainingMoney; numCoins++) {
			int currentRemainingMoney = remainingMoney - numCoins * coinValue;
			
			if(coinIndex < coinValues.length)
				ways+= chargeUsingOneKindOfCoin_dynamic(coinValues, coinIndex +1
						, currentRemainingMoney, moneyAndCoinIndexToWays);
			
		}
		
		moneyAndCoinIndexToWays[remainingMoney][coinIndex] = ways;
		
		return ways;
	}
	
	
	//20190924(Tue
	//應該是無法用dynamic 因為每一種方法是獨特的value from map object
	//除非是
	
	//suppose I want to visualize all changes
	// {coinVlues: numberOfCoins}... wow, it's so hard put it in words
	//map<coinValue, number>  currentCoinValueToNumber
	//arrayList< map<coinValue, number>> results
	public static void waysToMakeChange_usingMap(int[] coinValues, int remainingMoney) {
		
		HashMap<Integer,Integer> coinValueToNumber = new HashMap<Integer,Integer>();
		for(int coinValue : coinValues) {
			coinValueToNumber.put(coinValue, 0);
		}
		
		ArrayList<HashMap<Integer, Integer>> results =  new ArrayList<HashMap<Integer, Integer>>();
		
		 chargeUsingOneKindOfCoin_usingMap(coinValues, 0, remainingMoney,
				 coinValueToNumber, results);
		 
		 out.println("number of results: " + results.size());
		 Util.print(results);
		 
	}
	
	@SuppressWarnings("unchecked")
	//suppress this: results.add( (HashMap<Integer, Integer>) coinValueToNumber.clone());
	private static void chargeUsingOneKindOfCoin_usingMap(int[] coinValues, int coinIndex
			, int remainingMoney, HashMap<Integer,Integer> coinValueToNumber
			, ArrayList<HashMap<Integer, Integer>> results) {
		
		if(remainingMoney < 0)
			return ;
		
		if(remainingMoney == 0) {
			
			//clear the unused coin numbers
			for(int i = coinIndex + 1; i < coinValues.length; i++) {
				coinValueToNumber.put(coinValues[i], 0);
			}
			
			results.add( (HashMap<Integer, Integer>) coinValueToNumber.clone());
			//missing this line will fail
			return;
		}
		
		//out of choice
		if( coinIndex >= coinValues.length && remainingMoney > 0)
			return ;
		
		int coinValue = coinValues[coinIndex];
		for(int numCoins = 0; numCoins * coinValue <= remainingMoney; numCoins++) {
			int currentRemainingMoney = remainingMoney - numCoins * coinValue;
			
			coinValueToNumber.put(coinValue, numCoins);
			
			if(coinIndex < coinValues.length)
				chargeUsingOneKindOfCoin_usingMap(coinValues, coinIndex +1, currentRemainingMoney,
						coinValueToNumber, results);
		}
		
		return ;
	}
	

	
	
	
}
