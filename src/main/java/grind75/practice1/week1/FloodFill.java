package grind75.practice1.week1;

/**
 * You are given an image represented by an m x n grid of integers image, where
 * image[i][j] represents the pixel value of the image. You are also given three
 * integers sr, sc, and color. Your task is to perform a flood fill on the image
 * starting from the pixel image[sr][sc].
 * 
 * To perform a flood fill:
 * 
 * Begin with the starting pixel and change its color to color. Perform the same
 * process for each pixel that is directly adjacent (pixels that share a side
 * with the original pixel, either horizontally or vertically) and shares the
 * same color as the starting pixel. Keep repeating this process by checking
 * neighboring pixels of the updated pixels and modifying their color if it
 * matches the original color of the starting pixel. The process stops when
 * there are no more adjacent pixels of the original color to update. Return the
 * modified image after performing the flood fill.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
 * 
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 */
public class FloodFill {
	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		int m = image.length;
		int n = image[0].length;
		boolean[][] visited = new boolean[m][n];
		return fill(image, sr, sc, color, visited);
	}

	private int[][] fill(int[][] image, int sr, int sc, int color, boolean[][] visited) {
		int m = image.length;
		int n = image[0].length;

		if (sr < 0 || sr > n - 1 || sc < 0 || sc > n - 1 || visited[sr][sc])
			return image;

		int currentColor = image[sr][sc];
		visited[sr][sc] = true;
		image[sr][sc] = color;

		int[][] adjacents = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		for (int i = 0; i < adjacents.length; i++) {
			int row = sr + adjacents[i][0];
			int col = sc + adjacents[i][1];

			if (isNavigable(m, row, n, col)) {
				if (image[row][col] == currentColor) {
					fill(image, row, col, color, visited);
				}
			}
		}

		return image;
	}

	private boolean isNavigable(int rows, int row, int cols, int col) {
		if (row >= 0 && row < rows && col >= 0 && col < cols)
			return true;
		return false;
	}
}
