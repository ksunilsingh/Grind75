package grind75.practice2.week4;

import java.util.Stack;

public class MinStack {

	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> min = new Stack<>();

	public MinStack() {

	}

	public void push(int val) {
		if (min.isEmpty() || val <= min.peek())
			min.push(val);
		stack.push(val);
	}

	// removes the element on the top of the stack.
	public void pop() {
		if (!stack.isEmpty()) {
			int val = stack.pop();
			if (val == min.peek()) {
				min.pop();
			}
		}
	}

	// gets the top element of the stack.
	public int top() {
		if (stack.isEmpty())
			return -1;
		return stack.peek();
	}

	// retrieves the minimum element in the stack.
	public int getMin() {
		if (min.isEmpty())
			return -1;
		return min.peek();
	}

}
