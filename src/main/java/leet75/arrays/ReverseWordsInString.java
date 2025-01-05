package leet75.arrays;

public class ReverseWordsInString {
	public String reverseWords(String s) {
		String[] words = s.trim().split("\\s+");

		for (int i = 0; i < words.length / 2; i++) {
			String temp = words[i];
			words[i] = words[words.length - i - 1];
			words[words.length - i - 1] = temp;
		}

		StringBuilder result = new StringBuilder();
		for (String word : words) {
			result.append(word);
			result.append(" ");
		}
		return result.toString().trim();
	}
}
