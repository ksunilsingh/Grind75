package grind75.practice1.week2;

import java.util.ArrayList;
import java.util.List;

public class LinkedListMiddle {
	public ListNode middleNode(ListNode head) {
		List<ListNode> list = new ArrayList<>();

		while (head != null) {
			list.add(head);
			head = head.next;
		}
		return list.get(list.size() / 2);
	}
}
