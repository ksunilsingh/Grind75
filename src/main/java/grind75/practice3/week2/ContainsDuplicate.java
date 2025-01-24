package grind75.practice3.week2;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> count = new HashSet<>();
		for (int num : nums) {
			if (count.contains(num))
				return true;
			count.add(num);
		}
		return false;
	}
}
