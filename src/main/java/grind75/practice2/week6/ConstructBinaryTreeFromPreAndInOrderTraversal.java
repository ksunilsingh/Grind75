package grind75.practice2.week6;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreAndInOrderTraversal {

	// tracks the current position in the preorder array.
	// Root is at the beginning of the preorder array.
	private int preorderIndex;

	// Keep track of indices in the inorder array.
	// Key is the node value, and value is the array index of that element.
	private Map<Integer, Integer> inorderIndexMap;

	public TreeNode buildTree(int[] preorder, int[] inorder) {

		preorderIndex = 0;
		inorderIndexMap = new HashMap<>();

		// Populate the inorderIndexMap with node value and index
		for (int i = 0; i < inorder.length; i++) {
			inorderIndexMap.put(inorder[i], i);
		}

		return constructTree(preorder, 0, inorder.length - 1);
	}

	private TreeNode constructTree(int[] preorder, int left, int right) {
		if (left > right)
			return null;

		// Create the node using the nodevalue at preorderIndex
		// initially the preorderIndex is zero. So root node will be created.
		int rootVal = preorder[preorderIndex++];
		TreeNode root = new TreeNode(rootVal);

		// Use the segment to the left of the root node to create the left subtree
		root.left = constructTree(preorder, left, inorderIndexMap.get(rootVal) - 1);
		// Use the segment to the right of the root node to create the right subtree
		root.right = constructTree(preorder, inorderIndexMap.get(rootVal) + 1, right);
		return root;
	}
}
