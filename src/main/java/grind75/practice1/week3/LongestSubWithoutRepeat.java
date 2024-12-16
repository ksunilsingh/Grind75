package grind75.practice1.week3;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the
 * length of 3. Example 2:
 * 
 * Input: s = "bbbbb" Output: 1 Explanation: The answer is "b", with the length
 * of 1. Example 3:
 * 
 * Input: s = "pwwkew" Output: 3 Explanation: The answer is "wke", with the
 * length of 3. Notice that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 * 
 * 
 * Constraints:
 * 
 * 0 <= s.length <= 5 * 104 s consists of English letters, digits, symbols and
 * spaces.
 */
public class LongestSubWithoutRepeat {
	public int lengthOfLongestSubstring(String s) {
		int left = 0, len = 0;
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		for (int right = 0; right < s.length(); ++right) {
			if (charMap.containsKey(s.charAt(right))) {
				left = Math.max(left, charMap.get(s.charAt(right)) + 1);
			}
			len = Math.max(len, right - left + 1);
			charMap.put(s.charAt(right), right);
		}

		return len;
	}
}
