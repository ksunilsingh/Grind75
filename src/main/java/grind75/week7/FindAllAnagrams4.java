package grind75.week7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams4 {

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		if (s == null || p == null || s.length() < p.length()) {
			return result;
		}

		int[] pCount = new int[26];
		for (char c : p.toCharArray()) {
			pCount[c - 'a']++;
		}

		int[] sCount = new int[26];
		int windowSize = p.length();

		for (int i = 0; i < s.length(); i++) {
			sCount[s.charAt(i) - 'a']++;

			if (i >= windowSize) {
				sCount[s.charAt(i - windowSize) - 'a']--;
			}

			if (Arrays.equals(sCount, pCount))
				result.add(i - windowSize + 1);
		}

		return result;
	}

}
