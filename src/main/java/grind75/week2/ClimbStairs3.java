package grind75.week2;

public class ClimbStairs3 {

	public int climbStairs(int n) {

		if (n <= 2)
			return n;

		int first = 1;
		int second = 2;
		for (int i = 3; i < n; ++i) {
			int current = first + second;
			first = second;
			second = current;
		}
		return second;
	}
}
