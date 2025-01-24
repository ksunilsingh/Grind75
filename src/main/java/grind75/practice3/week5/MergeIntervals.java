package grind75.practice3.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, ((a, b) -> Integer.compare(a[0], b[0])));
		List<int[]> merged = new ArrayList<>();
		int n = intervals.length;
		int[] prevInterval = intervals[0];
		for (int i = 1; i < n; i++) {
			int[] currentInterval = intervals[i];
			if (currentInterval[0] > prevInterval[1]) {
				merged.add(prevInterval);
				prevInterval = currentInterval;
			} else {
				prevInterval[1] = Math.max(prevInterval[1], currentInterval[1]);
			}
		}
		merged.add(prevInterval);
		return merged.toArray(new int[merged.size()][]);
	}
}