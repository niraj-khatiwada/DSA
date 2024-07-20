import Sorting.BucketSort;

import java.util.Arrays;

class Main {

    public static void main(String[] args) {
        var sort = new BucketSort();
        var array = new int[] { 5, 4, 1, 3, 2, 2 };
        sort.sort(array, 3);
        System.out.println(Arrays.toString(array));

    }

}
