package Search;

import java.util.Arrays;

public class JumpSearch {
    public int find(int[] array, int value) {
        if (array.length == 0) {
            return -1;
        }

        Arrays.sort(array);

        var bucketSize = (int) Math.sqrt(array.length);
        var leftIndex = 0;
        var rightIndex = bucketSize - 1;

        while (true) {
            // We need to handle 3 cases.
            // 1. Math.sqrt() will always be minimum 1 (for elements length < 4) -> In this
            // case, rightIndex==leftIndex
            // 2. rightIndex can go out of bound
            // 3. If above 2 cases were not found, we can check the last element
            // On all these cases, we need to traverse and find the value from left to
            // rightIndex. Right index can have gone out of boundary
            if (leftIndex == rightIndex || rightIndex > (array.length - 1) || value <= array[rightIndex]) {
                // Traverse to that bucket
                for (var i = leftIndex; i <= rightIndex; i++) {
                    // But rightIndex might have gone out of boundary.
                    if (i > (array.length - 1)) {
                        break;
                    }
                    if (value == array[i]) {
                        return i;
                    }
                }
                break;
            }
            leftIndex = rightIndex + 1;
            rightIndex += bucketSize;
        }
        return -1;
    }
}
