package grind75.week8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class MaximumProfitJobScheduler {
	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

		int n = startTime.length;
		Job[] jobs = new Job[n];
		for (int i = 0; i < n; i++) {
			jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
		}
		Arrays.sort(jobs, Comparator.comparingInt(job -> job.endTime));

		TreeMap<Integer, Integer> endTimeProfitMap = new TreeMap<>();
		endTimeProfitMap.put(0, 0);

		for (Job job : jobs) {
			int includeProfit = job.profit + endTimeProfitMap.floorEntry(job.startTime).getValue();
			int excludeProfit = endTimeProfitMap.lastEntry().getValue();
			endTimeProfitMap.put(job.endTime, Math.max(excludeProfit, includeProfit));
		}
		return endTimeProfitMap.lastEntry().getValue();
	}
}

class Job {
	int startTime;
	int endTime;
	int profit;

	public Job(int startTime, int endTime, int profit) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.profit = profit;
	}
}