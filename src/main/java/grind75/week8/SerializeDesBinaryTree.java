package grind75.week8;

public class SerializeDesBinaryTree {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder result = new StringBuilder();
		traversePreOrder(root, result);
		return result.toString();
	}

	private void traversePreOrder(TreeNode current, StringBuilder result) {
		if (current == null) {
			result.append("*").append(" ");
			return;
		}

		result.append(current.val).append(" ");

		traversePreOrder(current.left, result);
		traversePreOrder(current.right, result);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {

		String[] nodeValues = data.split(" ");

		return deserializeImpl(nodeValues, new int[] { 0 });
	}

	private TreeNode deserializeImpl(String[] nodeValues, int[] index) {

		if (index[0] >= nodeValues.length)
			return null;

		String currentVal = nodeValues[index[0]++];

		if (currentVal.equals("*")) {
			return null;
		}

		TreeNode root = new TreeNode(Integer.parseInt(currentVal));

		root.left = deserializeImpl(nodeValues, index);
		root.right = deserializeImpl(nodeValues, index);
		return root;
	}

}
