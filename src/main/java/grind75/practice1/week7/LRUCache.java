package grind75.practice1.week7;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

 

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
 

Constraints:

1 <= capacity <= 3000
0 <= key <= 104
0 <= value <= 105
At most 2 * 105 calls will be made to get and put.
 */
public class LRUCache {

	private int capacity;

	// Key value storage for the cache
	private Map<Integer, Integer> cache = new HashMap<>();

	// LinkedList to keep track of the keys in the cache
	// Whenever a get is called on the cache for a key that is already there in the
	// cache,
	// LRUTracker removes that key from the tracker and adds it as first element to
	// make this key the most recently used key.
	// Whenever a put is called on the cache, if that key already exists in the
	// cache, the tracker removes that key, and adds this key as the first element.
	// Whenever a put is called on the cache, if that key doesn't exist in the
	// cache, and LRUTracker is full, then
	// 1) the tracker removes the last key representing the least recently used key,
	// 2) the last key is also removed from the cache, 3) tracker adds this key as
	// the first element.
	// In all cases, the key value pair is added to the cache.
	private LinkedList<Integer> LRUTracker = new LinkedList<>();

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			// Remove this key from the tracker, and
			// add this key as the first key in tracker so it becomes the most recently used
			// key
			LRUTracker.remove((Integer) key);
			LRUTracker.addFirst(key);
			return cache.get(key);
		}

		return -1;
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			// Remove key from the tracker
			LRUTracker.remove((Integer) key);
		} else {
			// If LRUTracker is already full i.e. size of the LRUTracker is >= capacity
			if (LRUTracker.size() >= capacity) {
				// remove the last element from the tracker because that is the least recently
				// used
				int lruKey = LRUTracker.removeLast();
				cache.remove(lruKey);
			}
		}

		// Add this key as the most recently used key in the tracker.
		LRUTracker.addFirst(key);
		// Add the element to the key value cache
		cache.put(key, value);
	}
}
