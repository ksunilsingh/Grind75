package grind75.practice2.week5;

/*
 * There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 */
public class SearchRotatedArray {
	public int search(int[] nums, int target) {
		int n = nums.length, left = 0, right = n - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				return mid;
			}

			// Binary logic can only be applied on the sorted array.
			// In the rotated arrays, one half has to be sorted
			// If left half is sorted
			if (nums[mid] >= nums[left]) {
				if (target >= nums[left] && target <= nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else /* right half is sorted */ {
				if (target >= nums[mid] && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}
}
