package leet75.stack;

import java.util.Stack;

public class AsteroidCollision {
	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();

		for (int asteroid : asteroids) {
			if (asteroid > 0) {
				stack.push(asteroid);
			} else {
				while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
					stack.pop();
				}

				if (stack.isEmpty() || stack.peek() < 0) {
					stack.push(asteroid);
				}

				if (stack.peek() == -asteroid) {
					stack.pop();
				}
			}
		}

		int[] answer = new int[stack.size()];
		int i = stack.size() - 1;

		while (!stack.isEmpty()) {
			answer[i--] = stack.pop();
		}
		return answer;

	}
}
