package leet75.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SearchSuggestion {

	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		TrieNode root = new TrieNode();
		for (String product : products) {
			insert(root, product);
		}

		List<List<String>> results = new ArrayList<>();

		for (char ch : searchWord.toCharArray()) {
			if (!root.containsKey(ch)) {
				break;
			}
			root = root.get(ch);
			results.add(root.getTopThree());
		}

		while (results.size() < searchWord.length()) {
			results.add(new ArrayList<String>());
		}

		return results;
	}

	private void insert(TrieNode root, String product) {
		for (char ch : product.toCharArray()) {
			if (!root.containsKey(ch)) {
				root.put(ch, new TrieNode());
			}
			root = root.get(ch);
			root.addToPQ(product);
		}
	}

}

class TrieNode {

	TrieNode[] children = new TrieNode[26];
	PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> b.compareTo(a));

	public TrieNode() {

	}

	public void addToPQ(String word) {
		pq.add(word);
		if (pq.size() > 3)
			pq.poll();
	}

	public List<String> getTopThree() {
		List<String> topThree = new ArrayList<>();
		while (!pq.isEmpty())
			topThree.add(pq.poll());
		Collections.reverse(topThree);
		return topThree;
	}

	public TrieNode get(char c) {
		return children[c - 'a'];
	}

	public boolean containsKey(char c) {
		return children[c - 'a'] != null;
	}

	public void put(char c, TrieNode node) {
		children[c - 'a'] = node;
	}
}