package test.tree;
import java.util.ArrayList;
import static java.lang.System.out;


public class Test_getPath_1 {
	
	public static void main(String[] args) {
		
		Node a = Node.getTree();
		Node.printTreePreOrder(a);
		out.println();
		
		ArrayList<ArrayList<String>> paths = getPaths(a);
		Node.printPaths(paths);
		
		
	}
	
	public static ArrayList<ArrayList<String>> getPaths(Node root){
		
		ArrayList<ArrayList<String>> paths = new ArrayList<>();
		return getPaths(root, paths);
	}
	
	public static ArrayList<ArrayList<String>> getPaths(Node root, ArrayList<ArrayList<String>> paths){
		
		//MISTAKE
		//forget this line
		//if null
		if(root == null) {
			return null;
		}
		
		//if leaf
		if(root.left == null && root.right == null) {
			ArrayList<String> path = new ArrayList<>();
			path.add(root.val);
			paths.add(path);
			return paths;
		}
		
		//if non-leaf
		ArrayList<ArrayList<String>> left_paths = getPaths(root.left );
		ArrayList<ArrayList<String>> right_paths = getPaths(root.right );
		
		//MISTAKE: forget this line
		if(left_paths != null) {
			for( int i = 0; i < left_paths.size(); i++ ) {
				left_paths.get(i).add(root.val);
				paths.add(left_paths.get(i));
			}	
		}
		
		if(right_paths != null) {
			for( int i = 0; i < right_paths.size(); i++ ) {
				right_paths.get(i).add(root.val);
				paths.add(right_paths.get(i));
			}
		}
		
		return paths;
	}

}


