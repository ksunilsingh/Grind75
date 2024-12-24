package grind75.practice2.week6;

/*
 * Given a string s, return the longest 
palindromic substring in s.
 */
public class LongestPalindromicString {
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0)
			return "";
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			// for odd length palindrome expand from i and go to left and right till the
			// longest palindrome is found
			// for even length palindrom expand from i, and i + 1 and go to left and right
			// till the longest palindrome is found
			int len = Math.max(expandFromCenter(s, i, i), expandFromCenter(s, i, i + 1));
			// If the max of the two length calculated is greater than the current longest
			// palindrome (end - start)
			// reset the start and end
			if (len > (end - start)) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);

	}

	/**
	 * Calculate the length of the longest palindrome starting from left and right
	 * as center and going toward beginning and end
	 * 
	 * @param s
	 * @param left
	 * @param right
	 * @return
	 */
	private int expandFromCenter(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			--left;
			++right;
		}
		return right - left - 1;
	}
}
