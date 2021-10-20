package c08_RecursionDynamicProgramming.p10_PaintFill;

import static java.lang.System.out;

public class PaintFillTest {

	public static void main(String[] args) {
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
	
	public static void printScreen(Color[][] screen) {
		out.println("");
		for(int row = 0; row < screen.length; row ++) {
			for(int col = 0; col < screen[0].length; col++) {
				out.print(screen[row][col].str() + " ");
			}
			out.println("");
		}
		
	}

}
