package grind75.practice1.week2;

/*
 * Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
 */
public class MajorityElement {

	public int majorityElement(int[] nums) {
		/*
		 * int threshold = nums.length / 2; Map<Integer, Integer> countMap = new
		 * HashMap<>(); for(int i=0; i < nums.length; i++) { int count =
		 * countMap.getOrDefault(nums[i],0) +1; if(count > threshold) return nums[i];
		 * countMap.put(nums[i], count); } return -1;
		 */
		// Boyer-Moore algorithm
		int n = nums.length;
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
			if (nums[i] == candidate)
				++count;
			if (count > n / 2)
				return candidate;
		}
		return -1;
	}
}
