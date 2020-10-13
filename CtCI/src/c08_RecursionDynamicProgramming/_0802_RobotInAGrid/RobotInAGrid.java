package c08_RecursionDynamicProgramming._0802_RobotInAGrid;

import java.util.ArrayList;
public class RobotInAGrid {
	
	public static ArrayList<Point> getPath(boolean[][] maze){
		
		if(maze == null || maze.length == 0 ) {
			return null;
		}
		
		ArrayList<Point> path = new ArrayList<Point>();
		
		if( getPath(maze, maze.length -1, maze[0].length -1, path) ) {
			return path;
		}
		
		return null;
		
	}
	
	public static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
		
		if(col < 0 || row < 0 || !maze[row][col]) {
			return false;
		}
		
		boolean isAtOrigin = ( row == 0 ) && ( col == 0 );
		
		if( isAtOrigin || getPath(maze, row, col -1, path)  || getPath(maze, row -1, col, path)) {
			Point p = new Point(row, col);
			path.add(p);
			return true;
		}
		
		return false;
	}
	
}


