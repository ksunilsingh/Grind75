package grind75.practice1.week1;

/*
 * Given two strings s and t, return true if t is an 
anagram
 of s, and false otherwise.
 */
public class ValidAnagrams {
	public boolean isAnagram(String s, String t) {
		char[] chars = new char[26];

		for (char c : s.toCharArray()) {
			chars[c - 'a']++;
		}

		for (char c : t.toCharArray()) {
			chars[c - 'a']--;
		}

		for (int val : chars) {
			if (val != 0)
				return false;
		}

		return true;
	}
}
