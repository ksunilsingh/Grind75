package leet75.prefixsum;

public class PivotIndex {

//	public int pivotIndex(int[] nums) {
//
//		for (int i = 0; i < nums.length; i++) {
//			int leftIndex = i, rightIndex = i;
//			int leftSum = 0;
//			int rightSum = 0;
//			while (leftIndex > 0) {
//				leftSum += nums[leftIndex - 1];
//				--leftIndex;
//			}
//			while (rightIndex < nums.length - 1) {
//				rightSum += nums[rightIndex + 1];
//				++rightIndex;
//			}
//
//			if (rightSum == leftSum)
//				return i;
//		}
//		return -1;
//
//	}

	public int pivotIndex(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		int leftSum = 0;
		for (int i = 0; i < nums.length; i++) {
			int rightSum = sum - leftSum - nums[i];
			if (rightSum == leftSum)
				return i;
			leftSum += nums[i];
		}
		return -1;
	}
}
