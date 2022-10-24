package c01_ArraysAndStrings.p07_RotateMatrix;
import static java.lang.System.out;

import java.util.StringJoiner;

import javax.naming.OperationNotSupportedException;
public class Test_RotateMatrix {

	public static void main(String[] args) throws OperationNotSupportedException {
		
		int[][] matrix01 = {
			{1, 2, 3, 4, 5},
			{11, 12, 13, 14, 15},
			{21, 22, 23, 24, 25},
			{31, 32, 33, 34, 35},
			{41, 42, 43, 44, 45}
		};
		
		int[][] matrix02 = {
				{1, 2, 3, 4, 5},
				{11, 12, 13, 14, 15},
				{21, 22, 23, 24, 25},
				{31, 32, 33, 34, 35},
			};
		
		RotateMatrix_01_circleFunction.matrixRotate(matrix01);
		printMatrix( matrix01 );
		
		RotateMatrix_01_circleFunction.matrixRotate(matrix02);
		printMatrix( matrix02 );
		
		
	}
	
	private static void printMatrix(int[][] matrix) {
		
		for( int i = 0; i < matrix.length; i ++ ) {
			for( int j = 0; j < matrix[0].length; j++ ) {
				out.printf("%4d", matrix[i][j]);
			}
			out.println( );
		}
	}

}


