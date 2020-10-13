package c08_RecursionDynamicProgramming._0802_RobotInAGrid;

import java.util.ArrayList;
import java.util.HashSet;
public class My_RobotInAGrid_01A_OnePath_DP {
	
	private static boolean isValid(boolean[][] maze, Point point, HashSet<Point> visitedInValidPoints) {
			
		//here
		if(visitedInValidPoints.contains(point)) {
			//it shows
//			System.out.println("hi");
			return false;
		}
		
		int row = point.row;
		int col = point.col;
		
		if(row ==0 && col ==0 ) {
			return true;
		}
		
		if(row < 0 || col < 0) {
			visitedInValidPoints.add(point);
			return false;
		}
		
		if(maze[row][col] == false) {
			visitedInValidPoints.add(point);
			return false;
		}
		
		boolean isLeftValid = isValid(maze, new Point(row -1, col), visitedInValidPoints);
		boolean isRightValid = isValid(maze, new Point(row, col -1), visitedInValidPoints);
		
		boolean result = isLeftValid || isRightValid;
		
		return result;
	}
	
	private static void getOnePath(boolean[][] maze, Point point, ArrayList<Point> resultPath
			, HashSet<Point> visitedInValidPoints) {
		
		int row = point.row;
		int col = point.col;
		
		if( isValid(maze, point, visitedInValidPoints) == false) {
			return;
		}
		
		if(row == 0 && col == 0) {
			resultPath.add(point);
			return;
		}
		
		if(isValid(maze, new Point(row -1, col), visitedInValidPoints)) {
			getOnePath(maze, new Point(row -1, col), resultPath, visitedInValidPoints);
			resultPath.add(point);
			return;
		}
		
		if(isValid(maze, new Point(row, col -1), visitedInValidPoints)) {
			getOnePath(maze, new Point(row, col -1), resultPath, visitedInValidPoints);
			resultPath.add(point);
			return;
		}
		
		return;
		
	}
	
	public static void getOnePath(boolean[][] maze, ArrayList<Point> resultPath) {
		
		int row = maze.length -1;
		int col = maze[0].length -1;
		Point point = new Point(row, col);
		
		
		getOnePath(maze, point, resultPath, new HashSet<>());
	}

}


