package grind75.practice1.week7;

import java.util.ArrayList;
import java.util.List;

/*Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
*/
public class LetterCombinationPhoneNumber {

	private static final String[] KEYPAD = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		List<String> answer = new ArrayList<>();
		if (digits == null || digits.length() == 0) {
			return answer;
		}

		backTrack(digits, 0, answer, new StringBuilder());
		return answer;
	}

	private void backTrack(String digits, int index, List<String> answer, StringBuilder current) {
		if (index == digits.length()) {
			answer.add(current.toString());
			return;
		}

		String letters = KEYPAD[digits.charAt(index) - '0'];

		for (char ch : letters.toCharArray()) {
			current.append(ch);
			backTrack(digits, index + 1, answer, current);
			current.deleteCharAt(current.length() - 1);
		}
	}

}
