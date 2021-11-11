package c08_RecursionDynamicProgramming.p10_PaintFill;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;

public class PaintFillTest {

	public static void main(String[] args) {
		
		String[] chosenOptions = { "2"};
		HashSet<String> options = new HashSet<>( Arrays.asList(chosenOptions) );
		
		if(options.contains("1")) {
			Color[][] screen= {
					{Color.White, Color.Green, Color.White, Color.White, Color.White}, 
					{Color.White, Color.Green, Color.White, Color.Green, Color.White}, 
					{Color.Green, Color.Green, Color.Green, Color.White, Color.White}, 
					{Color.White, Color.Green, Color.Green, Color.White, Color.White},
					{Color.White, Color.Green, Color.White, Color.White, Color.Green},
					};
			
			out.println("textbook answer: ");
			
			printScreen(screen);
			PaintFill.paintFill(screen, 1, 1, Color.Red);
			printScreen(screen);
			
			
			out.println("my way 1");
			printScreen(screen);
			MyPaintFill.paintFill(screen, 1, 1, Color.Black);
			printScreen(screen);
			
			out.println("my way02");
			printScreen(screen);
			My_PaintFill_02.paintFill(Color.Green, screen, 1, 1);
			printScreen(screen);
		}
		
		
		if(options.contains("2")) {
			Color02[][] screen02= {
					{Color02.White, Color02.Green, Color02.White, Color02.White, Color02.White}, 
					{Color02.White, Color02.Green, Color02.White, Color02.Green, Color02.White}, 
					{Color02.Green, Color02.Green, Color02.Green, Color02.White, Color02.White}, 
					{Color02.White, Color02.Green, Color02.Green, Color02.White, Color02.White},
					{Color02.White, Color02.Green, Color02.White, Color02.White, Color02.Green},
					};
			
			printScreen02(screen02);
			_Practice_MyPaintFill.paintFill(screen02, Color02.Red, 1, 1);
			printScreen02(screen02);
			
			_Practice_MyPaintFill.paintFill(screen02, Color02.Green, 10, 1);
			printScreen02(screen02);
			
		}
		
	}
	
	public static void printScreen(Color[][] screen) {
		out.println("");
		for(int row = 0; row < screen.length; row ++) {
			for(int col = 0; col < screen[0].length; col++) {
				out.print(screen[row][col].str() + " ");
			}
			out.println("");
		}
	}
	
	
	public static void printScreen02(Color02[][] screen) {
		out.println("");
		for(int row = 0; row < screen.length; row ++) {
			for(int col = 0; col < screen[0].length; col++) {
				out.print(screen[row][col].getSymbol() + " ");
			}
			out.println("");
		}
	}

}
