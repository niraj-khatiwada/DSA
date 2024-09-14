package Array;

import java.util.*;

public class TrappingRainWater {
    // O(n)
    public int rainWaterTrapped(int[] height) {
        var boundaryLeft = new int[height.length];
        var boundaryRight = new int[height.length];

        // Calculate max left value starting from index 0
        for (var i = 0; i < height.length; i++) {
            boundaryLeft[i] = Math.max(i > 0 ? boundaryLeft[i - 1] : 0, height[i]);
        }

        // Calculate max right value starting from index last
        for (var i = height.length - 1; i >= 0; i--) {
            boundaryRight[i] = Math.max(i < (height.length - 1) ? boundaryRight[i + 1] : 0, height[i]);
        }

        System.out.println(Arrays.toString(boundaryLeft));
        System.out.println(Arrays.toString(boundaryRight));

        var trapped = 0;
        for (var i = 0; i < height.length; i++) {
            trapped += Math.min(boundaryLeft[i], boundaryRight[i]) - height[i];
        }
        return trapped;
    }
}
