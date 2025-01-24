package grind75.practice3.week2;

public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] magCount = new int[26];
		for (char ch : magazine.toCharArray()) {
			magCount[ch - 'a']++;
		}

		int[] rnCount = new int[26];
		for (char ch : ransomNote.toCharArray()) {
			rnCount[ch - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			if (rnCount[i] > magCount[i])
				return false;
		}

		return true;
	}
}
