package c08_RecursionDynamicProgramming._0802_RobotInAGrid;

import java.util.ArrayList;
import java.util.HashSet;

import static java.lang.System.out;

public class RobotInAGrid_02_DP {

	static public ArrayList<Point> getPath(boolean[][] maze){
		
		if( maze == null || maze.length == 0) {
			return null; 
		}
		
		ArrayList<Point> path = new ArrayList<>();
		
		HashSet<Point> failedPoints = new HashSet<>();
		
		if(getPath(maze, maze.length -1, maze[0].length -1, path, failedPoints)) {
			return path;
		}
		
		return null;
		
	}
	
	static public boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path
			, HashSet<Point> failedPoints) {
		
		/*If out of bounds or not available, return*/
		
		if( col <0 || row <0 || !maze[row][col]) {
			return false;
		}
		
		Point p = new Point(row, col);
		
		/*if we've already visited this cell, return. */
		if(failedPoints.contains(p)) {
			out.println("failedPoints.contains(p)");
			return false;
		}
		
		boolean isAtOrigin = (row == 0) && (col == 0);
		
		/*if there's a path from start to my current location, add my location. */
		if(isAtOrigin || getPath(maze, row, col -1, path, failedPoints) 
				|| getPath(maze, row -1, col, path, failedPoints)) {
			
			path.add(p);
			return true;
		}
		
//		out.println("hi");
		failedPoints.add(p); // Cche result
		return false;
		
	}
	
}


