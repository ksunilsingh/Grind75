package grind75.practice1.week6;

import java.util.HashMap;
import java.util.Map;

/*
 * Construct Binary Tree from Preorder and Inorder Traversal
 * Given two integer arrays preorder and inorder 
 * where preorder is the preorder traversal of a binary tree and
 * inorder is the inorder traversal of the same tree, 
 * construct and return the binary tree.


Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.
 */
public class ConstructBinaryTree {

	private int preorderIndex;
	private Map<Integer, Integer> inorderIndexMap;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		preorderIndex = 0;
		inorderIndexMap = new HashMap<>();

		for (int i = 0; i < inorder.length; i++) {
			inorderIndexMap.put(inorder[i], i);
		}

		return constructTree(preorder, 0, inorder.length - 1);

	}

	private TreeNode constructTree(int[] preorder, int left, int right) {
		if (left > right)
			return null;

		int rootVal = preorder[preorderIndex++];
		TreeNode root = new TreeNode(rootVal);

		root.left = constructTree(preorder, left, inorderIndexMap.get(rootVal) - 1);
		root.right = constructTree(preorder, inorderIndexMap.get(rootVal) + 1, right);
		return root;
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