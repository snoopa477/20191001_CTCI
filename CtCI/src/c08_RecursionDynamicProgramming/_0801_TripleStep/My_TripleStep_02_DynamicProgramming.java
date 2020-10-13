package c08_RecursionDynamicProgramming._0801_TripleStep;
import static java.lang.System.out;
public class My_TripleStep_02_DynamicProgramming {
	
		public static int waysToReachPosition(int position) {
			int[] positionToWay = new int[position + 1 ];
			
			//suppose that unvisited index, its value is -1
			for(int i = 0; i < positionToWay.length; i++) {
				positionToWay[i] = -1;
			}
			
			int result = waysToReachPosition(position, positionToWay);
			return result;
			
		}
	
		//number of ways to reach position n from position 0
		private static int waysToReachPosition(int position, int[] positionToWay) {
			
			//I used to forget to add this line to cause due to array trying access negative index
			if( position < 0 ) {
				return 0;
			}
			
			if(positionToWay[position] != -1) {
				return positionToWay[position] ;
			}
			
			//base case
			if( position == 0 ) {
				positionToWay[position] = 1;
				return positionToWay[position];
			}
			
			//general cases
			positionToWay[position] =  waysToReachPosition(position -1, positionToWay) 
					+ waysToReachPosition(position -2, positionToWay ) 
					+ waysToReachPosition(position -3, positionToWay);
			
			//this line is shared among all cases, except for positionToWay[position] == -1
			return positionToWay[position];
			
			
		}

}