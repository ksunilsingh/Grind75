package grind75.week3;

import java.util.LinkedList;
import java.util.Queue;

public class NearestMatrixZeroDistance2 {

	public int[][] updateMatrix(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		int[][] nearestDist = new int[m][n];

		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0) {
					queue.add(new int[] { i, j });
					nearestDist[i][j] = 0;
				} else {
					nearestDist[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		while (!queue.isEmpty()) {
			int[] currentCell = queue.poll();
			int row = currentCell[0];
			int col = currentCell[1];

			for (int[] dir : directions) {
				int newRow = dir[0] + row;
				int newCol = dir[1] + col;
				if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n) {
					if (nearestDist[newRow][newCol] > nearestDist[row][col] + 1) {
						nearestDist[newRow][newCol] = nearestDist[row][col] + 1;
						queue.add(new int[] { newRow, newCol });
					}
				}
			}

		}

		return nearestDist;
	}
}
