package util;

import static java.lang.System.out;

public class TreeNode {
	public int data;
	public TreeNode left, right, parent;
	private int size = 0;

	public TreeNode(int d) {
		data = d;
		size = 1;
	}

	public void insertlnOrder(int d) {
		if (d <= data) {
			if (left == null) {
				setLeftChild(new TreeNode(d));
			} else {
				left.insertlnOrder(d);
			}
		}

		else {
			if (right == null) {
				setRightChild(new TreeNode(d));
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
		if (d == data) {
			return this;

		} else if (d <= data) {
			return left != null ? left.find(d) : null;
		} else if (d > data) {
			return right != null ? right.find(d) : null;
		}
		return null;
	}

	public void setLeftChild(TreeNode left) {
		this.left = left;
		if (left != null) {
			left.parent = this;
		}
	}

	public void setRightChild(TreeNode right) {
		this.right = right;
		if (right != null) {
			right.parent = this;
		}
	}
}
