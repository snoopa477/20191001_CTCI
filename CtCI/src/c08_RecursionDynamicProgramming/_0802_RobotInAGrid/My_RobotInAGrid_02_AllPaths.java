package c08_RecursionDynamicProgramming._0802_RobotInAGrid;

import java.util.ArrayList;

public class My_RobotInAGrid_02_AllPaths {
	
public static boolean isValid(boolean[][] maze, int row, int col) {
		
		
		//MISTAKE
		//don't forget this line
		if(row ==0 && col ==0 ) {
			return true;
		}
		
		if(row < 0 || col < 0) {
			return false;
		}
		
		if(maze[row][col] == false) {
			return false;
		}
		
		boolean isLeftValid = isValid(maze, row -1, col);
		boolean isRightValid = isValid(maze, row, col -1);
		
		boolean result = isLeftValid || isRightValid;
		
		return result;
	}
	
	public static ArrayList<ArrayList<Point>> getAllPaths(boolean[][] maze, Point point) {
		
		int row = point.row;
		int col = point.col;
		
		if( isValid(maze, row, col) == false) {
			return null;
		}
		
		ArrayList<ArrayList<Point>> resultPaths = new ArrayList<>();
		
		if(row == 0 && col == 0) {
			
			ArrayList<Point> newPath = new ArrayList<Point>();
			newPath.add(new Point(row, col));
			resultPaths.add(newPath);
			return resultPaths;
		}
		
		ArrayList<ArrayList<Point>> leftPaths = null;
		ArrayList<ArrayList<Point>> rightPaths = null;
		
		if(isValid(maze, row -1, col)) {
			leftPaths = getAllPaths(maze, new Point(row -1, col) );
		}
		
		if(isValid(maze, row, col -1 )) {
			rightPaths = getAllPaths(maze, new Point(row, col -1) );
		}
		
		if(leftPaths != null) {
			for(ArrayList<Point> path : leftPaths) {
				resultPaths.add(path);
			}
		}
		
		if(rightPaths != null) {
			for(ArrayList<Point> path : rightPaths) {
				resultPaths.add(path);
			}
		}
		
		for(ArrayList<Point> path : resultPaths) {
			path.add(point);
		}
		
		return resultPaths;
		
	}
	
	public static ArrayList<ArrayList<Point>> getAllPaths(boolean[][] maze) {
		
		int row = maze.length -1;
		int col = maze[0].length -1;
		Point point = new Point(row, col);
		
		return getAllPaths(maze, point);
		
	}

}


