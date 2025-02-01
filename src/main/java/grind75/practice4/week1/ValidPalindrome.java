package grind75.practice4.week1;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		char[] sChars = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase().toCharArray();
		for (int i = 0; i < sChars.length / 2; i++) {
			if (sChars[i] != sChars[sChars.length - i - 1])
				return false;
		}
		return true;
	}
}
