package grind75.practice3.week5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(candidates, target, 0, new LinkedList<Integer>(), result);
		return result;
	}

	private void backtrack(int[] candidates, int remaining, int start, LinkedList<Integer> combination,
			List<List<Integer>> result) {
		if (remaining == 0) {
			result.add(new ArrayList<Integer>(combination));
			return;
		} else if (remaining < 0) {
			return;
		}

		for (int i = start; i < candidates.length; i++) {
			combination.add(candidates[i]);
			backtrack(candidates, remaining - candidates[i], i, combination, result);
			combination.removeLast();
		}
	}
}
