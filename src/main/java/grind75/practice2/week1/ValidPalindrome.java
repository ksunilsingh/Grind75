package grind75.practice2.week1;

/*
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		char[] sChars = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().toCharArray();
		int len = sChars.length;
		for (int i = 0; i < len / 2; ++i) {
			if (sChars[i] != sChars[len - i - 1])
				return false;
		}
		return true;
		/*
		 * char[] sChars = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().toCharArray();
		 * int len = sChars.length; int left = 0, right = len - 1;
		 * 
		 * while (left < right) { if (sChars[left] != sChars[right]) { return false; }
		 * ++left; --right; }
		 * 
		 * return true;
		 */
	}

	public static void main(String[] args) {
		ValidPalindrome vp = new ValidPalindrome();
		vp.isPalindrome("A man, a plan, a canal: Panama");
	}
}
