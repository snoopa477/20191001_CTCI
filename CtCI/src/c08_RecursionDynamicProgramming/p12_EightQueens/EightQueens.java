package c08_RecursionDynamicProgramming.p12_EightQueens;

import java.util.ArrayList;

public class EightQueens {

	final static int GRID_SIZE = 8;
	
	public static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
		
		if( row == GRID_SIZE) {
			results.add(columns.clone());
		}
		else {
			for( int col = 0; col < GRID_SIZE; col++) {
				if(checkValid(columns, row, col)) {
					columns[row] = col;
					placeQueens(row + 1, columns, results);
				}
			}
		}
		
	}

	private static boolean checkValid(Integer[] columns, int row1, int column1) {
		
		for(int row2 = 0; row2 < row1; row2++) {
			int column2 = columns[row2];
			/* Check if (row2, column2) invalidates(row1, column1) as a queen spot
			 * 
			 * */
			
			/*Check if rows have a queen in the same column*/
			if(column1 == column2) {
				return false;
			}
			
			int columnDistance = Math.abs(column2 - column1);
			
			int rowDistance = row1 - row2;
			if(columnDistance == rowDistance) {
				return false;
			}
		}
		
		return true;
	}
	
}
