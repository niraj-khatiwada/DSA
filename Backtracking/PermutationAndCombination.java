package Backtracking;

import java.util.*;

public class PermutationAndCombination {
    // Slots cannot be empty
    // n!
    public void permutation(int[] nums) {
        for (var i = 0; i < nums.length; i++) {
            this._permutation(nums, i, 1, new ArrayList<Integer>());
        }
    }

    private void _permutation(int[] nums, int i, int count, ArrayList<Integer> list) {
        if (i > nums.length) {
            return;
        }

        list.add(nums[i]);

        if (count == (nums.length)) {
            System.out.println(list);
            return;
        }

        for (var j = 0; j < nums.length; j++) {
            this._permutation(nums, j, count + 1, new ArrayList<>(list));
        }

    }

}
