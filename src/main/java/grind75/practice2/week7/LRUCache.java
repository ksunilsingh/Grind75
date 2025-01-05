package grind75.practice2.week7;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

	private int capacity;

	private Map<Integer, Integer> cache = new HashMap<>();
	private LinkedList<Integer> LRUTracker = new LinkedList<>();

	// Initialize the LRU cache with positive size capacity.
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	// Return the value of the key if the key exists, otherwise return -1.
	public int get(int key) {
		if (!cache.containsKey(key))
			return -1;
		LRUTracker.remove((Integer) key);
		LRUTracker.addFirst(key);
		return cache.get(key);

	}

	// Update the value of the key if the key exists. Otherwise, add the key-value
	// pair to the cache. If the number of keys exceeds the capacity from this
	// operation, evict the least recently used key.
	public void put(int key, int value) {

		if (cache.containsKey(key)) {
			LRUTracker.remove((Integer) key);
		} else {
			if (LRUTracker.size() >= capacity) {
				int lruKey = LRUTracker.removeLast();
				cache.remove(lruKey);
			}
		}

		LRUTracker.addFirst(key);
		cache.put(key, value);

	}
}
