package c08_RecursionDynamicProgramming.p12_EightQueens.draft01;

import java.util.ArrayList;

//20190920(Fri
public class MyEightQueens {

	static final int SIZE = 8;
	
	//to represent an valid arrangement, that would be
	//Integer[8] queenColumnIndeces = values, which ranges from 0 to 7
	
	//Therefore, the whole valid arrangements would be
	//since we don't know how many arrangements would be, we use ArrayList
	//ArrayList<Integer[]> 
	
	//goal: a job that can be done, and pass down to other to do the same
	//finally, the whole task: queen arrangement is done!
	// So, what kind of job is that?
	
	//task
	public static ArrayList<Integer[]> waysToPlaceQueens( ) {
		
		ArrayList<Integer[]> results = new ArrayList<>();
		
		Integer[] queenColumnIndeces = new Integer[SIZE];
		
		int initialRow = 0;
		
		placeCurrentQueen(initialRow, queenColumnIndeces, results);
		
		return results;
		
	}
	
	private static void placeCurrentQueen(int current_Row , Integer[] queenColumnIndeces
			,ArrayList<Integer[]> results) {
		
		if(current_Row == SIZE) {
			results.add( queenColumnIndeces.clone());
			return;
		}
		
		
		for(int current_Column =0; current_Column < SIZE; current_Column++) {
			// check
			//我的entryPoint 在於current_Column為常數, 然後這層工作(確認可不可以放皇后)做完, 給下面的人做同樣的事情;
			//然後跳到上一層, 出現for 迴圈;current_Column 成為變數的一種
			if (isValidToPlaceCurrentQueen(current_Row,current_Column, queenColumnIndeces)) {
				queenColumnIndeces[current_Row] = current_Column;
				placeCurrentQueen(current_Row+1, queenColumnIndeces,results);
			} else {
				// do nothing
			}
		}
		
	}

	private static boolean isValidToPlaceCurrentQueen(int current_Row, int current_Column, Integer[] queenColumnIndeces) {
		
		for(int previous_Row = 0; previous_Row < current_Row; previous_Row++) {
			
			int previous_Column = queenColumnIndeces[previous_Row];
			
			if( previous_Column == current_Column )
				return false;
			
			if( isOnSameDiagonal(previous_Row, current_Row, previous_Column, current_Column) )
				return false;
		}
		
		return true;
	}

	private static boolean isOnSameDiagonal(int previousRow, int currentRow, int previousColumn, int currentColumn) {
		return Math.abs(previousRow - currentRow ) ==  Math.abs(previousColumn - currentColumn );
	}
	
	
}
