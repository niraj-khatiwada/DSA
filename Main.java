import Search.ExponentialSearch;
import java.util.*;

class Main {

    public static void main(String[] args) {
        var search = new ExponentialSearch();
        System.out.println(search.search(new int[] { 1, 2, 5, 11, 22 }, 22));
    }

}
