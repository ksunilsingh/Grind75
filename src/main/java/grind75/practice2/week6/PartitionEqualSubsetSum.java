package grind75.practice2.week6;

/*
 * Given an integer array nums, return true if you can partition the array into two subsets 
 * such that the sum of the elements in both subsets is equal or false otherwise.

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class PartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int num : nums)
			sum += num;

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

	public static void main(String[] args) {
		// Example input
		int[] nums = { 1, 5, 11, 5 };

		// Create an instance of the solution class
		PartitionEqualSubsetSum solution = new PartitionEqualSubsetSum();

		// Call the canPartition method
		boolean result = solution.canPartition(nums);

		// Output the result
		if (result) {
			System.out.println("The array can be partitioned into two subsets with equal sum.");
		} else {
			System.out.println("The array cannot be partitioned into two subsets with equal sum.");
		}
	}
}
