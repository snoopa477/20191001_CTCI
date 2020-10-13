package test.tree;

import static java.lang.System.out;

import java.util.ArrayList;

public class Node {
	
	public String val;
	public Node left;
	public Node  right;
	
	public Node(String val, Node left, Node right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	public Node(String val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
	
	public static Node getTree() {
		
		Node d = new Node("d");
		Node h = new Node("h");
		Node e = new Node("e",h,null);
		Node b = new Node("b", d, e);
		
		Node f = new Node("f");
		Node j = new Node("j");
		Node i = new Node("i",null,j);
		Node g = new Node("g",null,i);
		Node c = new Node("c",f,g);
		Node a = new Node("a",b,c);
		
		return a;
	}
	
	//in order: abeafcg
	public static Node getTree2() {
		
		Node d = new Node("d");
		Node e = new Node("e");
		Node f = new Node("f");
		Node g = new Node("g");
		
		Node b = new Node("b",d,e);
		Node c = new Node("c",f,g);
		Node a = new Node("a",b,c);
		
		return a;
	}
	
	public static void printTreePreOrder(Node root) {
		
		if(root == null) {
			return ;
		}
		
		out.print(root.val + " ");
		printTreePreOrder(root.left);
		printTreePreOrder(root.right);
		
	}
	
	public static void printPaths( ArrayList<ArrayList<String>> paths ) {
		
		for(int i = 0; i < paths.size(); i++) {
			ArrayList<String> path = paths.get(i);
			
			for(int j = 0; j < path.size(); j++) {
				out.print( path.get(j) + " ");
			}
			
			out.println();
			
		}
		
	}

}


