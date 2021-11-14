package c08_RecursionDynamicProgramming.p11_Coins;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
public class _Practice_coin_way02_ways {
	public static final boolean IS_DEBUG_ON = false;

	public static ArrayList<ArrayList<Integer>> getWaysOfSpendingMoney(int money, Integer[] coinValues) {
		

		ArrayList<Integer> sortedCoinValues = new ArrayList<Integer>( Arrays.asList(coinValues) );
		
		sortedCoinValues.sort( new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return (o1 - o2 ) * -1;
			}
		} );
		
		/* row: coin value index: from 0, indexing of max coin value to coinValues.length -1, indexing of min coin value
		 * column:  
		 */
		int cvIdxMoneyToWays[][] = new int[ coinValues.length ][ money +1 ];
		
		Integer[] coinNumberCombinatoin = new Integer[coinValues.length]; 
		Arrays.fill(coinNumberCombinatoin, -1 );
		ArrayList<ArrayList<Integer>> results = new ArrayList<>();
		
		getWaysOfSpendingMoneyHelper( money, 0, coinValues, cvIdxMoneyToWays, coinNumberCombinatoin, results);
		
		return results;
	}

	
	//DETAIL: coinNumberCombinatoin is growing; it grows to be mature when call reaches to base case
	private static void getWaysOfSpendingMoneyHelper(int money, int coinValueIndex, Integer[] coinValues,int[][] cvIdxMoneyToWays, Integer[] coinNumberCombinatoin, ArrayList<ArrayList<Integer>> results ) {
		
		if(IS_DEBUG_ON) out.println("coinValueIndex: " + coinValueIndex + "; money: " + money);
		
		if(cvIdxMoneyToWays[coinValueIndex][money] != 0) {
			//return cvIdxMoneyToWays[coinValueIndex][money];
			return;
		}
		
		//base case: consider only one kind of coin, and there's no further kind of coin to consider. Check if money is divisible by this kind of coin
		if( coinValueIndex == coinValues.length -1  ) {
			
			//DETAIL: now the growing of coinNumberCombinatoin completes
			if( money % coinValues[coinValueIndex] == 0) {
				coinNumberCombinatoin[coinValueIndex] = money / coinValues[coinValueIndex];
				results.add( new ArrayList<Integer> ( Arrays.asList(coinNumberCombinatoin ) ) );
				return ;
			}
			else {
				return ;
			}
			
		}
		
		//general case
		int result = 0;
		int currentCoinValue = coinValues[coinValueIndex];
		int totalSpent = 0 ;
		
		/* REASONING: given left money 'money' and current coinValue
		 * total ways of spending coins, consider coinIndex i to n, with money equals to
		 * considering total ways of spending money with coinIdex i, sum of each way multiply by total ways of spending coins, consider coinIndex i+1 to n, with money substracted by multi coins i.  
		 * 
		 */
		for(int numberOfCoins = 0; totalSpent <= money; numberOfCoins++, totalSpent = numberOfCoins * currentCoinValue) {

			
			int moneyLeft = money - totalSpent;
			//update coinNumberCombinatoin
			coinNumberCombinatoin[coinValueIndex] = numberOfCoins;
			getWaysOfSpendingMoneyHelper( moneyLeft, coinValueIndex +1, coinValues, cvIdxMoneyToWays , coinNumberCombinatoin, results );
		}

		cvIdxMoneyToWays[coinValueIndex][money] = result;
		//return result;
	}
}


