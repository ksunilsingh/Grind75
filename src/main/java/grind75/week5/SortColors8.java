package grind75.week5;

import java.util.HashMap;
import java.util.Map;

public class SortColors8 {
	public void sortColors(int[] nums) {

		Map<Integer, Integer> colorCounts = new HashMap<>();

		for (int num : nums) {
			colorCounts.put(num, colorCounts.getOrDefault(num, 0) + 1);
		}

		int count = colorCounts.getOrDefault(0, 0);
		int index = 0;
		for (int i = 0; i < count; i++) {
			nums[index++] = 0;
		}

		count = colorCounts.getOrDefault(1, 0);
		for (int i = 0; i < count; i++) {
			nums[index++] = 1;
		}

		count = colorCounts.getOrDefault(2, 0);
		for (int i = 0; i < count; i++) {
			nums[index++] = 2;
		}

	}
}
