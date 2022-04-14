package c04_TreesAndGraphs.p08_FirstCommonAncestor;

import static java.lang.System.out;

import util.TreeNode;

public class _0408_00_FirstCommonAncestor {

	TreeNode commonAncestor(TreeNode p, TreeNode q) {
		
		int delta = depth(p) - depth(q); // get difference in depths
		TreeNode first = delta > 0 ? q : p; // get shallower node
		TreeNode second = delta > 0 ? p : q; // get deeper node
		second = goUpBy(second, Math.abs(delta)); // move deeper node up
		
		/* Find where paths intersect. */
		while (first != second && first != null && second != null) {
			first = first.parent;
			second = second.parent;
		}

		return first == null || second == null ? null : first;
	}

	
	
	TreeNode goUpBy(TreeNode node, int delta) {
		
		while (delta > 0 && node != null) {
			node = node.parent;
			delta--;
		}
		return node;
	}

	
	
	int depth(TreeNode node) {
		
		int depth = 0;
		while (node != null) {
			node = node.parent;
			depth++;
		}
		return depth;
	}

}


