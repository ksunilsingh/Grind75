package grind75.practice3.week7;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationPhoneNo {

	private String[] KEYPAD = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		List<String> answer = new ArrayList<>();
		if (digits == null || digits.length() == 0) {
			return answer;
		}
		backtrack(digits, 0, answer, new StringBuilder());
		return answer;
	}

	private void backtrack(String digits, int index, List<String> answer, StringBuilder current) {
		if (index == digits.length()) {
			answer.add(current.toString());
			return;
		}

		String letters = KEYPAD[digits.charAt(index) - '0'];

		for (char ch : letters.toCharArray()) {
			current.append(ch);
			backtrack(digits, index + 1, answer, current);
			current.deleteCharAt(current.length() - 1);
		}
	}
}
