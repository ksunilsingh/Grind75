package grind75.practice3.week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> adjList = new ArrayList<>();

		for (int i = 0; i < numCourses; i++) {
			adjList.add(new ArrayList<>());
		}

		int[] indegrees = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			int course = prerequisites[i][0];
			int prereq = prerequisites[i][1];
			adjList.get(prereq).add(course);
			indegrees[course]++;
		}

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < numCourses; i++) {
			if (indegrees[i] == 0) {
				queue.add(i);
			}
		}

		int completedCourses = 0;
		while (!queue.isEmpty()) {
			int current = queue.poll();
			++completedCourses;
			for (int neighbour : adjList.get(current)) {
				--indegrees[neighbour];
				if (indegrees[neighbour] == 0) {
					queue.add(neighbour);
				}
			}
		}

		return completedCourses == numCourses;
	}
}
