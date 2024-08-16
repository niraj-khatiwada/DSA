import Sorting.BucketSort;
import java.util.*;

class Main {

    public static void main(String[] args) {
        var sort = new BucketSort();
        var array = new int[] { 3, 1, 2, 5, 4, 6, 222, 1000 };
        sort.sort(array);
        System.out.println(Arrays.toString(array));
    }

}
