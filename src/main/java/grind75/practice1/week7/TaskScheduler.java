package grind75.practice1.week7;

import java.util.Arrays;

/**
 * You are given an array of CPU tasks, each labeled with a letter from A to Z,
 * and a number n. Each CPU interval can be idle or allow the completion of one
 * task. Tasks can be completed in any order, but there's a constraint: there
 * has to be a gap of at least n intervals between two tasks with the same
 * label.
 * 
 * Return the minimum number of CPU intervals required to complete all tasks.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * 
 * Output: 8
 * 
 * Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A ->
 * B.
 * 
 * After completing task A, you must wait two intervals before doing A again.
 * The same applies to task B. In the 3rd interval, neither A nor B can be done,
 * so you idle. By the 4th interval, you can do A again as 2 intervals have
 * passed.
 * 
 * Example 2:
 * 
 * Input: tasks = ["A","C","A","B","D","B"], n = 1
 * 
 * Output: 6
 * 
 * Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.
 * 
 * With a cooling interval of 1, you can repeat a task after just one other
 * task.
 * 
 * Example 3:
 * 
 * Input: tasks = ["A","A","A", "B","B","B"], n = 3
 * 
 * Output: 10
 * 
 * Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle
 * -> idle -> A -> B.
 * 
 * There are only two types of tasks, A and B, which need to be separated by 3
 * intervals. This leads to idling twice between repetitions of these tasks.
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= tasks.length <= 104 tasks[i] is an uppercase English letter. 0 <= n <=
 * 100
 */
public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
		// Step 1: create the array for each type of task from A to Z
		int[] taskCount = new int[26];
		for (char ch : tasks) {
			taskCount[ch - 'A']++;
		}

		// Step 2. Sort the array
		Arrays.sort(taskCount);

		// Max number of tasks
		// Most frequent task is at the end because of sorting
		int max = taskCount[25];
		// max idle time for the most frequent task if done in sequence
		int idle = (max - 1) * n; // If the same task is done in sequence, there has to be cooling interval of n.

		// Try to fill the idle time in the most frequent with other tasks starting with
		// the 2nd most frequent task
		for (int i = 24; i >= 0 && taskCount[i] > 0 /* number of tasks for this iteration is greater than zero */
				&& idle >= 0 /*
								 * idle time is not already zero meaning that there is no need to continue if
								 * idle slots are already exhausted
								 */; i--) {
			idle -= Math.min(max - 1, taskCount[i]);
		}

		return tasks.length + Math.max(idle, 0);
	}
}
