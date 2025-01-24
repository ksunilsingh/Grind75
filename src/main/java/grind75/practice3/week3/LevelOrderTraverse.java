package grind75.practice3.week3;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraverse {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		Traverse(root, 0, result);
		return result;

	}

	private void Traverse(TreeNode current, int level, List<List<Integer>> result) {
		if (current == null)
			return;

		if (result.size() == level) {
			List<Integer> l = new ArrayList<>();
			l.add(current.val);
			result.add(l);
		} else {
			result.get(level).add(current.val);
		}

		Traverse(current.left, level + 1, result);
		Traverse(current.right, level + 1, result);
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