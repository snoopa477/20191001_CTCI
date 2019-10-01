package c08_RecursionDynamicProgramming.p12_EightQueens;

import java.util.ArrayList;

public class MyEightQueens {
final static int GRID_SIZE = 8;
	

	//wat is the meaning of columns[RowIndex]? value �� ��RowIndex th Row��valid column number
	//possible value: 0~7; impossible value/ initial value: -1

	public static void waysToPlaceQueens(int rowIndex, Integer[] validColumnIndeces
			, ArrayList<Integer[]> results) {
		
		if( rowIndex == GRID_SIZE) {
			results.add(validColumnIndeces.clone());
		}
		else {                                                    
			//It's actually DFS; however, how to think naturally about DFS?
			//Things that I have to practice: 1. ��Ѱ��D���n�X�h; 2. �@����Ҥ@�h. ���n:�@���N�Q����, ���ӽ���
			for( int colIndex = 0; colIndex < GRID_SIZE; colIndex++) {
				if(checkValid(validColumnIndeces, rowIndex, colIndex)) {
					validColumnIndeces[rowIndex] = colIndex;
					waysToPlaceQueens(rowIndex + 1, validColumnIndeces, results);
				}
			}
		}
		
	}

	private static boolean checkValid(Integer[] validColumnIndeces, int cuurentRowIndex
			, int currentColumnIndex) {
		
		for(int previousRowIndex = 0; previousRowIndex < cuurentRowIndex; previousRowIndex++) {
			int column2 = validColumnIndeces[previousRowIndex];
			/* Check if (row2, column2) invalidates(row1, column1) as a queen spot
			 * 
			 * */
			
			/*Check if rows have a queen in the same column*/
			if(currentColumnIndex == column2) {
				return false;
			}
			
			int columnDistance = Math.abs(column2 - currentColumnIndex);
			
			int rowDistance = cuurentRowIndex - previousRowIndex;
			//diagonal
			if(columnDistance == rowDistance) {
				return false;
			}
		}
		
		return true;
	}
}
