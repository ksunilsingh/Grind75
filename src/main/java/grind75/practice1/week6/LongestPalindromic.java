package grind75.practice1.week6;

/*
 * Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
 */
public class LongestPalindromic {
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0)
			return "";
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len = Math.max(expandFromCenter(s, i, i), expandFromCenter(s, i, i + 1));
			if (len > (end - start)) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private int expandFromCenter(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			--left;
			++right;
		}
		return right - left - 1;
	}
}
