package c08_RecursionDynamicProgramming._0802_RobotInAGrid;
import static java.lang.System.out;

import java.util.ArrayList;


public class Test_0802 {
	
	
	public static void main(String[] args) {
		
		
		{
			out.println("\ncase 1: textbook solution one: without DP");
			boolean[][] map = getMap();
			ArrayList<Point> path = RobotInAGrid.getPath(map);
			printPath(path);
			out.println();
		}
		
		{
			out.println("\ncase 2: my solution, one path without DP");
			boolean[][] map = getMap();
			ArrayList<Point> path = new ArrayList<>();
			My_RobotInAGrid_01_OnePath.getOnePath(map, path);
			printPath(path);
			out.println("path size is " + path.size());
		}
		
		{
			out.println("\ncase 3: my solution, all paths without DP");
			boolean[][] map = getMap();
			ArrayList<ArrayList<Point>> resultPahts = My_RobotInAGrid_02_AllPaths.getAllPaths(map);
			printPaths(resultPahts);
			//out.println("path size is " + path.size());
			out.println("paths size is " + resultPahts.size());
			
		}
		
		{
			out.println("\ncase 4: textbook solution, one path with DP");
			boolean[][] map = getMap();
			ArrayList<Point> path = RobotInAGrid_02_DP.getPath(map);
			printPath(path);
			//out.println("path size is " + path.size());
			out.println("paths size is " + path.size());
			
		}
		
		{
			out.println("\ncase 5: my solution, one path with DP");
			boolean[][] map = getMap();
			
			ArrayList<Point> path = new ArrayList<>();
			My_RobotInAGrid_01A_OnePath_DP.getOnePath(map, path);;
			printPath(path);
			//out.println("path size is " + path.size());
			out.println("paths size is " + path.size());
			
		}
		
		{
			out.println("\ncase 6: my solution, all paths with DP");
			
			boolean[][] map = getMap_v2();
			ArrayList<ArrayList<Point>> resultPahts = My_RobotInAGrid_02A_AllPaths_DP.getAllPaths(map);
			printPaths(resultPahts);
			out.println("paths size is " + resultPahts.size());
			
		}
		
		{
			out.println("\ncase 7: my solution, all paths with DP");
			
			boolean[][] map = getMap_v2();
			ArrayList<ArrayList<Point>> resultPahts = My_RobotInAGrid_02A_AllPaths_DP_02.getAllPaths(map);
			printPaths(resultPahts);
			out.println("paths size is " + resultPahts.size());
			
		}
		
		
		
	}
	
	
	public static boolean[][] getMap(){
		boolean[][] map = { { true, false, true, true}
							,{ true, true, true, true}
							,{ true, true, false, true}
							,{ true, false, true, true} };
		return map;
	}
	
	public static boolean[][] getMap_v2(){
		boolean[][] map = { { true, false, true, true}
							,{ true, true, true, true}
							,{ true, true, true, true}
							,{ true, false, true, true} };
		return map;
	}
	
	public static void printPath(ArrayList<Point> path) {
		
		for( Point p : path ) {
			out.print( p + " ");
		}
		out.println();
	}
	
	public static void printPaths(ArrayList<ArrayList<Point>> paths) {
		
		for(ArrayList<Point> path : paths) {
			
			printPath(path);
			//out.println();
		}
		
	}

}


