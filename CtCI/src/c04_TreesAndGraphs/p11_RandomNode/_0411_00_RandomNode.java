package c04_TreesAndGraphs.p11_RandomNode;

import static java.lang.System.out;

import java.util.Random;

public class _0411_00_RandomNode {
	class TreeNode {
		private int data;
		public TreeNode left;
		public TreeNode right;
		private int size = 0;

		public TreeNode(int d) {
			data = d;
			size = 1;
		}

		public TreeNode getRandomNode() {
			int leftSize = left == null ? 0 : left.size();
			Random random = new Random();
			int index = random.nextInt(size);
			if (index < leftSize) {
				return left.getRandomNode();
			} else if (index == leftSize) {
				return this;
			} else {
				return right.getRandomNode();
			}
		}

		public void insertlnOrder(int d) {
			if (d <= data) {
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

		public int data() {
			return data;
		}

		public TreeNode find(int d) {
			if (d == data) {
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
