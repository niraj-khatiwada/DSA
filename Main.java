import Search.TernarySearch;
import java.util.*;

class Main {

    public static void main(String[] args) {
        var search = new TernarySearch();
        System.out.println(search.search(new int[] { 1, 2, 5, 11, 22 }, -1));
    }

}
