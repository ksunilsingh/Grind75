package grind75.week2;

import java.util.HashMap;
import java.util.Map;

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

public class RansomeNote {

	public boolean canConstruct(String ransomNote, String magazine) {
		Map<Character, Integer> magMap = new HashMap<Character, Integer>();
		for (char c : magazine.toCharArray()) {
			magMap.put(c, magMap.getOrDefault(c, 0) + 1);
		}

		for (char c : ransomNote.toCharArray()) {
			if (magMap.containsKey(c) && magMap.get(c) > 0) {
				magMap.put(c, magMap.get(c) - 1);
			} else {
				return false;
			}
		}
		return true;
	}

}
