package grind75.practice3.week8;

public class KthSmallestValueBST {
	private int result = -1;
	private int count = 0;

	public int kthSmallest(TreeNode root, int k) {
		inorderTraversal(root, k);
		return result;
	}

	private void inorderTraversal(TreeNode current, int k) {
		if (current == null)
			return;

		inorderTraversal(current.left, k);

		++count;
		if (count == k) {
			result = current.val;
			return;
		}
		inorderTraversal(current.right, k);
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