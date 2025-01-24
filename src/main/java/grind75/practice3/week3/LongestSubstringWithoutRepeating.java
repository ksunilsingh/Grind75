package grind75.practice3.week3;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {
	public int lengthOfLongestSubstring(String s) {
		int left = 0, len = 0;
		Map<Character, Integer> charIndexMap = new HashMap<>();

		for (int right = 0; right < s.length(); right++) {
			char ch = s.charAt(right);
			if (charIndexMap.containsKey(ch)) {
				left = Math.max(left, charIndexMap.get(ch) + 1);
			}
			len = Math.max(len, right - left + 1);
			charIndexMap.put(ch, right);
		}
		return len;
	}
}
