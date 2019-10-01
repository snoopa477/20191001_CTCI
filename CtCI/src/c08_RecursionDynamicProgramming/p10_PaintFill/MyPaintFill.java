package c08_RecursionDynamicProgramming.p10_PaintFill;

public class MyPaintFill {

	
	static void paintFill(Color[][] screen, int row, int col, Color newColor) {
		
		
		Color.values();
		
		if(screen[row][col] == newColor) {
			return;
		}
		//we save one layer of braces because of return keyword
		
		
		//How do I know which parameter I need in the function declaration? 
		//if i need this information, then there's a chance I need it
		//I can try it and if I find out I don't need it, Just delete it
		//It's like experiment, I have to do back and forth until I get things right
		//Do it at once and achieve goal is non-sense. Perfection doesn't exist!
		paintFill(screen, row, col, screen[row][col], newColor);
		
	}

	private static void paintFill(Color[][] screen, int row, int col, Color oldColor, Color newColor) {
		
		//bad, because the snippet of code right behind this have to infer that screen[row][col] is 
		//now equal to old Color from this snippet of code
//		if( screen[row][col] != oldColor )
//			return;
		
		//wrong: if( row < 0 || row > screen.length || col < 0 || col > screen[0].length )
		if( row < 0 || row > screen.length-1 || col < 0 || col > screen[0].length-1 )
			return;
		
		//else is doing nothing; so
		//one if statement might describe 2 cases
		if( screen[row][col] == oldColor ) {
			screen[row][col] = newColor;
			
			paintFill(screen, row -1, col, oldColor, newColor);
			paintFill(screen, row +1, col, oldColor, newColor);
			paintFill(screen, row, col -1, oldColor, newColor);
			paintFill(screen, row, col +1, oldColor, newColor);
			
		}
		
		
		
	}
	
	
}
