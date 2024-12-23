package grind75.practice2.week1;

/*
 * You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
 */
public class MergeSortedLists {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

		// Dummy node
		ListNode dummy = new ListNode(-1);
		ListNode current = dummy;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				current.next = list1;
				list1 = list1.next;
			} else {
				current.next = list2;
				list2 = list2.next;
			}
			current = current.next;
		}

		if (list1 != null) {
			current.next = list1;
		}

		if (list2 != null) {
			current.next = list2;
		}

		return dummy.next;
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