package grind75.week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph7 {
	public Node cloneGraph(Node node) {
		if (node == null)
			return null;

		Map<Node, Node> visited = new HashMap<>();

		Node clone = new Node(node.val);
		visited.put(node, clone);

		Queue<Node> queue = new LinkedList<>();
		queue.add(node);

		while (!queue.isEmpty()) {
			Node currentNode = queue.poll();

			for (Node neighbor : currentNode.neighbors) {
				if (!visited.containsKey(neighbor)) {
					visited.put(neighbor, new Node(neighbor.val));
					queue.add(neighbor);
				}
				visited.get(currentNode).neighbors.add(visited.get(neighbor));
			}
		}

		return visited.get(node);
	}
}

class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}