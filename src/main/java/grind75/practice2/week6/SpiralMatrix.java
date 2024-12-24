package grind75.practice2.week6;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		int top = 0, bottom = m - 1, left = 0, right = n - 1;

		List<Integer> result = new ArrayList<>();

		while (left <= right && top <= bottom) {
			for (int i = left; i <= right; i++) {
				result.add(matrix[top][i]);
			}
			++top;
			for (int i = top; i <= bottom; i++) {
				result.add(matrix[i][right]);
			}
			--right;
			if (top <= bottom) {
				for (int i = right; i >= left; i--) {
					result.add(matrix[bottom][i]);
				}
				--bottom;
			}
			if (left <= right) {
				for (int i = bottom; i >= top; i--) {
					result.add(matrix[i][left]);
				}
				++left;
			}
		}
		return result;
	}
}