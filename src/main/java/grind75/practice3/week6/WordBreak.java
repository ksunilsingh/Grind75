package grind75.practice3.week6;

import java.util.List;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length()];

		for (int i = 0; i < s.length(); i++) {
			for (String word : wordDict) {
				if (i < word.length() - 1)
					continue;
				int start = i - word.length();
				if (i == word.length() - 1 || dp[start]) {
					if (s.substring(start + 1, i + 1).equals(word)) {
						dp[i] = true;
						break;
					}
				}
			}
		}
		return dp[s.length() - 1];
	}
}
