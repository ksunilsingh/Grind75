package grind75.practice3.week8;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

	PriorityQueue<Integer> lpq;
	PriorityQueue<Integer> rpq;

	/**
	 * initializes the MedianFinder object.
	 * 
	 * @return
	 */
	public MedianFinder() {
		lpq = new PriorityQueue<Integer>(Collections.reverseOrder());
		rpq = new PriorityQueue<Integer>();
	}

	/**
	 * adds the integer num from the data stream to the data structure.
	 * 
	 * @param num
	 */
	public void addNum(int num) {

		if (lpq.isEmpty() || num <= lpq.peek()) {
			lpq.offer(num);
		} else {
			rpq.offer(num);
		}

		if (lpq.size() > rpq.size() + 1) {
			rpq.offer(lpq.poll());
		} else if (rpq.size() > lpq.size()) {
			lpq.offer(rpq.poll());
		}

	}

	/*
	 * * returns the median of all elements so far. Answers within 10-5 of the
	 * actual answer will be accepted.
	 */
	public double findMedian() {
		if (lpq.size() == rpq.size()) {
			return (double) (lpq.peek() + rpq.peek()) / 2;
		} else {
			return lpq.peek();
		}
	}
}
