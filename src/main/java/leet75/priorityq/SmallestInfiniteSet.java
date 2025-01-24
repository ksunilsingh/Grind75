package leet75.priorityq;

import java.util.PriorityQueue;

public class SmallestInfiniteSet {

	PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
	int minNum = 1;

	public SmallestInfiniteSet() {

	}

	public int popSmallest() {
		if (!pq.isEmpty())
			return pq.poll();
		return minNum++;
	}

	public void addBack(int num) {
		if (minNum > num && !pq.contains(num)) {
			pq.add(num);
		}
	}
}
