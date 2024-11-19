package grind75.week5;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TimeMap {
	private Map<String, Map<Integer, String>> map = new HashMap<>();

	public TimeMap() {

	}

	public void set(String key, String value, int timestamp) {
		if (map.containsKey(key)) {
			map.get(key).put(timestamp, value);
		} else {
			TreeMap<Integer, String> innerMap = new TreeMap<>();
			innerMap.put(timestamp, value);
			map.put(key, innerMap);
		}
	}

	public String get(String key, int timestamp) {
		if (!map.containsKey(key))
			return "";

		TreeMap<Integer, String> innerMap = (TreeMap<Integer, String>) map.get(key);
		Entry<Integer, String> entry = innerMap.floorEntry(timestamp);

		return entry != null ? entry.getValue() : "";

//		if (innerMap.containsKey(timestamp))
//			return innerMap.get(timestamp);
//
//		List<Integer> timestamps = new ArrayList<>();
//		for (Entry<Integer, String> entry : innerMap.entrySet()) {
//			if (entry.getKey() < timestamp) {
//				timestamps.add(entry.getKey());
//			}
//		}
//		if (timestamps.size() == 0)
//			return "";
//		if (timestamps.size() == 1)
//			return innerMap.get(timestamps.get(0));
//		Optional<Integer> optTimestamp = timestamps.stream().max((a, b) -> Integer.compare(a, b));
//		return innerMap.get(optTimestamp.get());
	}

	public static void main(String[] args) {
		TimeMap timeMap = new TimeMap();
		timeMap.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1.
		System.out.println(timeMap.get("foo", 1)); // return "bar"
		System.out.println(timeMap.get("foo", 3)); // return "bar", since there is no value corresponding to foo at
													// timestamp 3 and
		// timestamp 2, then the only value is at timestamp 1 is "bar".
		timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp
										// = 4.
		System.out.println(timeMap.get("foo", 4)); // return "bar2"
		System.out.println(timeMap.get("foo", 5)); // return "bar2"
	}
}
