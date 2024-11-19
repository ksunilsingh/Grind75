package grind75.week6;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView6 {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> answer = new ArrayList<Integer>();
		rightView(root, answer, 0);
		return answer;
	}

	private void rightView(TreeNode current, List<Integer> answer, int level) {
		if (current == null)
			return;

		if (level == answer.size())
			answer.add(current.val);

		rightView(current.right, answer, level + 1);
		rightView(current.left, answer, level + 1);
	}
}

/**
 * Definition for a binary tree node.
 */
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
