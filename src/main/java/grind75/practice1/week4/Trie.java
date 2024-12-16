package grind75.practice1.week4;

public class Trie {

	private static TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode node = root;
		char[] wordChars = word.toCharArray();
		for (int i = 0; i < word.length(); i++) {
			char ch = wordChars[i];
			if (!node.containsKey(ch)) {
				node.put(ch, new TrieNode());
			}
			node = node.get(ch);
		}
		node.setEnd();
	}

	public boolean search(String word) {
		TrieNode node = root;
		char[] wordChars = word.toCharArray();
		for (int i = 0; i < word.length(); i++) {
			char ch = wordChars[i];
			if (!node.containsKey(ch)) {
				return false;
			}
			node = node.get(ch);
		}
		return node.isEnd();
	}

	public boolean startsWith(String prefix) {
		TrieNode node = root;
		char[] wordChars = prefix.toCharArray();
		for (int i = 0; i < prefix.length(); i++) {
			char ch = wordChars[i];
			if (!node.containsKey(ch)) {
				return false;
			}
			node = node.get(ch);
		}
		return true;
	}
}

class TrieNode {

	TrieNode[] links = new TrieNode[26];
	boolean isEnd = false;

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