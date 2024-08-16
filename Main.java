import Sorting.QuickSort;
import java.util.*;

class Main {

    public static void main(String[] args) {
        var sort = new QuickSort();
        var array = new int[] { 15, 6, 3, 22, 1, 10 };
        sort.sort(array);
        System.out.println(Arrays.toString(array));

    }

}
