package grind75.practice1.week8;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum
 * window substring of s such that every character in t (including duplicates)
 * is included in the window. If there is no such substring, return the empty
 * string "".
 * 
 * The testcases will be generated such that the answer is unique.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "ADOBECODEBANC", t = "ABC" Output: "BANC" Explanation: The minimum
 * window substring "BANC" includes 'A', 'B', and 'C' from string t. Example 2:
 * 
 * Input: s = "a", t = "a" Output: "a" Explanation: The entire string s is the
 * minimum window. Example 3:
 * 
 * Input: s = "a", t = "aa" Output: "" Explanation: Both 'a's from t must be
 * included in the window. Since the largest window of s only has one 'a',
 * return empty string.
 */
public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if (s == null || t == null || s.length() < t.length())
			return "";

		int m = s.length();
		int n = t.length();

		// Step 1. map of characters and their count in t
		Map<Character, Integer> tCountMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			tCountMap.put(t.charAt(i), tCountMap.getOrDefault(t.charAt(i), 0) + 1);
		}

		int left = 0; // Left pointer of the sliding window
		int formed = 0; // Count of unique characters from t that meet the frequency requirement

		int minWindowSize = Integer.MAX_VALUE;

		// map of characters in current window and their count
		Map<Character, Integer> windowCountMap = new HashMap<>();
		int startWindow = 0;
		// Expand the window by moving the right pointer
		for (int right = 0; right < m; right++) {
			// character at right pointer
			char c = s.charAt(right);

			// update the character count for this character in the windowCountMap
			windowCountMap.put(c, windowCountMap.getOrDefault(c, 0) + 1);

			// If the character count of windowCountMap and tCountMap for this character
			// matches then increment formed
			if (tCountMap.containsKey(c) && tCountMap.get(c).intValue() == windowCountMap.get(c).intValue()) {
				++formed;
			}

			while (left <= right && formed == tCountMap.size()) {
				if (right - left + 1 < minWindowSize) {
					minWindowSize = (right - left + 1);
					startWindow = left;
				}

				char cLeft = s.charAt(left);

				windowCountMap.put(cLeft, windowCountMap.get(cLeft) - 1);

				if (tCountMap.containsKey(cLeft)
						&& windowCountMap.get(cLeft).intValue() < tCountMap.get(cLeft).intValue()) {
					--formed;
				}
				++left;
			}
		}
		return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(startWindow, startWindow + minWindowSize);
	}
}
