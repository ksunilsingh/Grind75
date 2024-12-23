package grind75.practice2.week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */
public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// Step 1: Create the adjacency list
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < numCourses; ++i) {
			adjList.add(new ArrayList<Integer>());
		}

		// populate the adjacency list
		// calculate the number of prerequisites for each course
		int[] indegrees = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			int course = prerequisites[i][0];
			int prereq = prerequisites[i][1];
			// add the courses for which prereq is required
			adjList.get(prereq).add(course);
			indegrees[course]++;
		}

		Queue<Integer> queue = new LinkedList<>();

		// add the courses to the queue for which there are no prereqs
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
				--indegrees[neighbor];
				if (indegrees[neighbor] == 0) {
					queue.add(neighbor);
				}
			}
		}

		return completedCourses == numCourses;
	}
}
