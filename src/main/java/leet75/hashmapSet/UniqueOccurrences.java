package leet75.hashmapSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UniqueOccurrences {

	public boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int num : arr) {
			countMap.put(num, countMap.getOrDefault(num, 0) + 1);
		}

		Set<Integer> count = new HashSet<>();

		for (Entry<Integer, Integer> entry : countMap.entrySet()) {
			if (count.contains(entry.getValue()))
				return false;
			count.add(entry.getValue());
		}
		return true;
	}

}
