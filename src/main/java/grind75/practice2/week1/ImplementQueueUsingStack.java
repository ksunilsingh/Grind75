package grind75.practice2.week1;

import java.util.Stack;

public class ImplementQueueUsingStack {

	private final Stack<Integer> inStack;
	private final Stack<Integer> outStack;

	public ImplementQueueUsingStack() {
		inStack = new Stack<>();
		outStack = new Stack<>();
	}

	// Pushes element x to the back of the queue.
	public void push(int x) {
		inStack.push(x);
	}

	// Removes the element from the front of the queue and returns it.
	public int pop() {
		transferIfNeeded();
		return outStack.pop();
	}

	// Returns the element at the front of the queue.
	public int peek() {
		transferIfNeeded();
		return outStack.peek();
	}

	// Returns true if the queue is empty, false otherwise.
	boolean empty() {
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
