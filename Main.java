import Sorting.BubbleSort;

import java.util.Arrays;

class Main {

    public static void main(String[] args) {
        var sort = new BubbleSort();
        var array = new int[] { 1, 2, 4, 3 };
        sort.sort(array);
        System.out.println(Arrays.toString(array));

    }

}
