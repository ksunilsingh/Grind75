package grind75.practice4.week1;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

	/**
	 * Floyd’s Cycle Detection Algorithm
	 * 
	 * @param head
	 * @return
	 */
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}

		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			if (slow == fast)
				return true;
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}

	public boolean hasCycleNonOptimal(ListNode head) {
		Set<ListNode> nodes = new HashSet<>();
		while (head != null) {
			if (nodes.contains(head))
				return true;
			nodes.add(head);
			head = head.next;
		}
		return false;
	}
}
