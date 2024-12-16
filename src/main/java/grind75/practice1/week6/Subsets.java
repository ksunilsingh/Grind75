package grind75.practice1.week6;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		createSubset(nums, 0, new ArrayList<>(), result);
		return result;
	}

	private void createSubset(int[] nums, int index, ArrayList<Integer> current, List<List<Integer>> result) {
		if (index == nums.length) {
			result.add(new ArrayList<>(current));
			return;
		}

		current.add(nums[index]);
		createSubset(nums, index + 1, current, result);

		current.remove(current.size() - 1);
		createSubset(nums, index + 1, current, result);
	}
}
