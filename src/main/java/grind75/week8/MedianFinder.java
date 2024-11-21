package grind75.week8;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

	private final PriorityQueue<Integer> lpq;
	private final PriorityQueue<Integer> rpq;

	public MedianFinder() {
		lpq = new PriorityQueue<>(Collections.reverseOrder());
		rpq = new PriorityQueue<Integer>();
	}

	public void addNum(int num) {
		if (lpq.isEmpty() || num <= lpq.peek()) {
			lpq.add(num);
		} else {
			rpq.add(num);
		}

		if (lpq.size() > rpq.size() + 1) {
			rpq.add(lpq.poll());
		} else if (rpq.size() > lpq.size()) {
			lpq.add(rpq.poll());
		}
	}

	public double findMedian() {

		if (lpq.size() == rpq.size()) {
			return (double) (lpq.peek() + rpq.peek()) / 2.0;
		} else {
			return lpq.peek();
		}

	}
}
