package c10_SortingAndSearching.p09_SortedMatrixSearch;

import static java.lang.System.out;

public class _1009_01_SortedMatrixSearch {

	public static Coordinate findElement(int[][] matrix, int x) {
		
		Coordinate origin = new Coordinate(0, 0);
		Coordinate dest = new Coordinate(matrix.length -1, matrix[0].length -1);
		return findElement(matrix, origin, dest, x);
		
	}
	
	private static Coordinate findElement(int[][] matrix, Coordinate origin
			, Coordinate dest, int x) {
		
		if( !origin.inbounds(matrix) || !dest.inbounds(matrix) ) {
			return null;
		}
		
		if( matrix[origin.row][origin.col] == x ) {
			return origin;
		}
		else if( !origin.isBefore(dest) ) {
			return null;
		}
		
		/*
		 * set start to start of diagonal and end to the end of the diagonal. Since the
		 * grid may not be square, the end of the diagonal may bot equal dest. 
		 **/
		Coordinate start = (Coordinate) origin.clone();
		
		int diagDist = Math.min(dest.row - origin.row, dest.col - origin.col);
		Coordinate end = new Coordinate(start.row + diagDist, start.col + diagDist);
		Coordinate p = new Coordinate(0, 0);
		
		/*Do binary search on the diagnoal, looking for the first element > 0*/
		while( start.isBefore(end) ) {
			
			p.setToAverage(start, end);
			
			if( x > matrix[p.row][p.col] ) {
				start.row = p.row + 1;
				start.col = p.col + 1;
			}
			else {
				end.row = p.row -1;
				end.col = p.col -1;
			}
			
		}
		
		/*split the grid into quadrants. Search the bottom left and the top right*/
		
		return partitionAndSearch(matrix, origin, dest, start, x);
	}
	
	private static Coordinate partitionAndSearch(int[][] matrix, Coordinate origin
			, Coordinate dest, Coordinate pivot, int x) {
		
		Coordinate lowerLeftOrigin = new Coordinate(pivot.row, origin.col);
		Coordinate lowerLeftDest = new Coordinate(dest.row, pivot.col -1);
		
		Coordinate upperRightOrigin = new Coordinate(origin.row, pivot.col);
		Coordinate upperRightDest = new Coordinate(pivot.row -1 , dest.col);
		
		Coordinate lowerLeft = findElement(matrix, lowerLeftOrigin, lowerLeftDest, x);
		if(lowerLeft == null) {
			return findElement(matrix, upperRightOrigin, upperRightDest, x);
		}
		
		return lowerLeft;
		
	}
	
}
