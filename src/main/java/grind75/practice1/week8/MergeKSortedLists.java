package grind75.practice1.week8;

import java.util.PriorityQueue;

public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}

		// Step 1. Create a min heap with smallest elements from the lists at the root
		// of the tree.
		// If there are two list nodes a and b such that a.val < b.val, a is given
		// higher priority than b
		PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

		// Step 2. Add all the list nodes in the ListNode array to the priority queue
		// this way, the smallest value list node will be at the top and so forth
		for (ListNode node : lists) {
			if (node != null) {
				pq.add(node);
			}
		}

		// Create a dummy node for the result
		ListNode answer = new ListNode(0);
		ListNode current = answer;

		while (!pq.isEmpty()) {
			ListNode smallestNode = pq.poll();
			// Add the smallest node to the current node which is same as answer node in the
			// beginning
			current.next = smallestNode;
			// move current node to next node
			current = current.next;

			// If smallest node has a not null next node, add it to the priority queue so
			// that it gets processed
			if (smallestNode.next != null) {
				pq.add(smallestNode.next);
			}
		}

		return answer.next;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}