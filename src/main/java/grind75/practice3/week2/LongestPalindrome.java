package grind75.practice3.week2;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
	public int longestPalindrome(String s) {
		Map<Character, Integer> charCount = new HashMap<>();
		for (char ch : s.toCharArray()) {
			charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
		}

		int len = 0;
		boolean odd = false;
		for (int count : charCount.values()) {
			if (count == 0)
				continue;
			if (count % 2 == 0) {
				len += count;
			} else {
				len += (count - 1);
				odd = true;
			}
		}
		if (odd)
			++len;

		return len;
	}
}
