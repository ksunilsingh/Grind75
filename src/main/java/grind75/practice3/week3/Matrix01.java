package grind75.practice3.week3;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
	public int[][] updateMatrix(int[][] mat) {
		int rows = mat.length;
		int cols = mat[0].length;

		Queue<int[]> queue = new LinkedList<>();
		int[][] distance = new int[rows][cols];

		for (int row = 0; row < rows; ++row) {
			for (int col = 0; col < cols; ++col) {
				if (mat[row][col] == 1) {
					distance[row][col] = Integer.MAX_VALUE;
				} else {
					distance[row][col] = 0;
					queue.add(new int[] { row, col });
				}
			}
		}

		int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		while (!queue.isEmpty()) {
			int[] cell = queue.poll();
			int row = cell[0];
			int col = cell[1];

			for (int[] direction : directions) {
				int nextRow = row + direction[0];
				int nextCol = col + direction[1];

				if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols) {
					if (distance[nextRow][nextCol] > distance[row][col] + 1) {
						distance[nextRow][nextCol] = distance[row][col] + 1;
						queue.add(new int[] { nextRow, nextCol });
					}
				}
			}
		}
		return distance;
	}

}
