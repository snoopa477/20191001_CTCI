package c01_ArraysAndStrings.p08_ZeroMatrix;
import static java.lang.System.out;
public class ZeroMatrix_03_InferenceOverwirte {

	public static void makeZeroMatrix(int[][] originalMatrix) {
		
		int height = originalMatrix.length;
		int width = originalMatrix[0].length;
		
		for( int i = 0; i < height; i++ ) {
			for( int j = 0; j < width; j++ ) {
				if( originalMatrix[i][j] == 0 ) {
					
					/*PURPOSE: compared to program 'ZeroMatrix_02_InferenceTwoVector',
					 * instead of using additional space to take note, overwrite the original space (first col and first row) as a note, 
					 * indicating whether the whole row and column should be 0
					 */
					originalMatrix[i][0] = 0; //serve as hasZeroColumn
					originalMatrix[0][j] = 0; //serve as hasZeroRow
				}
			}
		}
		
		
		//PURPOSE: Using notes and write result to matrix
		for( int i = 0; i < height; i++ ) {
			if( originalMatrix[i][0] == 0 ) {
				makeZeroRow( originalMatrix, i );
			}
		}
		
		
		for( int j = 0; j < width; j++ ) {
			if( originalMatrix[0][j] == 0) {
				makeZeroColumn( originalMatrix, j );
			}
		}
		
	}
	
	
	
	//DETAIL: under the premise that index j is within matrix'd width boundary
	private static void makeZeroColumn( int[][] matrix, int colIndex ) {
		//iterate all rows
		for( int i = 0; i < matrix.length; i++ ) {
			matrix[i][colIndex] = 0;
		}
	}
	
	
	
	private static void makeZeroRow( int[][] matrix, int rowIndex ) {
		//iterate all columns
		for( int j = 0; j < matrix[0].length; j++ ) {
			matrix[rowIndex][j] = 0;
		}
	}
			
}


