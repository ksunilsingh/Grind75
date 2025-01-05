package leet75.TwoPointers;

public class MoveZeros {
	public void moveZeroes(int[] nums) {
		int left = 0;
		int n = nums.length;
		for (int right = 0; right < n; right++) {
			if (nums[right] == 0)
				continue;
			int temp = nums[right];
			nums[right] = nums[left];
			nums[left] = temp;
			++left;
		}
	}

	public static void main(String[] args) {
		MoveZeros mz = new MoveZeros();
		mz.moveZeroes(new int[] { 0, 1, 0, 3, 12 });
	}
}
