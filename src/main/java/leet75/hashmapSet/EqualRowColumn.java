package leet75.hashmapSet;

import java.util.Arrays;

public class EqualRowColumn {
	public int equalPairs(int[][] grid) {
		int n = grid.length;
		int count = 0;
		int[][] cols = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cols[j][i] = grid[i][j];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (Arrays.equals(grid[i], cols[j])) {
					++count;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		EqualRowColumn erc = new EqualRowColumn();
		erc.equalPairs(new int[][] { { 3, 2, 1 }, { 1, 7, 6 }, { 2, 7, 7 } });
	}
}
