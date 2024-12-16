package grind75.practice1.week8;

import java.util.Stack;

/**
 * Given an array of integers heights representing the histogram's bar height
 * where the width of each bar is 1, return the area of the largest rectangle in
 * the histogram.
 */
public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] heights) {
		int n = heights.length;
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;
		for (int i = 0; i <= n; i++) {
			int currentHeight = i == n ? 0 : heights[i];
			// Process the stack as long as the height at this index is less than the height
			// at the top of the stack
			while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
				int height = heights[stack.pop()];
				// Check if the stack is empty because of the stack.pop on the previous line
				int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
				maxArea = Math.max(maxArea, height * width);
			}
			stack.push(i);
		}

		return maxArea;

	}
}
