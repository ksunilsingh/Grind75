package grind75.practice2.week4;

import java.util.LinkedList;
import java.util.Queue;

/*
 * You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 
 */
public class RottingOranges {

	public int orangesRotting(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;

		// Add initial rotten oranges to a queue
		// each item in the queue will have row, col, and minutes
		// Count fresh oranges
		int freshOranges = 0;
		Queue<int[]> rottenQueue = new LinkedList<>();
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (grid[row][col] == 2) {
					rottenQueue.add(new int[] { row, col, 0 });
				} else if (grid[row][col] == 1) {
					++freshOranges;
				}
			}
		}

		int minutesElapsed = 0;
		while (!rottenQueue.isEmpty()) {
			int[] current = rottenQueue.poll();
			int curRow = current[0], curCol = current[1], minutes = current[2];
			minutesElapsed = minutes;

			int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

			for (int[] direction : directions) {
				int nextRow = curRow + direction[0];
				int nextCol = curCol + direction[1];

				/*
				 * if there is fresh orange at the next cell to this rotten orange
				 */
				if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && grid[nextRow][nextCol] == 1) {
					// reduce the fersh count by 1
					--freshOranges;
					// mark the next cell as rotten
					grid[nextRow][nextCol] = 2;
					// add this rotten cell to the rottenOrange queue for processing in the next
					// minute
					rottenQueue.add(new int[] { nextRow, nextCol, minutes + 1 });
				}
			}
		}
		return freshOranges > 0 ? -1 : minutesElapsed;
	}
}
