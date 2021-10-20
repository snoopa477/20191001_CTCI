package c04_TreesAndGraphs.p04_CheckBalanced;

import static java.lang.System.out;

import util.TreeNode;

public class _0404_00_CheckBalanced {
	int getHeight(TreeNode root) {
		if (root == null)
			return -1; // Base case
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}

	boolean isBalanced(TreeNode root) {
		if (root == null)
			return true; // Base case
		int heightDiff = getHeight(root.left) - getHeight(root.right);
		if (Math.abs(heightDiff) > 1) {
			return false;
		} else { // Recurse
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}
}
