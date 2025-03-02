package grind75.practice1.week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

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
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
 */
public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {

		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			adjList.add(new ArrayList<>());
		}

		int[] indegrees = new int[numCourses];

		for (int[] prerequisite : prerequisites) {
			int course = prerequisite[0];
			int prereq = prerequisite[1];
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
