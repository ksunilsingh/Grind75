package grind75.week2;

import java.util.ArrayList;
import java.util.List;

public class LinkedListMiddle9 {
	public ListNode9 middleNode(ListNode9 head) {
		List<ListNode9> list = new ArrayList<>();
		while (head != null) {
			list.add(head);
			head = head.next;
		}
		return list.get(list.size() / 2);
	}
}

/**
 * Definition for singly-linked list.
 */
class ListNode9 {
	int val;
	ListNode9 next;

	ListNode9() {
	}

	ListNode9(int val) {
		this.val = val;
	}

	ListNode9(int val, ListNode9 next) {
		this.val = val;
		this.next = next;
	}
}
