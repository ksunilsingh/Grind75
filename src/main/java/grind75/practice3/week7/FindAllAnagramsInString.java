package grind75.practice3.week7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInString {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> anagramIndexes = new ArrayList<Integer>();

		int[] pCount = new int[26];
		for (int i = 0; i < p.length(); i++) {
			pCount[p.charAt(i) - 'a']++;
		}

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
}
