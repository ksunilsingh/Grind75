package grind75.week4;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

	public int orangesRotting(int[][] grid) {

		int rows = grid.length;
		int cols = grid[0].length;

		Queue<int[]> queue = new LinkedList<>();
		int freshCount = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 2) {
					queue.offer(new int[] { i, j, 0 });
				} else if (grid[i][j] == 1) {
					freshCount++;
				}
			}
		}

		int minutesElapsed = 0;
		int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int i = current[0], j = current[1], minutes = current[2];
			minutesElapsed = minutes;

			for (int[] direction : directions) {
				int ni = i + direction[0];
				int nj = j + direction[1];

				if (ni >= 0 && ni < rows && nj >= 0 && nj < cols && grid[ni][nj] == 1) {
					grid[ni][nj] = 2;
					--freshCount;
					queue.add(new int[] { ni, nj, minutes + 1 });
				}
			}
		}

		return freshCount > 0 ? -1 : minutesElapsed;
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 1 } };
		RottingOranges ro = new RottingOranges();
		ro.orangesRotting(grid);
	}
}
