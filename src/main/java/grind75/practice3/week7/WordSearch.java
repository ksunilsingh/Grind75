package grind75.practice3.week7;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (word.charAt(0) == board[i][j] && search(board, i, j, 0, word)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean search(char[][] board, int i, int j, int index, String word) {
		if (index == word.length())
			return true;

		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j]) {
			return false;
		}

		char temp = board[i][j];
		board[i][j] = '*';

		boolean found = search(board, i + 1, j, index + 1, word) || search(board, i - 1, j, index + 1, word)
				|| search(board, i, j - 1, index + 1, word) || search(board, i, j + 1, index + 1, word);

		board[i][j] = temp;
		return found;
	}
}
