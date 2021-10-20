package c08_RecursionDynamicProgramming.p11_Coins;
import static java.lang.System.out;

import java.util.Arrays;
public class MyCoins_02 {

	
	public static int waysToGetCoins(int money, int[] coinValues) {
		
		//Arrays.sort(coinValues);
		//Arrays.sort(coinValues, Collections.reverseOrder());
		int[][] coinIndex_moneny_to_ways = new int[coinValues.length ][ money + 1];
		
		for( int i = 0; i <coinIndex_moneny_to_ways.length; i++ ) {
		//for( int i = 0; i < coinValues.length; i++) {
			Arrays.fill(coinIndex_moneny_to_ways[i], -1);
		}
		
//		for(int i = 0; i < coinValues.length; i ++) {
//			
//			for( int j = 0; j < coinIndex_moneny_to_ways[0].length; j ++) {
//				out.print( coinIndex_moneny_to_ways[i][j] + " " );
//			}
//			out.println();
//			
//		}
		
		return waysToGetCoins(money, coinValues, 0, coinIndex_moneny_to_ways);
	}
	
	
	//backbone
	static int waysToGetCoins(int money, int[] coinValues, int coinIndex, int[][] coinIndex_moneny_to_ways) {
		
		if( coinIndex_moneny_to_ways[coinIndex][money] != -1 ) {
			return coinIndex_moneny_to_ways[coinIndex][money];
		}
		
		//base case
		if( coinIndex == coinValues.length -1 ) {
			return 1;
		}
		
		int result = 0;
		
		int coinValue = coinValues[coinIndex];
		for( int number = 0; money - coinValue * number >= 0; number++ ) {
			result += waysToGetCoins(money - coinValue * number , coinValues, coinIndex + 1, coinIndex_moneny_to_ways);
		}
		
		coinIndex_moneny_to_ways[coinIndex][money] = result;
		out.printf("coinIndex_moneny_to_ways[%d][%d] = %d\n", coinIndex, money, result);
		
		return result;
	}
	
}


