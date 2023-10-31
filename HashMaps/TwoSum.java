package HashMaps;


/*
    Given an array of integers, return indices of the two numbers such
    that they add up to a specific target.Input: [2, 7, 11, 15] - target = 9
    Output: [0, 1] (because 2 + 7 = 9)
    Assume that each input has exactly one solution, and you may not use
    the same element twice.
 */

import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] array, int sum) {
        int[] indices = new int[2];
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }

        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            if (map.containsKey(sum - key)) {
                indices[0] = i;
                indices[1] = map.get(sum - key);
                break;
            }
        }
        return indices;
    }
}


    