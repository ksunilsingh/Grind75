package grind75.week3;

import java.util.ArrayList;
import java.util.List;

/*
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */
public class BinaryTreeLevelOrderTraversal6 {

	public List<List<Integer>> levelOrder(TreeNode6 root) {
		List<List<Integer>> nodeValues = new ArrayList<List<Integer>>();
		traverse(root, 0, nodeValues);
		return nodeValues;
	}

	private void traverse(TreeNode6 node, int level, List<List<Integer>> nodeValues) {
		if (node == null)
			return;

		if (nodeValues.size() == level) {
			List<Integer> list = new ArrayList<>();
			list.add(node.val);
			nodeValues.add(list);
		} else {
			nodeValues.get(level).add(node.val);
		}

		traverse(node.left, level + 1, nodeValues);
		traverse(node.right, level + 1, nodeValues);
	}

}

/**
 * Definition for a binary tree node.
 */
class TreeNode6 {
	int val;
	TreeNode6 left;
	TreeNode6 right;

	TreeNode6() {
	}

	TreeNode6(int val) {
		this.val = val;
	}

	TreeNode6(int val, TreeNode6 left, TreeNode6 right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
