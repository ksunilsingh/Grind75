package grind75.practice2.week2;

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
		Map<Character, Integer> charCount = new HashMap<Character, Integer>();

		for (char ch : s.toCharArray()) {
			charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
		}

		int length = 0;
		boolean odd = false;
		for (int count : charCount.values()) {
			if (count % 2 == 0) {
				length += count;
			} else {
				// If there are odd number of characters in s, only 1 less than number of
				// characters can be used in the palindrome
				// e.g. If x occurs 3 times in s, only two of those can be used in making the
				// palindrome
				length += count - 1;
				odd = true;
			}
		}

		// One of the characters that occur odd number of times can be used in the
		// center of the palindrome
		if (odd)
			++length;

		return length;
	}
}
