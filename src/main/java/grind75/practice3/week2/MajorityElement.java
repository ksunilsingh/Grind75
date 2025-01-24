package grind75.practice3.week2;

public class MajorityElement {
	public int majorityElement(int[] nums) {
		int count = 0;
		int candidate = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (count == 0) {
				++count;
				candidate = nums[i];
			} else if (candidate == nums[i]) {
				++count;
			} else {
				--count;
			}
		}

		count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == candidate) {
				++count;
			}
			if (count > nums.length / 2)
				return candidate;
		}

		return -1;
	}
}
