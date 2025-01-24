package leet75.intervals;

import java.util.Arrays;

public class NonOverlappingIntervals {

	public int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

		int count = 1;
		int previous = 0;
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] >= intervals[previous][1]) {
				++count;
				previous = i;
			}
		}
		return intervals.length - count;
	}
}
