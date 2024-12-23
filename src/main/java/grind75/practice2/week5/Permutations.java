package grind75.practice2.week5;

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
public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> perms = new ArrayList<>();
		backtrack(nums, 0, perms);
		return perms;
	}

	private void backtrack(int[] nums, int start, List<List<Integer>> perms) {
		if (start == nums.length) {
			List<Integer> list = new ArrayList<Integer>();
			Arrays.stream(nums).forEach(list::add);
			perms.add(list);
			return;
		}

		for (int i = start; i < nums.length; i++) {
			swap(nums, i, start);
			backtrack(nums, start + 1, perms);
			swap(nums, i, start);
		}
	}

	private void swap(int[] nums, int i, int start) {
		int temp = nums[i];
		nums[i] = nums[start];
		nums[start] = temp;
	}
}
