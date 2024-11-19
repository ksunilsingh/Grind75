package grind75.week6;

public class PartitionEqualSubsetSum2 {

	public boolean canPartition(int[] nums) {

		int sum = 0;
		for (int num : nums) {
			sum += num;
		}

		if (sum % 2 != 0)
			return false;

		int targetSum = sum / 2;

		boolean[] dp = new boolean[targetSum + 1];
		dp[0] = true;
		for (int num : nums) {
			for (int i = targetSum; i >= num; i--) {
				dp[i] = dp[i] || dp[i - num];
				if (dp[targetSum])
					return true;
			}
		}

		return false;
	}
}
