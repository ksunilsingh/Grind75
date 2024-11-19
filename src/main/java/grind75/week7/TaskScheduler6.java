package grind75.week7;

import java.util.Arrays;

public class TaskScheduler6 {
	public int leastInterval(char[] tasks, int n) {
		int[] cnt = new int[26];
		for (char ch : tasks) {
			cnt[ch - 'A']++;
		}

		Arrays.sort(cnt);
		int max = cnt[25];
		int idle = (max - 1) * n;

		for (int i = 24; i >= 0 && cnt[i] >= 0 && idle >= 0; i--) {
			idle -= Math.min(max - 1, cnt[i]);
		}
		return tasks.length + Math.max(idle, 0);
	}

	public static void main(String[] args) {
		TaskScheduler6 scheduler = new TaskScheduler6();
		char[] tasks = { 'A', 'C', 'A', 'B', 'D', 'B' };
		int n = 1;
		System.out.println("Minimum intervals needed: " + scheduler.leastInterval(tasks, n));

	}

}
