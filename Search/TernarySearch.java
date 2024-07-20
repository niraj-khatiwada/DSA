package Search;

import java.util.Arrays;

public class TernarySearch {
    public int find(int[] array, int value) {
        if (array.length == 0) {
            return -1;
        }
        Arrays.sort(array);
        var leftIndex = 0;
        var rightIndex = array.length - 1;

        while (true) {
            var midIndex1 = (rightIndex - leftIndex) / 3;
            var midValue1 = array[midIndex1];

            var midIndex2 = midIndex1 * 2;
            var midValue2 = array[midIndex2];

            if (midValue1 == value) {
                return midIndex1;
            }
            if (midValue2 == value) {
                return midIndex2;
            }
            if (midIndex1 == 0) {
                // This means we have either 1, 2 or 3 items left.
                for (var i = leftIndex; i <= rightIndex; i++) {
                    if (array[i] == value) {
                        return i;
                    }
                }
                // No match
                break;
            }

            if (value < midValue1) {
                rightIndex = midIndex1;
            }
            if (value > midValue1 && value < midValue2) {
                leftIndex = midIndex1;
                rightIndex = midIndex2;
            }
            if (value > midValue2) {
                leftIndex = midIndex2;
            }
        }
        return -1;
    }

    public int findUsingRecursion(int[] array, int value) {
        return this._findUsingRecursion(array, value, 0, array.length - 1);
    }

    private int _findUsingRecursion(int[] array, int value, int leftIndex, int rightIndex) {
        var midIndex1 = (rightIndex - leftIndex) / 3;
        var midValue1 = array[midIndex1];

        var midIndex2 = midIndex1 * 2;
        var midValue2 = array[midIndex2];

        if (midValue1 == value) {
            return midIndex1;
        }
        if (midValue2 == value) {
            return midIndex2;
        }
        if (midIndex1 == 0) {
            // This means we have either 1, 2 or 3 items left.
            for (var i = leftIndex; i <= rightIndex; i++) {
                if (array[i] == value) {
                    return i;
                }
            }
            // No match
            return -1;
        }

        if (value < midValue1) {
            rightIndex = midIndex1;
        }
        if (value > midValue1 && value < midValue2) {
            leftIndex = midIndex1;
            rightIndex = midIndex2;
        }
        if (value > midValue2) {
            leftIndex = midIndex2;
        }
        return _findUsingRecursion(array, value, leftIndex, rightIndex);
    }
}
