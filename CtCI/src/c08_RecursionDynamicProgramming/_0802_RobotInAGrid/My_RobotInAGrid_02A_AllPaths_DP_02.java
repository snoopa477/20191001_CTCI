package c08_RecursionDynamicProgramming._0802_RobotInAGrid;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.HashMap;
//2020 1107(Sat)
public class My_RobotInAGrid_02A_AllPaths_DP_02 {
	
	
	public static ArrayList<ArrayList<Point>> getAllPaths(boolean[][] maze){
		
		HashMap<Point, Boolean> pointToValidity = new HashMap<>();
		HashMap<Point, ArrayList<ArrayList<Point>>> pointToPaths = new HashMap<>();
		
		//temp
		return getAllPaths(maze, new Point(maze.length-1, maze[0].length -1), pointToValidity, pointToPaths);
	}
	
	static ArrayList<ArrayList<Point>> getAllPaths(boolean[][] maze, Point point 
			, HashMap<Point, Boolean> pointToValidity
			, HashMap<Point, ArrayList<ArrayList<Point>>> pointToPaths){
		
		if( isValid(maze, point, pointToValidity) == false ) {
			return null;
		}
		
		if( pointToPaths.containsKey(point) ) {
			return pointToPaths.get(point);
		}
		
		int row = point.row;
		int col = point.col;
		
		//base case
		if( row == 0 && col == 0 ) {
			ArrayList<ArrayList<Point>> result = new ArrayList<>();
			ArrayList<Point> origin = new ArrayList<>();
			origin.add(new Point(0, 0));
			result.add(origin);
			pointToPaths.put(point, result);
			return result;
		}
		
		//union
		//MISTAKE, wrong parameter
		//ArrayList<ArrayList<Point>> leftPaths = getAllPaths(maze, new Point(col -1, row) , pointToValidity, pointToPaths);
		//ArrayList<ArrayList<Point>> rightPaths = getAllPaths(maze, new Point(col, row -1) , pointToValidity, pointToPaths);
		
		ArrayList<ArrayList<Point>> leftPaths = getAllPaths(maze, new Point(row -1, col) , pointToValidity, pointToPaths);
		ArrayList<ArrayList<Point>> rightPaths = getAllPaths(maze, new Point(row, col -1 ) , pointToValidity, pointToPaths);
		
		//MISTAKE: in general I assume the usual case; however, don't forget the common trivial case, which is null object
		//and null object usally lead to NullPointer Exception
		//ArrayList<ArrayList<Point>> resultPaths = leftPaths;
		ArrayList<ArrayList<Point>> resultPaths = new ArrayList<>();
		
		if(leftPaths != null) {
			resultPaths.addAll( clonePaths( leftPaths ) );
		}
		if(rightPaths != null) {
			resultPaths.addAll( clonePaths( rightPaths ) );
		}
		addPoint(resultPaths, point);
		
		
//		resultPaths = clonePaths( leftPaths );
		//NullPointerException - if the specified collection is null
//		resultPaths.addAll( clonePaths(rightPaths) );
//		addPoint(resultPaths, point);
		
//		
//		if( leftPaths !=null ) {
//			
//			//MISTAKE: don't forget to do the actual operation
//			for(ArrayList<Point> path : leftPaths) {
//				path.add(point);
//			}
//			resultPaths.addAll( leftPaths );
//		}
//		
//		if(rightPaths!=null) {
//			for(ArrayList<Point> path : rightPaths) {
//				path.add(point);
//			}
//			resultPaths.addAll(rightPaths);
//		}
		
		pointToPaths.put(point, resultPaths);
		
		return resultPaths;
	}
	
	static boolean isValid(boolean[][] maze, Point point, HashMap<Point, Boolean> pointToValidity) {
		
		if(pointToValidity.containsKey(point)) {
			return pointToValidity.get(point);
		}
		
		int row = point.row;
		int col = point.col;
		
		//boundary
		if( row < 0 || col < 0 
				|| row > maze.length-1 || col > maze[0].length-1 ) {
			return false;
		}
		
		//invalid
		if( maze[row][col] == false ) {
			return false;
		}
		
		//base case
		if( row == 0 && col == 0 && maze[row][col] == true) {
			return true;
		}
		
		boolean leftResult = isValid(maze, new Point(row -1, col), pointToValidity);
		if(leftResult == true) {
			pointToValidity.put( point, leftResult );
			return leftResult;
		}
		
		boolean rightResult = isValid(maze, new Point(row, col -1 ), pointToValidity);
		pointToValidity.put(point, rightResult);
		
		return rightResult;
		
		//this is not as good as previous example
		//return leftResult || rightResult;
	}
	
//	static ArrayList<ArrayList<String>> deepClone(ArrayList<ArrayList<String>> paths){
	static ArrayList<ArrayList<Point>> clonePaths(ArrayList<ArrayList<Point>> paths){
		
		if(paths == null) {
			return null;
		}
		
		ArrayList<ArrayList<Point>> result = new ArrayList<>();
		
		for( ArrayList<Point> path: paths) {
			result.add( clonePath(path) );
		}
		return result;
	}
	
	//Erasure of method deepClone(ArrayList<ArrayList<String>>) is the same as another method in type 
	//My_RobotInAGrid_02A_AllPaths_DP_02
	static ArrayList<Point> clonePath(ArrayList<Point> path){
		
		//check null object
		if(path == null) {
			return null;
		}
		
		ArrayList<Point> result = new ArrayList<>();
		
		for( Point point: path) {
			result.add(point);
		}
		return result;
	}
	
	static void addPoint(ArrayList<ArrayList<Point>> paths, Point point) {
		
		if(paths == null) {
			return;
		}
		for( ArrayList<Point> path : paths ) {
			path.add(point);
		}
		
	}

}


