package grind75.practice2.week3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for
 * each cell.
 */
public class NearestZeroMatrix {
	public int[][] updateMatrix(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;

		int[][] distances = new int[m][n];

		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 1) {
					distances[i][j] = Integer.MAX_VALUE;
				} else {
					distances[i][j] = 0;
					queue.add(new int[] { i, j });
				}
			}
		}

		int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
		while (!queue.isEmpty()) {
			int[] currentCell = queue.poll();
			int row = currentCell[0];
			int col = currentCell[1];

			for (int[] direction : directions) {
				int nextRow = row + direction[0];
				int nextCol = col + direction[1];
				if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n) {
					if (distances[nextRow][nextCol] > distances[row][col] + 1) {
						distances[nextRow][nextCol] = distances[row][col] + 1;
						queue.add(new int[] { nextRow, nextCol });
					}
				}
			}
		}

		return distances;
	}
}