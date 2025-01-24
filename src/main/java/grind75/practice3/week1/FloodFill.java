package grind75.practice3.week1;

public class FloodFill {
	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		int rows = image.length;
		int cols = image[0].length;

		int startColor = image[sr][sc];
		if (startColor != color) {
			flood(image, sr, sc, color, rows, cols, startColor);
		}
		return image;
	}

	private void flood(int[][] image, int sr, int sc, int color, int rows, int cols, int startColor) {

		if (sr < 0 || sr >= rows || sc < 0 || sc >= cols) {
			return;
		}

		if (image[sr][sc] == startColor) {
			image[sr][sc] = color;
		} else {
			return;
		}

		flood(image, sr - 1, sc, color, rows, cols, startColor);
		flood(image, sr + 1, sc, color, rows, cols, startColor);
		flood(image, sr, sc + 1, color, rows, cols, startColor);
		flood(image, sr, sc - 1, color, rows, cols, startColor);
	}

}
