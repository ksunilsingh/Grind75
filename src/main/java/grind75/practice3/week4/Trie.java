package grind75.practice3.week4;

public class Trie {

	private static TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	void insert(String word) {
		TrieNode current = root;
		for (char ch : word.toCharArray()) {
			if (!current.containsKey(ch))
				current.put(ch, new TrieNode());
			current = current.get(ch);
		}
		current.setEnd();
	}

	// Returns true if the string word is in the trie (i.e., was inserted before),
	// and false otherwise.
	boolean search(String word) {
		TrieNode current = root;
		for (char ch : word.toCharArray()) {
			if (!current.containsKey(ch))
				return false;
			current = current.get(ch);
		}
		return current.isEnd();
	}

	// Returns true if there is a previously inserted string word that has the
	// prefix prefix, and false otherwise.
	boolean startsWith(String prefix) {
		TrieNode current = root;
		for (char ch : prefix.toCharArray()) {
			if (!current.containsKey(ch))
				return false;
			current = current.get(ch);
		}
		return true;
	}
}

class TrieNode {

	TrieNode[] links = new TrieNode[26];
	private boolean isEnd = false;

	public TrieNode get(char ch) {
		return links[ch - 'a'];
	}

	public boolean containsKey(char ch) {
		return links[ch - 'a'] != null;
	}

	public void put(char ch, TrieNode node) {
		links[ch - 'a'] = node;
	}

	public void setEnd() {
		isEnd = true;
	}

	public boolean isEnd() {
		return isEnd;
	}
}
