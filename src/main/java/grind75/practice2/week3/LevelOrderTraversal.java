package grind75.practice2.week3;

import java.util.ArrayList;
import java.util.List;

/*
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 * Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 */
public class LevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> levelTraversalData = new ArrayList<List<Integer>>();
		traverse(root, 0, levelTraversalData);
		return levelTraversalData;
	}

	private void traverse(TreeNode current, int level, List<List<Integer>> levelTraversalData) {
		if (current == null)
			return;

		if (levelTraversalData.size() == level) {
			List<Integer> l = new ArrayList<Integer>();
			l.add(current.val);
			levelTraversalData.add(l);
		} else {
			levelTraversalData.get(level).add(current.val);
		}

		traverse(current.left, level + 1, levelTraversalData);
		traverse(current.right, level + 1, levelTraversalData);

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