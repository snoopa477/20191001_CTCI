package c01_ArraysAndStrings.p07_RotateMatrix;
import static java.lang.System.out;

import javax.naming.OperationNotSupportedException;
public class RotateMatrix_01_circleFunction {

	
	public static void matrixRotate( int[][] matrix ) throws OperationNotSupportedException {
		
		int matrixHeight = matrix.length;
		int matrixLength = matrix[0].length;
		if( matrixHeight != matrixLength ) {
			throw new OperationNotSupportedException("this is not square, roatation is not supported");
		}
		
		for( int i = 0; i < matrixHeight / 2; i++ ) {
			cicleRotate(matrix, i);
		}
		
	}
	
	
	private static void cicleRotate( int[][] matrix, int layerIndex ) {
		
		int matrixLength = matrix.length;
		//DETAIL: start + offset = end
		int coord_Offset = matrixLength -1 - layerIndex * 2;
		if( coord_Offset <= 0 ) {
			return ;
		}
		
		int coord_Start = layerIndex;
		int coord_End = coord_Start + coord_Offset;
		
		/* MAPPING HELPER:
		 * up : coord_Start
		 * down: coord_End
		 * right: coord_End
		 * left: coord_Start
		 */
		
		//update from offset to max_offset
		for( int i = 0; i < coord_Offset; i++ ) {
			//TIP: let the comment lead the code
			//up left goes right
			int tempUpLeft = matrix[ coord_Start ][ coord_Start + i ];
			//up left <- up right goes down
			matrix[ coord_Start ][ coord_Start + i ] = matrix[ coord_Start + i ][ coord_End ];
			//X: up right <- right down
			//up right <- down right goes left
			matrix[ coord_Start + i ][ coord_End ] = matrix[ coord_End ][ coord_End - i ];
			//down right <- down left goes up
			//java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 5
			//WRONG: validation tip: 'end' with -1, 'start' with +1
			//matrix[ coord_End ][ coord_End - i ] = matrix[ coord_Start - i][ coord_End ];
			//WRONG
			//matrix[ coord_End ][ coord_End - i ] = matrix[ coord_Start ][ coord_End - i ];
			
			matrix[ coord_End ][ coord_End - i ] = matrix[ coord_End - i ][ coord_Start ];
			//left down <- left up 
			matrix[ coord_End - i ][ coord_Start ] = tempUpLeft;
		}
	}
	
}


