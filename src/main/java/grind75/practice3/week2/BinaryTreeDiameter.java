package grind75.practice3.week2;

public class BinaryTreeDiameter {

	private int diameter = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		height(root);
		return diameter;
	}

	private int height(TreeNode current) {
		if (current == null)
			return 0;

		int leftHeight = height(current.left);
		int rightHeight = height(current.right);

		diameter = Math.max(diameter, leftHeight + rightHeight);
		return Math.max(leftHeight, rightHeight) + 1;
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