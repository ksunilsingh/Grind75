package grind75.practice1.week3;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

 

Example 1:


Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
 */
public class NearestZeroMatrix {
	public int[][] updateMatrix(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;

		int[][] nearestDist = new int[m][n];
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0) {
					nearestDist[i][j] = 0;
					queue.add(new int[] { i, j });
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

			for (int[] direction : directions) {
				int newRow = row + direction[0];
				int newCol = col + direction[1];
				if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
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