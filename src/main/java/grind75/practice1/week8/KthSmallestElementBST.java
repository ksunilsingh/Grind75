package grind75.practice1.week8;

/*
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */
public class KthSmallestElementBST {

	private int result = -1;
	private int count = 0;

	public int kthSmallest(TreeNode root, int k) {
		// In a BST, an in-order traversal visits nodes in ascending order.
		// This property ensures the kth visited node is the kth smallest element.
		inorderTraversal(root, k);
		return result;
	}

	private void inorderTraversal(TreeNode current, int k) {
		// reached the last node
		if (current == null)
			return;

		inorderTraversal(current.left, k);

		++count;
		if (k == count) {
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