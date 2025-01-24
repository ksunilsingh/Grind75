package grind75.practice3.week4;

import java.util.Stack;

public class MinStack {

	public Stack<Integer> stack = new Stack<>();
	public Stack<Integer> minStack = new Stack<>();

	/*
	 * initializes the stack object.
	 */
	public MinStack() {

	}

	/*
	 * pushes the element val onto the stack.
	 */
	public void push(int val) {
		stack.push(val);
		if (minStack.isEmpty() || minStack.peek() >= val) {
			minStack.push(val);
		}
	}

	/*
	 * removes the element on the top of the stack.
	 */
	public void pop() {
		if (!stack.isEmpty()) {
			int topVal = stack.pop();
			if (topVal == minStack.peek()) {
				minStack.pop();
			}
		}
	}

	/*
	 * gets the top element of the stack.
	 */
	public int top() {
		if (stack.isEmpty()) {
			return -1;
		}
		return stack.peek();
	}

	/*
	 * retrieves the minimum element in the stack.
	 */
	public int getMin() {
		if (minStack.isEmpty()) {
			return -1;
		}
		return minStack.peek();
	}

}
