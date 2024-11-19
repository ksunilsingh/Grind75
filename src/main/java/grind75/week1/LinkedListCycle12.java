package grind75.week1;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle12 {
	public boolean hasCycle(ListNode12 head) {
		Set<ListNode12> set = new HashSet<ListNode12>();
		while (head != null) {
			if (set.contains(head))
				return true;
			set.add(head);
			head = head.next;
		}
		return false;
	}
}

class ListNode12 {
	int val;
	ListNode12 next;

	ListNode12(int x) {
		val = x;
		next = null;
	}
}