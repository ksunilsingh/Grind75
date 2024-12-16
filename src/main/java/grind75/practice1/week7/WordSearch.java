package grind75.practice1.week7;

/*
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.

 */
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		// Setup
		int rows = board.length;
		int cols = board[0].length;

		// Traverse cells
		for (int row = 0; row < rows; ++row) {
			for (int col = 0; col < cols; ++col) {
				// If first letter of the word matches the current cell, start findWord
				if (board[row][col] == word.charAt(0) && searchWord(board, row, col, 0, word)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean searchWord(char[][] board, int row, int col, int index, String word) {
		// Index represents the index in the word. If Index has reached word length,
		// it means we have a match
		if (index == word.length()) {
			return true;
		}

		// If the current index in the word doesn't match the cell, then return false
		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
				|| word.charAt(index) != board[row][col]) {
			return false;
		}

		// Mark current cell as *
		char temp = board[row][col];
		board[row][col] = '*';

		// Look for next letter in the word in all the four directions
		boolean found = searchWord(board, row + 1, col, index + 1, word)
				|| searchWord(board, row, col + 1, index + 1, word) || searchWord(board, row - 1, col, index + 1, word)
				|| searchWord(board, row, col - 1, index + 1, word);

		board[row][col] = temp;
		return found;
	}
}
