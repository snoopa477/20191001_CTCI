package c08_RecursionDynamicProgramming.p11_Coins;
//import static java.lang.System.out;
import java.util.ArrayList;

//2020 1213(Sun)
public class MyCoins_way02_recursionType02 {
	
	public static ArrayList<Integer[]> waysToGetCoins(int money, int[] coinValues) {
		
		Integer[] waysToSpendMoney = new Integer[coinValues.length];
		ArrayList<Integer[]> results = new ArrayList<>();
		
		waysToSpendMoney(0, coinValues, money, waysToSpendMoney, results);
		return results;
	}
	
	//suppose [50, 25, 10, 1]
	//backbone
	static void waysToSpendMoney( int currentIndex, int[] coinValues, int money
			,Integer[] waysToSpendMoney, ArrayList<Integer[]> results) {
		
		//reap
		//pre assumption: coinValues[currentIndex] == 1
		if( currentIndex == coinValues.length -1 ) {
			//wrong, we need number of coins spent, 
			//waysToSpendMoney[ currentIndex ] = 1;
			waysToSpendMoney[ currentIndex ] = money;
			results.add( waysToSpendMoney.clone() );
			//don't forget, otherwise when JVM reach to "int coinValue = coinValues[currentIndex];" will cause error
			return;
		}
		
		int coinValue = coinValues[currentIndex];
		
		for( int numOfCoins = 0; money - numOfCoins * coinValue >=0; numOfCoins ++ ) {
			
			waysToSpendMoney[currentIndex] = numOfCoins;
			waysToSpendMoney( currentIndex + 1, coinValues, money - numOfCoins * coinValue,
					waysToSpendMoney, results);
			//not necessary
			waysToSpendMoney[currentIndex] = -1;
		}
	}

}


