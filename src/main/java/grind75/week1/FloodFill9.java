package grind75.week1;

public class FloodFill9 {

	public static void main(String[] args) {
		FloodFill9 ff = new FloodFill9();
		int[][] input = new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		ff.floodFill(input, 1, 1, 2);
	}

	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		int m = image.length;
		int n = image[0].length;

		boolean[][] isVisited = new boolean[m][n];
		return fill(image, sr, sc, color, isVisited);
	}

	private int[][] fill(int[][] image, int sr, int sc, int color, boolean[][] isVisited) {
		int m = image.length;
		int n = image[0].length;

		if (sr < 0 || sr > n - 1 || sc < 0 || sc > n - 1 || isVisited[sr][sc])
			return image;

		int currentColor = image[sr][sc];

		if (isNavigable(m, n, sr, sc)) {
			isVisited[sr][sc] = true;
			if (currentColor == image[sr][sc]) {
				image[sr][sc] = color;
			}
		}

		int[][] adjacent = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		for (int i = 0; i < adjacent.length; i++) {
			int row = sr + adjacent[i][0];
			int col = sc + adjacent[i][1];
			if (isNavigable(m, n, row, col)) {
				if (currentColor == image[row][col]) {
					fill(image, row, col, color, isVisited);
				}
			}
		}

		return image;

	}

	private boolean isNavigable(int rows, int columns, int row, int column) {
		if (row < 0 || row >= rows || column < 0 || column >= columns) {
			return false;
		}
		return true;
	}
}
