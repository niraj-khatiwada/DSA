import Sorting.CountingSort;

import java.util.Arrays;

class Main {

    public static void main(String[] args) {
        var sort = new CountingSort();
        var array = new int[] {};
        sort.sort(array);
        System.out.println(Arrays.toString(array));

    }

}
