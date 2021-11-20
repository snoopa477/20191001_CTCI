package c08_RecursionDynamicProgramming.p12_EightQueens;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;

//for comment detail, see _Practice_EightQueens_way02_ways
public class _Practice_EightQueens_way01_number {

	public static final int MAX_QUEENS =  8;
	
	public static int getWaysToPlaceQueens(){
		

		Integer[] queenRowToColumn = new Integer[MAX_QUEENS];
		Arrays.fill(queenRowToColumn, -1);
		
		int results = getWaysToPlaceQueensHelper(queenRowToColumn, 0);
		
		return results;
	}
	

	//private static int getWaysToPlaceQueensHelper(Integer[] queenRowToColumn, int currentRow, ArrayList<Integer[]> results) {
	private static int getWaysToPlaceQueensHelper(Integer[] queenRowToColumn, int currentRow) {
		
		int results = 0;
		
		if(currentRow == MAX_QUEENS) {
			
			//REPLACED by
			//REASONING: be careful the unit, which is number of way : this kind of arrangement Integer[](size 8)  counts as 1 way 
			return 1;
			
			//REPLACED with _Practice_EightQueens_way02_ways
			//Integer[] result = Arrays.copyOf(queenRowToColumn, queenRowToColumn.length);
			//results.add(result);
		}
		
		
		//general case
		for(int col = 0; col < MAX_QUEENS; col++) {
			
			setQueenPosition( queenRowToColumn, currentRow, col );
			if( isPlacedQueenValid(queenRowToColumn, currentRow) ) {
				int nextRow = currentRow +1;
				
				//REPLACED by
				results += getWaysToPlaceQueensHelper( queenRowToColumn,  nextRow);
				//REPLACED with _Practice_EightQueens_way02_ways
				//getWaysToPlaceQueensHelper(queenRowToColumn, nextRow, results);
			}
			
		}
		
		return results;
		
	}
	
	
	private static boolean isPlacedQueenValid(Integer[] queenRowToColumn, int currentRow) {
		
		for(int row = 0; row < currentRow; row++) {
			if( isDiagonal(queenRowToColumn, currentRow, row)
				||	queenRowToColumn[row] == queenRowToColumn[currentRow]) {
				return false;
			}
		}
		
		return true;
	}

	
	//PURPOSE: make people understandable 
	private static boolean isDiagonal(Integer[] queenRowToColumn, int thisRow, int thatRow) {
		
		return Math.abs(thisRow - thatRow) ==  Math.abs(queenRowToColumn[thisRow] - queenRowToColumn[thatRow]);
	}
	
	
	
	private static void setQueenPosition(Integer[] queenRowToColumn, int row, int column) {
		
		if(row <0 || row >MAX_QUEENS-1) {
			return ;
		}
		
		queenRowToColumn[row] = column ;
	}
	
}
