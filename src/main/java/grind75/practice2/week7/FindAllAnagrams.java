package grind75.practice2.week7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given two strings s and p, return an array of all the start indices of p's 
anagrams
 in s. You may return the answer in any order.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
 */
public class FindAllAnagrams {
	public List<Integer> findAnagrams(String s, String p) {

		List<Integer> anagramIndexes = new ArrayList<Integer>();

		int[] pCount = new int[26];
		for (char ch : p.toCharArray()) {
			pCount[ch - 'a']++;
		}

		int index = 0;
//		int n = s.length() - p.length();
//
//		while (index <= n) {
//			String s1 = s.substring(index, index + p.length());
//			int[] sCount = new int[26];
//			for (char ch : s1.toCharArray()) {
//				sCount[ch - 'a']++;
//			}
//
//			if (Arrays.equals(sCount, pCount)) {
//				anagramIndexes.add(index);
//			}
//			++index;
//		}

		int[] sCount = new int[26];
		int windowLength = p.length();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			sCount[ch - 'a']++;

			if (i >= windowLength) {
				sCount[s.charAt(i - windowLength) - 'a']--;
			}

			if (Arrays.equals(sCount, pCount)) {
				anagramIndexes.add(i - windowLength + 1);
			}

		}

		return anagramIndexes;
	}

	public static void main(String[] args) {
		FindAllAnagrams faa = new FindAllAnagrams();
		faa.findAnagrams("abab", "ab");
	}
}
