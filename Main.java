import Sorting.CountingSort;

import java.util.Arrays;

class Main {

    public static void main(String[] args) {
        var sort = new CountingSort();
        var array = new int[] { 5, 4, 2, 3, 1, 1, 5 };
        sort.sort(array);
        System.out.println(Arrays.toString(array));

    }

}
