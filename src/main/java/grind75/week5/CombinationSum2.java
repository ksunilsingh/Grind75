package grind75.week5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		backTrack(target, candidates, 0, new LinkedList<Integer>(), result);
		return result;
	}

	private void backTrack(int remaining, int[] candidates, int start, LinkedList<Integer> combination,
			List<List<Integer>> result) {
		if (remaining == 0) {
			result.add(new ArrayList<Integer>(combination));
			return;
		} else if (remaining < 0) {
			return;
		}

		for (int i = start; i < candidates.length; ++i) {
			combination.add(candidates[i]);
			backTrack(remaining - candidates[i], candidates, i, combination, result);
			combination.removeLast();
		}
	}
}
