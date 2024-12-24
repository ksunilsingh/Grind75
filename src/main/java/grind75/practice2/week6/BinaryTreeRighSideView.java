package grind75.practice2.week6;

import java.util.ArrayList;
import java.util.List;

/*
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 */
public class BinaryTreeRighSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		rightView(root, 0, result);
		return result;
	}

	private void rightView(TreeNode current, int level, List<Integer> result) {
		if (current == null)
			return;

		if (level == result.size()) {
			result.add(current.val);
		}

		rightView(current.right, level + 1, result);
		rightView(current.left, level + 1, result);
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