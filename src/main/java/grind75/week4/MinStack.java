package grind75.week4;

import java.util.Stack;

public class MinStack {

	public final Stack<Integer> stack = new Stack<Integer>();
	public final Stack<Integer> minStack = new Stack<Integer>();

	public MinStack() {

	}

	public void push(int val) {
		stack.push(val);
		if (minStack.isEmpty() || val <= minStack.peek()) {
			minStack.push(val);
		}
	}

	public void pop() {
		if (stack.isEmpty())
			return;
		if (stack.pop().equals(minStack.peek()))
			minStack.pop();
	}

	public int top() {
		if (stack.isEmpty())
			return -1;
		return stack.peek();
	}

	public int getMin() {
		if (minStack.isEmpty())
			return -1;
		return minStack.peek();
	}

}
