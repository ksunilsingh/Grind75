package grind75.week6;

import java.util.ArrayList;
import java.util.List;

public class subsets5 {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		createSubsets(0, nums, new ArrayList<>(), result);
		return result;
	}

	private void createSubsets(int index, int[] nums, ArrayList<Integer> current, List<List<Integer>> result) {
		if (index == nums.length) {
			result.add(new ArrayList<>(current));
			return;
		}

		current.add(nums[index]);
		createSubsets(index + 1, nums, current, result);

		current.remove(current.size() - 1);
		createSubsets(index + 1, nums, current, result);
	}
}
