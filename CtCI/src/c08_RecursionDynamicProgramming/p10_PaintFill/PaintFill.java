package c08_RecursionDynamicProgramming.p10_PaintFill;



//20190815(Thur
public class PaintFill {
	//enum Color {Black, White, Red, Yellow, Green}
	
	public static boolean paintFill(Color[][] screen, int r, int c, Color ncolor) {
		
		//corner case
		if(screen[r][c] == ncolor)
			return false;
		
		return paintFill(screen, r, c, screen[r][c], ncolor);
	}

	private static boolean paintFill(Color[][] screen, int r, int c, Color ocolor, Color ncolor) {
		
		if( r < 0 || r >= screen.length || c < 0 || c >= screen[0].length)
			return false;
		
		if(screen[r][c] == ocolor) {
			screen[r][c] = ncolor;
			paintFill(screen, r -1, c, ocolor, ncolor);//up
			paintFill(screen, r +1, c, ocolor, ncolor);//down
			paintFill(screen, r, c -1, ocolor, ncolor);//left
			paintFill(screen, r, c +1, ocolor, ncolor);//right
		}
		
		return true;
	}
	
}
