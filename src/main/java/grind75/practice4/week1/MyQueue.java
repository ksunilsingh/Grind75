package grind75.practice4.week1;

import java.util.Stack;

public class MyQueue {

	private Stack<Integer> inStack = new Stack<>();
	private Stack<Integer> outStack = new Stack<>();

	/**
	 * Pushes element x to the back of the queue.
	 * 
	 * @return
	 */
	public void push(int x) {
		inStack.push(x);
	}

	/*
	 * Removes the element from the front of the queue and returns it.
	 */
	public int pop() {
		transferIfNeeded();
		return outStack.pop();
	}

	/**
	 * Returns the element at the front of the queue.
	 * 
	 * @return
	 */
	public int peek() {
		transferIfNeeded();
		return outStack.peek();
	}

	/**
	 * Returns true if the queue is empty, false otherwise.
	 * 
	 * @return
	 */
	public boolean empty() {
		transferIfNeeded();
		return outStack.isEmpty();
	}

	private void transferIfNeeded() {
		if (outStack.isEmpty()) {
			while (!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
		}
	}
}
