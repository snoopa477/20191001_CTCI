package c04_TreesAndGraphs.p04_CheckBalanced;

import static java.lang.System.out;

import util.TreeNode;

public class _0404_01_CheckBalanced {

	int checkHeight(TreeNode root) {
		if (root == null)
			return -1;
		int leftHeight = checkHeight(root.left);
		if (leftHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE; // Pass error up
		int rightHeight = checkHeight(root.right);
		if (rightHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE; // Pass error up
		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1) {
			return Integer.MIN_VALUE; // Found error -> pass it back
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}

	boolean isBalanced(TreeNode root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}
}
