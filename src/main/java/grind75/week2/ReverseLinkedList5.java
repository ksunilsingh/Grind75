package grind75.week2;

public class ReverseLinkedList5 {

	public ListNode5 reverseList(ListNode5 head) {

		ListNode5 prev = null;
		while (head != null) {
			ListNode5 next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

}

/**
 * Definition for singly-linked list.
 */
class ListNode5 {
	int val;
	ListNode5 next;

	ListNode5() {
	}

	ListNode5(int val) {
		this.val = val;
	}

	ListNode5(int val, ListNode5 next) {
		this.val = val;
		this.next = next;
	}
}
