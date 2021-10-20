package c04_TreesAndGraphs.p05_ValidateBST;

import static java.lang.System.out;

import util.TreeNode;

public class _0405_00_ValidateBST {
	int index = 0;

	void copyBST(TreeNode root, int[] array) {
		if (root == null)
			return;
		copyBST(root.left, array);
		array[index] = root.data;
		index++;
		copyBST(root.right, array);
	}

	boolean checkBST(TreeNode root) {
		int[] array = new int[root.size()];
		copyBST(root, array);
		for (int i = 1; i < array.length; i++) {
			if (array[i] <= array[i - 1])
				return false;
		}
		return true;
	}
}
