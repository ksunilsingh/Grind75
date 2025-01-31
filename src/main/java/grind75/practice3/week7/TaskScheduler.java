package grind75.practice3.week7;

import java.util.Arrays;

public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
		int[] taskCount = new int[26];
		for (char ch : tasks) {
			taskCount[ch - 'A']++;
		}
		Arrays.sort(taskCount);
		int maxTask = taskCount[25];
		int idle = (maxTask - 1) * n;

		for (int i = 24; i >= 0 && taskCount[i] > 0 && idle >= 0; i--) {
			idle -= Math.min(maxTask - 1, taskCount[i]);
		}
		return tasks.length + Math.max(0, idle);
	}
}
