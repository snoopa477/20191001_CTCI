package c04_TreesAndGraphs.p05_ValidateBST;
import static java.lang.System.out;

import util.MyTreeNode;
public class ValidateBST_01_Definition {

	public static boolean checkBST( MyTreeNode root ) {
		
		//THINK_FURTHER: this is like implicit recursion call: every call the argument root is getting lower and lower, until reaching to the bottom.
		//REASONING: the root has no boundaries, because it doesn't have any parents.
		return checkBST( root, null, null );
	}
	
	
	
	/*
	 REASONING: 
	 	for every node in a tree must fulfill all the following requirements:
	 	1. the node is within the boundary, updated by its parent
	 	2. node's left subtree is BST
	 	3. node's right subtree is BST
	 	
	 	if one of condition doesn't fulfill, it's not BST.
	 	it one of the node is not BST, then the whole tree is not BST. 
	 
	 */
	//REASONING: adoption of Integer is better than int, since Integer can be presented with null, which is needed in this scenario
	//private static boolean checkBST( MyTreeNode root, int left_ValueBound, int right_ValueBound  ) {
	private static boolean checkBST( MyTreeNode root, Integer left_ValueBound, Integer right_ValueBound  ) {
		
		//don't forget about this
		if( root == null ) {
			return true;
		}
		
		//I prefer to write this way than merging two if statements into one
		if( left_ValueBound != null ) {
			if( root.data <= left_ValueBound  ) {
				return false;
			}
		}
		
		
		if( right_ValueBound != null ) {
			if( right_ValueBound < root.data ) {
				return false;
			}
		}
		//THINK_FURTHER: reaching here meaning the node is within the right and left boundaries
		
		
		//REASONING: in the left child's perspective, its parent's value is its latest updated right bound value; furthermore, parent's value is the smallest among all ancestors, which LEFT descendants are the node and the parent, so parent's value is the strictest. 
		boolean isLeft_TreeBST = checkBST( root.left, left_ValueBound, root.data );
		//BETTER: cut-off
		if( isLeft_TreeBST == false ) {
			return false;
		}
		
		boolean isRight_TreeBST = checkBST( root.right, root.data, right_ValueBound );
		boolean isBST = isLeft_TreeBST && isRight_TreeBST;
		
		return isBST;
	}
	
}


