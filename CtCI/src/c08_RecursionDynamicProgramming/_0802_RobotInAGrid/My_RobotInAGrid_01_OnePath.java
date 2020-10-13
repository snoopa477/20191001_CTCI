package c08_RecursionDynamicProgramming._0802_RobotInAGrid;
import java.util.ArrayList;
public class My_RobotInAGrid_01_OnePath {
	
	public static boolean isValid(boolean[][] maze, int row, int col) {
		
		
		//MISTAKE
		//dont forget this line
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
	
	public static void getOnePath(boolean[][] maze, Point point, ArrayList<Point> resultPath) {
		
		int row = point.row;
		int col = point.col;
		
		if( isValid(maze, row, col) == false) {
			return;
		}
		
		if(row == 0 && col == 0) {
			resultPath.add(point);
			return;
		}
		
		if(isValid(maze, row -1, col)) {
			getOnePath(maze, new Point(row -1, col), resultPath);
			resultPath.add(point);
			return;
		}
		
		if(isValid(maze, row , col -1)) {
			getOnePath(maze, new Point(row, col -1), resultPath);
			resultPath.add(point);
			return;
		}
		
		return;
		
	}
	
	public static void getOnePath(boolean[][] maze, ArrayList<Point> resultPath) {
		
		int row = maze.length -1;
		int col = maze[0].length -1;
		Point point = new Point(row, col);
		
		getOnePath(maze, point, resultPath);
	}

}


