package grind75.practice2.week4;

/*
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left 
subtree
 of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4
 */
public class ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
		return validate(root, null, null);
	}

	private boolean validate(TreeNode current, Integer lower, Integer upper) {
		if (current == null)
			return true;

		int val = current.val;
		if (lower != null && val <= lower) {
			return false;
		}

		if (upper != null && val >= upper) {
			return false;
		}

		if (!validate(current.left, lower, val)) {
			return false;
		}

		if (!validate(current.right, val, upper)) {
			return false;
		}
		return true;
	}
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