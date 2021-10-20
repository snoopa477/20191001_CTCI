package c08_RecursionDynamicProgramming.p10_PaintFill;
import static java.lang.System.out;
public class My_PaintFill_02 {

	
	public static void paintFill(Color newColor, Color[][] map, int row, int col) {
		
		if( isWithinBoundary(map, row, col) == false) {
			out.println("hi");
			return;
		}
		
		Color oldColor = map[row][col];
		paintFill( oldColor, newColor, map, row, col );
	}
	
	//backbone
	static void paintFill(Color oldColor, Color newColor, Color[][] map, int row, int col) {
		
		//boundary
		if( isWithinBoundary(map, row, col) == false) {
			return;
		}
		
		if( map[row][col] == oldColor ) {
			//paintFill
			map[row][col] = newColor;
			paintFill(oldColor, newColor, map, row -1, col);
			paintFill(oldColor, newColor, map, row +1, col);
			paintFill(oldColor, newColor, map, row, col -1);
			paintFill(oldColor, newColor, map, row, col +1);
		}
		
	}
	
	static boolean isWithinBoundary( Color[][] map, int col, int row ) {
		
		int width = map[0].length;
		int height = map.length;
		
		//MISTAKE
		//tip: keep variable one side, don't make it interchangeable on both side
		//if( 0 < row || row > height || 0 < col || col > width ) {
		
		//MIstake: index and length are different unit
		//if( row < 0 || row > height || col < 0 || col > width ) {
		
		if( row < 0 || row > height-1 || col < 0 || col > width-1 ) {
			return false;
		}
		
		return true;
	}
	
}


