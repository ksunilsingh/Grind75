package grind75.week5;

import java.util.ArrayList;
import java.util.List;

/*
 * 
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
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
 */

public class Permutations3 {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		backTrack(nums, result, 0);
		return result;
	}

	private void backTrack(int[] nums, List<List<Integer>> result, int start) {
		if (start == nums.length) {
			List<Integer> list = new ArrayList<Integer>();
			for (int num : nums) {
				list.add(num);
			}
			result.add(list);
		}

		for (int i = start; i < nums.length; ++i) {
			swap(nums, start, i);
			backTrack(nums, result, start + 1);
			swap(nums, start, i);
		}
	}

	private void swap(int[] nums, int start, int i) {
		int temp = nums[start];
		nums[start] = nums[i];
		nums[i] = temp;
	}

	public static void main(String[] args) {
		Permutations3 perm = new Permutations3();
		perm.permute(new int[] { 1, 2, 3 });
	}
}
