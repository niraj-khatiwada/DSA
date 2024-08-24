import java.util.*;

import Greedy.MinimumSumOfAbsoluteDifference;

class Main {

    public static void main(String[] args) {
        var greedy = new MinimumSumOfAbsoluteDifference();
        // System.out.println(greedy.minimumSum(new int[] { 4, 1, 8, 7 }, new int[] { 2,
        // 3, 6, 5 }));
        var nums = new int[] { 1, 12, 50 };
        Arrays.sort(nums);
        System.out.println(_findClosest(nums, 0));

    }

    private static int _findClosest(int[] nums, int t) {
        var l = 0;
        var r = nums.length - 1;
        var closest = nums[0];
        while (l <= r) {
            var m = (l + r) / 2;
            var itm = nums[m];
            if (itm == t) {
                return t;
            } else if (t < itm) {
                r = m - 1;
            } else {
                l = m + 1;
            }
            if (Math.abs(itm - t) < Math.abs(closest - t)) {
                closest = itm;
            }
        }
        return closest;
    }
}
