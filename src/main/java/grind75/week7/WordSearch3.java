package grind75.week7;

/*
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */
public class WordSearch3 {
	public boolean exist(char[][] board, String word) {
		int rows = board.length;
		int cols = board[0].length;

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (board[row][col] == word.charAt(0) && searchWord(board, word, row, col, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean searchWord(char[][] board, String word, int row, int col, int index) {
		if (index == word.length())
			return true;

		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
				|| board[row][col] != word.charAt(index))
			return false;

		char temp = board[row][col];
		board[row][col] = '*';

		boolean found = searchWord(board, word, row + 1, col, index + 1)
				|| searchWord(board, word, row - 1, col, index + 1) || searchWord(board, word, row, col + 1, index + 1)
				|| searchWord(board, word, row, col - 1, index + 1);

		board[row][col] = temp;
		return found;
	}

}
