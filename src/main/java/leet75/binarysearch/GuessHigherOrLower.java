package leet75.binarysearch;

public class GuessHigherOrLower {
	public int guessNumber(int n) {
		int left = 0, right = 0;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (guess(mid) == 0) {
				return mid;
			} else if (guess(mid) == 1) {
				right = mid - 1;
			} else if (guess(mid) == -1) {
				left = mid + 1;
			}
		}
		return -1;
	}

	private int guess(int mid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
