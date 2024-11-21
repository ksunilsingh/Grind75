package grind75.week8;

import java.util.Stack;

public class LargestRectangleInHistogam {
	public int largestRectangleArea(int[] heights) {

		int n = heights.length;

		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;
		for (int i = 0; i <= n; i++) {
			int currentHeight = i == n ? 0 : heights[i];

			while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
				int height = heights[stack.pop()];
				int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
				maxArea = Math.max(maxArea, width * height);
			}

			stack.push(i);
		}

		return maxArea;

	}
}
