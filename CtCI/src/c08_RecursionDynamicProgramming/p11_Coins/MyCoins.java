package c08_RecursionDynamicProgramming.p11_Coins;

//20190818(Sun)
//從藝術的觀點來看, JavaLanguage 還是有表現的極限; 有時候很多notation無法表現我的想法, 必須依賴inference才行
//或者, 要看

//課本所提供的答案, 是最正確的捷徑; 然而, 人的思路未必那麼巧一次到達捷徑;
//因此, 遇到錯誤時要能修正
public class MyCoins {
	
	public static int waysToMakeChange(int n) {
		int []coinValues = {50, 10, 1};
		int [][] computedResults = new int [n+1][coinValues.length];// precomputed values
		return waysToMakeChange(n, coinValues, 0 , computedResults);
	}
	
	
	//所有case共用一個集體概念: ways to make change
	//然而; 勿錯把所有case當作是彼此之間有所關聯(若有, 也必須要證明)
	private static int waysToMakeChange(int amount, int[] coinValues
			, int coinIndex, int[][] computedResults) {
		
		if(computedResults[amount][coinIndex] > 0) {
			return computedResults[amount][coinIndex];
		}
		
		//之所以可以這麼寫: 當最後一個index mapping 到的value為1, 且所有value為整數才行得通
		//因為, 所有整數都可以被1所構成
		if(coinIndex >= coinValues.length -1)
			return 1;
		
		int conValue = coinValues[coinIndex];
		
		int ways = 0;
		
		for(int i =0; i * conValue <= amount; i++) {
			// don't get mistaken i as 1
			int remainingAmount = amount - i* conValue;
			if(remainingAmount >= 0)
				ways += waysToMakeChange(remainingAmount, coinValues, coinIndex + 1, computedResults);
			else
				ways += 0;
		}
		computedResults[amount][coinIndex] = ways;
		
		return ways;
	} 
}
