package c04_TreesAndGraphs.p08_FirstCommonAncestor;

import static java.lang.System.out;

import util.TreeNode;

public class _0408_04_FirstCommonAncestor {
	class Result {
		public TreeNode node;
		public boolean isAncestor;

		public Result(TreeNode n, boolean isAnc) {
			node = n;
			isAncestor = isAnc;
		}
	}

	TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Result r = commonAncHelper(root, p, q);
		if (r.isAncestor) {
			return r.node;
		}
		return null;
	}

	Result commonAncHelper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return new Result(null, false);
		if (root == p && root == q) {
			return new Result(root, true);
		}
		Result rx = commonAncHelper(root.left, p, q);
		if (rx.isAncestor) { // Found common ancestor
			return rx;
		}
		Result ry = commonAncHelper(root.right, p, q);
		if (ry.isAncestor) { // Found common ancestor
			return ry;
		}
		if (rx.node != null && ry.node != null) {
			return new Result(root, true); // This is the common ancestor
		} else if (root == p || root == q) {
			/*
			 * If we're currently at p or q, and we also found one of those nodes in a
			 * subtree, then this is truly an ancestor and the flag should be true.
			 */
			boolean isAncestor = rx.node != null || ry.node != null;
			return new Result(root, isAncestor);
		} else {
			return new Result(rx.node != null ? rx.node : ry.node, false);
		}
	}
}
