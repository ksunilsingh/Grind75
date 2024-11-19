package grind75.week2;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 */
public class MajorityElement6 {

	public int majorityElement(int[] nums) {
		int n = nums.length;
		int threshold = n / 2;

		Map<Integer, Integer> numCount = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int count = numCount.getOrDefault(nums[i], 0) + 1;
			if (count > threshold)
				return nums[i];
			numCount.put(nums[i], count);

		}

		return -1;

	}

	/*
	 * 
	 * Step 1: Find the candidate element This step uses Boyer-Moore Voting
	 * Algorithm. The idea is that we keep track of a candidate element (el) and its
	 * count (count). If the count becomes 0, we reset the candidate to the current
	 * element (nums[i]). If the current element matches the candidate, we increase
	 * the count. If the current element doesn't match, we decrease the count. This
	 * step identifies a potential candidate for the majority element.
	 * 
	 * Step 2: Verify if the candidate is actually the majority element After
	 * finding the candidate, the code counts its occurrences to confirm if it
	 * appears more than n/2 times. If it does, the candidate is returned as the
	 * majority element. If no such element is found, the function returns -1.
	 * 
	 */
	/*
	 * int num = nums.length; int count = 0; int el = nums[0]; for(int i=0; i < num;
	 * i++) { if(count == 0 ) { ++count; el = nums[i]; } else if(nums[i] == el) {
	 * ++count; } else { --count; } } count = 0; for(int i=0; i < num; i++) {
	 * if(nums[i] == el) { ++count; } if(count > num/2) return el; } return -1;
	 */

}
