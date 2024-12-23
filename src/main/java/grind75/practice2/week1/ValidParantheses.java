package grind75.practice2.week1;

import java.util.Map;
import java.util.Stack;

/*
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */
public class ValidParantheses {
	private Map<Character, Character> bracketMap = Map.of('{', '}', '[', ']', '(', ')');

	public boolean isValid(String s) {
		Stack<Character> chars = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (ch == '{' || ch == '[' || ch == '(') {
				chars.push(ch);
			} else {
				if (chars.isEmpty() || ch != bracketMap.get(chars.pop())) {
					return false;
				}
			}
		}
		return chars.isEmpty();
	}
}
