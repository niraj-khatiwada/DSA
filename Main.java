import Sorting.MergeSort;

import java.util.Arrays;

class Main {

    public static void main(String[] args) {
        var sort = new MergeSort();
        var array = new int[] { 4, 8, 1, 2, 3 };
        sort.sort(array);
        System.out.println(Arrays.toString(array));

    }

}
