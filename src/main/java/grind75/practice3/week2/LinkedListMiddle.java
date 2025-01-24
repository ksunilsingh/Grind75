package grind75.practice3.week2;

import java.util.HashMap;
import java.util.Map;

public class LinkedListMiddle {
	public ListNode middleNode(ListNode head) {
		Map<Integer, ListNode> map = new HashMap<>();
		int index = 0;
		while (head != null) {
			map.put(index++, head);
			head = head.next;
		}
		return map.get(index / 2);
	}
}
