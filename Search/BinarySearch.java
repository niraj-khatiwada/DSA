package Search;

import java.util.Arrays;

public class BinarySearch {
    public int find(int[] array, int value) {
        if (array.length == 0) {
            return -1;
        }
        Arrays.sort(array);
        var leftIndex = 0;
        var rightIndex = array.length - 1;

        while (true) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            var middleValue = array[middleIndex];
            if (middleValue == value) {
                return middleIndex;
            }
            // This means we have 1 or 2 items left;
            if (leftIndex == rightIndex || (leftIndex + 1) == rightIndex) {
                if (array[rightIndex] == value) {
                    return rightIndex;
                } else {
                    // Left also didn't match, right also didn't match. So, no match.
                    break;
                }
            }
            if (value > middleValue) {
                leftIndex = middleIndex;
            } else {
                rightIndex = middleIndex;
            }
        }
        return -1;
    }

    public int findUsingRecursion(int[] array, int value) {
        if (array.length == 0) {
            return -1;
        }
        return this._findUsingRecursion(array, value, 0, array.length - 1);
    }

    private int _findUsingRecursion(int[] array, int value, int leftIndex, int rightIndex) {
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
        return _findUsingRecursion(array, value, leftIndex, rightIndex);

    }
}
