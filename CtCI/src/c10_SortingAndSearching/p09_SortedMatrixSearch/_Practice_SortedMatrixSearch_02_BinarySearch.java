package c10_SortingAndSearching.p09_SortedMatrixSearch;
import static java.lang.System.out;
public class _Practice_SortedMatrixSearch_02_BinarySearch {
	
	static final boolean IS_DEBUG_ON = false;
	
	
	public static _Practice_Coordinate find( int[][] maze, final int keyValue) {
		return find(maze, keyValue
			, new _Practice_Coordinate(0,0)
			, new _Practice_Coordinate( maze.length -1, maze[0].length -1 ));
	}
	
	
	/** 
	 * trying to search the keyValue among the rectangle, starting from rect_UpLt to rect_DnRt
	 * rect_UpLt: the point that defines rectangle upper left corner
	 * rect_DnRt: the point that defines rectangle down right corner
	 */
	private static _Practice_Coordinate find(int[][] maze, final int keyValue,_Practice_Coordinate rect_UpLt, _Practice_Coordinate rect_DnRt) {
		
		
		//ERROR ArrayIndexOutOfBoudnsException
		//REASONING: basic check however it is often ignored since it's not part of the main concept
		if( checkIfValidPoint(maze, rect_UpLt) == false || checkIfValidPoint(maze, rect_DnRt ) == false ) {
			return null;
		}
		
		//Since we assume rect_UpLt and rect_DnRt, rect_Upt is expected to be smaller/equal to  rect_Upt
		//if( (rect_UpLt.getRow() <= rect_DnRt.getRow()) == false || (rect_UpLt.getCol() <= rect_DnRt.getCol()) == false ) {
		if(rect_UpLt.rowCompare(rect_DnRt) > 0 || rect_UpLt.colCompare(rect_DnRt) > 0) {
			return null;
		}
		
		
		_Practice_Coordinate slash_UpLt = rect_UpLt;
		_Practice_Coordinate slash_DnRt = getBackslashDnRt(rect_UpLt, rect_DnRt);
		
		//PURPOSE: trying to find keyValue among the backslash: from slash_UpLt to slash_DnRt
		//DETAIL: slash_UpLt is the left bound of searching; slash_DnRt is the right bound of searching
		
		//DETAIL: check if slash_UpLt is before slash_DnRt
		while( slash_UpLt.rowCompare(slash_DnRt) <= 0 && slash_UpLt.colCompare(slash_DnRt) <= 0 ) {
			
			
			_Practice_Coordinate slash_Mid = getAveragePoint(slash_UpLt, slash_DnRt);
			
			if( slash_Mid.getValue(maze) == keyValue) {
				return slash_Mid;
			}
			else if( slash_Mid.getValue(maze) < keyValue ) {
				//WRONG: Why do I make such mistake? I guess slash_UpLt is not good to read
				//slash_DnRt = new _Practice_Coordinate( 
				//	slash_Mid.getRow() -1, slash_Mid.getCol() -1 );
				slash_UpLt = new _Practice_Coordinate( 
						slash_Mid.getRow() +1, slash_Mid.getCol() +1 );
			}
			// keyValue < slash_Mid.getValue(maze) 
			else {
				slash_DnRt = new _Practice_Coordinate( 
						slash_Mid.getRow() -1, slash_Mid.getCol() -1 );
				
			}
		}
		
		/*REASONING: reaching here meaning keyVlalue is not found on the slash line; however, area that doesn't not include slash might contain keyVlue
		  since slash_DnRt.getValue() < keyValue, and slash_DnRt.getValue() is the largest of the area, diagonally starting from rect_UpLt to slash_Dnrt -> keyVlaue is greater than that area -> keyValue not is that area 
		  likewise, since keyValue < slash_UpLt.getValue(), and slash_UpLt.getValue() is the smallest  of the area, diagonally starting from slash_UpLt to rect_DnRt ->  keyVlaue is smaller than that area -> keyValue is not in that area 
		  Therefore, we search for the rest area.
		 */
		
		//TIPS: drawing a graph helps
		/*
		 x -     rect_UpLt
		 - x     slash_DnRt
		     x - slash_UpLt
		     - x rect_DnRt
		 */
		//PURPOSE search for the remaining areas that doesn't ruled out by slash_DnRt and slash_UpLt
		_Practice_Coordinate result = find(maze, keyValue
			, new _Practice_Coordinate( slash_UpLt.getRow(), rect_UpLt.getCol())
			, new _Practice_Coordinate( rect_DnRt.getRow(), slash_DnRt.getCol() ) );
		
		if( result != null ) {
			return result;
		}
		
		//PURPOSE first area failed to find key, try second area
		result =  find(maze, keyValue
				, new _Practice_Coordinate( rect_UpLt.getRow(), slash_UpLt.getCol())
				, new _Practice_Coordinate( slash_DnRt.getRow(), rect_DnRt.getCol() ) );
		
		return result;
	}
	
	
	
	private static _Practice_Coordinate getBackslashDnRt( _Practice_Coordinate rect_UpLt, _Practice_Coordinate rect_DnRt) {
		
		int len_Row = Math.abs(rect_UpLt.getRow() - rect_DnRt.getRow());
		int len_Col = Math.abs(rect_UpLt.getCol() - rect_DnRt.getCol());
		int offset = Math.min( len_Row, len_Col );
		
		_Practice_Coordinate slashSnRt = new _Practice_Coordinate( rect_UpLt.getRow() + offset, rect_UpLt.getCol() + offset);
		
		return slashSnRt;
	}
	
	
	
	private static _Practice_Coordinate getAveragePoint(_Practice_Coordinate a, _Practice_Coordinate b  ) {
		
		int row_a = a.getRow();
		int col_a = a.getCol();
		
		int row_b = b.getRow();
		int col_b = b.getCol();
		
		_Practice_Coordinate averagePoint 
			= new _Practice_Coordinate( row_a + ( row_b - row_a )/2, col_a + ( col_b - col_a )/2 );
		return averagePoint;
	}
	
	
	
	static private boolean checkIfValidPoint( int[][] maze, _Practice_Coordinate p ) {
		int row = p.getRow();
		int col = p.getCol();
		if( 0<= row && row < maze.length && 0<= col && col < maze[0].length ) {
			return true;
		}
		return false;
	}
	
	
}


