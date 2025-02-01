package grind75.practice4.week1;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		int[] chars = new int[26];

		for (int i = 0; i < s.length(); i++) {
			chars[s.charAt(i) - 'a']++;
		}

		for (int i = 0; i < t.length(); i++) {
			chars[t.charAt(i) - 'a']--;
		}

		for (int count : chars) {
			if (count != 0)
				return false;
		}

		return true;
	}
}
