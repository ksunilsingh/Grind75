package leet75.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class DeleteMiddleNode {
	public ListNode deleteMiddle(ListNode head) {

		Map<Integer, ListNode> map = new HashMap<>();

		ListNode current = head;
		int index = 0;
		while (current != null) {
			map.put(index++, current);
			current = current.next;
		}

		ListNode previousNode = map.get((map.size() / 2) - 1);
		ListNode nextNode = map.get((map.size() / 2) + 1);
		previousNode.next = nextNode;
		return head;

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