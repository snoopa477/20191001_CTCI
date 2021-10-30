package c08_RecursionDynamicProgramming._0802_RobotInAGrid;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.HashMap;
public class _Practice_My_RobotInAGrid_02A_AllPaths_DP {

	private static boolean isDebugOn = false;
	/*PURPOSE
	 * Compared to _Practice_My_RobotInAGrid_01A_OnePath_DP, the reason we use HashMap instead of HasSet is valid point is visited more than one time
	 */
	private static boolean isValid(boolean[][] maze, Point point, HashMap<Point, Boolean> pointToValidity) {
		
		//PURPOSE: check if Map already have the answer
		if( pointToValidity.containsKey(point) ) {
			return pointToValidity.get(point);
		}
		
		/*THINK_FURTHER: base case and general case is like filter; however, only one of them is activated at one time. It's not so direct by reading the code, since we don't specify if, and else if
		*/
		
		int row = point.row;
		int col = point.col;
		
		/*
		 DETAIL: 
		 1. put code row < 0 || col < 0 before referencing array
		 2. since no recursoin call for this case, DP is not used
		 */
		if( row < 0 || col < 0 || maze[row][col] == false ) {
//			if(isDebugOn) out.print( point + " invalid; ");
			return false; 
		}
		
		/*DETAIL: 
		this section must be sure there's no such case that row < 0 nor col < 0, otherwise indexing array would be wrong
		*/
		//PURPOSE: base case
		if( row == 0 && col == 0 && maze[row][col] == true ) {
//			if(isDebugOn) out.print("origin isValid; ");
			return true;
		}
		
		//PURPOSE: general case
		boolean isValid_fromUpPoint = isValid(maze, new Point(row -1, col), pointToValidity);
		boolean isValid_fromLeftPoint = isValid(maze, new Point(row, col -1), pointToValidity);
		boolean result = isValid_fromUpPoint || isValid_fromLeftPoint; 
		
		//PURPOSE: we now compute the answer, put it in map for potential later use
		/*DETAIL: based on previous if statement pointToValidity.containsKey(point), reaching here means that we're first time here
		 */
		pointToValidity.put(point, result);
//		if(isDebugOn) out.print( point + (result? " valid " : " invalid " ) + "; ");
		return result;
	}
	
	/*
	 DETAIL
	 look at the signature, even though we have so much parameters; we may only need some in this function,
other would be used in other functions, called by this function.
	 */
	
	/*
	 PURPOSE
	 add all paths from sub call getAllPaths, then add a new point, in post order then update the Map
	 * */
	/*
	 REPLACED
	 * private static void getAllPaths( Point point, ArrayList<ArrayList<Point>> resultPaths, boolean[][] maze, HashMap<Point, Boolean> pointToValidity) {
	*/
	private static void updatePointToPaths( Point point, boolean[][] maze, HashMap<Point, ArrayList<ArrayList<Point>>> pointToPaths, HashMap<Point, Boolean> pointToValidity) {
		
		//if(isDebugOn) out.print(point + " ");
		
		/*
		 DETAIL
		 paths: ArrayList<ArrayList<Point>>>
		 path: ArrayList<Point>
		 * */
		
		//PURPOSE DP Check if we compute already
		if( pointToPaths.containsKey(point) ) {
			if(isDebugOn) out.print( point + "containsKey ;");
			return ;
		}
		
		//PURPOSE check if this point valid
		if( isValid(maze, point, pointToValidity) == false ) {
			if(isDebugOn) out.print( point + "not valid ;");
			return;
		}
		
		//DETAIL: complicated and trivial
		if( isValid(maze, point, pointToValidity) && point.row == 0 && point.col == 0 ) {
			if(isDebugOn) out.print( point + "origin ;");
			Point origin = new Point( point.row, point.col );
			ArrayList<ArrayList<Point>> paths_origin = new ArrayList<>();
			ArrayList<Point> path_origin = new ArrayList<Point>();
			path_origin.add( origin );
			paths_origin.add(path_origin);
			pointToPaths.put(origin, paths_origin);
			
			if(isDebugOn) out.println("origin");
			
			return ;
		}
		
		//PURPOSE collect paths from upper point and left point
		int row = point.row;
		int col = point.col;
		Point upperPoint = new Point(row -1, col);
		ArrayList<ArrayList<Point>> paths_upperPoint = null;
		if( isValid(maze, upperPoint, pointToValidity) ) {
			updatePointToPaths( upperPoint, maze, pointToPaths, pointToValidity);
			//DETAIL it gets complicated
			paths_upperPoint = pointToPaths.containsKey(upperPoint) ?pointToPaths.get(upperPoint) : null;
		}
		
		
		Point leftPoint = new Point(row, col -1 );
		ArrayList<ArrayList<Point>> paths_leftPoint = null;
		if( isValid(maze, leftPoint, pointToValidity) ) {
			/*MISTAKE
			updatePointToPaths( upperPoint, maze, pointToPaths, pointToValidity);
			*/
			updatePointToPaths( leftPoint, maze, pointToPaths, pointToValidity);
			paths_leftPoint = pointToPaths.containsKey(leftPoint) ? pointToPaths.get(leftPoint) : null;
		}
		
		//PURPOSE: add leftPoint and upperPoint paths to current paths, and add this point in paths
		ArrayList<ArrayList<Point>> paths_point = new ArrayList<>();
		
		deepClonePaths( paths_point, paths_upperPoint );
		deepClonePaths( paths_point, paths_leftPoint );
		addPointToPaths( paths_point, point );
		
		pointToPaths.put(point, paths_point);
		if(isDebugOn) out.print( point + "general case ;");
	}

	

	private static void deepClonePaths(ArrayList<ArrayList<Point>> paths_dest, ArrayList<ArrayList<Point>> paths_source) {
		
		if( paths_dest == null || paths_source == null ) {
			return ;
		}
		
		//PURPOSE: instantiate a new path for paths_dest, flled the value from path_source
		for( ArrayList<Point> path_source : paths_source ) {
			//DETAIL: know what to call, can save time of re-inventing wheels
			ArrayList<Point> path_dest = new ArrayList<Point>( path_source );
			paths_dest.add(path_dest);
		}
	}
	

	
	private static void addPointToPaths(ArrayList<ArrayList<Point>> paths, Point point) {
		
		for( ArrayList<Point> path : paths ) {
			path.add(point);
		}
	}
	
	public static ArrayList<ArrayList<Point>> getAllPaths(boolean[][] maze){
		
		int lastRow = maze.length -1;
		int lastCol = maze[0].length -1;
		Point lastPoint = new Point( lastRow, lastCol);
		
		HashMap<Point, ArrayList<ArrayList<Point>>> pointToPaths = new HashMap<>();
		HashMap<Point, Boolean> pointToValidity = new HashMap<Point, Boolean>();
		
		updatePointToPaths( lastPoint, maze, pointToPaths, pointToValidity );
		
		if( isDebugOn ) {
			out.println("\nall the point ot paths keys");
			for( Point point: pointToPaths.keySet()) {
				out.print (point + " ");
			}
		}
		
		return pointToPaths.get(lastPoint);
	}
	
}


