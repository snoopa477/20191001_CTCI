package c04_TreesAndGraphs.p06_Successor;
import static java.lang.System.out;

import util.MyTreeNode;
public class Successor_00 {

	public static MyTreeNode getInOrderSuccessor( MyTreeNode root ) {
		
		//DETAIL: This is easily forgotten because this has little do to with the main idea 
		if( root == null ) {
			return null;
		}
		
		/*
		 REASONING: in order successor is the smallest node among the nodes that are greater than the current node.
		 Therefore, suppose a node has
		 1. a parent which left child is this node, suggesting that the parent is at right side of the node
		 2. right subtree
		 
		 , since they are both at the right side, they're all greater than the node.
		 However, right subtree is smaller than the parent which left child is this node, because left subtree of parent is smaller than the parent, and the right subtree we mentioned is in the left tree of the parent.
		 Therefore, to find the smallest nodes that are greater than than the node, we first seek for right subtree, then the parent which has left child of this node.
		 
		 * */
		
		//PURPOSE: we first look for right subtree
		//DETAIL: don't forget every element in right tree is greater than the node
		if( root.right != null ) {
			return getSmallestNode( root.right );
		}
		//PURPOSE: if right subtree not exist, we then seek for the parent which left child is this node
		else {
			//MISTAKE: careful of the argument
			//return getParentHavingLeftChild( root.parent );
			return getParentHavingLeftChild( root );
		}
		
	}
	


	private static MyTreeNode getSmallestNode(MyTreeNode root) {
		
		MyTreeNode currentNode = root;
		
		//IMAGINE: trying to get the tail of a linked list, which points to nothing
		/*TIP: Think of De Morgan's laws
		 * the opposite condition of if statement is
		 * currentNode == null || currentNode.left == null
		 * =>
		 * 1. currentNode == null ( 2
		 * 2. currentNode != null && currentNode.left == null (1
		 */
		while( currentNode != null && currentNode.left != null ) {
			currentNode = currentNode.left;
		}
		
		/*THINK_FURTHER
		 * Reaching here is either null node or the smallest node
		 */
		return currentNode;
	}
	
	
	
	private static MyTreeNode getParentHavingLeftChild( MyTreeNode root ) {
		
		//This is complicated, because there are three expressions in a if statement
		/*It is similar to getSmallestNode
		 * the opposite of if condition is
		 * currentNode == null ||  currentNode.parent == null || currentNode.parent.left == currentNode
		 * =>
		 * 1. currentNode == null ( 4
		 * 2. currentNode != null &&  currentNode.parent == null ( 2. This is UNDESIRABLE condition
		 * 3. currentNode != null &&  currentNode.parent != null || currentNode.parent.left == currentNode ( 1
		 */
		/*
		while( currentNode != null 
				&& currentNode.parent != null
				&& currentNode.parent.left != currentNode ) {
			currentNode = currentNode.parent;
		}*/
		
		//Better, because there are two expressions. it's easy to consider
		MyTreeNode currentNode = root;
		MyTreeNode parentNode = root.parent;
		
		//MISTAKE
		//while( parentNode != null && parentNode.right != currentNode ) {
		while( parentNode != null && parentNode.left != currentNode ) {
			//prepare for the next loop
			currentNode = parentNode;
			parentNode = parentNode.parent;
		}
		
		
		//THINK_FURTHER: reaching here meaning it is either parent node is null or parent node's right child is the current node( of course, the parent node is existent. )
		return parentNode;
	}

	
	
}


