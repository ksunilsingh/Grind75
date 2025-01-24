package grind75.practice3.week2;

public class FirstBadVersion {
	public int firstBadVersion(int n) {
		int left = 0, right = n - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (isBadVersion(mid)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	private boolean isBadVersion(int n) {
		return true;
	}
}
