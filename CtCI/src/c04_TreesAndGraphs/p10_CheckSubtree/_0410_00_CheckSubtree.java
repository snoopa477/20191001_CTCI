package c04_TreesAndGraphs.p10_CheckSubtree;

import static java.lang.System.out;

import util.TreeNode;

public class _0410_00_CheckSubtree {
	boolean containsTree(TreeNode t1, TreeNode t2) {
		StringBuilder string1 = new StringBuilder();
		StringBuilder string2 = new StringBuilder();
		getOrderString(t1, string1);
		getOrderString(t2, string2);
		return string1.indexOf(string2.toString()) != -1;
	}

	void getOrderString(TreeNode node, StringBuilder sb) {
		if (node == null) {
			sb.append("X"); // Add null indicator
			return;
		}
		sb.append(node.data + " "); // Add root
		getOrderString(node.left, sb); // Add left
		getOrderString(node.right, sb); // Add right
	}
}
