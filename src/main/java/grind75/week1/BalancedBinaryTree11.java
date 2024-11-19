package grind75.week1;

public class BalancedBinaryTree11 {
	public boolean isBalanced(TreeNode11 root) {
		return checkHeight(root) != -1;
	}

	private int checkHeight(TreeNode11 root) {
		if (root == null)
			return 0;

		int leftHeight = checkHeight(root.left);
		if (leftHeight == -1)
			return -1;

		int rightHeight = checkHeight(root.right);
		if (rightHeight == -1)
			return -1;

		if (Math.abs(rightHeight - leftHeight) > 1)
			return -1;

		return Math.max(leftHeight, rightHeight) + 1;
	}

}

class TreeNode11 {
	int val;
	TreeNode11 left;
	TreeNode11 right;

	TreeNode11() {
	}

	TreeNode11(int val) {
		this.val = val;
	}

	TreeNode11(int val, TreeNode11 left, TreeNode11 right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
