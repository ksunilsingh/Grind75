package leet75.slidingwindow;

public class LongestSubarray1s {
	public int longestSubarray(int[] nums) {
		int left = 0, zeros = 0, ans = 0;

		for (int right = 0; right < nums.length; ++right) {
			if (nums[right] == 0) {
				++zeros;
			}

			while (zeros > 1) {
				if (nums[left] == 0) {
					--zeros;
				}
				++left;
			}
			ans = Math.max(ans, right - left + 1 - zeros);
		}
		return ans == nums.length ? ans - 1 : ans;
	}
}
