package Array;

import java.util.*;

public class TripletsSum {
    // O(n^2 + nlog(n))
    // See LeetCode 15. 3Sum
    public List<List<Integer>> threeSum(int[] nums) {
        var used = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        for (var i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue;
            var target = nums[i] * -1;
            var l = i + 1;
            var r = nums.length - 1;
            while (l < r) {
                var sum = nums[l] + nums[r];
                if (sum == target) {
                    var list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    used.add(list);
                    l++;
                    r--;
                } else if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for (var itm : used) {
            list.add(itm);
        }
        return list;
    }

    // O(n^3)
    public void tripletsSum(int[] array) {
        var used = new TreeSet<int[]>((a, b) -> Arrays.compare(a, b));
        for (var i = 0; i < array.length; i++) {
            for (var j = i + 1; j < array.length; j++) {
                for (var k = j + 1; k < array.length; k++) {
                    if (i != j && j != k && i != k) {
                        if ((array[i] + array[j] + array[k]) == 0) {
                            var item = new int[] { array[i], array[j], array[k] };
                            Arrays.sort(item);
                            if (!used.contains(item)) {
                                System.out.printf("%s %s %s\n", array[i], array[j], array[k]);
                                used.add(item);
                            }
                            break;
                        }
                    }

                }
            }
        }
    }

}
