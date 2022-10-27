package c01_ArraysAndStrings.p08_ZeroMatrix;
import static java.lang.System.out;
public class ZeroMatrix_02_InferenceTwoVector {
	
	public static void makeZeroMatrix(int[][] originalMatrix) {
		
		int height = originalMatrix.length;
		int width = originalMatrix[0].length;
		
		//PURPOSE: additional space to record
		//I think this var name is ambiguous, requiring a lot of focus 
		//boolean[] hasZeroColumn = new boolean[height];
		boolean[] row0Index_to_existence = new boolean[height];
		//boolean[] hasZeroRow = new boolean[width]; 
		boolean[] col0Index_to_existence = new boolean[width]; 
		
		for( int i = 0; i < height; i++ ) {
			for( int j = 0; j < width; j++ ) {
				if( originalMatrix[i][j] == 0 ) {
					row0Index_to_existence[i] = true;
					col0Index_to_existence[j] = true;
				}
			}
		}
		
		
		//PURPOSE: Using notes and write result to matrix
		//PURPOSE: make zero row
		for( int i = 0; i < height; i++ ) {
			if( row0Index_to_existence[i] ) {
				makeZeroRow( originalMatrix, i );
			}
		}
		
		
		//PURPOSE: make zero col
		for( int j = 0; j < width; j++ ) {
			//WRONG: I guess I get confused between the var names
			//if( row0Index_to_existence[j] ) {
			if( col0Index_to_existence[j] ) {
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



