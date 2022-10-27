package c01_ArraysAndStrings.p08_ZeroMatrix;
import static java.lang.System.out;
public class ZeroMatrix_01_noInference {
	
	
	public static void makeZeroMatrix(int[][] originalMatrix) {
		
		int height = originalMatrix.length;
		int width = originalMatrix[0].length;
		
		//int [][] resultMatrix = new int[height][width];
		//PURPOSE: additional space to record
		boolean [][] hasZeroMatrix = new boolean[height][width];
		
		
		for( int i = 0; i < height; i++ ) {
			for( int j = 0; j < width; j++ ) {
				if( originalMatrix[i][j] == 0 ) {
					makeZeroRow(hasZeroMatrix, i);
					makeZeroColumn(hasZeroMatrix, j);
				}
			}
		}
		
		//replace the value to orginal matrix
		for( int i = 0; i < height; i++ ) {
			for( int j = 0; j < width; j++ ) {
				if( hasZeroMatrix[i][j] == true ) {
					originalMatrix[i][j] = 0;
				}
			}
		}
	}
	
	
	
	//DETAIL: under the premise that index j is within matrix'd width boundary
	private static void makeZeroColumn( boolean[][] matrix, int colIndex ) {
		//iterate all rows
		for( int i = 0; i < matrix.length; i++ ) {
			matrix[i][colIndex] = true;
		}
	}
	
	
	private static void makeZeroRow( boolean[][] matrix, int rowIndex ) {
		//iterate all columns
		for( int j = 0; j < matrix[0].length; j++ ) {
			matrix[rowIndex][j] = true;
		}
		
	}
	
	
}


