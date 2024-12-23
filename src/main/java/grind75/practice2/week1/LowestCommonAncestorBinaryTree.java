package grind75.practice2.week1;

/*
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

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
Output: 2
 */
public class LowestCommonAncestorBinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while (root != null) {
			// if both p and q have values smaller than current root, it mean they are both
			// in the left half of the current root.
			if (p.val < root.val && q.val < root.val) {
				root = root.left;
				// if both p and q have values greater than current root, it mean they are both
				// in the right half of the current root.
			} else if (p.val > root.val && q.val > root.val) {
				root = root.right;
			} else {
				// they are both in the separate half of the current root. So this is the LCA
				return root;
			}
		}
		return null;
	}

}
