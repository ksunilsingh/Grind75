package grind75.practice1.week4;

import java.util.Stack;

/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.
 */
public class MinStack {

	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();

	public MinStack() {

	}

	public void push(Integer val) {
		stack.push(val);
		if (!minStack.isEmpty()) {
			if (val <= minStack.peek()) {
				minStack.push(val);
			}
		} else {
			minStack.push(val);
		}
	}

	public void pop() {
		if (stack.isEmpty())
			return;
		if (stack.pop().equals(minStack.peek())) {
			minStack.pop();
		}

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
