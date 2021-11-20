package c08_RecursionDynamicProgramming.p12_EightQueens;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class TestEightQueens {

	public static void main(String[] args) {
		
		String[] chosenOptions = { "3", "5", "6" };
		HashSet<String> options = new HashSet<>( Arrays.asList(chosenOptions) );
		
		if(options.contains("1"))
		{
			ArrayList<Integer[]> result = new ArrayList<Integer[]>();
			EightQueens.placeQueens(0, new Integer[8], result);
			out.println("the result is " + result.size());

			//printChessBoards(result);
		}
		
		if(options.contains("2"))
		{
			out.println("MyEightQueens");
			
			ArrayList<Integer[]> result = new ArrayList<Integer[]>();
			MyEightQueens.waysToPlaceQueens(0, new Integer[8], result);
			out.println("the result is " + result.size());

			printChessBoards(result);
		}
		
		if(options.contains("3"))
		{
			out.println("MyEightQueens_way02_freq2_recursionType2");
			ArrayList<Integer[]> results = MyEightQueens_way02_freq2_recursionType2.waysToPutQueens();
			out.println("the result is " + results.size());

			printChessBoards(results);
		}
		
		if(options.contains("4"))
		{
			out.println("MyEightQueens_way01_recursionType1");
			
			out.println("the result is " + MyEightQueens_way01_recursionType1.waysToPutQueens());

		}
		
		if(options.contains("5"))
		{
			out.println("_Practice_EightQueens_way02_ways");
			
			ArrayList<Integer[]> results = _Practice_EightQueens_way02_ways.getWaysToPlaceQueens();
			out.println("the result is " + results.size());

			printChessBoards(results);

		}
		
		if(options.contains("6"))
		{
			out.println("_Practice_EightQueens_way01_number");
			
			out.println("the result is " + _Practice_EightQueens_way01_number.getWaysToPlaceQueens());

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
