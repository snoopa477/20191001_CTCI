package c01_ArraysAndStrings.p08_ZeroMatrix;
import static java.lang.System.out;
public class Test_ZeroMatrix {

	public static void main(String[] args) {
		
		out.println("\n----------------------ZeroMatrix_01_noInference");
		{
			int[][] matrix = getMatrix1() ;
			ZeroMatrix_01_noInference.makeZeroMatrix(matrix);
			printMatrix(matrix);
		}
		
		
		out.println("\n----------------------ZeroMatrix_02_InferenceTwoVector");
		{
			int[][] matrix = getMatrix1() ;
			ZeroMatrix_02_InferenceTwoVector.makeZeroMatrix(matrix);
			printMatrix(matrix);
		}
		
		
		out.println("\n----------------------ZeroMatrix_03_InferenceOverwirte");
		{
			int[][] matrix = getMatrix1() ;
			ZeroMatrix_03_InferenceOverwirte.makeZeroMatrix(matrix);
			printMatrix(matrix);
		}
		
		
	}
	
	
	
	private static int[][] getMatrix1(){
		
		return new int[][] {
			{ 1, 2, 3, 4, 5, 6},
			{ 1, 2, 3, 4, 5, 6},
			{ 1, 2, 0, 4, 5, 6},
			{ 1, 2, 3, 4, 5, 6},
			{ 1, 2, 3, 4, 0, 6},
			{ 1, 0, 3, 4, 5, 6}
		};
	}
	
	private static void printMatrix(int[][] matrix) {
		
		int height = matrix.length;
		int width = matrix[0].length;
		
		for( int i = 0; i < height; i++ ) {
			for( int j = 0; j < width; j++) {
				out.printf("%4d", matrix[i][j]);
			}
			out.println();
		}
		
	}

}


