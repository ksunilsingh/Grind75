package grind75.practice3.week1;

import java.util.Map;
import java.util.Stack;

public class ValidParantheses {
	private static final Map<Character, Character> bracketMap = Map.of('(', ')', '{', '}', '[', ']');

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (bracketMap.containsKey(ch)) {
				stack.push(ch);
			} else {
				if (stack.isEmpty() || ch != bracketMap.get(stack.pop())) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
