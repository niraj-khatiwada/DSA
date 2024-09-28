import java.util.*;

import Search.BinarySearch;

class Main {

    public static void main(String[] args) {
        var bs = new BinarySearch();
        System.out.println(bs.lowerBound(new int[] { 1, 2, 3, 4, 6, 7 }, 5));
        System.out.println(bs.upperBound(new int[] { 1, 2, 3, 4, 6, 7 }, 5));

    }

}
