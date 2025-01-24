package grind75.practice3.week3;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		int m = intervals.length;
		List<int[]> merged = new ArrayList<>();

		int index = 0;

		while (index < m && newInterval[0] > intervals[index][1]) {
			merged.add(intervals[index]);
			++index;
		}

		while (index < m && intervals[index][0] <= newInterval[1]) {
			newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
			newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
			++index;
		}
		merged.add(newInterval);

		while (index < m) {
			merged.add(intervals[index]);
			++index;
		}
		return merged.toArray(new int[merged.size()][]);
	}
}
