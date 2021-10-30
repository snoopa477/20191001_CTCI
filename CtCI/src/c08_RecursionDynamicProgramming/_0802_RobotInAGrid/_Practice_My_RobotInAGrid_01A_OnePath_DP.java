package c08_RecursionDynamicProgramming._0802_RobotInAGrid;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.HashSet;
//2021 1023(Sat
public class _Practice_My_RobotInAGrid_01A_OnePath_DP {
	
	static private boolean isDebugOn = false;
	
	//What we already have: boolean[][] maze
	//data Structure that we have defined before: Point
	
	
	//THINK_FURTHER the argument indicates this point such value
	private static boolean isValid( Point point, boolean[][] maze, HashSet<Point> visitedInvalidPoints) {
		
		if( visitedInvalidPoints.contains(point)) {
			if(isDebugOn) out.print( point + " invalid;");
			return false;
		}
		
		//check the point itself
		
		int col = point.col;
		int row = point.row;
		
		//PURPOSE base case
		if( col == 0 && row == 0 && maze[row][col] == true ) {
			if(isDebugOn) out.print( point + " valid;");
			return true;
		}
		
		//PURPOSE general case
		/*THINK_FURTHER actually we don't need maze[row].length -1 || row < 0 || row > maze.length -1
		since the point can only move up or left, and starting with right down corner*/
		//REPLACED if( col < 0 || col > maze[row].length -1 || row < 0 || row > maze.length -1 ) {
		if( col < 0 || row < 0 ) {
			//I almost forget to do this
			visitedInvalidPoints.add(point);
			if(isDebugOn) out.print( point + " invalid;");
			return false;
		}
		
		if( maze[row][col] == false ) {
			visitedInvalidPoints.add(point);
			if(isDebugOn) out.print( point + " invalid;");
			return false;
		}

		//PURPOSE so far, the point itself is ok, now check its previous points that reach this point
		/*MISTAKE: a stupid mistake
		boolean isLeftPreviousPoints_Valid = isValid( new Point( col -1, row ), maze, visitedInvalidPoints);
		boolean isUpPreviousPoints_Valid = isValid( new Point( col, row -1 ), maze, visitedInvalidPoints);
		*/
		boolean isLeftPreviousPoints_Valid = isValid( new Point( row -1, col ), maze, visitedInvalidPoints);
		boolean isUpPreviousPoints_Valid = isValid( new Point( row, col -1 ), maze, visitedInvalidPoints);
		
		boolean result = isLeftPreviousPoints_Valid || isUpPreviousPoints_Valid;
		
		if(result == false) {
			visitedInvalidPoints.add(point);
		}
		
		if(isDebugOn) out.print( point + (result? " valid;": " invalid;" ));
		//could be either true or false
		return result;
	}
	
	
	
	//PURPOSE: if is valid, add point to result path, in postOrder way
	/*REPLACED
	private static ArrayList<Point> getOnePath(Point point, boolean maze[][], ArrayList<Point> resultPath, HashSet<Point> visitedInvalidPoints ){
	*/
	//THINK_FURTHER result is in return statement v.s. result is in argument
	private static void getOnePath(Point point, boolean maze[][], ArrayList<Point> resultPath, HashSet<Point> visitedInvalidPoints ){
		
		
		if(isValid(point, maze, visitedInvalidPoints) == false ) {
			//THINK_FURTHER result is in return statement v.s. result is in argument
			return ; 
		}
		
		//PURPOSE now the point is ok, check the previous points that reach the point
		int col = point.col;
		int row = point.row;
		
		//PURPOSE base case
		if( col == 0 && row == 0 && maze[row][col] == true ) {
			Point origin = new Point(0, 0);
			resultPath.add(origin);
			if(isDebugOn) out.println("add origin");
			return;
		}
		
		//PURPOSE the following section is general case
		Point upPoint = new Point(row -1 , col);
		if(isValid( upPoint, maze, visitedInvalidPoints)) {
			//PURPOSE post order
			getOnePath(upPoint,  maze, resultPath, visitedInvalidPoints );
			resultPath.add(point);
			/* MISTAKE
			 resultPath.add(upPoint);
			 */
			if(isDebugOn) out.println("add upPoint");
			//PURPOSE we only need this, no need to discover further
			return;
		}
		
		Point leftPoint = new Point(row, col -1 );
		if(isValid( leftPoint, maze, visitedInvalidPoints)) {
			//post order
			getOnePath(leftPoint,  maze, resultPath, visitedInvalidPoints );
			resultPath.add(point);
			/* MISTAKE
			 * resultPath.add(leftPoint);
			 */
			if(isDebugOn) out.println("add leftPoint");
			//PURPOSE we only need this, no need to discover further
			return;
		}

	}
	
	
	
	//the interface that user uses
	public static ArrayList<Point> getOnePath(boolean maze[][]){
		
		int lastRow = maze.length -1;
		//DETAIL it's rectangular, so index watever would have the same result
		int lastCol = maze[0].length -1;
		
		
		HashSet<Point> visitedInvalidPoints = new HashSet<>();
		ArrayList<Point> resultPath = new ArrayList<>();
		
		getOnePath( new Point(lastRow, lastCol), maze, resultPath, visitedInvalidPoints );
		
		return resultPath;
	}
	
}


