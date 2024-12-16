package grind75.practice1.week8;

public class BinaryTreeSerializeDeserialize {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder result = new StringBuilder();
		preorder(root, result);
		return result.toString();
	}

	private void preorder(TreeNode current, StringBuilder result) {
		if (current == null) {
			result.append("*").append(" ");
			return;
		}

		result.append(current.val).append(" ");

		preorder(current.left, result);
		preorder(current.right, result);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] nodeValues = data.split(" ");
		// Store the index in an array of length 1 because we want to pass it as
		// reference.
		return deserializeImpl(nodeValues, new int[] { 0 });
	}

	private TreeNode deserializeImpl(String[] nodeValues, int[] index) {

		// Base case: If all the nodeValues are processed i.e. the value of index[0] is
		// greater than length of nodeValues
		if (index[0] >= nodeValues.length) {
			return null;
		}

		// Get the current value that is being processed from nodeValues using the value
		// in index[0]
		// And increment the value in index[0]
		String currentVal = nodeValues[index[0]++];

		// If currentVal is *, then return null because during serialization, we added *
		// for leaf nodes
		if (currentVal.equals("*")) {
			return null;
		}

		// Create a new node with currentVal
		TreeNode root = new TreeNode(Integer.parseInt(currentVal));

		// process the next value in nodeValues. Next value because value in index[0] is
		// already incremented
		// Assign it to the left of the root node
		root.left = deserializeImpl(nodeValues, index);
		// process the next value in nodeValues. Next value because value in index[0] is
		// already incremented
		// Assign it to the right of the root node
		root.right = deserializeImpl(nodeValues, index);

		return root;
	}
}
