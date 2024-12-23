package grind75.practice2.week5;

public class SortColors {
	public void sortColors(int[] nums) {
		int red = 0, white = 0, blue = 0;
		for (int num : nums) {
			if (num == 0)
				++red;
			if (num == 1)
				++white;
			if (num == 2)
				++blue;
		}

		int index = 0;
		for (int i = 0; i < red; i++) {
			nums[index++] = 0;
		}
		for (int i = 0; i < white; i++) {
			nums[index++] = 1;
		}
		for (int i = 0; i < blue; i++) {
			nums[index++] = 2;
		}
	}
}
