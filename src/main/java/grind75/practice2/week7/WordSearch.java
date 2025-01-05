package grind75.practice2.week7;

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
		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (word.charAt(0) == board[i][j] && searchWord(board, i, j, 0, word)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean searchWord(char[][] board, int i, int j, int index, String word) {
		// If first letter of the word matches the current cell, start findWord
		if (index == word.length()) {
			return true;
		}

		// If the current index in the word doesn't match the cell, then return false
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j]) {
			return false;
		}

		char temp = board[i][j];
		board[i][j] = '*';

		// Look for next letter in the word in all the four directions
		boolean found = searchWord(board, i + 1, j, index + 1, word) || searchWord(board, i - 1, j, index + 1, word)
				|| searchWord(board, i, j + 1, index + 1, word) || searchWord(board, i, j - 1, index + 1, word);

		board[i][j] = temp;
		return found;
	}
}
