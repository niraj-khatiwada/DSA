import Sorting.MergeSort;
import java.util.*;

class Main {

    public static void main(String[] args) {
        var sort = new MergeSort();
        var array = new int[] { 1, 3, 5, 0, 2, 6 };
        sort.sort(array);
        System.out.println(Arrays.toString(array));

    }

}
