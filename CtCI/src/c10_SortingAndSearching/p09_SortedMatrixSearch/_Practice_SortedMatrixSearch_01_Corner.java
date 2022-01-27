package c10_SortingAndSearching.p09_SortedMatrixSearch;
import static java.lang.System.out;
public class _Practice_SortedMatrixSearch_01_Corner {

	public static _Practice_Coordinate find( int[][] maze, final int keyValue) {
		
		//PURPOSE make a pivot coordinate that starts with upper right corner
		/*REASONING 
		 * the pivot is largest in x-dimension; smallest in y-dimension.
		 */
		/*THINK_FURTHER
		 * what if we don't place pivot at either upper right corner or down left corner?
		 * if that's the case, and if the pivot is larger than the key, when pivot want to get smaller, it can either go left or up. This is NONDETERMINISTIC; 
		 * what's more, if the pivot choose go up while the key is actually at the left, than it's impossible for the pivot the meet the key. 
		 */
		int min_row = 0;
		int max_col = maze[0].length -1;
		_Practice_Coordinate pivot = new _Practice_Coordinate(min_row, max_col);
		
		
		//REASONING when false, that means the whole maze is exhausted and still not found -> not found
		while( pivot.inBound(maze) ) {
			
			//DETAIL: this is dumb value
			int pivotValue = -1;
			try {
				pivotValue = pivot.getValue(maze);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			if( pivotValue == keyValue ) {
				return pivot;
			}
			else if( pivotValue < keyValue ){
				//REASONING: if pivot wants to get larger, it has ONLY one option: go down; in the other hand, the option to go right is impossible because the pivot gets smaller by going left, which is contradictory. 
				pivot.adjustPosition(1, 0);
			}
			//if( pivotValue > keyValue )
			else {
				//REASONING: likewise, get smaller by going left, and this is the only option
				pivot.adjustPosition(0, -1);
			}
			
		}
		return null;
		
	}
	
	
}


