package c10_SortingAndSearching.p09_SortedMatrixSearch;
import static java.lang.System.out;
public class _Practice_Coordinate {

	//private static final Exception Exception = null;
	private int row;
	private int col;
	
	
	public _Practice_Coordinate(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
	
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	
	
	public void adjustRow(int offset) {
		row += offset;
	}
	
	
	public void adjustCol(int offset) {
		col += offset;
	}
	
	
	//public void adjust(int offset_row, int offset_col) {
	public void adjustPosition(int offset_row, int offset_col) {
		adjustRow(offset_row);
		adjustCol(offset_col);
	}
	
	
	public int rowCompare( _Practice_Coordinate other ) {
		return row - other.getRow();
	}
	
	
	public int colCompare( _Practice_Coordinate other ) {
		return col - other.getCol();
	}
	
	
	
	//QUESTION: I don't know if throwing exception is appropriate. it will eventually throw exception by me or JVM, and that doesn't matter
	public int getValue( int[][] maze ) /*throws java.lang.Exception*/ {
		//if( inBound(maze) ) {
		return maze[row][col];
		//}
		
		//throw Exception;
	}
	
	
	
	//CAUTION: if argument type is Object, then it is overriding; however we don't have the need to compare object that is not _Practice_Coordinate
	public boolean equals(_Practice_Coordinate other) {
		
		if( row == other.getRow() && col == other.getCol() ) {
			return true;
		}
		
		return false;
	}
	
	
	
	public boolean inBound(int[][] maze) {
		
		int max_row = maze.length -1;
		int max_col = maze[0].length -1;
		
		if( 0 <= row && row <= max_row && 0 <= col && col <= max_col ) {
			return true;
		}
		
		return false;
	}
	
	
	public String toString() {
		// java.io.PrintStream@37374a5e
		//return  out.printf("(%4d, %4d)", row, col).toString();
		return String.format("(%4d, %4d)", row, col);
	}
	
	
	
}


