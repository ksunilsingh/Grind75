package leet75.queue;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {

	private final Queue<Integer> queue;

	public RecentCounter() {
		queue = new LinkedList<>();
	}

	public int ping(int t) {
		queue.add(t);
		int rangeStart = t - 3000;
		while (queue.peek() < rangeStart) {
			queue.poll();
		}
		return queue.size();
	}
}