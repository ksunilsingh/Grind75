package grind75.week3;

import java.util.ArrayList;
import java.util.List;

/*
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 

Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105
 */

public class InsertInterval1 {

	public static void main(String[] args) {
		InsertInterval1 ins = new InsertInterval1();
//		int[][] array = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
//		ins.insert(array, new int[] { 4, 8 });
//		int[][] array1 = { { 1, 3 }, { 6, 9 } };
//		ins.insert(array1, new int[] { 2, 5 });
		int[][] array2 = { { 0, 5 }, { 9, 12 } };
		ins.insert(array2, new int[] { 7, 16 });
	}

	public int[][] insert(int[][] intervals, int[] newInterval) {
		int m = intervals.length;
		List<int[]> mergedIntervals = new ArrayList<>();
		int i = 0;

		while (i < m && intervals[i][1] < newInterval[0]) {
			mergedIntervals.add(intervals[i++]);
		}

		while (i < m && intervals[i][0] <= newInterval[1]) {
			newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
			newInterval[1] = Math.max(newInterval[1], intervals[i++][1]);
		}
		mergedIntervals.add(newInterval);

		while (i < m) {
			mergedIntervals.add(intervals[i++]);
		}

		return mergedIntervals.toArray(new int[mergedIntervals.size()][]);

	}

//	public int[][] insert(int[][] intervals, int[] newInterval) {
//		int m = intervals.length;
//		List<int[]> mergedIntervals = new ArrayList<>();
//		for (int i = 0; i < m; i++) {
//			int start = intervals[i][0];
//			int end = intervals[i][1];
//			if (newInterval[0] > end || newInterval[1] < start) {
//				mergedIntervals.add(new int[] { start, end });
//			} else {
//				int mergedIntervalStart = Math.min(start, newInterval[0]);
//				while (newInterval[0] >= start && newInterval[1] >= end) {
//					++i;
//					start = intervals[i][0];
//					end = intervals[i][1];
//				}
//				--i;
//				if (start > newInterval[1])
//					mergedIntervals.add(new int[] { mergedIntervalStart, newInterval[1] });
//				else {
//					int mergedIntervalEnd = Math.max(end, newInterval[1]);
//					mergedIntervals.add(new int[] { mergedIntervalStart, mergedIntervalEnd });
//				}
//			}
//		}
//		int[][] mergedIntervalsArr = new int[mergedIntervals.size()][2];
//		int index = 0;
//		for (int[] mergedInterval : mergedIntervals) {
//			mergedIntervalsArr[index][0] = mergedInterval[0];
//			mergedIntervalsArr[index++][1] = mergedInterval[1];
//		}
//
//		return mergedIntervalsArr;
//
//	}
}
