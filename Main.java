import Sorting.InsertionSort;

import java.util.Arrays;

class Main {

    public static void main(String[] args) {
        var sort = new InsertionSort();
        var array = new int[] { 8, 3, 1, 2, 4 };
        sort.sort(array);
        System.out.println(Arrays.toString(array));

    }

}
