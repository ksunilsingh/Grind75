package grind75.week4;

public class Trie {

	private static TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (!node.containsKey(ch)) {
				node.put(ch, new TrieNode());
			}
			node = node.get(ch);
		}
		node.setEnd();
	}

	public boolean search(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (!node.containsKey(ch)) {
				return false;
			}
			node = node.get(ch);
		}
		return node.isEnd();
	}

	public boolean startsWith(String prefix) {
		TrieNode node = root;
		for (int i = 0; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);
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
	boolean flag = false;

	TrieNode get(char ch) {
		return links[ch - 'a'];
	}

	boolean containsKey(char ch) {
		return links[ch - 'a'] != null;
	}

	void put(char ch, TrieNode node) {
		links[ch - 'a'] = node;
	}

	void setEnd() {
		flag = true;
	}

	boolean isEnd() {
		return flag;
	}
}
