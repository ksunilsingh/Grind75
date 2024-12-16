package grind75.practice1.week4;

/**
 * Given the root of a binary tree, determine if it is a valid binary search
 * tree (BST).
 * 
 * A valid BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's
 * key. The right subtree of a node contains only nodes with keys greater than
 * the node's key. Both the left and right subtrees must also be binary search
 * trees.
 */
public class ValidateBinaryTree {

	private int minValue = Integer.MIN_VALUE;

	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;

		if (!isValidBST(root.left))
			return false;

		if (minValue >= root.val)
			return false;

		minValue = root.val;

		if (!isValidBST(root.right))
			return false;

		return true;
	}
	/*
	 * Stack<Integer> stack = new Stack<>();
	 * 
	 * public boolean isValidBST(TreeNode root) { stackFill(root); while
	 * (!stack.isEmpty()) { int current = stack.pop(); if (stack.isEmpty()) return
	 * true;
	 * 
	 * if (current <= stack.peek()) { return false; } } return true; }
	 * 
	 * public void stackFill(TreeNode root) { if (root == null) return;
	 * stackFill(root.left); stack.push(root.val); stackFill(root.right); }
	 */
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}