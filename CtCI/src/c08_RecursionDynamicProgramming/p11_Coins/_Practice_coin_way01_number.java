package c08_RecursionDynamicProgramming.p11_Coins;
import static java.lang.System.out;
import java.util.*;
public class _Practice_coin_way01_number {
	
	public static final boolean IS_DEBUG_ON = false;

	public static int getWaysOfSpendingMoney(int money, Integer[] coinValues) {
		
		/*DETAIL: if coinValues type is int, instead of Integer
		The constructor ArrayList<Integer>(Arrays.asList(coinValues)) is undefined
		REASON: public static <T> List<T> asList(T... a)
		Usually I use type String, which is not primitive type
		*/ 
		ArrayList<Integer> sortedCoinValues = new ArrayList<Integer>( Arrays.asList(coinValues) );
		
		//DETAIL: descending order of coin value would make the number of call less than ascender order of coin values.
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
		//int coinValueIndexAndMoneyToWays[][] = new int[ coinValues.length ][ money +1 ];
		//Arrays.fill(cvIdxMoneyToWays, -1);
		
		int result = getWaysOfSpendingMoneyHelper( money, 0, coinValues, cvIdxMoneyToWays);
		
		return result;
	}

	private static int getWaysOfSpendingMoneyHelper(int money, int coinValueIndex, Integer[] coinValues,int[][] cvIdxMoneyToWays) {
		
		if(IS_DEBUG_ON) out.println("coinValueIndex: " + coinValueIndex + "; money: " + money);
		
		//if(cvIdxMoneyToWays[coinValueIndex][money] != -1) {
		if(cvIdxMoneyToWays[coinValueIndex][money] != 0) {
			return cvIdxMoneyToWays[coinValueIndex][money];
		}
		
		//base case: consider only one kind of coin, and there's no further kind of coin to consider. Check if money is divisible by this kind of coin
		if( coinValueIndex == coinValues.length -1  ) {
			
			//EXAMPLE if the coin value is 1
			if( money % coinValues[coinValueIndex] == 0) {
				return 1;
			}
			else {
				return 0;
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
			//WRONG: this totalSpent is not update with numberOfCoins at the same time, that makes totalSpent outdated. In this case, at the next round, suppose totalSpent == money, which is outdated, and then we update new totalSpent, which will greater than money 
			//totalSpent = numberOfCoins * currentCoinValue;
			
			int moneyLeft = money - totalSpent;
			result += getWaysOfSpendingMoneyHelper( moneyLeft, coinValueIndex +1, coinValues, cvIdxMoneyToWays );
		}

		cvIdxMoneyToWays[coinValueIndex][money] = result;
		return result;
	}
	
}


