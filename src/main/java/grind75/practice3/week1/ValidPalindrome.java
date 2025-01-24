package grind75.practice3.week1;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		char[] sChars = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase().toCharArray();
		int n = sChars.length;
		for (int i = 0; i < n / 2; i++) {
			if (sChars[i] != sChars[n - i - 1]) {
				return false;
			}
		}
		return true;
	}
}
