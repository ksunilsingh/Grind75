package leet75.slidingwindow;

public class MaximumNumberVowelsSubstring {

	public int maxVowels(String s, int k) {
		int vowelsCount = 0;
		int[] vowels = new int[128];
		vowels['a'] = 1;
		vowels['e'] = 1;
		vowels['i'] = 1;
		vowels['o'] = 1;
		vowels['u'] = 1;

		for (int i = 0; i < k; i++) {
			vowelsCount += vowels[s.charAt(i)];
		}
		int maxVowelsCount = vowelsCount;
		for (int i = k; i < s.length(); i++) {
			vowelsCount += vowels[s.charAt(i)] - vowels[s.charAt(i - k)];
			maxVowelsCount = Math.max(maxVowelsCount, vowelsCount);
			if (maxVowelsCount == k)
				return maxVowelsCount;
		}
		return maxVowelsCount;
	}

	public static void main(String[] args) {
		MaximumNumberVowelsSubstring mnvs = new MaximumNumberVowelsSubstring();
		mnvs.maxVowels("weallloveyou", 7);
	}
}
