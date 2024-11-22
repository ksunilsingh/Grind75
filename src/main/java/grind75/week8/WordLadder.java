package grind75.week8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		Map<String, List<String>> patternMap = buildPatternMap(wordList, beginWord.length());

		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);

		int level = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String currentWord = queue.poll();
				for (String neighbour : getNeighbours(currentWord, patternMap)) {
					if (neighbour.equals(endWord)) {
						return level + 1;
					}

					if (!visited.contains(neighbour)) {
						visited.add(neighbour);
						queue.add(neighbour);
					}
				}
			}
			++level;
		}

		return 0;
	}

	private Map<String, List<String>> buildPatternMap(List<String> wordList, int wordLength) {
		Map<String, List<String>> patternMap = new HashMap<>();

		for (String word : wordList) {
			for (int i = 0; i < wordLength; i++) {
				String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
				patternMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
			}
		}
		return patternMap;

	}

	private List<String> getNeighbours(String word, Map<String, List<String>> patternMap) {
		List<String> neighbours = new ArrayList<>();

		for (int i = 0; i < word.length(); i++) {
			String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
			neighbours.addAll(patternMap.getOrDefault(pattern, new ArrayList<String>()));
		}
		return neighbours;

	}
}
