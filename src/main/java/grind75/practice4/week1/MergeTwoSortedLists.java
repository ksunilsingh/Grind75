package grind75.practice4.week1;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

		ListNode merged = new ListNode(-1);
		ListNode current = merged;
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
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
		return merged.next;
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
