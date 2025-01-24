package grind75.practice3.week1;

import java.util.Stack;

public class MyQueue {

	private Stack<Integer> inStack = new Stack<>();
	private Stack<Integer> outStack = new Stack<>();

	// Pushes element x to the back of the queue.
	public void push(int x) {
		inStack.push(x);
	}

	// Removes the element from the front of the queue and returns it.
	public int pop() {
		transferIfneeded();
		return outStack.pop();
	}

	// Returns the element at the front of the queue.
	public int peek() {
		transferIfneeded();
		return outStack.peek();
	}

	// Returns true if the queue is empty, false otherwise.
	public boolean empty() {
		return inStack.isEmpty() && outStack.isEmpty();
	}

	private void transferIfneeded() {
		if (outStack.isEmpty()) {
			while (!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
		}
	}

}
