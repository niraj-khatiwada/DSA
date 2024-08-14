import java.util.*;

import Sorting.BubbleSort;

class Main {

    public static void main(String[] args) {
        var sort = new BubbleSort();
        var array = new int[] { 6, 5, 4, 3, 1 };
        sort.sort(array);
        System.out.println(Arrays.toString(array));
    }

}
