package grind75.practice1.week6;

import java.util.ArrayList;
import java.util.List;

/*
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 

Example 1:

Input: root = [1,2,3,null,5,null,4]

Output: [1,3,4]

Explanation:



Example 2:

Input: root = [1,2,3,4,null,null,null,5]

Output: [1,3,4,5]

Explanation:



Example 3:

Input: root = [1,null,3]

Output: [1,3]

Example 4:

Input: root = []

Output: []

 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

 */
public class BinaryTreeRightSideView {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> answer = new ArrayList<>();
		rightView(root, 0, answer);
		return answer;
	}

	private void rightView(TreeNode current, int level, List<Integer> answer) {
		if (current == null)
			return;

		if (level == answer.size()) {
			answer.add(current.val);
		}

		rightView(current.right, level + 1, answer);
		rightView(current.left, level + 1, answer);
	}

}
