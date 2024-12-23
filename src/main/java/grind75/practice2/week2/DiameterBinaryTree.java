package grind75.practice2.week2;

/* Diameter of Binary Tree

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
The length of a path between two nodes is represented by the number of edges between them.

Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100
*/
public class DiameterBinaryTree {
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