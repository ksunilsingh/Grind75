package leet75.stack;

import java.util.Stack;

public class RemoveStart {
	public String removeStars(String s) {
		Stack<Character> s1 = new Stack<>();

		for (char ch : s.toCharArray()) {
			if (ch != '*') {
				s1.push(ch);
			} else {
				if (!s1.isEmpty())
					s1.pop();
			}
		}
		StringBuilder answer = new StringBuilder();
		while (!s1.isEmpty()) {
			answer.insert(0, s1.pop());
		}

		return answer.toString();

	}
}
