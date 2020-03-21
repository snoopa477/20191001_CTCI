package c10_SortingAndSearching.p09_SortedMatrixSearch;

/**
 * 
 * O- - - - -> x
 * |
 * |
 * |
 * v
 * y
 */
public class Coordinate implements Cloneable{
	
	public int row;
	public int col;
	
	public Coordinate(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	public boolean inbounds(int[][] matrix) {
		
		int maxRowIndex = matrix.length;
		int maxColIndex = matrix[0].length;
		//wrong:
		//if( 0 <= row && row <= maxRowIndex && 0 <= col && col <= maxColIndex ) {
		if( 0 <= row && row < maxRowIndex && 0 <= col && col < maxColIndex ) {
			return true;
		}
		return false;
		
//		return row >= 0 && col >=0 &&
//				row < matrix.length && col < matrix[0].length;
	}
	
	public boolean isBefore(Coordinate p) {
		return row <= p.row && col <= p.col;
	}
	
	public Object clone() {
		return new Coordinate(row, col);
	}
	
	public void setToAverage(Coordinate min, Coordinate max) {
		
		row = (min.row + max.row) / 2;
		col = (min.col + max.col) / 2;
		
	}
	
	@Override
	public  String toString() {
		return "(row,col)=("+row+","+col+")";
	}

}
