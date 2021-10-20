package c08_RecursionDynamicProgramming.p12_EightQueens;
//import static java.lang.System.out;
public class MyEightQueens_way01_recursionType1 {
	
	static final int GRID_SIZE = 8;
	
	public static int waysToPutQueens() {
		
		return waysToPutQueens(0, new int[GRID_SIZE] );
	}
	
	//backbone
	static int waysToPutQueens(int currentRow, int[] rowToColumn) {
		
	   if( currentRow == GRID_SIZE ) {
		   return 1;
	   }
		
		int result = 0;
		
		for(int currentColumn = 0; currentColumn < GRID_SIZE; currentColumn++) {
			
			if(isValid(currentRow, currentColumn, rowToColumn)) {
				rowToColumn[currentRow] = currentColumn;
				result += waysToPutQueens( currentRow + 1, rowToColumn );
				//not necessary
				rowToColumn[currentRow] = -1;
			}
			
		}
		
		return result;
	}
	
	private static boolean isValid(int currentRow, int currentColumn, int[] rowToColumn) {
		
		for( int row = 0; row < currentRow; row++) {
			
			int column = rowToColumn[row];
			if( column == currentColumn 
					|| Math.abs(column - currentColumn ) == Math.abs(row - currentRow ) ) {
				return false;
			}
			
		}
		
		return true;
	}

}


