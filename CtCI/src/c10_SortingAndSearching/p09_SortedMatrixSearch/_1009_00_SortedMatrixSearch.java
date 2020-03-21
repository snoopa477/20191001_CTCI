package c10_SortingAndSearching.p09_SortedMatrixSearch;

public class _1009_00_SortedMatrixSearch {

	public static boolean findElement(int[][] matrix, int elem) {
		
		int row = 0;
		int col = matrix[0].length - 1;
		
		while( row < matrix.length && col >=0 ) {
			
			if(matrix[row][col] == elem) {
				return true;
			}else if (matrix[row][col] > elem) {
				col--;
			}else {
				row++;
			}
		
		}
		return false;
		
	}
	
}
