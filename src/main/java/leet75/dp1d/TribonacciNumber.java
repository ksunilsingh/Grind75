package leet75.dp1d;

public class TribonacciNumber {

	public int tribonacci(int n) {
		if (n == 0)
			return 0;
		if (n == 1 || n == 2)
			return 1;
		int a = 0, b = 1, c = 1;
		for (int i = 3; i <= n; i++) {
			int sum = a + b + c;
			a = b;
			b = c;
			c = sum;
		}
		return c;
	}
}
