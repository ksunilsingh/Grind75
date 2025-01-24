package grind75.practice3.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> permutations = new ArrayList<>();
		backtrack(nums, 0, permutations);
		return permutations;
	}

	private void backtrack(int[] nums, int start, List<List<Integer>> permutations) {

		if (start == nums.length) {
			List<Integer> list = new ArrayList<>();
			Arrays.stream(nums).forEach(list::add);
			permutations.add(list);
			return;
		}

		for (int i = start; i < nums.length; i++) {
			swap(nums, i, start);
			backtrack(nums, start + 1, permutations);
			swap(nums, i, start);
		}

	}

	private void swap(int[] nums, int i, int start) {
		int temp = nums[i];
		nums[i] = nums[start];
		nums[start] = temp;
	}
}
