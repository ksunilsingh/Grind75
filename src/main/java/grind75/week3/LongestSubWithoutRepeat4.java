package grind75.week3;

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
public class LongestSubWithoutRepeat4 {
	public int lengthOfLongestSubstring(String s) {
		int left = 0, right = 0;
		int len = 0;

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		while (right < s.length()) {
			if (map.containsKey(s.charAt(right))) {
				left = Math.max(map.get(s.charAt(right)) + 1, left);
			}

			map.put(s.charAt(right), right);
			if (len < right - left + 1) {
				len = right - left + 1;
			}

			++right;
		}
		return len;
	}
}
