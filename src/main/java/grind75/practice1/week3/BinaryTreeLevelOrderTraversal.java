package grind75.practice1.week3;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		traverse(root, 0, result);
		return result;
	}

	private void traverse(TreeNode node, int level, List<List<Integer>> result) {
		if (node == null)
			return;

		if (result.size() == level) {
			List<Integer> l = new ArrayList<Integer>();
			l.add(node.val);
			result.add(l);
		} else {
			result.get(level).add(node.val);
		}

		traverse(node.left, level + 1, result);
		traverse(node.right, level + 1, result);

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