package grind75.practice3.week5;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TimeMap {

	Map<String, TreeMap<Integer, String>> map = new HashMap<>();

	// Initializes the object of the data structure.
	TimeMap() {

	}

	// Stores the key key with the value value at the given time timestamp.
	public void set(String key, String value, int timestamp) {
		TreeMap<Integer, String> timeStampKV = map.getOrDefault(key, new TreeMap<Integer, String>());
		timeStampKV.put(timestamp, value);
		map.put(key, timeStampKV);
	}

	// Returns a value such that set was called previously, with timestamp_prev <=
	// timestamp.
	// If there are multiple such values, it returns the value associated with the
	// largest timestamp_prev. If there are no values, it returns "".
	public String get(String key, int timestamp) {
		if (!map.containsKey(key))
			return "";

		TreeMap<Integer, String> timeStampKV = map.get(key);

		Entry<Integer, String> entry = timeStampKV.floorEntry(timestamp);
		return entry != null ? entry.getValue() : "";
	}
}
