package leet75.TwoPointers;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int left = 0, right = height.length - 1, maxArea = 0;
		while (left <= right) {
			int area = (right - left) * Math.min(height[right], height[left]);
			maxArea = Math.max(maxArea, area);
			if (height[left] < height[right]) {
				++left;
			} else {
				--right;
			}
		}
		return maxArea;
	}
}
