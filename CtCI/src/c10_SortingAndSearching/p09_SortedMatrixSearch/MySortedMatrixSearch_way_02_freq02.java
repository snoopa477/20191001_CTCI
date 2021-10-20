package c10_SortingAndSearching.p09_SortedMatrixSearch;
//import static java.lang.System.out;


//2021 0123(Sat)
public class MySortedMatrixSearch_way_02_freq02 {

	
	
	public static Coordinate searchElement(int[][] sortedMatrix, int keyValue) {
		
		Coordinate rect_UpLeft = new Coordinate(0,0);
		int len = sortedMatrix[0].length;
		int height = sortedMatrix.length;
		Coordinate rect_DownRight = new Coordinate(height -1, len -1);
		
		return binarySearch_2D(sortedMatrix, rect_UpLeft, rect_DownRight, keyValue);
	}
	
	
	
	//backbone
	private static Coordinate binarySearch_2D(int[][] sortedMatrix
			, Coordinate rect_UpLeft, Coordinate rect_DownRight
			, int keyValue) {
		
		//trivial case test
		//doubt that if they're necessary. If not sure, jsut list em
		boolean isWithinMatrix = rect_UpLeft.inbounds(sortedMatrix) && rect_DownRight.inbounds(sortedMatrix);
		boolean isRectangle = rect_UpLeft.isBefore(rect_DownRight);
		if( isWithinMatrix == false || isRectangle == false ) {
			return null;
		}
		
		Coordinate left_bound_sqr_diag = rect_UpLeft;
		Coordinate right_bound_sqr_diag = getSquareDiagonalRightBound(rect_UpLeft, rect_DownRight);
		
		Coordinate left_diag = new Coordinate(left_bound_sqr_diag);
		Coordinate right_diag = new Coordinate(right_bound_sqr_diag);
		Coordinate mid_diag = new Coordinate(0,0);
		mid_diag.setToAverage(left_diag, right_diag);
		
		while( left_diag.isBefore(right_diag) ){
			
			mid_diag.setToAverage(left_diag, right_diag);
			int mid_value = sortedMatrix[mid_diag.row][mid_diag.col];
			if( mid_value == keyValue ) {
				return mid_diag;
			}
			else if( keyValue < mid_value ) {
				right_diag.set(right_diag.row -1 , right_diag.col - 1);
			}
			else {
				left_diag.set(left_diag.row +1 , left_diag.col + 1);
			}
		}
		
		//backbone
		Coordinate subRect_1_UpLeft = new Coordinate(rect_UpLeft.row, left_diag.col);
		Coordinate subRect_1_DownRight = new Coordinate(right_diag.row, rect_DownRight.col);
		Coordinate result = binarySearch_2D(sortedMatrix, subRect_1_UpLeft, subRect_1_DownRight, keyValue );
		if(result != null) {
			return result;
		}
		
		Coordinate subRect_2_UpLeft = new Coordinate(left_diag.row, rect_UpLeft.col);
		Coordinate subRect_2_DownRight = new Coordinate(rect_DownRight.row, right_diag.col);
		return binarySearch_2D(sortedMatrix, subRect_2_UpLeft, subRect_2_DownRight, keyValue );
	}
	
	
	
	private static Coordinate getSquareDiagonalRightBound(Coordinate rect_UpLt, Coordinate rect_DnRt) {
		
		int diagonalLength = Math.min( Math.abs(rect_UpLt.row - rect_DnRt.row) 
				, Math.abs(rect_UpLt.col - rect_DnRt.col));
		Coordinate result = new Coordinate(rect_UpLt.row + diagonalLength , rect_UpLt.col + diagonalLength);
		return result;
	}
	
}


