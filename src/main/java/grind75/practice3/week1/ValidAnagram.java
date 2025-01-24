package grind75.practice3.week1;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		int[] chars = new int[26];

		for (char ch : s.toCharArray()) {
			chars[ch - 'a']++;
		}

		for (char ch : t.toCharArray()) {
			chars[ch - 'a']--;
		}

		for (int count : chars) {
			if (count != 0)
				return false;
		}
		return true;
	}
}
