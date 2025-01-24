package grind75.practice3.week4;

public class NumberOfIslands {

	public int numIslands(char[][] grid) {

		if (grid == null || grid.length == 0) {
			return 0;
		}

		int rows = grid.length;
		int cols = grid[0].length;

		int islandCount = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (grid[row][col] == '1') {
					++islandCount;
					countIslands(grid, row, col, rows, cols);
				}
			}
		}
		return islandCount;

	}

	private void countIslands(char[][] grid, int row, int col, int rows, int cols) {

		if (row >= rows || row < 0 || col >= cols || col < 0 || grid[row][col] == '0') {
			return;
		}

		grid[row][col] = '0';

		countIslands(grid, row - 1, col, rows, cols);
		countIslands(grid, row + 1, col, rows, cols);
		countIslands(grid, row, col - 1, rows, cols);
		countIslands(grid, row, col + 1, rows, cols);
	}
}
