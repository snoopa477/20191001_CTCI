package c08_RecursionDynamicProgramming.p12_EightQueens;
//import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
public class MyEightQueens_way02_freq2_recursionType2 {
	
	private static final Integer GRID_SIZE = 8;
	
	
	public static ArrayList<Integer[]> waysToPutQueens() {
		
		Integer[] rowToColumn = new Integer[GRID_SIZE];
		//not necessary
		Arrays.fill(rowToColumn, -1);
		
		ArrayList<Integer[]> results = new ArrayList<>();
		waysToPutQueens(0, rowToColumn, results);
		
		return results;
	}
	
	//backbone
	static void waysToPutQueens(int currentRow, Integer[] rowToColumn, ArrayList<Integer[]> results) {
		
		//reap: 
		//note: always be careful if we should clone object, which is to be added to results
		if(currentRow == GRID_SIZE) {
			//is clone necessary? why?
			results.add(rowToColumn.clone());
			//don't forget
			return;
		}
		
		for(int currentColumn = 0; currentColumn < GRID_SIZE; currentColumn++) {
			if( isValid(currentRow, currentColumn, rowToColumn) ) {
				rowToColumn[currentRow] = currentColumn;
				waysToPutQueens( currentRow + 1, rowToColumn, results );
				//not necessary
				rowToColumn[currentRow] = -1;
			}
		}
		
	}


	private static boolean isValid(int currentRow, int currentColumn, Integer[] rowToColumn) {
		
		for( int row = 0; row < currentRow; row++) {
			
			int column = rowToColumn[row];
			if( column == currentColumn 
					|| Math.abs(column - currentColumn ) == Math.abs(row - currentRow ) ) {
				return false;
			}
			
		}
		
		return true;
	}

}


