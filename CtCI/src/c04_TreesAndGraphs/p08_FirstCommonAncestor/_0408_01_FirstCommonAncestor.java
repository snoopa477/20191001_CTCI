package c04_TreesAndGraphs.p08_FirstCommonAncestor;

import static java.lang.System.out;

import util.TreeNode;

public class _0408_01_FirstCommonAncestor {
	
	TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		/* Check if either node is not in the tree, or if one covers the other. */
		if (!covers(root, p) || !covers(root, q)) {
			return null;
		} 
		else if (covers(p, q)) {
			return p;
		} 
		else if (covers(q, p)) {
			return q;
		}

		
		/* Traverse upwards until you find a node that covers q. */
		TreeNode sibling = getSibling(p);
		TreeNode parent = p.parent;
		while (!covers(sibling, q)) {
			sibling = getSibling(parent);
			parent = parent.parent;
		}
		return parent;
	}

	
	
	boolean covers(TreeNode root, TreeNode p) {
		
		if (root == null)
			return false;
		if (root == p)
			return true;
		return covers(root.left, p) || covers(root.right, p);
	}

	
	
	TreeNode getSibling(TreeNode node) {
		
		if (node == null || node.parent == null) {
			return null;
		}
		TreeNode parent = node.parent;
		return parent.left == node ? parent.right : parent.left;
	}
	
}




