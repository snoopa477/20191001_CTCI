package c08_RecursionDynamicProgramming.p10_PaintFill;
import static java.lang.System.out;
public class _Practice_MyPaintFill {
	
	private static final boolean IS_DEBUG_ON = true;

	/* PURPOSE user paint the color 'newColor' at row 'row', col 'col'
	 * 
	 */
	public static void paintFill(Color02[][] screen, Color02 newColor, int row, int col) {
		
		//if(IS_DEBUG_ON) out.println("width " + )
		
		Color02 toBeFilledColor = screen[row][col];
		if (toBeFilledColor == newColor) {
			return ;
		}
		
		paintFillHelper(screen, newColor, toBeFilledColor, row,col);
		
	}
	
	/* THINK_FURTHER: when and how do we end the filling process? When the first call of paintFillHelper ends, meaning it has completes all sub-call, which also means sub-calls complete their descendant calls -> all pixel are considered.
	 * */
	/* DETAIL recursion post-order: iterative
	 */
	/*PURPOSE paint on the screen. for each call, paint one pixel, if possible.
	 * 
	 */
	private static void paintFillHelper(Color02[][] screen, Color02 newColor, Color02 oldColor, int row, int col) {
		
		//DETAIL
		//the following might go wrong: access array after checking its boundary
		//if( screen[row][col] == newColor || row < 0 ... )
		
		//MISTAKE: mindful what unit I'm using: length or index
		//if( row < 0 || row > screen.length || col < 0 || col > screen[0].length ) {
		if( row < 0 || row > screen.length-1 || col < 0 || col > screen[0].length-1 ) {
			return ;
		}
		
		
		//ERROR ArrayIndexOutOfBoundsException
		//already filled
		Color02 toBeFilledColor = screen[row][col];
		if (toBeFilledColor == newColor) {
			return ;
		}
		
		//If I missed this line, new color will paint everywhere
		if(toBeFilledColor != oldColor) {
			return ;
		}
		
		
		//fill w/ new color
		screen[row][col] = newColor;
		
		//explore the neighbor pixels
		paintFillHelper(screen, newColor, oldColor, row -1, col);
		paintFillHelper(screen, newColor, oldColor, row +1, col);
		paintFillHelper(screen, newColor, oldColor, row, col -1);
		paintFillHelper(screen, newColor, oldColor, row, col +1);
		
	}
	
}


