package grind75.practice3.week1;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> diffMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			if (diffMap.containsKey(diff)) {
				return new int[] { diffMap.get(diff), i };
			}
			diffMap.put(nums[i], i);
		}
		return null;
	}
}
