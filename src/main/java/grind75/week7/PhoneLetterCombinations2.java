package grind75.week7;

import java.util.ArrayList;
import java.util.List;

public class PhoneLetterCombinations2 {

	private static final String[] KEYPAD = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		List<String> results = new ArrayList<String>();

		if (digits == null || digits.length() == 0)
			return results;

		backtrack(digits, results, 0, new StringBuilder());

		return results;
	}

	private void backtrack(String digits, List<String> results, int index, StringBuilder current) {
		if (index == digits.length()) {
			results.add(current.toString());
			return;
		}
		char digit = digits.charAt(index);
		String letters = KEYPAD[digit - '0'];

		for (char letter : letters.toCharArray()) {
			current.append(letter);
			backtrack(digits, results, index + 1, current);
			current.deleteCharAt(current.length() - 1);
		}
	}
}
