package c04_TreesAndGraphs.p08_FirstCommonAncestor;
import static java.lang.System.out;

import util.MyTreeNode;
public class FirstCommonAncestor_03_Parent_Sibling {
	
	public static MyTreeNode getCommonAncestor( MyTreeNode root, MyTreeNode nodeA, MyTreeNode nodeB) {
		
		//PURPOSE: we start from the premise that targets nodes are in the same tree.
		if( root == null ) {
			return null;
		}
		
		if( containsNodeInTree(root, nodeA) == false || containsNodeInTree(root, nodeB) == false) {
			return null;
		}
		
		/*PURPOSE: Under the premise that 
		 * all nodes are existent, and both targets are in the tree, rooted from root,
		 * check if targets are in descendant-parent relationship. 
		 */
		if( containsNodeInTree(nodeA, nodeB) ) {
			return nodeA;
		}
		
		if( containsNodeInTree(nodeB, nodeA)) {
			return nodeB;
		}
		
		/* REASONING: targets are not in descendant-parent relationship, and 
		 * all nodes are existent -> 
		 * given nodeA, the nodeB lies in nodeA's sibling tree
		 * , or given nodeA's ancestor P, nodeB lies in the subtree that doesn't contain nodeA, which is called sibling 
		 */
		
		//DETAIL: one of descendants of current_Node is nodeA
		MyTreeNode theCurrentFromA = nodeA;
		MyTreeNode theCurrentFromA_Parent = theCurrentFromA.parent;
		MyTreeNode theCurrentFromA_Sibling= getSibling(theCurrentFromA);
		
		while( theCurrentFromA_Parent != null 
			&& containsNodeInTree( theCurrentFromA_Sibling, nodeB ) == false ) {
		
			theCurrentFromA = theCurrentFromA_Parent;
			theCurrentFromA_Parent = theCurrentFromA_Parent.parent;
			theCurrentFromA_Sibling = getSibling( theCurrentFromA );
		}
		
		//REASONING: given existent, reaching here meaning theCurrentFromA contains nodeB, meaning common ancestor
		return theCurrentFromA_Parent;
	}
	
	
	
	private static MyTreeNode getSibling( MyTreeNode root ) {

		if( root == null || root.parent == null ) {
			return null;
		}
		
		//REASONING: reaching here root != null && root.parent != null, so we can do further operations
		MyTreeNode parent = root.parent;
		MyTreeNode sibling = parent.left == root? parent.right : parent.left;
		
		return sibling;
	}
	
	
	
	private static boolean containsNodeInTree( MyTreeNode root, MyTreeNode target) {
		
		if( root == null || target == null) {
			return false;
		}
		
		
		if( root == target ) {
			return true;
		}
		
		//IMAGINE: all root can do is done: check root itself. If there's still task to do, the remaining part is assigned to subtrees.
		return containsNodeInTree( root.left, target ) || containsNodeInTree( root.right, target );
	}
	
}


