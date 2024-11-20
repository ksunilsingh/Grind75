package grind75.week8;

public class KthSmallestInBST {

	private int count = 0;
	private int result = -1;

	public int kthSmallest(TreeNode root, int k) {
		inOrderTraversal(root, k);
		return result;
	}

	private void inOrderTraversal(TreeNode current, int k) {
		if (current == null)
			return;

		inOrderTraversal(current.left, k);
		
		++count;
		if(count == k) {
			result = current.val;
			return;
		}
		
		inOrderTraversal(current.right, k);

	}
}

/**
 * Definition for a binary tree node.
 */
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
