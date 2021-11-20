package c08_RecursionDynamicProgramming.p12_EightQueens;
import static java.lang.System.out;
import java.util.*;

public class _Practice_EightQueens_way02_ways {

	public static final int MAX_QUEENS =  8;
	
	public static ArrayList<Integer[]> getWaysToPlaceQueens(){
		
		/* DETAIL The index itself is row, and the value is column
		 * and the pair (row, column) suggest where the queen is placed
		 */
		//THINK_FURTHER: it could also define this way: The index itself is column, and the value is row
		Integer[] queenRowToColumn = new Integer[MAX_QUEENS];
		Arrays.fill(queenRowToColumn, -1);
		
		//ERROR: NullPointerException, when this object trying to call add().
		//ArrayList<Integer[]> results = null;
		ArrayList<Integer[]> results = new ArrayList<>();
		getWaysToPlaceQueensHelper(queenRowToColumn, 0, results);
		
		return results;
	}
	
	/* PURPOSE: we fill queens to the map from top to down
	 * queenRowToColumn: current state, it changes as call ends. It changes all the way through the recursion process
	 * */
	/* DETAIL: post-order recursion iterative
	 * the 
	 */
	private static void getWaysToPlaceQueensHelper(Integer[] queenRowToColumn, int currentRow, ArrayList<Integer[]> results) {
		
		//end case, I'd rather say. base case would be misnomer for me
		//reach to the end, we now sure queens are all at appropriate position, add them to resutls
		if(currentRow == MAX_QUEENS) {
			Integer[] result = Arrays.copyOf(queenRowToColumn, queenRowToColumn.length);
			results.add(result);
			//don't forget
			return;
		}
		
		
		//general case
		//DETAIL: not all queens are at the same state: some queens are at previous state, not updated until call reaches to end case
		/* REASONING
		 total ways of puts queens at i to n row equals to
		 total to of ( queen at row i is placed at every column-if possible-, multiply its accordingly total ways of puts quuens at i+1 to n row)
		 */
		//PURPOSE try every column for the queen. Place the queen, then check if valid? if so, proceed the next round
		for(int col = 0; col < MAX_QUEENS; col++) {
			
			setQueenPosition( queenRowToColumn, currentRow, col );
			if( isPlacedQueenValid(queenRowToColumn, currentRow) ) {
				int nextRow = currentRow +1;
				getWaysToPlaceQueensHelper(queenRowToColumn, nextRow, results);
			}
			
		}
	}
	
	
	//PURPOSE: since we fill queens from top to down, we check upwards. 
	//DETAIL: under the context, queens which row index is lower than current row is appropriately placed
	private static boolean isPlacedQueenValid(Integer[] queenRowToColumn, int currentRow) {
		
		for(int row = 0; row < currentRow; row++) {
			if( isDiagonal(queenRowToColumn, currentRow, row)
				||	queenRowToColumn[row] == queenRowToColumn[currentRow]) {
				return false;
			}
		}
		
		//all queens not violate => valid
		return true;
	}

	//PURPOSE: make people understandable 
	private static boolean isDiagonal(Integer[] queenRowToColumn, int thisRow, int thatRow) {
		
		return Math.abs(thisRow - thatRow) ==  Math.abs(queenRowToColumn[thisRow] - queenRowToColumn[thatRow]);
	}
	
	
	
	private static void setQueenPosition(Integer[] queenRowToColumn, int row, int column) {
		
		if(row <0 || row >MAX_QUEENS-1) {
			return ;
		}
		
		queenRowToColumn[row] = column ;
	}
	
}


