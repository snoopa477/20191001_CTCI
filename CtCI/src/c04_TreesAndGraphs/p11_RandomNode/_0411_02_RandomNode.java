package c04_TreesAndGraphs.p11_RandomNode;

import static java.lang.System.out;

import java.util.Random;

import c04_TreesAndGraphs.p11_RandomNode._0411_00_RandomNode.TreeNode;

public class _0411_02_RandomNode {
	class Tree {
		TreeNode root = null;

		public int size() {
			return root == null ? 0 : root.size();
		}

		public TreeNode getRandomNode() {
			if (root == null)
				return null;
			Random random = new Random();
			int i = random.nextInt(size());
			return root.getlthNode(i);
		}

		public void insertlnOrder(int value) {
			if (root == null) {
				root = new TreeNode(value);
			} else {
				root.insertlnOrder(value);
			}
		}

		class TreeNode {
			/* constructor and variables are the same. */
			private int data;
			public TreeNode left;
			public TreeNode right;
			private int size = 0;

			public TreeNode(int d) {
				data = d;
				size = 1;
			}

			public TreeNode getlthNode(int i) {
				int leftSize = left == null ? 0 : left.size();
				if (i < leftSize) {
					return left.getlthNode(i);
				} else if (i == leftSize) {
					return this;
				} else {
					/* Skipping over leftSize + 1 nodes, so subtract them. */
					return right.getlthNode(i - (leftSize + 1));
				}
			}

			public void insertlnOrder(int d) {
				/* same */if (d <= data) {
					if (left == null) {
						left = new TreeNode(d);
					} else {
						left.insertlnOrder(d);
					}
				} else {
					if (right == null) {
						right = new TreeNode(d);
					} else {
						right.insertlnOrder(d);
					}
				}
				size++;
			}

			public int size() {
				return size;
			}

			public TreeNode find(int d) {
				/* same */if (d == data) {
					return this;
				} else if (d <= data) {
					return left != null ? left.find(d) : null;
				} else if (d > data) {
					return right != null ? right.find(d) : null;
				}
				return null;
			}
		}

	}

}
