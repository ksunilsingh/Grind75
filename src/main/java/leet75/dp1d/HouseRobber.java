package leet75.dp1d;

public class HouseRobber {
	public int rob(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];

		int prev1 = nums[0];
		int prev2 = Math.max(nums[0], nums[1]);

		for (int i = 2; i < nums.length; i++) {
			int current_robbed = Math.max(prev2, prev1 + nums[i]);
			prev1 = prev2;
			prev2 = current_robbed;
		}
		return prev2;
	}
}
