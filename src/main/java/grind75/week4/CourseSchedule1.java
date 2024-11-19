package grind75.week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule1 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// Create an adjacency list the courses
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			adjList.add(new ArrayList<>());
		}

		// Create an array to maintain in-degrees of each course
		// This is to track the prerequisites for each couse
		int[] indegrees = new int[numCourses];

		// Fill the adjacency list using prerequisities
		// update the indegrees
		for (int[] prereq : prerequisites) {
			int course = prereq[0];
			int prerequisite = prereq[1];
			adjList.get(prerequisite).add(course);
			indegrees[course]++;
		}

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < numCourses; ++i) {
			if (indegrees[i] == 0) {
				queue.add(i);
			}
		}

		int completedCourses = 0;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			++completedCourses;

			for (int neighbor : adjList.get(current)) {
				if (--indegrees[neighbor] == 0) {
					queue.add(neighbor);
				}
			}
		}

		return numCourses == completedCourses;
	}
}
