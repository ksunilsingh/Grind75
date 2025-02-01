package grind75.practice4.week2;

/*
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

 

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 

Constraints:

1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.
 */
public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] magChars = new int[26];

		for (char ch : magazine.toCharArray()) {
			magChars[ch - 'a']++;
		}

		for (char ch : ransomNote.toCharArray()) {
			magChars[ch - 'a']--;
		}

		for (int count : magChars) {
			if (count < 0)
				return false;
		}

		return true;
	}
}
