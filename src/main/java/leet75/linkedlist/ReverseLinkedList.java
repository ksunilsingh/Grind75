package leet75.linkedlist;

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		ListNode previous = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = previous;
			previous = head;
			head = next;
		}
		return previous;
	}
}
