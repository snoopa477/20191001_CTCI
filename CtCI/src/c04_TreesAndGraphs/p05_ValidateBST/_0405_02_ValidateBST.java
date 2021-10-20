package c04_TreesAndGraphs.p05_ValidateBST;

import static java.lang.System.out;

import util.TreeNode;

public class _0405_02_ValidateBST {
	boolean checkBST(TreeNode n) {
		return checkBST(n, null, null);
	}

	boolean checkBST(TreeNode n, Integer min, Integer max) {
		if (n == null) {
			return true;
		}
		if ((min != null && n.data <= min) || (max != null && n.data > max)) {
			return false;
		}
		if (!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max)) {
			return false;
		}
		return true;
	}
}
