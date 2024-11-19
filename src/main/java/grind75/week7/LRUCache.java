package grind75.week7;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

	private int capacity;

	private final Map<Integer, Integer> map = new HashMap<>();
	private final LinkedList<Integer> cache = new LinkedList<>();

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (!map.containsKey(key))
			return -1;
		cache.remove((Integer) key);
		cache.addFirst(key);
		return map.get(key);
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {

			cache.remove(key);
			cache.addFirst(key);
		} else {
			if (cache.size() >= capacity) {
				int lruKey = cache.removeLast();
				cache.remove(lruKey);
			}
		}

		map.put(key, value);

	}
}
