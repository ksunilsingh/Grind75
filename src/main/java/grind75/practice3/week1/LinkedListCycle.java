package grind75.practice3.week1;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
		Set<ListNode> set = new HashSet<ListNode>();
		while (head != null) {
			if (set.contains(head))
				return true;
			set.add(head);
			head = head.next;
		}
		return false;
	}
}
