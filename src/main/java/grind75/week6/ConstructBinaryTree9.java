package grind75.week6;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree9 {

	private int preorderIndex;
	private Map<Integer, Integer> inorderIndexMap;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		preorderIndex = 0;
		inorderIndexMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < inorder.length; i++) {
			inorderIndexMap.put(inorder[i], i);
		}

		return constructTree(preorder, 0, inorder.length - 1);
	}

	private TreeNode constructTree(int[] preorder, int left, int right) {
		if (left > right)
			return null;

		int rootValue = preorder[preorderIndex++];
		TreeNode root = new TreeNode(rootValue);

		root.left = constructTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
		root.right = constructTree(preorder, inorderIndexMap.get(rootValue) + 1, right);

		return root;
	}
}
