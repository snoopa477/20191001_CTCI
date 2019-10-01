package c08_RecursionDynamicProgramming.p12_EightQueens;

import static java.lang.System.out;

import java.util.ArrayList;

public class TestEightQueens {

	public static void main(String[] args) {
		
		{
			ArrayList<Integer[]> result = new ArrayList<Integer[]>();
			EightQueens.placeQueens(0, new Integer[8], result);
			out.println("the result is " + result.size());

			//printChessBoards(result);
		}
		
		{
			ArrayList<Integer[]> result = new ArrayList<Integer[]>();
			MyEightQueens.waysToPlaceQueens(0, new Integer[8], result);
			out.println("the result is " + result.size());

			printChessBoards(result);
		}
		
	}
	
	public static void printChessBoards(ArrayList<Integer[]> chessBoards) {
		
		for(int i =0; i < chessBoards.size(); i ++) {
			out.println("----------------------------");
			out.println( i + "th chessBoard:");
			printChessBoard(chessBoards.get(i));
			out.println("");
		}
	}
	
	public static void printChessBoard(Integer[] chessBoard) {
		for(int i =0; i < chessBoard.length; i++) {
			printRow(chessBoard[i]);
		}
	}
	
	// e.g: 3
	// - - - Q - - - -
	//the former is 3, later is 8 - index - 1
	
	// e.g: 7
	// - - - - - - - Q
	//later is 8 -7 -1 = 0
	
	//e.g.: 0
	// Q - - - - - - -
	//later is 8 -0-1 = 7
	public static void printRow( int queenColumIndex ) {
		printGridBeforeQueen(queenColumIndex);
		out.print(" Q");
		printGirdAfterQueen(queenColumIndex);
		out.println();
	}

	private static void printGridBeforeQueen(int queenColumIndex) {
		for(int i = 0; i < queenColumIndex; i++) {
			out.print(" -");
		}
	}
	
	private static void printGirdAfterQueen(int queenColumIndex) {
		int numGridAfterQueen = 8 - 1 -queenColumIndex;
		for(int i = 0; i < numGridAfterQueen; i++) {
			out.print(" -");
		}		
	}

}
