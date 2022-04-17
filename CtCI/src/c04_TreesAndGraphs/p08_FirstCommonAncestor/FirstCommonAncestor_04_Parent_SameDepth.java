package c04_TreesAndGraphs.p08_FirstCommonAncestor;
import static java.lang.System.out;

import util.MyTreeNode;
public class FirstCommonAncestor_04_Parent_SameDepth {
	
	static final boolean IS_DEBUG_ON = false;

	public static MyTreeNode getCommonAncestor( MyTreeNode root, MyTreeNode nodeA, MyTreeNode nodeB) {

		if( nodeA == null || nodeB == null) {
			return null;
		}
		
		/*REASONING: we don't check if both nodes in the same tree; 
		 * if they are not in the same tree, given with same depth going upwards, they won't meet each other
		 * if they're in the same tree, given same depth going upwards, they meet each other, and it is common ancestor
		 */
		
		//PURPOSE: make theCurrentA and theCurrentB on the same depth, and then go upward together
		MyTreeNode theCurrentA = nodeA;
		MyTreeNode theCurrentB = nodeB;
		
		int depthA = getDepth( root, nodeA, 1 );
		int depthB = getDepth( root, nodeB, 1 );
		

		int depthDifference = Math.abs( depthA - depthB ); 
		if( depthDifference != 0 ) {
			
			if( depthA > depthB) {
				theCurrentA = goUpwardBy( theCurrentA, depthDifference );
			}
			else {
				theCurrentB = goUpwardBy( theCurrentB, depthDifference );
			}
		}
		
		
		//int commonDepth = depthA > depthB? depthB : depthA;
		int commonDepth = Math.min( depthA, depthB );
		int distanceToRoot = commonDepth - 1;
		
		while( !( distanceToRoot == 0 || theCurrentA == theCurrentB ) ) {
			theCurrentA = goUpwardBy(theCurrentA, 1);
			theCurrentB = goUpwardBy(theCurrentB, 1);
			distanceToRoot--;
		}
		

		if( theCurrentA == theCurrentB ) {
			return theCurrentA;
		}
		else {
			return null;
		}
		
	}
	
	
	
	//TODO: gotta think clearly...
	private static int getDepth( MyTreeNode root, MyTreeNode target, int currentDepth ) {
		
		if( root == null ) {
			//REASONING non-existent node takes 0 depth
			return 0;
		}
		
		if( root == target ) {
			return currentDepth;
		}
		
		int leftResult = getDepth(root.left, target, currentDepth + 1);
		
		if( leftResult != 0 ) {
			return leftResult;
		}
		
		int rightResult = getDepth(root.right, target, currentDepth + 1);
		return rightResult;
	}
	
	
	//WRONG: it's height, calculated from bottom. What was I thinking? 
	/*private static int getDepth( MyTreeNode root ) {
		
		if( root == null ) {
			//REASONING non-existent node takes 0 depth
			return 0;
		}

		
		int left_SubTreeDepth = getDepth( root.left );
		int right_SubTreeDepth = getDepth( root.right );
		//DETAIL: the root itself existent, adding depth 1
		int currentDepth = 1 + Math.max(left_SubTreeDepth, right_SubTreeDepth);
		return currentDepth;
	}*/
	
	
	
	private static MyTreeNode goUpwardBy( MyTreeNode currentNode, int offset ) {
	//WRONG: passing by reference works when the referenced object changed; instead of  changing things that reference variable points to
	//private static void goUpwardBy( MyTreeNode currentNode, int offset ) {
		
		while( currentNode != null && offset > 0 ) {
			currentNode = currentNode.parent;
			offset--;
		}
		
		return currentNode;
	}
	
}


