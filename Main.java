import java.util.*;

import Graphs.DisjointSet;

class Main {

    public static void main(String[] args) {
        var ds = new DisjointSet(5);
        ds.union(0, 3);
        ds.union(0, 5);
        ds.union(2, 3);
        ds.union(2, 5);
        ds.union(1, 4);

        System.out.println(Arrays.toString(ds.size));
    }

}
