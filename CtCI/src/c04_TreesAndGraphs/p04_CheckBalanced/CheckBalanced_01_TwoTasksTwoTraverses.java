package c04_TreesAndGraphs.p04_CheckBalanced;
import static java.lang.System.out;

import util.MyTreeNode;
/*
 This is not the optimal for some reasons:
 1. if the subtree is unbalanced, we could've have just skip counting it height; however in the program is sill does
 * */
//THINK_FURTHER: it seems we cannot put getHeight after checkBalanced, because checkBalanced depends on getHeight
public class CheckBalanced_01_TwoTasksTwoTraverses {

	public static boolean checkBalanced( MyTreeNode root ) {
		
		
		//QUESTION WHY?
		//It doesn't matter for null node to be true or false; however, that matters for its parent: when a node has two null nodes I think it should be balanced
		if( root == null ) {
			return true;
		}
		
		int height_leftTree = getHeight( root.left );
		int height_rightTree = getHeight( root.right );
		
		if( Math.abs( height_leftTree - height_rightTree ) > 1 ) {
			return false;
		}
		
		/*THINK_FURTHER: think about the relationship between current node's balance and subtrees balances,
		 the current node's balance is equal to ( isBalance of left tree and is balance of right tree )
		 */
		boolean isBalanced_leftTree = checkBalanced( root.left );
		//PURPOSE: cut off
		if( isBalanced_leftTree == false ) {
			return false;
		}
		boolean isBalanced_rightTree = checkBalanced( root.right );
		boolean result = isBalanced_leftTree && isBalanced_rightTree;
		return result;
		
	}
	
	
	
	private static int getHeight( MyTreeNode root ) {
		
		//REASONING: non-existent node has not height, which is zero
		if( root == null ) {
			return 0;
		}
		
		//REASONING: the height of tree is the max height among subtrees plus the root node( which is 1 )
		
		//DETAIL: I don't like nested function
		//int height = Math.max( getHeight( root.left ), getHeight( root.right ) ) + 1;
		int height_leftTree = getHeight( root.left );
		int height_rightTree = getHeight( root.right );
		int height = Math.max( height_leftTree, height_rightTree )
				+ 1;
		return height;
		
	}
	
}


