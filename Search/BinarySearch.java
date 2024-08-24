package Search;

import java.util.Arrays;

public class BinarySearch {
    // O(log(n))
    public int find(int[] nums, int t) {
        if (nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        var l = 0;
        var r = nums.length - 1;
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
        }
        return -1;
    }

    public int findUsingRecursion(int[] array, int value) {
        if (array.length == 0) {
            return -1;
        }
        return this.findUsingRecursion(array, value, 0, array.length - 1);
    }

    public int findUsingRecursion(int[] array, int value, int leftIndex, int rightIndex) {
        int middleIndex = (leftIndex + rightIndex) / 2;
        var middleItem = array[middleIndex];
        if (middleItem == value) {
            return middleIndex;
        }
        if (leftIndex == rightIndex || (leftIndex + 1) == rightIndex) {
            if (array[rightIndex] == value) {
                return rightIndex;
            }
            return -1;
        }
        if (value < middleItem) {
            rightIndex = middleIndex;
        } else {
            leftIndex = middleIndex;
        }
        return findUsingRecursion(array, value, leftIndex, rightIndex);
    }

    // O(log(n))
    // If the value does not match, this gives the closest neighbor.
    public int findClosestNeighbor(int[] nums, int t) {
        Arrays.sort(nums); // The number must be given already sorted though.
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
