package leet75.TwoPointers;

import java.util.Arrays;

public class MaxNumOfKSumPairs {
	public int maxOperations(int[] nums, int k) {
		int n = nums.length, left = 0, right = n - 1, count = 0;
		Arrays.sort(nums);
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum == k) {
				++count;
				++left;
				--right;
			} else if (sum > k) {
				--right;
			} else {
				++left;
			}
		}
		return count;
	}
}
