package grind75.practice2.week4;

public class Trie {

	private static TrieNode root = new TrieNode();

	public Trie() {

	}

	public void insert(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			if (!node.containsKey(c)) {
				node.put(c, new TrieNode());
			}
			node = node.get(c);
		}
		node.setEnd();
	}

	public boolean search(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			if (!node.containsKey(c)) {
				return false;
			}
			node = node.get(c);
		}
		return node.isEnd;
	}

	public boolean startsWith(String prefix) {
		TrieNode node = root;
		for (char c : prefix.toCharArray()) {
			if (!node.containsKey(c)) {
				return false;
			}
			node = node.get(c);
		}
		return true;
	}

}

class TrieNode {

	TrieNode[] links = new TrieNode[26];
	boolean isEnd = false;

	public TrieNode() {

	}

	public TrieNode get(char c) {
		return links[c - 'a'];
	}

	public boolean containsKey(char c) {
		return links[c - 'a'] != null;
	}

	public void put(char c, TrieNode node) {
		links[c - 'a'] = node;
	}

	public void setEnd() {
		isEnd = true;
	}

	public boolean isEnd() {
		return isEnd;
	}
}