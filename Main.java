import java.util.*;

import Graphs.DisjointSet;

class Main {

    public static void main(String[] args) {
        var ds = new DisjointSet(5);
        ds.union(0, 3);
        ds.union(1, 3);
        ds.union(1, 4);
        ds.union(1, 5);
        ds.union(2, 5);
    }

}
