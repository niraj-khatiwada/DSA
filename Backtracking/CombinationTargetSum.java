package Backtracking;

import java.util.*;

public class CombinationTargetSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rs = new ArrayList<>();
        for (var j = 0; j < candidates.length; j++) {
            this._combinationSum(candidates, j, target, new ArrayList<Integer>(), rs);
        }
        return rs;
    }

    private void _combinationSum(int[] candidates, int i, int target, List<Integer> path, List<List<Integer>> rs) {
        // Base Case
        if (i >= candidates.length || (target - candidates[i]) < 0) {
            return;
        }

        var val = candidates[i];
        var rem = target - val;
        path.add(val);
        if (rem == 0) {
            rs.add(path);
            return;
        }

        for (var j = i; j < candidates.length; j++) {
            _combinationSum(candidates, j, target - val, new ArrayList<Integer>(path), rs);
        }
    }
}
