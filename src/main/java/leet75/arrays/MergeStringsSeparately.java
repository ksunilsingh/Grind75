package leet75.arrays;

public class MergeStringsSeparately {

	public String mergeAlternately(String word1, String word2) {
		int w1Length = word1.length();
		int w2Length = word2.length();
		StringBuilder merged = new StringBuilder();
		int w1Index = 0, w2Index = 0;
		while (w1Index + w2Index < w1Length + w2Length) {
			if (w1Index < w1Length) {
				merged.append(word1.charAt(w1Index++));
			}
			if (w2Index < w2Length) {
				merged.append(word2.charAt(w2Index++));
			}

		}
		return merged.toString();
	}
}
