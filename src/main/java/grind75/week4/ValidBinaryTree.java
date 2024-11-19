package grind75.week4;

import java.util.Stack;

public class ValidBinaryTree {

	private long minVal = Long.MIN_VALUE;

	public boolean isValidBSTRecursive(TreeNodeBST root) {

		if (root == null)
			return true;

		if (!isValidBSTRecursive(root.left))
			return false;

		if (minVal >= root.val)
			return false;

		minVal = root.val;

		if (!isValidBSTRecursive(root.right))
			return false;

		return true;
	}

	Stack<Integer> stack = new Stack<Integer>();

	public boolean isValidBST(TreeNodeBST root) {
		stackFill(root);
		while (!stack.isEmpty()) {
			int ele = stack.pop();

			if (stack.isEmpty())
				return true;

			if (ele <= stack.peek()) {
				return false;
			}
		}
		return true;
	}

	private void stackFill(TreeNodeBST root) {
		if (root != null) {
			stackFill(root.left);
			stack.push(root.val);
			stackFill(root.right);
		}
	}

}

/**
 * Definition for a binary tree node.
 */
class TreeNodeBST {
	int val;
	TreeNodeBST left;
	TreeNodeBST right;

	TreeNodeBST() {
	}

	TreeNodeBST(int val) {
		this.val = val;
	}

	TreeNodeBST(int val, TreeNodeBST left, TreeNodeBST right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
