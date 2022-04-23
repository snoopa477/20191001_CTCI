package util;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
public class MyTreeNodeUtility {
	
	public static Integer[] input01 = {4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15};
	
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
	
	
	
	public static void printBFSwithDetail( MyTreeNode root ) {
		
		//THINK_FURTHER: due to first in first out, if something is put into queue, that thing will be executed first, and the first thing to put is 'neighbor', hence fulfill the purpose of BFS
		LinkedList<MyTreeNode> queue = new LinkedList<>();
		
		queue.addFirst(root);
		
		while( queue.isEmpty() == false ) {
			
			MyTreeNode currentNode = queue.removeLast();
			
			if( currentNode != null ) {
				out.printf(getNodeDetail( currentNode ));
				
				//PURPOSE: put the adjacents into the queue, which are left and right nodes
				queue.addFirst( currentNode.left );
				queue.addFirst( currentNode.right );
				
			}
			
		}
		
	}
	
	
	
	private static String getNodeDetail( MyTreeNode root) {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		if( root == null) {
			stringBuilder.append("null\n");
		}
		
		stringBuilder.append( String.format("node %s, parent %s, leftChild %s, rightChild %s\n"
				, String.valueOf( root.data )
				, root.parent == null ? "X" : String.valueOf( root.parent.data ) 
				, root.left == null ? "X" : String.valueOf( root.left.data ) 
				, root.right == null ? "X" : String.valueOf( root.right.data ) 
				) );
		
		return stringBuilder.toString();
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
	
	
	/*
	 level 0:
	 Node: 8, L: 4, R: 12
	 
	 level 1:
	 Node: 4, L: 2, R:  6
	 Node:12, L:10, R: 14
	 
	 level 2:
	 Node: 2, L: 1, R:  3
	 Node: 6, L: 5, R:  7
	 Node:10, L: 9, R: 11
	 Node:14, L:13, R: 15
	 
	 level 3:
	 Node: 1, L: x, R:  x
	 Node: 3, L: x, R:  x
	 Node: 5, L: x, R:  x
	 Node: 7, L: x, R:  x
	 Node: 9, L: x, R:  x
	 Node:11, L: x, R:  x
	 Node:13, L: x, R:  x
	 Node:15, L: x, R:  x
	  
	 * */
	public static MyTreeNode makeTree01() {
		
		MyTreeNode root = new MyTreeNode(8);
		
		//Arrays.asList(4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15)
		Arrays.asList( input01 )
			.forEach( key -> root.insertNodeInOrder(key) );
		
		return root;
	}
	
	
	
	/*
	 level 0:
	 Node: 8, L: 4, R: 12
	 
	 level 1:
	 Node: 4, L: 2, R:  x
	 Node:12, L:10, R: 14
	 
	 level 2:
	 Node: 2, L: 1, R:  3
	 Node:10, L: 9, R: 11
	 Node:14, L:13, R: 15
	 
	 level 3:
	 Node: 1, L: x, R:  x
	 Node: 3, L: x, R:  x
	 Node: 9, L: x, R:  x
	 Node:11, L: x, R:  x
	 Node:13, L: x, R:  x
	 Node:15, L: x, R:  x
	  
	 * */
	public static MyTreeNode makeTree02() {
		
		MyTreeNode root = new MyTreeNode(8);
		
		Arrays.asList(4, 2, 1, 3, 12, 10, 9, 11, 14, 13, 15)
			.forEach( key -> root.insertNodeInOrder(key) );
		
		return root;
	}
	
	
	
	/*
	 level 0:
	 Node: 8, L: 4, R: 12
	 
	 level 1:
	 Node: 4, L: 2, R:  x
	 Node:12, L:10, R: 14
	 
	 level 2:
	 Node: 2, L: 3, R:  1
	 Node:10, L: 9, R: 11
	 Node:14, L:13, R: 15
	 
	 level 3:
	 Node: 1, L: x, R:  x
	 Node: 3, L: x, R:  x
	 Node: 9, L: x, R:  x
	 Node:11, L: x, R:  x
	 Node:13, L: x, R:  x
	 Node:15, L: x, R:  x
	 * */
	//A non BST tree
	public static MyTreeNode makeTree03() {
		
		/*
		MyTreeNode root = new MyTreeNode(8);
		Arrays.asList(4, 2, 3, 1, 12, 10, 9, 11, 14, 13, 15)
			.forEach( key -> root.insertNodeInOrder(key) );
		*/
		
		MyTreeNode nodeWithVal_01 = new MyTreeNode( 1, null, null);
		MyTreeNode nodeWithVal_03 = new MyTreeNode( 3, null, null);
		MyTreeNode nodeWithVal_05 = new MyTreeNode( 5, null, null);
		MyTreeNode nodeWithVal_07 = new MyTreeNode( 7, null, null);
		MyTreeNode nodeWithVal_09 = new MyTreeNode( 9, null, null);
		MyTreeNode nodeWithVal_11 = new MyTreeNode(11, null, null);
		MyTreeNode nodeWithVal_13 = new MyTreeNode(13, null, null);
		MyTreeNode nodeWithVal_15 = new MyTreeNode(15, null, null);
		
		MyTreeNode nodeWithVal_02 = new MyTreeNode( 2, nodeWithVal_03, nodeWithVal_01);
		MyTreeNode nodeWithVal_06 = new MyTreeNode( 6, nodeWithVal_05, nodeWithVal_07);
		MyTreeNode nodeWithVal_10 = new MyTreeNode(10, nodeWithVal_09, nodeWithVal_11);
		MyTreeNode nodeWithVal_14 = new MyTreeNode(14, nodeWithVal_13, nodeWithVal_15);
		
		MyTreeNode nodeWithVal_04 = new MyTreeNode( 4, nodeWithVal_02, nodeWithVal_06);
		MyTreeNode nodeWithVal_12 = new MyTreeNode(12, nodeWithVal_10, nodeWithVal_14);
		
		MyTreeNode nodeWithVal_08 = new MyTreeNode( 8, nodeWithVal_04, nodeWithVal_12);
		
		return nodeWithVal_08;
	}
	
	
	/*
	 level 0:
	 Node: 4, L: 2, R: 6
	 
	 level 1:
	 Node: 2, L: 1, R:  3
	 Node: 6, L: 5, R:  7
	 
	 level 2:
	 Node: 1, L: X, R:  X
	 Node: 3, L: X, R:  X
	 Node: 5, L: X, R:  X
	 Node: 7, L: X, R:  X
	 
	 * */
	public static MyTreeNode makeTree04() {
		
		MyTreeNode root = new MyTreeNode(4);
		
		Arrays.asList(2, 1, 3, 6, 5, 7)
			.forEach( key -> root.insertNodeInOrder(key) );
		
		return root;
	}
	
	
	
	//REASONING: the reason Key type Integer not adopted is because same value ( e.g. 3) however the Integer object might be different -> cannot use map.get
	//public static HashMap<Integer, MyTreeNode> getValueToNode( MyTreeNode root ){
	public static HashMap<String, MyTreeNode> getValueToNode( MyTreeNode root ){
		
		HashMap<String, MyTreeNode> valueToNode = new HashMap<>();
		getValueToNodeHelper( root, valueToNode );
		
		return valueToNode;
	}
	
	
	
	private static void getValueToNodeHelper( MyTreeNode root, HashMap<String, MyTreeNode> valueToNode ) {
		
		if(root == null) {
			return ;
		}
		
		valueToNode.put( String.valueOf( root.data ), root );
		
		getValueToNodeHelper(root.left, valueToNode);
		//MISTAKE: typo
		//getValueToNodeHelper(root.left, valueToNode);
		getValueToNodeHelper(root.right, valueToNode);
		
		
	}
	
}


 