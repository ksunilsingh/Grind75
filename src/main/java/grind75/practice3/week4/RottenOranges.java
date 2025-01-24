package grind75.practice3.week4;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
	public int orangesRotting(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;

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
			int currentRow = current[0];
			int currentCol = current[1];
			int minutes = current[2];
			minutesElapsed = minutes;

			int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

			for (int[] direction : directions) {
				int nextRow = currentRow + direction[0];
				int nextCol = currentCol + direction[1];

				if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && grid[nextRow][nextCol] == 1) {
					--freshOranges;
					grid[nextRow][nextCol] = 2;
					rottenQueue.add(new int[] { nextRow, nextCol, minutes + 1 });
				}
			}
		}
		return freshOranges > 0 ? -1 : minutesElapsed;
	}
}
