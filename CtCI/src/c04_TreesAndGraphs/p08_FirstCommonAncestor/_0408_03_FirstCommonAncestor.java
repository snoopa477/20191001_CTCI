package c04_TreesAndGraphs.p08_FirstCommonAncestor;

import static java.lang.System.out;

import util.TreeNode;

public class _0408_03_FirstCommonAncestor {
	/* The below code has a bug. */
	TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if (root == p && root == q)
			return root;
		TreeNode x = commonAncestor(root.left, p, q);

		if (x != null && x != p && x != q) { // Already found ancestor
			return x;
		}
		TreeNode y = commonAncestor(root.right, p, q);
		if (y != null && y != p && y != q) { // Already found ancestor
			return y;
		}
		if (x != null && y != null) { // p and q found in diff. subtrees
			return root; // This is the common ancestor
		} else if (root == p || root == q) {
			return root;
		} else {

			return x == null ? y : x; /* return the non-null value */

		}

	}
}
