package grind75.practice1.week8;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 

Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
 

Constraints:

-105 <= num <= 105
There will be at least one element in the data structure before calling findMedian.
At most 5 * 104 calls will be made to addNum and findMedian.
 */
public class MedianFinder {

	private final PriorityQueue<Integer> lpq;
	private final PriorityQueue<Integer> rpq;

	public MedianFinder() {
		// Priority queue which is a max heap.
		// So insert(5), insert(1), insert(10) will result in 10, 5, 1 if polled 3 times
		// max value comes out first, followed by 2nd max....
		lpq = new PriorityQueue<>(Collections.reverseOrder());
		// Priority queue which is a min heap.
		// So insert(5), insert(1), insert(10) will result in 1, 5, 10 if polled 3 times
		// min value comes out first, followed by 2nd min....
		rpq = new PriorityQueue<>();
	}

	public void addNum(int num) {

		// if the number is smaller than or equal to the last value in lpq, then add it
		// to lpq
		// Also add to lpq if lpq is empty
		if (lpq.isEmpty() || num <= lpq.peek()) {
			lpq.add(num);
		} else {
			rpq.add(num);
		}

		// Balance the lpq and rpq
		// if lpq size is greater than rpq size + 1, the get the max element in lpq and
		// add it to rpq
		if (lpq.size() > rpq.size() + 1) {
			rpq.add(lpq.poll());
		} else if (rpq.size() > lpq.size()) {
			lpq.add(rpq.poll());
		}

	}

	public double findMedian() {
		// if the two priority queues are the same length, means there are even number
		// of elements
		// so the median will be the average of max value in lpq, and min value in rpq.
		if (lpq.size() == rpq.size()) {
			return (double) (lpq.peek() + rpq.peek()) / 2;
		} else {
			return lpq.peek();
		}
	}

	public static void main(String[] args) {
		MedianFinder medianFinder = new MedianFinder();
		medianFinder.addNum(1); // arr = [1]
		medianFinder.addNum(2); // arr = [1, 2]
		medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
		medianFinder.addNum(3); // arr[1, 2, 3]
		medianFinder.findMedian(); // return 2.0
	}
}
