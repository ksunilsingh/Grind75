package grind75.week4;

import java.util.Arrays;

public class CoinChange3 {
	public int coinChange(int[] coins, int amount) {
		// Step 1: Create a dp array of size amount + 1 and initialize with amount + 1
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1); // Initialize with a large value
		dp[0] = 0; // Base case: 0 coins are needed to make amount 0

		// Step 2: Iterate over all amounts from 1 to amount
		for (int i = 1; i <= amount; i++) {
			// Step 3: Check each coin denomination
			for (int coin : coins) {
				if (i - coin >= 0) { // If the coin can contribute to this amount
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
		}

		// Step 4: Check if we found a solution
		return dp[amount] > amount ? -1 : dp[amount];
	}
}
