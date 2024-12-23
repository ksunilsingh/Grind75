package grind75.week1;

/*
 * 
 * 
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: �The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).�

 

Example 1:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [2,1], p = 2, q = 1
 * 
 */

public class LowestCommonAncestor10 {

	public TreeNode10 lowestCommonAncestor(TreeNode10 root, TreeNode10 p, TreeNode10 q) {

		while (root != null) {
			if (root.val < p.val && root.val < q.val) {
				root = root.right;
			} else if (root.val > p.val && root.val > q.val) {
				root = root.left;
			} else {
				return root;
			}
		}
		return null;

	}
}

class TreeNode10 {
	int val;
	TreeNode10 left;
	TreeNode10 right;

	TreeNode10(int x) {
		val = x;
	}
}