package leet75.arrays;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		int maxCandies = 0;

		for (int candy : candies) {
			maxCandies = Math.max(candy, maxCandies);
		}
		List<Boolean> result = new ArrayList<Boolean>();
		for (int i = 0; i < candies.length; i++) {
			result.add(candies[i] + extraCandies >= maxCandies);
		}
		return result;

	}
}
