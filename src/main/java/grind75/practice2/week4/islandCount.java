package grind75.practice2.week4;

/*
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class islandCount {

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;

		int m = grid.length;
		int n = grid[0].length;
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					++count;
					countIsland(grid, i, j);
				}
			}
		}
		return count;
	}

	private void countIsland(char[][] grid, int i, int j) {

		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
			return;
		}

		grid[i][j] = '0';

		int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		for (int[] direction : directions) {
			int newRow = i + direction[0];
			int newCol = j + direction[1];
			countIsland(grid, newRow, newCol);
		}
	}
}
