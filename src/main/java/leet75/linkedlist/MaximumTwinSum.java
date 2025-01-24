package leet75.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class MaximumTwinSum {

	public int pairSum(ListNode head) {
		List<Integer> list = new ArrayList<>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}

		int maxSum = Integer.MIN_VALUE;
		int n = list.size();
		for (int i = 0; i < n / 2; i++) {
			int sum = list.get(i) + list.get(n - i - 1);
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}
}
