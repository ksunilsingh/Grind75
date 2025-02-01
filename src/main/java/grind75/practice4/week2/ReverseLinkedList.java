package grind75.practice4.week2;

/*Given the head of a singly linked list, reverse the list, and return the reversed list.*/

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

	// Method to print the linked list
	private void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println("null");
	}

	public static void main(String[] args) {
		// Create example linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ReverseLinkedList rll = new ReverseLinkedList();
		// Print original linked list
		System.out.println("Original Linked List:");
		rll.printList(head);

		// Reverse the linked list

		ListNode reversedHead = rll.reverseList(head);

		// Print reversed linked list
		System.out.println("Reversed Linked List:");
		rll.printList(reversedHead);
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