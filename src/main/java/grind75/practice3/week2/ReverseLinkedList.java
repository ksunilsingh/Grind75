package grind75.practice3.week2;

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