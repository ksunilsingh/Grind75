package grind75.practice1.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array nums of distinct integers, return all the possible 
permutations
. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 */
public class Permutation {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(nums, 0, result);
		return result;
	}

	private void backtrack(int[] nums, int start, List<List<Integer>> result) {
		if (start == nums.length) {
			List<Integer> list = new ArrayList<>();
			Arrays.stream(nums).forEach(list::add);
			result.add(list);
		}

		for (int i = start; i < nums.length; i++) {
			swap(nums, start, i);
			backtrack(nums, start + 1, result);
			swap(nums, start, i);
		}
	}

	private void swap(int[] nums, int start, int i) {
		int temp = nums[start];
		nums[start] = nums[i];
		nums[i] = temp;
	}

}
