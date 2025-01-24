package grind75.practice3.week5;

public class SortColors {
	public void sortColors(int[] nums) {
		int[] countColors = new int[3];
		for (int i = 0; i < nums.length; i++) {
			countColors[nums[i]]++;
		}

		int index = 0;
		for (; index < countColors[0]; index++) {
			nums[index] = 0;
		}
		int endIndex = index + countColors[1];
		for (; index < endIndex; index++) {
			nums[index] = 1;
		}
		endIndex += countColors[2];
		for (; index < endIndex; index++) {
			nums[index] = 2;
		}
	}

	public static void main(String[] args) {
		SortColors sc = new SortColors();
		sc.sortColors(new int[] { 2, 0, 2, 1, 1, 0 });
	}
}
