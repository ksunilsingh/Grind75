package leet75.dp1d;

public class Tiling {
	public int numTilings(int n) {
		long[] dp = new long[n + 3];
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 5;

		for (int i = 3; i < n; i++) {
			dp[i] = (2 * dp[i - 1] + dp[i - 3]) % 1000000007;
		}
		return (int) dp[n - 1];
	}
}
