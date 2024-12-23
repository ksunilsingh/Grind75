package grind75.practice2.week1;

/*Given two strings s and t, return true if t is an 
anagram
 of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 
 */
public class ValidAnagrams {

	public boolean isAnagram(String s, String t) {
		int[] chars = new int[26];

		for (char ch : s.toCharArray()) {
			chars[ch - 'a']++;
		}

		for (char ch : t.toCharArray()) {
			chars[ch - 'a']--;
		}

		for (int val : chars) {
			if (val != 0)
				return false;
		}

		return true;
	}

}
