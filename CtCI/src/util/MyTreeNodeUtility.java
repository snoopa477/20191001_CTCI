package util;
import static java.lang.System.out;

import java.util.LinkedList;
public class MyTreeNodeUtility {

	public static MyTreeNode makeTree(int[] inputs) {
		
		MyTreeNode root = new MyTreeNode(inputs[0]);
		
		for( int i = 1; i < inputs.length; i++ ) {
			root.insertNodeInOrder(inputs[i]);
		}
		return root;
	}
	
	
	
	public static void printInOrder( MyTreeNode root ) {
		
		//base case
		if( root == null ) {
			return ;
		}
		
		//THINK_FURTHER: let the left node done its job before print the current node
		//IMAGINE: the completion of left node job is the whole left subtree--every element in that tree-- done its job 
		printInOrder( root.left );
		out.printf("%d ", root.data);
		printInOrder( root.right );
		
	}
	
	
	
	//QUESTION: can't do unless there's tag denoting whether a node is visited before? Nah, tree node won't be visited twice
	public static void printBFS( MyTreeNode root ) {
		
		//THINK_FURTHER: due to first in first out, if something is put into queue, that thing will be executed first, and the first thing to put is 'neighbor', hence fulfill the purpose of BFS
		LinkedList<MyTreeNode> queue = new LinkedList<>();
		
		queue.addFirst(root);
		
		while( queue.isEmpty() == false ) {
			
			MyTreeNode currentNode = queue.removeLast();
			
			if( currentNode != null ) {
				out.printf("%d ", currentNode.data);
				
				//PURPOSE: put the adjacents into the queue, which are left and right nodes
				queue.addFirst( currentNode.left );
				queue.addFirst( currentNode.right );
				
			}
			
		}
		
	}
	
	
	//REASONING: the height depends on left and right tree -> post order
	public static int getHeightOfTree( MyTreeNode root ) {
		
		if( root == null ) {
			//null node don't have height
			return 0;
		}
		
		//REASONING: current node exits, itself has one level
		
		int left_height =  getHeightOfTree( root.left );
		int right_height =  getHeightOfTree( root.right );
		
		int currentLevel = Math.max( left_height , right_height) + 1;
		
		return currentLevel;
	}
	
}


 