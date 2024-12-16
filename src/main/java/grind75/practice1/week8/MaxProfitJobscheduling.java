package grind75.practice1.week8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/*
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

If you choose a job that ends at time X you will be able to start another job that starts at time X.

Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job. 
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
 */
public class MaxProfitJobscheduling {

	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

		// Step 1. Create jobs array
		Job[] jobs = new Job[startTime.length];
		for (int i = 0; i < startTime.length; i++) {
			jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
		}

		// Step 2. Sort jobs by end time
		Arrays.sort(jobs, Comparator.comparingInt(job -> job.endTime));

		// Step 3. Use TreeMap for dynamic programming
		// create a map of end times and profits
		// Initialize the treeMap with 0,0 to start dynamic programming
		TreeMap<Integer, Integer> endTimeProfitMap = new TreeMap<>();
		endTimeProfitMap.put(0, 0);

		for (Job job : jobs) {
			// Step 4. Calculate the profit if including the current job
			// Use TreeMap.floorEntry(job.startTime) to get the latest job that ends just or
			// before the current job's start time
			// Add the current job profit
			int includeProfit = job.profit + endTimeProfitMap.floorEntry(job.startTime).getValue();

			// Step 5. retrieve the profit from the map if the profit from current job is
			// not included
			int excludeProfit = endTimeProfitMap.lastEntry().getValue();

			// Step 6. update the dynamic programming treemap using this job's end time as
			// key and
			// the max of include profit and exclude profit as value
			endTimeProfitMap.put(job.endTime, Math.max(includeProfit, excludeProfit));
		}

		// Step 7. Last entry in the treemap gives the max profit
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