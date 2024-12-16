package grind75.practice1.week4;

import java.util.LinkedList;
import java.util.Queue;

/*
 * You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 */
public class RottingOranges {
	public int orangesRotting(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;

		Queue<int[]> queue = new LinkedList<>();
		int freshCount = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (grid[row][col] == 2) {
					queue.add(new int[] { row, col, 0 });
				} else if (grid[row][col] == 1) {
					++freshCount;
				}
			}
		}
		int minutesElapsed = 0;
		int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentRow = current[0], currentCol = current[1], minutes = current[2];
			minutesElapsed = minutes;
			for (int[] direction : directions) {
				int nextRow = currentRow + direction[0];
				int nextCol = currentCol + direction[1];

				if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && grid[nextRow][nextCol] == 1) {
					grid[nextRow][nextCol] = 2;
					--freshCount;
					queue.add(new int[] { nextRow, nextCol, minutes + 1 });
				}
			}
		}

		return freshCount > 0 ? -1 : minutesElapsed;
	}
}
