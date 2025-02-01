package grind75.practice4.week1;

public class FloodFill {
	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		int rows = image.length;
		int cols = image[0].length;

		int startColor = image[sr][sc];
		if (startColor != color) {
			fill(image, sr, sc, rows, cols, color, startColor);
		}
		return image;
	}

	private void fill(int[][] image, int sr, int sc, int rows, int cols, int color, int startColor) {

		if (sr < 0 || sr >= rows || sc < 0 || sc >= cols) {
			return;
		}

		if (image[sr][sc] == startColor) {
			image[sr][sc] = color;
		} else {
			return;
		}

		fill(image, sr + 1, sc, rows, cols, color, startColor);
		fill(image, sr - 1, sc, rows, cols, color, startColor);
		fill(image, sr, sc + 1, rows, cols, color, startColor);
		fill(image, sr, sc - 1, rows, cols, color, startColor);
	}
}
