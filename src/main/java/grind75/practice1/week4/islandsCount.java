package grind75.practice1.week4;

/*
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 */
public class islandsCount {

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;

		int islandCount = 0;
		int rows = grid.length;
		int cols = grid[0].length;

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (grid[row][col] == '1') {
					++islandCount;
					dfs(grid, row, col);
				}
			}
		}
		return islandCount;
	}

	private void dfs(char[][] grid, int row, int col) {
		int rows = grid.length;
		int cols = grid[0].length;

		if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0')
			return;

		grid[row][col] = '0';

		dfs(grid, row - 1, col);
		dfs(grid, row + 1, col);
		dfs(grid, row, col - 1);
		dfs(grid, row, col + 1);
	}
}
