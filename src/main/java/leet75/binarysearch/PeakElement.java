package leet75.binarysearch;

public class PeakElement {
	public int findPeakElementLinear(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return 0;
		if (n == 2) {
			if (nums[0] > nums[1]) {
				return 0;
			} else {
				return 1;
			}
		}
		int prev = nums[0];
		for (int i = 0; i < n - 1; i++) {
			int next = nums[i + 1];
			if (i == 0 && nums[i] > next) {
				return 0;
			} else if (nums[i] > prev && nums[i] > next) {
				return i;
			}
			prev = nums[i];
		}
		if (nums[n - 1] > prev) {
			return n - 1;
		}
		return -1;
	}

	public int findPeakElement(int[] nums) {
		int n = nums.length;
		int left = 0, right = n - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[mid + 1]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		PeakElement pe = new PeakElement();
		pe.findPeakElement(new int[] { 3, 2, 1 });
	}
}
