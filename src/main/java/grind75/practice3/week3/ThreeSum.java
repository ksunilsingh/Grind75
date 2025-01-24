package grind75.practice3.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		Arrays.sort(nums);
		int n = nums.length;
		for (int i = 0; i < n - 2; i++) {
			int left = i + 1, right = n - 1;

			if (i > 0 && nums[i - 1] == nums[i])
				continue;

			while (left < right) {
				int sum = nums[left] + nums[i] + nums[right];
				if (sum == 0) {
					result.add(Arrays.asList(nums[left], nums[i], nums[right]));

					while (left < right && nums[left] == nums[left + 1]) {
						++left;
					}

					while (left < right && nums[right] == nums[right - 1]) {
						--right;
					}
					++left;
					--right;
				} else if (sum > 0) {
					--right;
				} else {
					++left;
				}
			}
		}

		return result;
	}
}
