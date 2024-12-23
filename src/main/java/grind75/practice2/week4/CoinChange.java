package grind75.practice2.week4;

import java.util.Arrays;

/*
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 */
public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		// Fill the array with amount+1 to indicate that all amounts are unreachable
		// initially
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				// It is possible to add this coin only if the amount i is greater than the
				// current coin
				int diff = i - coin;
				if (diff >= 0) {
					// dp[diff] gives the number of coins without using this coin
					// Calculate the min of dp[i] and "adding this coin count(1) to dp[diff]"
					dp[i] = Math.min(dp[i], dp[diff] + 1);
				}
			}

		}

		// if dp[amount] is still at its initial value of (amount+1), this means that
		// the amount is not reachable
		return dp[amount] == (amount + 1) ? -1 : dp[amount];
	}
}
