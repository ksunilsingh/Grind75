package grind75.week2;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome4 {

	public int longestPalindrome(String s) {

		Map<Character, Integer> charCount = new HashMap<>();

		for (char c : s.toCharArray()) {
			charCount.put(c, charCount.getOrDefault(c, 0) + 1);
		}

		int length = 0;
		boolean odd = false;
		for (int count : charCount.values()) {
			if (count % 2 == 0) {
				length += count;
			} else {
				length += count - 1;
				odd = true;
			}
		}

		if (odd)
			++length;

		return length;
	}

}
