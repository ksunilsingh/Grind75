package grind75.practice3.week7;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

	private Map<Integer, Integer> cache = new HashMap<>();
	private LinkedList<Integer> LRUTracker = new LinkedList<>();
	private int capacity;

	/**
	 * Initialize the LRU cache with positive size capacity.
	 * 
	 * @param key
	 * @param value
	 */
	LRUCache(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Return the value of the key if the key exists, otherwise return -1.
	 * 
	 * @param key
	 * @return
	 */
	int get(int key) {
		if (!cache.containsKey(key))
			return -1;

		LRUTracker.remove((Integer) key);
		LRUTracker.addFirst(key);

		return cache.get(key);
	}

	/**
	 * Update the value of the key if the key exists. Otherwise, add the key-value
	 * pair to the cache. If the number of keys exceeds the capacity from this
	 * operation, evict the least recently used key.
	 * 
	 * @param key
	 * @param value
	 */
	void put(int key, int value) {

		if (cache.containsKey(key)) {
			LRUTracker.remove((Integer) key);
		} else {
			if (LRUTracker.size() >= capacity) {
				int lrukey = LRUTracker.removeLast();
				cache.remove(lrukey);
			}
		}

		LRUTracker.addFirst(key);
		cache.put(key, value);
	}
}
