package grind75.practice4.week2;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest 
palindrome
 that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.

 

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
 */
public class LongestPalindrome {
	public int longestPalindrome(String s) {
		int maxLength = 0;
		Map<Character, Integer> charCount = new HashMap<>();

		for (char ch : s.toCharArray()) {
			charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
		}

		boolean odd = false;
		for (int count : charCount.values()) {
			if (count % 2 == 0) {
				maxLength += count;
			} else {
				maxLength += count - 1;
				odd = true;
			}
		}
		if (odd)
			++maxLength;
		return maxLength;
	}
}
