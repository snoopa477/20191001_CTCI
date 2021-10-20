package c04_TreesAndGraphs.p05_ValidateBST;

import static java.lang.System.out;

import util.TreeNode;

public class _0405_01_ValidateBST {
	Integer last_printed = null;

	boolean checkBST(TreeNode n) {
		if (n == null)
			return true;

		// Check I recurse left
		if (!checkBST(n.left))
			return false;

		// Check current
		if (last_printed != null && n.data <= last_printed) {
			return false;
		}
		last_printed = n.data;
		// Check I recurse right
		if (!checkBST(n.right))
			return false;
		return true; // All good!
	}
}
