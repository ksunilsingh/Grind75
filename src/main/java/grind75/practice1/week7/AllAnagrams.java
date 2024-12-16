package grind75.practice1.week7;

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
 */
public class AllAnagrams {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> anagrams = new ArrayList<>();

		if (s == null || p == null || s.length() < p.length()) {
			return anagrams;
		}

		int[] pCount = new int[26];
		for (int i = 0; i < p.length(); i++) {
			pCount[p.charAt(i) - 'a']++;
		}

		int[] sCount = new int[26];
		int windowSize = p.length();

		for (int i = 0; i < s.length(); i++) {
			sCount[s.charAt(i) - 'a']++;

			if (i >= windowSize) {
				sCount[s.charAt(i - windowSize) - 'a']--;
			}

			if (Arrays.equals(sCount, pCount)) {
				anagrams.add(i - windowSize + 1);
			}
		}

		return anagrams;
	}

	public static void main(String[] args) {
		AllAnagrams allAna = new AllAnagrams();
		allAna.findAnagrams("abab", "ab");
	}
}

//int[] allChars = new int[26];
//
//for (int i = 0; i < p.length(); i++) {
//	allChars[p.charAt(i) - 'a']++;
//}
//
//for (int i = 0; i < s.length() - p.length(); i++) {
//	String subString = s.substring(i, p.length() + i);
//	for (int j = 0; j < subString.length(); j++) {
//		allChars[subString.charAt(j) - 'a']--;
//	}
//
//	boolean anagram = true;
//	for (int j = 0; j < allChars.length; j++) {
//		if (allChars[j] != 0) {
//			anagram = false;
//			break;
//		}
//	}
//	if (anagram) {
//		anagrams.add(i);
//	}
//	allChars = new int[26];
//	for (int j = 0; j < p.length(); j++) {
//		allChars[p.charAt(j) - 'a']++;
//	}
//}