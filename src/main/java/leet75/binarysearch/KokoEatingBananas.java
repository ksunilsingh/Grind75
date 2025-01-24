package leet75.binarysearch;

import java.util.Arrays;

public class KokoEatingBananas {
	public int minEatingSpeed(int[] piles, int h) {
		int left = 1;
		int right = Arrays.stream(piles).max().getAsInt();
		while (left <= right) {
			int mid = left + (right - left) / 2;
			long totalHours = 0;

			for (int pile : piles) {
				totalHours += (pile + mid - 1) / mid;
			}

			if (totalHours > h) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}
}
