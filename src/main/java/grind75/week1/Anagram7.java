package grind75.week1;

public class Anagram7 {
	public boolean isAnagram(String s, String t) {
		int[] count = new int[26];

		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}

		for (char c : t.toCharArray()) {
			count[c - 'a']--;
		}

		for (int val : count) {
			if (val != 0)
				return false;
		}
		return true;
	}
}
