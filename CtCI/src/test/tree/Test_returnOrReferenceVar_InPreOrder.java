package test.tree;
import static java.lang.System.out;

import java.util.ArrayList;
public class Test_returnOrReferenceVar_InPreOrder {

	public static void main(String[] args) {
		
		Node a = Node.getTree2();
		Node.printTreePreOrder(a);
		out.println();
		
		ArrayList<String> inOrder1= new ArrayList<>();
		getInOrder(a, inOrder1);
		
		for(String elt: inOrder1) {
			out.print(elt + " ");
		}
		out.println();
		
		ArrayList<String> inOrder2= getInOrder(a);
		
		for(String elt: inOrder1) {
			out.print(elt + " ");
		}
		out.println();
		
		
		
	}
	
	public static void getInOrder(Node root, ArrayList<String> inOrder) {
		
		if(root == null) {
			return;
		}
		
		getInOrder(root.left, inOrder);
		inOrder.add(root.val);
		getInOrder(root.right, inOrder);
	}
	
	
	
	
	public static ArrayList<String> getInOrder(Node root){
		
		if(root == null) {
			return null;
		}
		
		ArrayList<String> LST_inOrder = getInOrder(root.left);
		ArrayList<String> RST_inOrder = getInOrder(root.right);
		
		ArrayList<String> result = new ArrayList<>();
		
		if(LST_inOrder != null) {
			for(String elt: LST_inOrder) {
				result.add(elt);
			}
		}
		
		result.add(root.val);
		
		if(RST_inOrder != null) {
			for(String elt: RST_inOrder) {
				result.add(elt);
			}
		}
		
		return result;
		
	}
	
	
}


