package grind75.week7;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int n = height.length;

		int left = 0, right = n - 1;
		int maxArea = 0;

		while (left < right) {
			int area = (right - left) * Math.min(height[left], height[right]);
			maxArea = Math.max(maxArea, area);
			if (height[right] > height[left]) {
				++left;
			} else {
				--right;
			}
		}
		return maxArea;
	}
}
