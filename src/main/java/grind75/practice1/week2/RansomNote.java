package grind75.practice1.week2;

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
		int[] charCount = new int[26];

		for (char c : magazine.toCharArray()) {
			charCount[c - 'a']++;
		}

		for (char c : ransomNote.toCharArray()) {
			charCount[c - 'a']--;
			if (charCount[c - 'a'] < 0)
				return false;
		}

		return true;
	}
}
