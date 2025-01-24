package leet75.priorityq;

import java.util.PriorityQueue;

public class TotalCostToHireKWorkers {

	public long totalCost(int[] costs, int k, int candidates) {
		PriorityQueue<Integer> pqBegin = new PriorityQueue<>();
		PriorityQueue<Integer> pqEnd = new PriorityQueue<>();
		int left = 0, right = costs.length - 1;
		long totalCost = 0;
		for (int i = 0; i < k; i++) {
			// No of k candidates from beginning
			while (pqBegin.size() < candidates && left <= right) {
				pqBegin.add(costs[left++]);
			}
			// No of k candidates from end
			while (pqEnd.size() < candidates && left <= right) {
				pqEnd.add(costs[right--]);
			}

			int beginCost = pqBegin.size() > 0 ? pqBegin.peek() : Integer.MAX_VALUE;
			int endCost = pqEnd.size() > 0 ? pqEnd.peek() : Integer.MAX_VALUE;

			if (beginCost <= endCost) {
				totalCost += beginCost;
				pqBegin.poll();
			} else {
				totalCost += endCost;
				pqEnd.poll();
			}
		}
		return totalCost;
	}

}
