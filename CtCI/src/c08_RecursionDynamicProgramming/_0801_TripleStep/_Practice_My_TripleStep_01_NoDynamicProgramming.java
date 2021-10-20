package c08_RecursionDynamicProgramming._0801_TripleStep;
import static java.lang.System.out;

import java.util.Arrays;
//2021 1019
public class _Practice_My_TripleStep_01_NoDynamicProgramming {

	//input: integer, output: integer
	
	public static int waysToGetPosition(int position) {
		
		int[] positionToWays = new int[ position + 1 ];
		Arrays.fill(positionToWays, -1);
		
		return waysToGetPosition(position, positionToWays);
		
	}
	
	private static int waysToGetPosition(int position, int[] positionToWays) {
	//public static int waysToGetPosition(int position) {
		
		
		if(position < 0) {
			return 0;
		}
		
		if(positionToWays[position] != -1) {
			return positionToWays[position];
		}
		
		if(position == 0) {
			positionToWays[position] = 1;
			return positionToWays[position];
		}
		
		//wrong: would cause
		//int[] positionToWays = new int[ position + 1 ];
		//position is 0, making index as negative
		/*
		positionToWays[position] =  
				waysToGetPosition(position -1 )
				+ waysToGetPosition(position -2)
				+ waysToGetPosition(position -3 );
		*/
		
		positionToWays[position] =  
				waysToGetPosition(position -1, positionToWays )
				+ waysToGetPosition(position -2, positionToWays)
				+ waysToGetPosition(position -3, positionToWays );
		
		return positionToWays[position];
	}
	
	
}


