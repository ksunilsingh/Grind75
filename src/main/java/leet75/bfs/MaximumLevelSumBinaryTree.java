package leet75.bfs;

public class MaximumLevelSumBinaryTree {
	private int[] levelSum = new int[10000];
	private int levelCount;

	public int maxLevelSum(TreeNode root) {
		int level = 1, maxSum = Integer.MIN_VALUE;

		traverseTree(root, 0);

		for (int i = 0; i <= levelCount; i++) {
			if (levelSum[i] > maxSum) {
				maxSum = levelSum[i];
				level = i + 1;
			}
		}
		return level;
	}

	private void traverseTree(TreeNode current, int level) {
		if (current == null)
			return;

		levelSum[level] += current.val;

		levelCount = Math.max(levelCount, level);

		traverseTree(current.left, level + 1);
		traverseTree(current.right, level + 1);
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
