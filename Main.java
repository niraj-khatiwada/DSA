import Sorting.QuickSort;

import java.util.Arrays;

class Main {

    public static void main(String[] args) {
        var sort = new QuickSort();
        var array = new int[] { 15, 6, 3, 1, 22, 10, 13 };
        sort.sort(array);
        System.out.println(Arrays.toString(array));

    }

}
