package grind75.practice1.week1;

import java.util.Stack;

public class QueueUsingStacks {

	private final Stack<Integer> inStack;
	private final Stack<Integer> outStack;

	public QueueUsingStacks() {
		inStack = new Stack<>();
		outStack = new Stack<>();
	}

	public void push(int x) {
		inStack.push(x);
	}

	public int pop() {
		transferIfNeeded();
		return outStack.pop();
	}

	public int peek() {
		transferIfNeeded();
		return outStack.peek();
	}

	public boolean empty() {
		return inStack.isEmpty() && outStack.isEmpty();
	}

	private void transferIfNeeded() {
		if (outStack.isEmpty()) {
			while (!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
		}
	}
}
