package grind75.practice3.week6;

public class LongestPalindromicString {
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len = Math.max(ExpandFromCenter(s, i, i), ExpandFromCenter(s, i, i + 1));

			if (len > (end - start)) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private int ExpandFromCenter(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			--left;
			++right;
		}
		return right - left - 1;
	}
}
