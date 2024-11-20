package grind75.week8;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public String minWindow(String s, String t) {

		if (s == null || t == null || s.length() < t.length()) {
			return "";
		}

		Map<Character, Integer> tCharCountMap = new HashMap<>();

		for (char c : t.toCharArray()) {
			tCharCountMap.put(c, tCharCountMap.getOrDefault(c, 0) + 1);
		}

		int left = 0, formed = 0;

		Map<Character, Integer> windowCountMap = new HashMap<>();
		int windowSize = Integer.MAX_VALUE;
		int windowStart = 0;

		for (int right = 0; right < s.length(); right++) {

			char c = s.charAt(right);
			windowCountMap.put(c, windowCountMap.getOrDefault(c, 0) + 1);

			if (tCharCountMap.containsKey(c) && tCharCountMap.get(c).intValue() == windowCountMap.get(c).intValue()) {
				formed++;
			}

			while (left <= right && formed == tCharCountMap.size()) {

				if (right - left + 1 < windowSize) {
					windowSize = (right - left + 1);
					windowStart = left;
				}

				c = s.charAt(left);

				windowCountMap.put(c, windowCountMap.get(c) - 1);

				if (tCharCountMap.containsKey(c)
						&& windowCountMap.get(c).intValue() < tCharCountMap.get(c).intValue()) {
					--formed;
				}
				++left;
			}
		}
		return windowSize == Integer.MAX_VALUE ? "" : s.substring(windowStart, windowStart + windowSize);
	}
}
