package c01_ArraysAndStrings.p08_ZeroMatrix;

import static java.lang.System.out;

public class _0108_00_ZeroMatrix {
	void setZeros(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		// Store the row and column index with value 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}

		// Nullify rows
		for (int i = 0; i < row.length; i++) {
			if (row[i])
				nullifyRow(matrix, i);
		}
		// Nullify columns
		for (int j = 0; j < column.length; j++) {
			if (column[j])
				nullifyColumn(matrix, j);
		}
	}

	void nullifyRow(int[][] matrix, int row) {
		for (int j = 0; j < matrix[0].length; j++) {
			matrix[row][j] = 0;
		}
	}

	void nullifyColumn(int[][] matrix, int col) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}
	}
}
