package grind75.practice1.week6;

import java.util.List;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can
 * be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * Note that the same word in the dictionary may be reused multiple times in the
 * segmentation.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "leetcode", wordDict = ["leet","code"] Output: true Explanation:
 * Return true because "leetcode" can be segmented as "leet code". Example 2:
 * 
 * Input: s = "applepenapple", wordDict = ["apple","pen"] Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple". Note that you are allowed to reuse a dictionary word. Example 3:
 * 
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"] Output:
 * false
 */
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
