package leet75.slidingwindow;

public class MaxAverageSubarray {
//	public double findMaxAverage(int[] nums, int k) {
//		double runningAverage = 0D;
//		double maxAverage = Double.NEGATIVE_INFINITY;
//		for (int right = 0; right <= nums.length - k; ++right) {
//
//			int sum = 0;
//			for (int left = right; left < (right + k); ++left) {
//				sum += nums[left];
//			}
//			runningAverage = (double) ((double) sum / (double) k);
//			if (runningAverage > maxAverage)
//				maxAverage = runningAverage;
//		}
//		return maxAverage;
//	}

	public double findMaxAverage(int[] nums, int k) {
		int sum = 0;
		for (int i = 0; i < k; ++i) {
			sum += nums[i];
		}
		int maxSum = sum;
		for (int i = k; i < nums.length; ++i) {
			sum += nums[i] - nums[i - k];
			maxSum = Math.max(maxSum, sum);
		}
		return (double) maxSum / k;
	}

	public static void main(String[] args) {
		MaxAverageSubarray mas = new MaxAverageSubarray();
		mas.findMaxAverage(new int[] { -1 }, 1);
		// mas.findMaxAverage(new int[] { 1, 12, -5, -6, 50, 3 }, 4);

	}
}
