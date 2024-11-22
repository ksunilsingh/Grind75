package grind75.week8;

import java.util.PriorityQueue;

public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;

		PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
		for (ListNode listNode : lists) {
			if (listNode != null) {
				pq.add(listNode);
			}
		}

		ListNode answer = new ListNode(0);
		ListNode current = answer;

		while (!pq.isEmpty()) {
			ListNode smallestNode = pq.poll();
			current.next = smallestNode;
			current = current.next;

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
