package grind75.practice4.week1;

import java.util.Map;
import java.util.Stack;

public class ValidParantheses {

	private Map<Character, Character> map = Map.of('(', ')', '{', '}', '[', ']');

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (map.containsKey(ch)) {
				stack.push(ch);
			} else {
				if (stack.isEmpty() || ch != map.get(stack.pop()))
					return false;
			}
		}
		return stack.isEmpty();
	}
}
