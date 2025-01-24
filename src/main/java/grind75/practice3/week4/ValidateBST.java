package grind75.practice3.week4;

public class ValidateBST {
	public boolean isValidBST(TreeNode root) {
		return validate(root, null, null);
	}

	private boolean validate(TreeNode current, Integer left, Integer right) {
		if (current == null) {
			return true;
		}

		if (left != null && current.val <= left)
			return false;

		if (right != null && current.val >= right)
			return false;

		if (!validate(current.left, left, current.val)) {
			return false;
		}

		if (!validate(current.right, current.val, right)) {
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